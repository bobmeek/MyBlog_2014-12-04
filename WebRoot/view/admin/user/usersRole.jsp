<%@ page pageEncoding="UTF-8"%> 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
			<a href="#add_role_modal" data-target="#add_role_modal" data-toggle="modal" class="btn btn-primary btn-lg" id="add_role_link">添加角色</a>			
		</div>
	</div>
	
	
	<!-- 显示用户 -->
	<div style="height:500px;">
		<table class="table table-responsive table-striped table-bordered table-hover" id="allRoles">
			<thead>
				<tr>
					<th style="display: none;">ID</th>
					<th>角色标识</th>
					<th>角色描述</th>
					<th>负责模块</th>
					<th>详情</th>
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
	
	<div class="modal fade" id="show_role_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="width:500px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true" id="close_update">&times;</span><span class="sr-only">Close</span>
					</button>
					<h2 class="modal-title" style="text-align: center" id="myModalLabel">角色信息</h2>
				</div>
				<div class="modal-body" style="height:230px;">
					<div>
			 			<table class="show-resource" id="show_role_table">
				 			<tr style="display: none;">
				 				<td>ID</td>
				 				<td><span class="sp" id="id_role_span_update"></span><input type="text" class="form-control in" style="display: none;" id="id_role_text_update"/></td>
				 			</tr>
				 			<tr>
				 				<td>角色标识</td>
				 				<td><span class="sp" id="role_role_span_update"></span><input type="text" class="form-control in" style="display: none;" id="role_role_text_update"/></td>
				 			</tr>
				 			<tr>
				 				<td>角色描述</td>
				 				<td><span class="sp" id="desc_role_span_update"></span><input type="text" class="form-control in" style="display: none;" id="desc_role_text_update"/></td>
				 			</tr>
			 			</table>
			 		</div>
			 		
			 		
				</div>
				<div class="modal-footer">
					<button type="button" id="update_role_btn" class="btn btn-primary btn-lg btn-block">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="add_role_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true" id="close_add_role">&times;</span><span class="sr-only">Close</span>
					</button>
					<h2 class="modal-title" style="text-align: center">添加角色</h2>
				</div>
				<div class="modal-body" style="height:150px;margin-top:20px;">
					<form class="form-horizontal">
						  <div class="form-group">
						    <label for="role_add_role" class="col-sm-3 control-label">角色名称</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" id="role_add_role"  placeholder="例子：ROLE_CEO"/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="desc_add_role" class="col-sm-3 control-label">角色描述</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" id="desc_add_role" placeholder= "例子：首席执行官"/>
						    </div>
						  </div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btn-lg btn-block" id="add_role_btn">确定</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
</body>
