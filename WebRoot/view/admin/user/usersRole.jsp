<%@ page pageEncoding="UTF-8"%> 
<%@ taglib prefix="role" uri="http://shiro.apache.org/tags" %>
<head>
	<style>
		ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:180px;height:200px;overflow-y:scroll;overflow-x:auto;}
	</style>
	        
</head>
<body>
	
	<div style="width:100%;height:50px;">
		<div class="" style="float:left;with:300px;height:50px;margin-left:-14px;">
			<ol class="breadcrumb">
			  <li><a href="javascript:void(0)">用户管理</a></li>
			  <li class="active">用户角色管理</li>
			</ol>
		</div>
		<div style="float:right;margin-bottom:10px;">
			<role:hasPermission name="role:delete">
				<a href="javascript:void(0)" class="btn btn-danger btn-lg" id="delete_user_link">删除角色</a>
			</role:hasPermission>
			<role:hasPermission name="role:add">
				<a href="#add_user_modal" data-target="#add_user_modal" data-toggle="modal" class="btn btn-primary btn-lg" id="add_user_link">添加角色</a>			
			</role:hasPermission>
		</div>
	</div>
	
	
	<!-- 显示用户 -->
	<div style="height:500px;">
		<table class="table table-responsive table-striped table-bordered table-hover" id="allRoles">
			<thead>
				<tr>
					<th style="display: none;">ID</th>
					<th>职位名称</th>
					<th>职位描述</th>
					<th>管辖部门</th>
					<th>操作</th>
				</tr>
			</thead>
			
			<tbody>
			</tbody>
		</table>
	</div>
	
	
	<div id="resourceTree" style="display:none; position: absolute;">
		<ul id="tree" class="ztree"></ul>
	</div>	
	
</body>
