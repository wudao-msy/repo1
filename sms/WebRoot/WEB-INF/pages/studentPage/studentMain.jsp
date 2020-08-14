<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>学生管理系统</title>
	<meta charset=UTF-8">    
	<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css" type="text/css">
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
	      url:"/blog/findAllByPage.do",//要请求数据的文件路径
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
	                   field:'bid',
	                   align:'center'
	                 
	               },
	               {
	            	   title:'日志标题',
	            	   field:'title',
	            	   align:'center',
	            	   formatter:actionLion
	            	   
	               },
	               {
	                   title:'更新时间',
	                   field:'createDate',
	                   align:'center',
	               },
	               {
	                   title:'作者',
	                   field:'student',
	                   align:'center',
	                   formatter:function(value, row, index){
	                	   return value.name;
	                   }
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
      function actionLion(value,row,index){
       	  let id=index+1;
    	  let result="";	
		  result+="<a class=\"btn btn-Info  btn-xs\" onclick=\"showModalDetail("+id+")\">"+value+"</a>";  	
		  return result;  
      }     
	  
      
      function showModalDetail(bid){
      	$.post('/blog/findById.do',{'bid':bid},function(blog){
      		alert(1);
      		 $('#title').val(blog.title);
      		 $('#content').val(blog.content);
      		 $('#showBlog').modal('show');
      	},'json');
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
      
     
	    }
      
      
	  )</script>  
  </head>
  <body>
     <% request.setAttribute("index",0); %>
    <jsp:include page="top.jsp"/>
    <div class="container margin-top-10">
    	<div class="col-sm-8">
    		<div class="panel panel-default">
			  <div class="panel-body">
			   
			    <table id="cusTable" data-toggle="tooltip">
					
				</table>
			  </div>
			</div>
   		</div>
    <jsp:include page="right.jsp"/>	
    </div>
    <jsp:include page="bottom.jsp"/>
    


	<!-- 班级添加model窗口 -->
    <div class="modal fade" id="showBlog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" ">blog详情</h4>
	      </div>
	      <form  id="frmAddCourse" class="form-horizontal">
		      <div class="modal-body">
			     <div class="form-group">
			       <label class="col-sm-3 control-label">blog名称：</label>
			       <div class="col-sm-6">
			         <input class="form-control" type="text" id="title" name="title" readonly="readonly">
			       </div>
			       <label class="col-sm-3 control-label error-info" style="text-align:left;"></label>
			    </div>
			    <div class="form-group">
			       <label class="col-sm-3 control-label">blog详情：</label>
			       <div class="col-sm-6">
			       	  <textarea class="form-control" rows="10" style="resize:none;" id="content" name="content" readonly="readonly">
						 
				      </textarea>
			       </div>
			       <label class="col-sm-3 control-label error-info" style="text-align:left;" rows="10" style="resize:none;"></label>
			    </div>
		      </div>
		  </form>
	    </div>
	  </div>
	</div>
	<!-- MODEL结束 -->
    
    
    
    
  </body>
</html>
