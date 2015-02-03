<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<head>
	<style type="text/css">
		
		table th{
			
			text-align:center;
		
		}
		
		table td{
			text-align:center;
		}
	</style>
</head>
<body>

	<div style="width:100%;height:50px;">
		<div class="" style="float:left;with:300px;height:50px;margin-left:-14px;">
			<ol class="breadcrumb">
			  <li><a href="javascript:void(0)">用户管理</a></li>
			  <li class="active">用户信息管理</li>
			</ol>
		</div>
		<div style="float:right;margin-bottom:10px;">
			<shiro:hasPermission name="user:delete">
				<a href="javascript:void(0)" class="btn btn-danger btn-lg" id="delete_user_link">删除用户</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="user:add">
				<a href="#add_user_modal" data-target="#add_user_modal" data-toggle="modal" class="btn btn-primary btn-lg" id="add_user_link">添加用户</a>
			</shiro:hasPermission>
		</div>
	</div>

	<!-- 显示用户 -->
	<div style="height:500px;">
		<table class="table table-responsive table-striped table-bordered table-hover" id="allUsers">
			<thead>
				<tr>
					<th style="display: none;">ID</th>
					<th><input type="checkbox" id="allUsers_check"></th>
					<th>用户名</th>
					<th>邮箱</th>
					<th>注册</th>
					<th>最后登录</th>
					<th>状态</th>
					<th>详情</th>
					<th>现居职位</th>
					<!-- <th>操作</th> -->
					<!-- <th colspan="2">操作</th> -->
				</tr>
			</thead>
			
			<tbody>
			</tbody>
		</table>
	</div>
	<div class="user-page" id="user_page">
		<nav>	
		  <ul class="pager">
	   		<li class="previous" id="user_pre"><a href="javascript:void(0)">&larr; 前一页</a></li>
	  	  	<li class="next" id="user_next"><a href="javascript:void(0)">下一页 &rarr;</a></li>
		  </ul>
		</nav>
	</div>
	
	<!--编辑用户 -->
	<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="show_userext_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true" id="close_update">&times;</span><span class="sr-only">Close</span>
					</button>
					<h2 class="modal-title" style="text-align: center" id="myModalLabel">我的名片</h2>
				</div>
				<div class="modal-body" style="height:420px;">
					<div class="head-img">
						<img src="" width="200px" height="200px" alt="..." class="img-circle" id="head_img">
						<div style="margin-left:50px;margin-top: 30px;" >
							<input type="file" class="btn-primary in" name="headPic" style="display: none;" id="head_pic_file">
							<button class="btn btn-primary" title="上 传 头 像" id="head_pic_btn">上 传 头 像</button>
						</div>	
			 		</div>
			 		
			 		<div style="width:310px;height:400px;float:left;border:1px solid #EDF3F4">
			 			<table class="show-userext"  id="show_userext_table">
				 			<tr style="display: none;">
				 				<td>ID</td>
				 				<td><span class="sp" id="id_span_update"></span><input type="text" class="form-control in" style="display: none;" id="id_text_update"/></td>
				 			</tr>
				 			<tr>
				 				<td>用户名</td>
				 				<td><span class="sp" id="username_span_update"></span><input type="text" class="form-control in" disabled="disabled" style="display: none;" id="username_text_update"/></td>
				 			</tr>
				 			<tr>
				 				<td>邮箱</td>
				 				<td><span class="sp" id="email_span_update"></span><input type="text" class="form-control in" style="display: none;" id="email_text_update"/></td>
				 			</tr>
				 			<tr>
				 				<td>QQ</td>
				 				<td><span class="sp" id="qq_span_update"></span><input type="text" class="form-control in" style="display: none;" id="qq_text_update"/></td>
				 			</tr>
				 			<tr>
				 				<td>电话</td>
				 				<td><span class="sp" id="mobile_span_update"></span><input type="text" class="form-control in" style="display: none;" id="mobile_text_update"/></td>
				 			</tr>
				 			<tr>
				 				<td>生日</td>
				 				<td><span class="sp" id="birthday_span_update"></span><input type="date" class="form-control in" style="display: none;" id="birthday_text_update"/></td>
				 			</tr>
				 			<tr>
				 				<td>个性签名</td>
				 				<td><span class="sp" id="signature_span_update"></span><input type="text" class="form-control in" style="display: none;" id="signature_text_update"/></td>
				 			</tr>
				 			<tr>
				 				<td>个人简介</td>
				 				<td><span class="sp" id="intro_span_update"></span><textarea class="form-control in" style="display: none;" id="intro_text_update">我是来自Supermap的软件工程师，我的名字叫夏煜正，专注于Java开发，敏捷开发，传播正能量，从我做起。</textarea></td>
				 			</tr>
			 			
			 			</table>
			 		</div>
			 		
			 		
				</div>
				<div class="modal-footer">
					<div class="alert alert-danger" role="alert" style="text-align: left;display: none;">
						<h4>
							<i class="icon-remove-sign"> </i>
						</h4>
					</div>
					<button type="button" id="update_user_btn" class="btn btn-primary btn-lg btn-block">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<!--添加用户 -->
	
	<div class="modal fade" id="add_user_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						&times;
					</button>
					<h2 class="modal-title" style="text-align: center" id="myModalLabel">添加用户</h2>
				</div>
				<div class="modal-body" style="height:150px;margin-top:20px;">
					<form class="form-horizontal" action="article/showArticles">
						<div class="form-group">
							<label for="username_text_add" class="col-sm-2 control-label">用户名</label>

							<div class="col-sm-9">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="icon-user"></i>
									</div>
									<input id="username_text_add" type="text" class="form-control input-lg" placeholder="请输入用户名">
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="userpwd_text_add" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-9">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="icon-key"></i>
									</div>
									<input id="userpwd_text_add" type="password" class="form-control input-lg" placeholder="请输入密码">
								</div>
							</div>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btn-lg btn-block" id="add_user_btn">确定</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
