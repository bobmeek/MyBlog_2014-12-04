<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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

<link rel="stylesheet" type="text/css" href="resources/front_base/css/main.css" />
<link rel="stylesheet" type="text/css" href="resources/front_frame/bootstrap/css/bootstrap.css" />
<style type="text/css">


</style>
</head>

<body>

	<div class="banner">
		<span style="color:gray;font-size:40px;margin-left:0px">夏煜正官方网站</span><br/>
		<span style="color:red;font-size:12px;margin-left:0px">研究互联网产品和技术，提供原创中文精品教程</span>
	</div>
		
	<div class="navigate">

		<nav class="navbar navbar-default " role="navigation"> 
<!-- 		  <nav class="navbar navbar-default navbar-fixed-top" role="navigation"> -->
		<div class="container-fluid">

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left" style="margin-left:0px">
					<li class="active"><a href="javascript:void(0)">首页</a></li>
					<li><a href="javascript:void(0)">读书</a></li>
					<li class="dropdown"><a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">编程 <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" style="margin-left:435px" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>

			</div>
		</div>
		</nav>

	</div>
	
</body>
</html>
