<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>后台管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="resources/front_base/css/tree-menu.css">
<link rel="stylesheet" href="resources/front_frame/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="resources/front_frame/bootstrap/css/font-awesome.css">
</head>

<body>
	<nav class="side_nav navbar navbar-fixed-top navbar-inverse" role="navigation"> <!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#nav-top">
			<div>菜单</div>
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>

		</button>
		<!-- <a class="navbar-brand" href="#">MsOnLine</a> -->
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="nav-top">
		<ul class="nav navbar-nav" id="accordion" data-toggle="buttons">
<!-- 			<li class="panel"> -->
				
<!-- 				<a href="#personal_manage" class="dropdown-toggle collapsed" data-toggle="collapse" data-parent="#accordion"> -->
<!-- 					<i class="icon-wrench icon-large"></i> 个人信息<b class="caret"></b> -->
<!-- 				</a> -->
<!-- 				<ul id="personal_manage" class="collapse list-unstyled sednav"> -->
<!-- 					<li><a href="#">详细信息</a></li> -->
<!-- 					<li><a href="#">密码修改</a></li> -->
<!-- 				</ul> -->
<!-- 			</li> -->
			<li class="panel">
				<a href="#users_manage" class="dropdown-toggle collapsed" data-toggle="collapse" data-parent="#accordion">
					<i class="icon-user icon-large"></i> 用户管理<b class="caret"></b>
				</a>
				<ul id="users_manage" class="collapse list-unstyled sednav">
					<li><a href="#" id="personInfo">个人资料</a></li>
					<li><a href="#">密码修改</a></li>
					<li><a href="#" id="allUsersInfo">用户信息管理</a></li>
					<li><a href="#" id="allUsersGroup">用户组管理</a></li>
					<li><a href="#" id="allUsersRole">用户角色管理</a></li>
				</ul>
			</li>
			<li class="panel">
				<a href="#topic_manage" class="dropdown-toggle collapsed" data-toggle="collapse" data-parent="#accordion"><i class="icon-book icon-large"></i> 文章管理<b
					class="caret"></b></a>
				<ul id="topic_manage" class="list-unstyled sednav collapse" style="height: 0px;">
					<li><a href="#">发布文章</a></li>
					<li><a href="#">文章信息</a></li>
					<li><a href="#">栏目信息</a></li>
				</ul></li>
			<li class="panel">
				<a href="#system_manage"  class="dropdown-toggle collapsed"  data-toggle="collapse" data-parent="#accordion"><i class="icon-cogs icon-large"></i> 系统配置<b
					class="caret"></b></a>
				<ul id="system_manage" class="list-unstyled sednav collapse" style="height: 0px;">
					<li><a href="#">超级链接管理</a></li>
					<li><a href="#">网站信息管理</a></li>
					<li><a href="#">首页图片管理</a></li>
					<li><a href="#">网站数据备份</a></li>
					<li><a href="#">系统清理管理</a></li>
				</ul></li>
		</ul>
	</div>
	</nav>


	<div class="containerk">
		<div class="row top_info">
			<div class="col-xs-6 " style="float:right;">
				<div class="btn-group users_info ">
					<button type="button" class="btn btn-default dropdown-toggle " data-toggle="dropdown">
						<span class="glyphicon glyphicon-user"></span> Keven <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">信息</a></li>
						<li><a href="#">设置</a></li>
						<li class="divider"></li>
						<li><a href="#">退出登录</a></li>
					</ul>
				</div>
				<div class="btn-group users_info" style="padding-top: 8px;padding-right:50px;">
					<i class="icon-flag" style="margin-right:20px;"> 2015.01.09</i> 
					<i class="icon-time"> 2015.01</i> 
				</div>					
			</div>
		</div>
		
		<div id="show" >
<%-- 			<div id="personInfoPage" class="page" style="display:visibility;">
				<jsp:include page="user/personInfo.jsp" flush="true"></jsp:include>
			</div>		
			<div id="allUsersInfoPage" class="page" style="display:none;">
				<jsp:include page="user/allUsersInfo.jsp" flush="true"></jsp:include>
			</div> --%>
			<div id="personInfoPage" class="page" style="display:none;">
				<jsp:include page="user/personInfo.jsp" flush="true"></jsp:include>
			</div>		
			<div id="allUsersInfoPage" class="page" style="display:visibility;">
				<jsp:include page="user/allUsersInfo.jsp" flush="true"></jsp:include>
			</div>
			<div id="allUsersGroupPage" class="page" style="display: none;">
				<jsp:include page="user/allUsersGroup.jsp" flush="true"></jsp:include>
			</div>
			<div id="allUsersRolePage" class="page" style="display: none;">
				<jsp:include page="user/allUsersRole.jsp" flush="true"></jsp:include>
			</div>
		</div>
		
	</div>
	
	
	
		<script type="text/javascript" src="resources/front_base/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="resources/front_frame/bootstrap/js/bootstrap.js"></script>
		<script type="text/javascript" src="resources/front_frame/bootstrap/js/bootstrap.file-input.js"></script>
		<script type="text/javascript" src="resources/front_base/js/ajaxfileupload.js"></script>
		<script type="text/javascript" src="resources/front_base/js/admin/admin.js"></script>
		<script type="text/javascript" src="resources/front_base/js/admin/userManage.js"></script>
</body>
</html>
