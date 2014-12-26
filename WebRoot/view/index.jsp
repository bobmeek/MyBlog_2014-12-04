<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="resources/front_base/css/main.css" />


<style type="text/css">

</style>

</head>

<body>



<div>
		<jsp:include page="public/header.jsp" flush="true"></jsp:include>
	
		<div id="content">
			<div id="content-left">
				<div class="content-title">热门推荐</div>	
				<div id="content-left-top">
							
					<img src="resources/front_base/img/successful.png" width="100%" height="100%" />
				
				</div>
				<div class="content-title">推荐教程</div>
				<div id="content-left-bottom">
				
					欢迎啊${name }！
				
				</div>
			</div>
			
			<div id="right">
				<div class="content-title">最后发表</div>	
				<div>
					<ul>
						<c:forEach var="article" items="${articles}">
							<li><a href="javascript:void(0)" >${article.title}</a></li>
						</c:forEach>
						
					</ul>
					
				</div>
			</div>
		</div>

</div>
	
</body>
</html>
