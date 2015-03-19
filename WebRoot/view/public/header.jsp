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
	
	
	</head>

<body>

		<div id="top"><!-- 顶部区域 -->
			<div id="top_menu"><!-- 顶部导航区域 -->
				<ul class="nav">
					<li><a href="#" class="index">首页</a></li>
					<li><a href="#">前端开发</a></li>
					<li><a href="#">网页设计</a></li>
					<li><a href="#">移动开发</a></li>
					<li><a href="#">操作系统</a></li>
					<li><a href="#">编译原理</a></li>
					<li><a href="#">数据结构</a></li>
					<li><a href="#">软件教程</a></li>
					<li><a href="#">留言吐槽</a></li>
				</ul>				
			</div><!-- 顶部导航区域结束 -->
		</div><!-- 顶部区域结束 -->

</body>
</html>