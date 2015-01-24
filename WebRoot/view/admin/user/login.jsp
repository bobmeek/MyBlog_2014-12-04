<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登陆界面</title>
</head>

<body>
    <form action="login" method="post">
    	用户： <input type="text" name="username" style="width:150px;" /><br />
   	   	密码： <input type="password" name="userpwd" style="width:150px;" /><br />
    	<input type="submit" value="登录 " />
    </form>
</body>
</html>
