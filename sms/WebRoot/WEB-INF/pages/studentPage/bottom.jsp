<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/bootstrap/css/bootstrapValidator.min.css" type="text/css"></link>
<script type="text/javascript" src="/bootstrap/js/bootstrapValidator.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

//显示修改模态对话框
	  function showModalModify(sid){
		  //alert(sid);
		  $.post('/student/findById.do',{'sid':sid},function(student){
			 console.log(student); //注意：post需要传递第四个参数，值为json,表示返回的值是一个json字符串，否则就是一个普通字符串
			 //console.log(student.sid); 
			 //1:将值取出
			 $('#sid').val(student.sid);
			 $('#username').val(student.username);
			 $('#name').val(student.name);
			 $('#age').val(student.age);
			 //设置性别单选按钮
			 if(student.gender=='0'){
				 $('#male').prop('checked',true);
			 }
			 else{
				 $('#female').prop('checked',true);
				 
			 }
			 //设置班级和课程下拉列表值
			 $('#gid1').val(student.grade.gid);
			 $('#cid1').val(student.course.cid);
			 
			 //2:将值写入对应节点
			 
			 
			 //3:显示该修改模态框
			 $('#modifyStudent').modal('show');
			 
		  },'json');
		  
		  $(document).ready(function () {
		  
		  $('#frmModifyStudent').bootstrapValidator({
	    	 feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',//成功后输出的图标
		            invalid: 'glyphicon glyphicon-remove',//失败后输出的图标
		            validating: 'glyphicon glyphicon-refresh'//长时间加载时输出的图标
		        },
		     fields:{
		    	 username: {//表单元素name的值					   
					    validators: {//验证规则
					        notEmpty: {
					            message: '用户名不能为空'//验证失败输出的值
					        },
					        stringLength:{
					        	min:3,
					        	max:10,
					        	message:'用户名长度必须3-10位'
					        	
					        },
					        regexp:{
					        	regexp:/^[0-9a-zA-Z_]+$/,
					        	message:'用户名只能包含数字、字母、下划线'
					        }
					         ,
					        remote:{//向远程服务器发送请求进行校验
					        	type:'post',
					        	url:'/student/findByUsername.do',
					        	//message:'用户名已经被占用'
					        } 
					     
					    }
					},
				name:{
					validators:{
						notEmpty:{
							message:'姓名不能为空'
						}
					}
				},
				age:{
					validators:{
						notEmpty:{
							message:'年龄不能为空'
						},
						greaterThan:{
							value:10,
							inclusive:true,
							message:'年龄必须大于等于10'
						}
					}
				},
				gid:{
					validators:{
						notEmpty:{
							message:'班级不能为空，请选择'
						}
					}
				},
				cid:{
					validators:{
						notEmpty:{
							message:'课程不能为空，请选择'
						}
					}
				}
		     }
	    });
	   });
	  }
</script>
	
