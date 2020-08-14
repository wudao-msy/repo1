<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	      <form action="/sysuser/modifyPassword.do?id=${user.id}" class="form-horizontal" method="post" onsubmit="return checkData()">
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
			         <input class="form-control" type="hidden" id="userPassword" name="userPassword" value="${user.password}">
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