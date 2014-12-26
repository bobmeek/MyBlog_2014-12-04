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

</head>



<body class="templatemo-bg-gray">
	<jsp:include page="../public/header.jsp"></jsp:include>


	<div class="panel panel-default " id="reg-panel">
		<div class="panel-heading">
			<h2 class="panel-title">注册新用户</h2>
		</div>
		<div class="panel-body">
			<div class="col-md-12">
				<form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="#" method="post">
					<div class="form-inner">
						<div class="form-group">
							<div class="col-md-12">
								<label for="username" class="control-label">用户名</label> 
								<input type="text" class="form-control input-lg" id="username" placeholder="由字母、数字、下划线组成">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<label for="email" class="control-label" >Email</label> 
								<input  type="email" class="form-control input-lg" id="email" placeholder="您常用的邮箱地址">
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
									<input type="radio" name="boyRadios" id="boyRadios" value="option1"> 男
								</label> 
								<label class="radio-inline">
									<input type="radio" name="girlRadios" id="girlRadios" value="option2"> 女
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6">
								<label for="password" class="control-label">密码</label> 
								<input type="password" class="form-control input-lg" id="password" placeholder="最小长度6位" >
							</div>
							<div class="col-md-6">
								<label for="sure_password" class="control-label">确认密码</label> 
								<input type="password" class="form-control input-lg" id="sure_password" placeholder="再一次输入密码"  >
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<label><input type="checkbox">	点击注册，表明你同意我们的 <a href="javascript:;" data-toggle="modal" data-target="#templatemo_modal">服务条款</a></label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<input type="submit" value="注册新用户" class="btn btn-info btn-lg">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		
		
		
		
		
		
		
	</div>
	
	

<script type="text/javascript" src="resources/front_base/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="resources/front_frame/bootstrap/js/bootstrap.js"></script>
	
	
</body>

</html>
