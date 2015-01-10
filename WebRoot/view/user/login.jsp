<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="resources/front_base/css/main.css">




</head>

<body>

<!-- 		  <div id="pagecontain"> -->
<!-- 		    <form action="article/showArticles" method="post"> -->
<!-- 		    	用户： <input type="text" name="j_username" style="width:150px;" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}"/><br /> -->
<!-- 	    	   	密码： <input type="password" name="j_password" style="width:150px;" /><br /> -->
<!-- 		    	<input type="submit" value="登录 " /> -->
<!-- 		    </form> -->
<!-- 		  </div> -->
  	<div id="pagecontain">
		    <form action="user/login.do" method="post">
		    	用户： <input type="text" name="attr" style="width:150px;" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}"/><br />
	    	   	密码： <input type="password" name="userpwd" style="width:150px;" /><br />
		    	<input type="submit" value="登录 " />
		    </form>
		  </div>
<!-- 	<div class="error ${param.error == true ? '' : 'hide'}"> -->
<!-- 		登陆失败<br> ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message} -->
<!-- 	</div> -->
<!-- 	<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post" style="width:260px;text-align:center;"> -->
<!-- 		<fieldset> -->
<!-- 			<legend>登陆</legend> -->
<!-- 			用户： <input type="text" name="j_username" style="width:150px;" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" /><br /> 密码： <input type="password" name="j_password" style="width:150px;" /><br /> -->
<!-- 			<input type="checkbox" name="_spring_security_remember_me" />两周之内不必登陆<br /> <input type="submit" value="登陆" /> <input type="reset" value="重置" /> -->
<!-- 		</fieldset> -->
<!-- 	</form> -->
</body>
</html>
