<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	$(function(){
	   //正确显示导航栏
	   let navIndex = ${index};
	   //console.log($('ul.nav li').size());
	   $('ul.nav li').each(function(i){
		   //alert(i);
		   //将所有导航栏背景清空
		   $(this).removeClass('active');
		   if(navIndex==i){
			   $(this).addClass('active');
		   }
	   });
	   
	   
	});
</script>
</head>
<body>
<div class="container nav-height">
   		<div class="col-sm-3">
   			<img alt="" src="/images/logn.png">
   		</div>
   		<div class="col-md-3 col-md-offset-6 visible-md-block visible-lg-block">
   			<p class="p-css">2018 年 4 月 16 日 23:22:00</p>
   		</div>
    </div>
    <div class="nav-style">
    	<div class="container">
	    	<div class="col-sm-12">
	    		<ul class="nav nav-pills">
				  <li class="active"><a href="/blog/toStudentMain.do">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
				  <li><a href="/blog/studentBlog.do">我的日志</a></li>
				  <li><a href="/blog/newBlog.do">发表日志</a></li>				 
				  <li class="dropdown">
			          <a href="#" data-toggle="dropdown">预留连接 <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a class="btn btn-link" style="text-align: left;" onclick="showModalModify(${stu.sid})">更新个人信息</a></li>
					  	<li><a class="btn btn-link" data-toggle="modal" data-target="#modfiyPWD" style="text-align: left;">修改登录密码</a></li>
			            <li role="separator" class="divider"></li>
					  <li><a onclick="logOut()" style="cursor: pointer;">退出校园系统</a></li>
			          </ul>
			        </li>
				</ul>
	   		</div>
    	</div>
    </div>
</body>
</html>