</head>
<body>
<!-- 页尾 版权声明 -->
    <div class="container">
		<div class="col-sm-12 foot-css">
		        <p class="text-muted credit">
		            Copyright © 2018 中兴软件 版权所有
		        </p>
	    </div>
    </div>
    
    
    <!-- 修改模态框start -->
    <div class="modal fade" id="modifyStudent" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">修改学员</h4>
	        <form action="/student/modifyStudent1.do" class="form-horizontal" method="post" id="#frmModifyStudent">
				     <input type="hidden" id="sid" name="sid"/>
				     <div class="form-group">
				       <label class="col-sm-3 control-label">登录账户：</label>
				       <div class="col-sm-6">
				         <input class="form-control" type="text"  name="username" id="username">
				       </div>
				       <label class="col-sm-3 control-label error-info" style="text-align:left;"></label>
				    </div>
				     <div class="form-group">
				       <label class="col-sm-3 control-label">学生姓名：</label>
				       <div class="col-sm-6">
				         <input class="form-control" type="text" name="name" id="name">
				       </div>
				       <label class="col-sm-3 control-label error-info" style="text-align:left;"></label>
				    </div>
				     <div class="form-group">
				       <label class="col-sm-3 control-label">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</label>
				       <div class="col-sm-6">
				         <input class="form-control" type="text"  name="age" id="age">
				       </div>
				       <label class="col-sm-3 control-label error-info" style="text-align:left;"></label>
				    </div>
				     <div class="form-group">
				       <label class="col-sm-3 control-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
				       <div class="col-sm-6">
					       <div class="radio">
							  <label>
							    <input type="radio" value="0" name="gender" id="male" checked="checked"> 男
							  </label>
							  &nbsp;&nbsp;&nbsp;
							  <label>
							    <input type="radio" value="1" name="gender" id="female"> 女
							  </label>
							</div>
						</div>
				       <label class="col-sm-3 control-label error-info" style="text-align:left;"></label>
				    </div>
				    <div class="form-group">
				       <label class="col-sm-3 control-label">班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级：</label>
				       <div class="col-sm-6">
				         <select class="form-control" name="gid" id="gid1">
				       	 	<option value="">-请选择-</option>
				       	 	<c:forEach items="${gradeList}" var="grade">
			       	 			<option value="${grade.gid}">${grade.gname}</option>
			       	 		</c:forEach>
				       	 </select>
				       </div>
				       <label class="col-sm-3 control-label error-info" style="text-align:left;"></label>
				    </div>
				    <div class="form-group">
				       <label class="col-sm-3 control-label">课&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;程：</label>
				       <div class="col-sm-6">
				         <select class="form-control" name="cid" id="cid1">
				       	 	<option value="">-请选择-</option>
				       	 	<c:forEach items="${courseList}" var="course">
			       	 			<option value="${course.cid}">${course.cname}</option>
			       	 		</c:forEach>
				       	 </select>
				       </div>
				       <label class="col-sm-3 control-label error-info" style="text-align:left;"></label>
				    </div>
				    <div class="form-group">
				       <div class="col-sm-6  col-sm-offset-3">
				       	 <div class="col-sm-6">
					         <button type="reset" class="btn btn-primary btn-block">重&nbsp;&nbsp;置</button>
				       	 </div>
				       	 <div class="col-sm-6">
					         <button type="submit" class="btn btn-primary btn-block">修&nbsp;&nbsp;改</button>
				       	 </div>
				       </div>
				    </div>
			      </form>
	        
	      </div>
	     
	      
	    </div>
	  </div>
	</div>
    
    <!-- 修改模态框end -->
    
    
    <!-- username修改model窗口 -->
    <div class="modal fade" id="modfiyName" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">用户名字修改</h4>
	      </div>
	      <form action="/sysuser/modifyUserName.do?id=${user.id}" class="form-horizontal" method="post" onsubmit="return checkNull()">
		      <div class="modal-body">
			     <div class="form-group">
			       <label class="col-sm-3 control-label">姓名：</label>
			       <div class="col-sm-6">
			         <input class="form-control" type="text" id="username" name="username">
			       </div>
			       <span id="usernameMsg" class="col-sm-3 control-label error-info" style="text-align:left;"/>
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
    
    
    
    
    <!-- 密码修改model窗口 -->
    <div class="modal fade" id="modfiyPWD" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">用户密码修改</h4>
	      </div>
	      <form action="/student/modifyPassword.do?id=${stu.sid}" class="form-horizontal" method="post" onsubmit="return checkData()">
		      <div class="modal-body">
			     <div class="form-group">
			       <label class="col-sm-3 control-label">登录密码：</label>
			       <div class="col-sm-6">
			         <input class="form-control" type="password" id="oldPassword" name="oldPassword">
			       </div>
			       <span id="oldPasswordMsg" class="col-sm-3 control-label error-info" style="text-align:left;"/>
			    </div>
			     <div class="form-group">
			       <label class="col-sm-3 control-label">新的密码：</label>
			       <div class="col-sm-6">
			         <input class="form-control" type="password" id="newPassword" name="newPassword">
			       </div>
			       <span id="newPasswordMsg" class="col-sm-3 control-label error-info" style="text-align:left;"/>
			    </div>
			     <div class="form-group">
			       <label class="col-sm-3 control-label">重复密码：</label>
			       <div class="col-sm-6">
			         <input class="form-control" type="password" id="nextPassword" name="nextPassword">
			       </div>
			       <span id="nextPasswordMsg" class="col-sm-3 control-label error-info" style="text-align:left;"/>
			    </div>
			    <div class="form-group">
			       <div class="col-sm-6">
			         <input class="form-control" type="hidden" id="userPassword" name="userPassword" value="${stu.password}">
			       </div>
			       <span id="oldPasswordMsg" class="col-sm-3 control-label error-info" style="text-align:left;"/>
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
</body>
</html>