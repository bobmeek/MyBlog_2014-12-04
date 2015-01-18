<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


<link rel="stylesheet" href="resources/front_frame/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="resources/front_frame/bootstrap/css/font-awesome.css">
<link rel="stylesheet" href="resources/front_base/css/main.css" />
<style type="text/css">
/* body { padding-bottom: 100px; } */
</style>
</head>

<body>
	<!-- 	<div class="banner"> -->
	<!-- 		<span style="color:gray;font-size:40px;margin-left:180px">夏煜正官方网站</span><br />  -->
	<!-- 		<span style="color:red;font-size:14px;margin-left:180px">研究互联网产品和技术，提供原创中文精品教程</span> -->
	<!-- 	</div> -->

	<!-- 	<div class="navigate"> -->

	<!-- 		<nav class="navbar navbar-default " role="navigation">  -->
	<!-- 				  <nav class="navbar navbar-default navbar-fixed-top" role="navigation"> -->

	<!-- 		<ul class="nav navbar-nav navbar-left" style="margin-left:180px"> -->
	<!-- 			<li class="active"><a href="javascript:void(0)">首页</a></li> -->
	<!-- 			<li><a href="javascript:void(0)">读书</a></li> -->
	<!-- 			<li><a href="javascript:void(0)">编程</a></li> -->
	<!-- 			<li><a href="javascript:void(0)">Python教程</a></li> -->
	<!-- 			<li><a href="javascript:void(0)">Git编程</a></li> -->
	<!-- 			<li><a href="javascript:void(0)">问答</a></li> -->
	<!-- 		</ul> -->
	<!-- 		<form class="navbar-form navbar-right" style="margin-right:400px" role="search"> -->
	<!-- 			<div class="form-group"> -->
	<!-- 				<input type="text" class="form-control" placeholder="Search"> -->
	<!-- 			</div> -->
	<!-- 			<button type="submit" class="btn btn-default">搜索</button> -->

	<!-- 			<a href="${basePath}view/user/register.jsp" class="btn btn-primary btn-large">注册</a> -->
	<!-- 			<a href="${basePath}view/user/login.jsp" class="btn">登录</a> -->
	<!-- 			<a href="#login" data-toggle="modal" class="btn">登录</a> -->
	<!-- 		</form> -->

	<!-- 		</nav> -->

	<!-- 	</div> -->


	<div class="navigate">

		<nav class="navbar navbar-inverse  navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Myblog</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
					<li class="active"><a href="javascript:void(0)">首页</a></li>
					<li><a href="javascript:void(0)">读书</a></li>
					<li><a href="javascript:void(0)">编程</a></li>
					<li><a href="javascript:void(0)">Python教程</a></li>
					<li><a href="javascript:void(0)">Git编程</a></li>
					<li><a href="javascript:void(0)">问答</a></li>
				</ul>
				<form class="navbar-form navbar-search navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control search-query" placeholder="搜索">
					</div>
				</form>
				<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${null==username}">
						<li><a href="${basePath}view/user/register.jsp">注册</a></li>
						<li><a href="#login_modal" data-target="#login_modal" data-toggle="modal">登录</a></li>
					</c:when>
					<c:otherwise>
						<li class="dropdown">
							<button type="button" class="btn btn btn-default navbar-btn" data-toggle="dropdown">
								<i class="glyphicon glyphicon-user"></i> ${username } <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">信息</a></li>
								<li><a href="#">设置</a></li>
								<li class="divider"></li>
								<li><a href="#">退出登录</a></li>
							</ul>
						</li>
					</c:otherwise>
				</c:choose>
					
					
				</ul>
			</div>
		</div>
		</nav>

	</div>



	<div class="modal fade" id="login_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h2 class="modal-title" style="text-align: center;" id="myModalLabel">用户登录</h2>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="article/showArticles">
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名</label>

							<div class="col-sm-8">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="icon-user"></i>
									</div>
									<input id="username" name="j_username" type="text" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" class="form-control input-lg" placeholder="请输入用户名/邮箱">
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="userpwd" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-8">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="icon-key"></i>
									</div>
									<input id="userpwd" name="j_password" type="password" class="form-control input-lg" placeholder="请输入密码">
								</div>
							</div>
						</div>
					</form>

				</div>

				<div class="modal-footer">
					<div class="alert alert-danger" role="alert" style="text-align: left;display: none;">
						<h4>
							<i class="icon-remove-sign"> </i>
						</h4>
					</div>
					<button type="button" id="login_btn" class="btn btn-primary btn-lg btn-block">登录</button>
				</div>



			</div>
		</div>
	</div>


	<script type="text/javascript" src="resources/front_base/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="resources/front_base/js/login.js"></script>
	<script type="text/javascript" src="resources/front_frame/bootstrap/js/bootstrap.js"></script>

</body>
</html>
