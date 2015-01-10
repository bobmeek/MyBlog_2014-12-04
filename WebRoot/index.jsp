<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>success Page</title>
		
	</head>
	<span style="font-size: 12px;">
		<body>
			这是首页，欢迎<sec:authentication property="name" />
			!
			<br>
			<a href="admin.jsp">进入admin页面</a>
			<a href="other.jsp">进入其它页面</a>
		</body>
	</span>	
</html>
