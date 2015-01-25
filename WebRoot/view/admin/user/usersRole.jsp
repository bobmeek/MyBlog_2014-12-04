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
				<tr>
					<td>ROLE_CEO</td>
					<td>首席执行官</td>
					<td>用户管理、文章管理、系统管理</td>
					<td><a href='#' class='btn btn-sm btn-success'>详细</a></td>
				</tr>
				<tr>
					<td>ROLE_CTO</td>
					<td>首席技术官</td>
					<td>用户管理、文章管理、系统管理</td>
					<td><a href='#' class='btn btn-sm btn-success'>详细</a></td>
				</tr>
				<tr>
					<td>ROLE_CIO</td>
					<td>首席信息官</td>
					<td>用户管理、文章管理、系统管理</td>
					<td><a href='#' class='btn btn-sm btn-success'>详细</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	
	
<!-- 	<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="show_role_modal"> -->
<!-- 		<div class="modal-dialog"> -->
<!-- 			<div class="modal-content"> -->
<!-- 				<div class="modal-header"> -->
<!-- 					<button type="button" class="close" data-dismiss="modal"> -->
<!-- 					<span aria-hidden="true" id="close_update">&times;</span><span class="sr-only">Close</span> -->
<!-- 				</button> -->
<!-- 				<h2 class="modal-title" style="text-align: center" id="myModalLabel">角色设置</h2> -->
<!-- 				</div> -->
<!-- 				<div class="modal-body" style="height:500px;"> -->
<!-- 					<div id="resourceTree"> -->
						<!-- <ul id="tree" class="ztree"></ul> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="modal-footer"></div> -->
<!-- 			</div>	 -->
<!-- 		</div> -->
<!-- 	</div> -->
	
	
	<div id="resourceTree" style="display:none; position: absolute;">
		<ul id="tree" class="ztree"></ul>
	</div>	
	
</body>
