<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>header</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="resources/front_base/css/main.css" />
<link rel="stylesheet" href="resources/front_frame/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="resources/front_frame/bootstrap/css/font-awesome.css">
<style type="text/css">
</style>
</head>

<body>
	<div class="banner">
		<span style="color:gray;font-size:40px;margin-left:180px">夏煜正官方网站</span><br /> 
		<span style="color:red;font-size:14px;margin-left:180px">研究互联网产品和技术，提供原创中文精品教程</span>
	</div>

	<div class="navigate">

		<nav class="navbar navbar-default " role="navigation"> <!-- 		  <nav class="navbar navbar-default navbar-fixed-top" role="navigation"> -->

		<ul class="nav navbar-nav navbar-left" style="margin-left:180px">
			<li class="active"><a href="javascript:void(0)">首页</a></li>
			<li><a href="javascript:void(0)">读书</a></li>
			<li><a href="javascript:void(0)">编程</a></li>
			<li><a href="javascript:void(0)">Python教程</a></li>
			<li><a href="javascript:void(0)">Git编程</a></li>
			<li><a href="javascript:void(0)">问答</a></li>
		</ul>
		<form class="navbar-form navbar-right" style="margin-right:400px" role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
			<button type="submit" class="btn btn-default">搜索</button>
			
			<a href="${basePath}view/register.jsp" class="btn btn-primary btn-large">注册</a>
			<a href="${basePath}view/login.jsp" class="btn">登录</a>
			<a href="#login" data-toggle="modal" class="btn">登录</a>
		</form>

		</nav>

	</div>






<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h2 class="modal-title" id="myModalLabel">用户登录</h2>
      </div>
      <div class="modal-body">
     	 <form class="form-horizontal">
	      	<div class="form-group">
		      	<label for="username" class="col-sm-2 control-label">用户名</label>
		      	 
		      	<div class="col-sm-8">
			      	<div class="input-group">
			      		<div class="input-group-addon"><i class="icon-user"></i> </div>
			      	    <input id="username" type="text" class="form-control input-lg" placeholder="请输入用户名">
			        </div>
		        </div>
	        </div>
	        
	        <div class="form-group">
		      	<label for="userpwd" class="col-sm-2 control-label">密码</label>
		      	<div class="col-sm-8">
		      		<div class="input-group">
		      			<div class="input-group-addon"><i class="icon-key"></i></div>
		      			<input id="userpwd" type="password" class="form-control input-lg" placeholder="请输入密码">
		      		</div>
		        </div>
	        </div>
	        
      	</form>
      </div>
      <div class="modal-footer" >
        <button type="button" class="btn btn-primary btn-lg btn-block">登录</button>
      </div>
       
    </div>
  </div>
</div>







	
</body>
</html>
