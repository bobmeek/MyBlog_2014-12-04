 <%@ page pageEncoding="UTF-8"%> 
 <head>
 </head>
 <body>
 	
 	<div style="width:100%;height:50px;">
	<div style="float:left;with:300px;height:50px;margin-left:-14px;">
		<ol class="breadcrumb">
		  <li><a href="javascript:void(0)">用户管理</a></li>
		  <li class="active">个人信息</li>
		</ol>
	</div>
	</div>
 	
 	<div style="width:100%;height:800px;border:1px solid green;">
 		<div class="head-img" style="width:300;height:300px;border:1px solid blue;float:left;margin-top:200px;margin-left:100px;">
			<img src="" alt="..." class="img-circle">
 		</div>
 		<div class="user-info" style="width:800;height:500px;border:1px solid red;display:inline-block;">
 		
 			
 			
 			
 			<div class="panel panel-default " id="reg_panel">
		<div class="panel-heading">
			<h2 class="panel-title">详细资料</h2>
		</div>
		<div class="panel-body">

				<form class="" role="form" action="#" method="post">
						<div class="form-group" id="username_group">
								<label for="username" class="control-label">用户名</label>
								<input type="text"  class="form-control input-lg" id="username" placeholder="由字母、数字、下划线组成">
						</div>
						<div class="form-group" id="email_group">
								<label for="email" class="control-label" >Email</label> 
								<input  type="email" class="form-control input-lg" id="email" placeholder="您常用的邮箱地址">
						</div>
						<div class="form-group" id="password_group">
								<label for="password" class="control-label">密码</label> 
								<input type="password" class="form-control input-lg" id="password" placeholder="最小长度6位" >
						</div>
						
						<div class="form-group" id="password_sure_group">
								<label for="password_sure" class="control-label">确认密码</label> 
								<input type="password" class="form-control input-lg" id="password_sure" placeholder="再一次输入密码"  >
						</div>
						
						<div class="alert alert-danger " role="alert" style="padding-top:23px;display: none;">
  							<h4><i class="icon-remove-sign">  </i></h4>
						</div>
						
						<div class="form-group">
							<button type="button" class="btn btn-info btn-lg btn-block" id="register_btn">更新</button>
						</div>
				</form>
			</div>
			
		</div>
 			
 			
 			
 			
 		</div>
 	</div>
 	
 	
<!--  	<script type="text/javascript" src="resources/front_base/js/jquery-1.8.3.js"></script> -->
 </body>
