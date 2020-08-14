<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>学生管理系统</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css" type="text/css"></link>
    <link rel="stylesheet" href="/css/mycss.css" type="text/css"></link>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
    <script>
    	$(function(){
    		CKEDITOR.replace('content');
    	});
		
		
		function checkIsNull(){
		let titleMsg=$('#titleMsg').text;
		
		let contentMsg=$('#contentMsg').text;
		
		if(titleMsg){
			return false;
		}
		return true;
	}
	
	$(function() {
	//校验新名字类型名称是否为空,与新密码是否相同
			$('#title').blur(function(){
				$('#titleMsg').text('');
				let name=$(this).val();
				let msg=checkNull(name);
				$('#titleMsg').text(msg);
		    });	
		
			
		});
		
	//判断是否为null
		function checkNull(data) {
			if(!data){
				return '不能为空';
			}
			return '';
		}
    </script>
  </head>
  <body>
    <% request.setAttribute("index",2); %>
    <jsp:include page="top.jsp"/>
    <div class="container margin-top-10">
    	<div class="col-sm-8">
    		<div class="panel panel-default">
			  <div class="panel-body">
				<form method="post" action="/blog/addBlog.do" >
				
				  <div class="form-group">
				   
				    <input type="hidden" class="form-control" id="sid" name="sid" value="${stu.sid}" >
				  </div>
				  <div class="form-group">
				    <label>日志标题：</label><label class="control-label error-info" style="text-align:left;"></label>
				    <input type="text" class="form-control" id="title" name="title">
				    <span id="titleMsg" class="col-sm-3 control-label error-info" style="text-align:left;"/>
				  </div>
				  <div class="form-group">
				    <label>日志正文：</label><label class="control-label error-info" style="text-align:left;"></label>
				    <textarea id="content" name="content" cols="20" rows="2" class="ckeditor"></textarea>
				    
				  </div>
				  <div class="text-right">
					  <button type="submit" class="btn btn-success">发&nbsp;&nbsp;&nbsp;&nbsp;表</button>
				  </div>
				</form>
			  </div>
			</div>
   		</div>
    	<jsp:include page="right.jsp"/>	
    </div>
    <jsp:include page="bottom.jsp"/>
    
      
  </body>
</html>
