<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>学生管理系统</title>
	<meta charset=UTF-8">    
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/css/mycss.css" type="text/css">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap-table.css"/>
    <script type="text/javascript" src="/bootstrap/js/bootstrap-table.js"></script>
    <link rel="stylesheet" href="/bootstrap/css/bootstrapValidator.min.css" type="text/css"></link>
    <script type="text/javascript" src="/bootstrap/js/bootstrapValidator.min.js"></script>
    <link rel="stylesheet" href="/css/style.css" type="text/css"/>
    
     <script>
    function initTable() {  
    	//alert(1);
	    //先销毁表格  
	    $('#cusTable').bootstrapTable('destroy');  
	    //初始化表格,动态从服务器加载数据  
	    $("#cusTable").bootstrapTable({  
	      method: 'post',
	      contentType: "application/x-www-form-urlencoded",//post请求必须要有！
	      url:"/course/findAllByPage.do",//要请求数据的文件路径
	      striped: true, //是否显示行间隔色
	      pageNumber: 1, //初始化加载第一页，默认第一页
	      pagination:true,//是否分页
	      queryParamsType:'limit',//查询参数组织方式
	      queryParams:queryParams,//请求服务器时所传的参数
	      sidePagination:'server',//指定服务器端分页
	      pageSize:5,//单页记录数
	      pageList:[5,10,20,30],//分页步进值
	      showRefresh:false,//刷新按钮
	      showColumns:false,
	      clickToSelect: true,//是否启用点击选中行
	      toolbarAlign:'right',//工具栏对齐方式
	      buttonsAlign:'right',//按钮对齐方式
	      undefinedText: "空",//当数据为 undefined 时显示的字符  
	      columns:[
	               {
	                   title:'编号',
	                   field:'cid',
	                   align:'center'
	                 
	               },
	               {
	                   title:'课程名称',
	                   field:'cname',
	                   align:'center'
	                   
	               },
	               {
	                   title:'课程描述',
	                   field:'cdesc',
	                   align:'center',
	               },
	               {
	            	   title:'操作',
	            	   field:'cid',
	            	   align:'center',
	            	   formatter:actionFormatter
	            	   
	               }
	           ]
	    });
	  }
	  
	    //请求服务数据时所传参数
	  function queryParams(params){
	    return{
	      //页码  
	      pageNo: (params.offset / params.limit) + 1,
	      //页面大小
	      pageSize:params.limit
	    }
	  }
	  //操作栏的格式化
      function actionFormatter(value,row,index){
    	  let id=value;
    	  let result="";
    	  result+="<a class=\"btn btn-success    btn-xs\" onclick=\"showModalModify("+id+")\">修改</a>&nbsp;&nbsp;";
    	  result+="<a class=\"btn btn-danger  	 btn-xs\" onclick=\"showModalDelete("+id+")\">删除</a>";
    	  return result;  
      }     
      
     function showModalModify(cid){
      	$.post('/course/findById.do',{'cid':cid},function(course){
      		 $('#cid').val(course.cid);
      		 alert(course.cname);
      		 $('#cname').val(course.cname);
      		 $('#cdesc').val(course.cdesc);
      		 $('#modifyCourse').modal('show');
      	},'json');
      }
      
      function showModalDelete(cid){
      	$('#del_id').val(cid);
		  //显示删除确认框
		 $('#deleteCourse').modal('show');
      }
      
      function deleteCourse(){
      	let cid=$('#del_id').val();
		location.href='/course/deleteCourse.do?cid='+cid;
      }
      
      $(document).ready(function () {          
	    //调用函数，初始化表格  
	    initTable(); 
	    //获取服务器端传递过来的msg
	    let msg='${msg}';
	    if(msg!=''){
	    	//在这个表格上初始化一个弹出栏
	    	$('#cusTable').tooltip({
	    		title:'提示消息',
	    		template:'<div class="tooltip tooltipMsg">'+msg+'</div>',
	    		trigger:'manual'
	    	}).tooltip('show');
	    	
	    }
	    
	    //完成表单提交后表单的tooltip在显示后2秒钟以后自动关闭
		$('[data-toggle="tooltip"]').each(function(){
			//这个this表示的是表单中的元素
			$(this).on('shown.bs.tooltip',function(){//绑定事件，当tooltip显示之后触发
			   //这个this表示当前tooltip,
			   let _this=this;
			   setTimeout(function(){
				 $(_this).tooltip('hide');  
			   },2000);
			});
			
		});
      
      $('#frmAddCourse').bootstrapValidator({
	    	 feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',//成功后输出的图标
		            invalid: 'glyphicon glyphicon-remove',//失败后输出的图标
		            validating: 'glyphicon glyphicon-refresh'//长时间加载时输出的图标
		        },
		     fields:{
		    	 cname: {//表单元素name的值					   
					    validators: {//验证规则
					        notEmpty: {
					            message: '课程名不能为空'//验证失败输出的值
					        }
					    }
					},
				cdesc:{
					validators:{
						notEmpty:{
							message:'内容不能为空'
						}
					}
				}
		     }
	    });
	    
	     $('#frmModifyCourse').bootstrapValidator({
	    	 feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',//成功后输出的图标
		            invalid: 'glyphicon glyphicon-remove',//失败后输出的图标
		            validating: 'glyphicon glyphicon-refresh'//长时间加载时输出的图标
		        },
		     fields:{
		    	 cname: {//表单元素name的值					   
					    validators: {//验证规则
					        notEmpty: {
					            message: '课程名不能为空'//验证失败输出的值
					        }
					    }
					},
				cdesc:{
					validators:{
						notEmpty:{
							message:'内容不能为空'
						}
					}
				}
		     }
	    });
       });
      
      //按条件查询
	  function queryByCondition(){
		  //初始化表格
		  initTableByConditon();
	  }
	  
	  function initTableByConditon(){
		//先销毁表格  
	    $('#cusTable').bootstrapTable('destroy');  
	    //初始化表格,动态从服务器加载数据  
	    //alert(1);
	    $("#cusTable").bootstrapTable({  
	      method: 'post',
	      contentType: "application/x-www-form-urlencoded",//post请求必须要有！
	      url:"/course/findByCondition.do",//要请求数据的文件路径
	      striped: true, //是否显示行间隔色
	      pageNumber: 1, //初始化加载第一页，默认第一页
	      pagination:true,//是否分页
	      queryParamsType:'limit',//查询参数组织方式
	      queryParams:queryParamsByCondition,//请求服务器时所传的参数
	      sidePagination:'server',//指定服务器端分页
	      pageSize:5,//单页记录数
	      pageList:[5,10,20,30],//分页步进值
	      showRefresh:false,//刷新按钮
	      showColumns:false,
	      clickToSelect: true,//是否启用点击选中行
	      toolbarAlign:'right',//工具栏对齐方式
	      buttonsAlign:'right',//按钮对齐方式
	      undefinedText: "空",//当数据为 undefined 时显示的字符  
	     columns:[
	               {
	                   title:'编号',
	                   field:'cid',
	                   align:'center'
	                 
	               },
	               {
	                   title:'课程名称',
	                   field:'cname',
	                   align:'center'
	                   
	               },
	               {
	                   title:'课程描述',
	                   field:'cdesc',
	                   align:'center',
	               },
	               {
	            	   title:'操作',
	            	   field:'cid',
	            	   align:'center',
	            	   formatter:actionFormatter
	            	   
	               }
	           ]
	    });		  
	  }
	  
	  //请求服务数据时所传参数
	  function queryParamsByCondition(params){
	    return{
	      //页码  
	      pageNo: (params.offset / params.limit) + 1,
	      //页面大小
	      pageSize:params.limit,
	      //查询表单元素中的值
	      cname:$('#cname').val()
	    }
	  }
      
	  </script>  
  </head>
  <body>
     <% request.setAttribute("index",3); %>
    <jsp:include page="top.jsp"/>
    <div class="container margin-top-10">
    	<div class="col-sm-8">
    		<div class="panel panel-default">
			  <div class="panel-body">
			  	<form class="form-inline" method="post">
				  <div class="form-group">
				    <label>课程:</label>
				    <input type="text" class="form-control input-sm" placeholder="不填查询所有" id="cname" name="cname">
				  </div>
			       <button type="reset" class="btn btn-success btn-sm">重&nbsp;&nbsp;置</button>
			       <button type="button" class="btn btn-success btn-sm" onclick="queryByCondition()">查&nbsp;&nbsp;询</button>
				</form>
				<hr/>
			   <div class="padding-bottom-3" style="text-align: right;">
			  		<button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#addCourse" >添加新课程</button>
			  	</div>
			    <table id="cusTable" data-toggle="tooltip">
					
				</table>
			  </div>
			</div>
   		</div>
    <jsp:include page="right.jsp"/>	
    </div>
    <jsp:include page="bottom.jsp"/>
    
    
	<!-- 班级修改model窗口 -->
    <div class="modal fade" id="modifyCourse" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">班级信息修改</h4>
	      </div>
	      <form action="/course/modifyCourse.do" class="form-horizontal" id="frmModifyCourse" method="post">
		      <div class="modal-body">
				<div class="form-group">
			       <label class="col-sm-3 control-label">班级编号：</label>
			       <div class="col-sm-6">
			         <input class="form-control" type="text" id="cid" name="cid" readonly="readonly">
			       </div>
			       <label class="col-sm-3 control-label error-info" style="text-align:left;"></label>
			    </div>
			     <div class="form-group">
			       <label class="col-sm-3 control-label">班级名称：</label>
			       <div class="col-sm-6">
			         <input class="form-control" type="text" id="cname" name="cname">
			       </div>
			       <label class="col-sm-3 control-label error-info" style="text-align:left;"></label>
			     </div>
			    <div class="form-group">
			       <label class="col-sm-3 control-label">班级详情：</label>
			       <div class="col-sm-6">
			         <input class="form-control" type="text" id="cdesc" name="cdesc">
			       </div>
			       <label class="col-sm-3 control-label error-info" style="text-align:left;"></label>
			    </div>
		      </div>
		      <div class="modal-footer">
		          <button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">关&nbsp;&nbsp;闭</button>
		          <button type="reset" class="btn btn-default">重&nbsp;&nbsp;置</button>
		          <button type="submit" class="btn btn-default">修&nbsp;&nbsp;改</button>
			  </div>
		  </form>
	    </div>
	  </div>
	</div>
	<!-- MODEL结束 -->
	
	
	<!-- 班级添加model窗口 -->
    <div class="modal fade" id="addCourse" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">新课程添加</h4>
	      </div>
	      <form action="/course/addCourse.do" id="frmAddCourse" class="form-horizontal" id="frmAddCourse" method="post">
		      <div class="modal-body">
			     <div class="form-group">
			       <label class="col-sm-3 control-label">课程名称：</label>
			       <div class="col-sm-6">
			         <input class="form-control" type="text" id="cname" name="cname">
			       </div>
			       <label class="col-sm-3 control-label error-info" style="text-align:left;"></label>
			    </div>
			    <div class="form-group">
			       <label class="col-sm-3 control-label">课程描述：</label>
			       <div class="col-sm-6">
			         <input class="form-control" type="text" id="cdesc" name="cdesc">
			       </div>
			       <label class="col-sm-3 control-label error-info" style="text-align:left;"></label>
			    </div>
		      </div>
		      <div class="modal-footer">
		          <button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">关&nbsp;&nbsp;闭</button>
		          <button type="reset" class="btn btn-default">重&nbsp;&nbsp;置</button>
		          <button type="submit" class="btn btn-default">添&nbsp;&nbsp;加</button>
			  </div>
		  </form>
	    </div>
	  </div>
	</div>
	<!-- MODEL结束 -->
	
	
    
    
    <!-- 删除Course模态框start -->
    <div class="modal fade" id="deleteCourse">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">操作提示</h4>
	      </div>
	      <input type="hidden" id="del_id"/>
	      <div class="modal-body">
	        <p style="font-size: 25px;font-style: bold;">确认要删除该条数据吗？</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" onclick="deleteCourse()">确认</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
    <!-- 提示模态框end -->
  </body>
</html>
