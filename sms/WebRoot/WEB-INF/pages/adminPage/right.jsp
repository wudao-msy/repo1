<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function checkNull(){
		let usernameMsg=$('#usernameMsg').text;
		
		if(usernameMsg){
			return false;
		}
		return true;
	}

	
	function checkData(){
		
		//旧密码
		let oldPasswordMsg=$('#oldPasswordMsg').text();
		
		//新密码
		let newPasswordMsg=$('#newPasswordMsg').text();
		
		//重复密码
		let nextPasswordMsg=$('#nextPasswordMsg').text();
	
		
		//获取所有的异常返回，如果有，不能提交表单
		if(oldPasswordMsg||newPasswordMsg||nextPasswordMsg){
			return false;
		}
		return true;
	}
	
	$(function() {
			
			//校验旧密码类型名称是否为空
			$('#oldPassword').blur(function(){
				$('#oldPasswordMsg').text('');
				let name=$(this).val();
				let msg=checkOldPassword(name);
				$('#oldPasswordMsg').text(msg);
		    });	
		    
		    //校验新密码类型名称是否为空,与新密码是否相同
			$('#newPassword').blur(function(){
				$('#newPasswordMsg').text('');
				let name=$(this).val();
				let msg=checkNull(name);
				$('#newPasswordMsg').text(msg);
		    });	
		    
		    //校验重复密码类型名称是否为空
			$('#nextPassword').blur(function(){
				$('#nextPasswordMsg').text('');
				let newpwd=document.getElementById("newPassword").value;
				let nextpwd=document.getElementById("nextPassword").value;
				let msg=checkNewPassword(newpwd,nextpwd);
				$('#nextPasswordMsg').text(msg);
		    });	
		   
			 //校验新名字类型名称是否为空,与新密码是否相同
			$('#username').blur(function(){
				$('#usernameMsg').text('');
				let name=$(this).val();
				let msg=checkNull(name);
				$('#usernameMsg').text(msg);
		    });	
			
		});
			
		
		//判断旧密码是否与该用户原密码相同
		function checkOldPassword(date){
			let userPassword=document.getElementById("userPassword").value;
			if(date!=userPassword){
				return '密码不正确';
			}
			return '';
		}
		
		//判断新密码与重复密码是否相同
		function checkNewPassword(newpwd,nextpwd){
			if(newpwd!=nextpwd){
				return '两次密码不相同';
			}
			return '';
		}
		
		//判断是否是数字
		function checkNumber(data){
			let num=Number(data)+'';
			if(num=='NaN'){
				return 'error';
			}
			return '';
		}
		
		//判断是否为null
		function checkNull(data) {
			if(!data){
				return '不能为空';
			}
			return '';
		}
	
	
	//退出系统
	  function logOut(){
		  $.ajax({
			  method: 'post',
			  url:'/sysuser/logOut.do',
			  success:function(){
				  alert('你已退出系统');
				  //重新定位到login.jsp,继续登录
				  location='/login.jsp';
			  }
		  });
	  }
</script>
</head>
<body>
<div class="col-sm-4">
    		<div class="panel panel-default">
    		  <div class="panel-heading">
    		  	 <img alt="" src="/images/user.png">
			     <span class="font-style"> 欢迎您：${user.username}管理员！</span>
    		  </div>
			  <div class="panel-body">
			  	<div class="col-sm-12">
				   	<ul class="nav nav-pills nav-stacked">
					  <li><a class="btn btn-link" data-toggle="modal" data-target="#modfiyPWD" style="text-align: left;">修改登录密码</a></li>
					  <li><a onclick="logOut()" style="cursor: pointer;">退出校园系统</a></li>
					</ul>
			  	</div>
			  </div>
			</div>
			<div class="panel panel-default">
    		  <div class="panel-heading">
    		  	 <img alt="" src="/images/message.png"> 
			     <span class="font-style">&nbsp;联系我们：</span>
    		  </div>
			  <div class="panel-body">
			  	<address class="padding-left-10 font-info">
				  <strong>联系地址：</strong><br>
				  南京市紫荆花路68号中兴通讯南京研发中心<br>
				  <strong>联系电话：</strong><br>
				   025-12345678
				</address>
			  </div>
			</div>
   		</div>
   	</div>
</body>
</html>