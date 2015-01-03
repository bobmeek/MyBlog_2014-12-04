<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>用户注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="resources/front_base/css/main.css" rel="stylesheet" type="text/css">
<link href="resources/front_frame/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="resources/front_frame/bootstrap/css/bootstrap-theme.css" rel="stylesheet" type="text/css">

<style type="text/css">
	
	body
	{
/* 		background-image: url("resources/front_base/img/huanghun.jpg"); */
	}

</style>

</head>



<body class="templatemo-bg-gray">
	<jsp:include page="../public/header.jsp"></jsp:include>

	<div class="panel panel-default " id="reg_panel">
		<div class="panel-heading">
			<h2 class="panel-title">注册新用户</h2>
		</div>
		<div class="panel-body">
			<div class="col-md-12">
				<form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="#" method="post">
					<div class="form-inner">
						<div class="form-group">
							<div class="col-md-12">
								<label for="name" class="control-label">用户名</label> 
								<input type="text"  class="form-control input-lg" id="name" placeholder="由字母、数字、下划线组成">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<label for="mail" class="control-label" >Email</label> 
								<input  type="email" class="form-control input-lg" id="mail" placeholder="您常用的邮箱地址">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6">
								<label for="phone" class="control-label">手机号码</label> 
								<input type="text" class="form-control input-lg" id="phone" placeholder="您常用的手机号码">
							</div>
							<div class="col-md-4">
								<label for="birthday" class="control-label">出生日期</label> 
								<input type="date" class="form-control input-lg" id="birthday" placeholder="">
							</div>
							<div class="col-md-2 templatemo-radio-group" style="margin-top:24px;">
								<label class="radio-inline"> 
									<input type="radio" name="sex" id="boyRadios" value="boy"> 男
								</label> 
								<label class="radio-inline">
									<input type="radio" name="sex" id="girlRadios" value="gril"> 女
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6">
								<label for="password" class="control-label">密码</label> 
								<input type="password" class="form-control input-lg" id="password" placeholder="最小长度6位" >
							</div>
							<div class="col-md-6">
								<label for="password_sure" class="control-label">确认密码</label> 
								<input type="password" class="form-control input-lg" id="password_sure" placeholder="再一次输入密码"  >
							</div>
						</div>
						
						
						
						<div class="alert alert-danger " role="alert" style="padding-top:23px">
  							<h4><i class="icon-remove-sign">  </i></h4>
						</div>
						
						<div class="form-group">
							<div class="col-md-12">
								<button type="button" class="btn btn-info btn-lg btn-block" id="register_btn">注册新用户</button>
							</div>
						</div>
					</div>
				</form>
			</div>
			
		</div>
		
		
		
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<div class="panel panel-default " id="reg_panel_return">
		<div class="panel-heading">
			<h2 class="panel-title">注册新用户</h2>
		</div>
		<div class="panel-body active-info">
				<i class="icon-ok-sign icon-5x" style="color:green;margin-left:80px;"></i>
				<h3>注册成功,验证邮件发送到</h3>	
				<div style="color:red;font-style:italic;" id="mail_return">yuzheng.xia@foxmail.com</div>
				<h3>请查收邮件并激活你的账号</h3>
						
		</div>
		
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

<script type="text/javascript" src="resources/front_base/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="resources/front_base/js/jquery-json.js"></script>
<script type="text/javascript" src="resources/front_frame/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/front_base/js/register.js"></script>
	
</body>

</html>

