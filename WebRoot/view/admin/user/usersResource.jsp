 <%@ page pageEncoding="UTF-8"%> 
 <body>
 	<div style="width:100%;height:50px;">
		<div class="" style="float:left;with:300px;height:50px;margin-left:-14px;">
			<ol class="breadcrumb">
			  <li><a href="javascript:void(0)">用户管理</a></li>
			  <li class="active">用户资源管理</li>
			</ol>
		</div>
	</div>
	
	<!-- 显示用户 -->
	<div style="height:500px;">
		<table class="tree table table-responsive table-striped table-bordered table-hover" id="allResources">
			<thead>
				<tr>
					<th style="text-align:left;">名称</th>
					<th style="display: none;">ID</th>
					<th>类型</th>
					<th>URL路径</th>
					<th>权限字符串</th>
					<th>操作</th>
				</tr>
			</thead>
			
			<tbody>
			</tbody>
		</table>
	</div>
	
	
	<div class="modal fade" id="show_resource_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="width:500px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true" id="close_update">&times;</span><span class="sr-only">Close</span>
					</button>
					<h2 class="modal-title" style="text-align: center" id="myModalLabel">资源信息</h2>
				</div>
				<div class="modal-body" style="height:230px;">
					<div>
			 			<table class="show-resource" id="show_resource_table">
				 			<tr style="display: none;">
				 				<td>ID</td>
				 				<td><span class="sp" id="id_res_span_update"></span><input type="text" class="form-control in" style="display: none;" id="id_res_text_update"/></td>
				 			</tr>
				 			<tr>
				 				<td>名称</td>
				 				<td><span class="sp" id="name_res_span_update"></span><input type="text" class="form-control in" style="display: none;" id="name_res_text_update"/></td>
				 			</tr>
				 			<tr>
				 				<td>类型</td>
				 				<td>
				 					<span class="sp" id="type_res_span_update"></span>
				 					<div class="btn-group in" style="display: none;" id="type_res_text_update">
									  <button data-toggle="dropdown" class="btn btn-default dropdown-toggle">按钮<span class="caret"></span></button>
									    <ul class="dropdown-menu">
  									      <li><input type="radio" id="menu_update" name="NAME" value="VALUE"><label for="menu_update">菜单</label></li>
									      <li><input type="radio" id="button_update" name="NAME" value="VALUE" checked="checked"><label for="button_update">按钮</label></li>
									    </ul>
									</div>
				 				
				 				</td>
				 			</tr>
				 			<tr>
				 				<td>URL路径</td>
				 				<td><span class="sp" id="url_res_span_update"></span><input type="text" class="form-control in" style="display: none;" id="url_res_text_update"/></td>
				 			</tr>
			 				<tr>
				 				<td>权限字符串</td>
				 				<td><span class="sp" id="permission_res_span_update"></span><input type="text" class="form-control in" style="display: none;" id="permission_res_text_update"/></td>
				 			</tr>
			 			</table>
			 		</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="resource_update_btn" class="btn btn-primary btn-lg btn-block">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="add_resource_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						&times;
					</button>
					<h2 class="modal-title" style="text-align: center">添加子节点</h2>
				</div>
				<div class="modal-body" style="height:300px;margin-top:20px;">
					<form class="form-horizontal">
						 <div class="form-group" style="display: none;">
						    <label for="parentids_add_res" class="col-sm-3 control-label">父节点IDS</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" id="parentids_add_res"  placeholder="父节点ID">
						    </div>
						  </div>
						 <div class="form-group" style="display: none;">
						    <label for="parentid_add_res" class="col-sm-3 control-label">父节点ID</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" id="parentid_add_res"  placeholder="父节点ID">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="parentname_add_res" class="col-sm-3 control-label">父节点名称</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" disabled="disabled" id="parentname_add_res"  placeholder="父节点名称">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="childrenname_add_res" class="col-sm-3 control-label">子节点名称</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" id="childrenname_add_res" placeholder="子节点名称">
						    </div>
						  </div>
						  <div class="form-group">
						    <label class="col-sm-3 control-label">类型</label>
						    <div class="col-sm-8">
								<div class="btn-group">
								  <button data-toggle="dropdown" class="btn btn-default dropdown-toggle" id="type_add_res">按钮<span class="caret"></span></button>
								    <ul class="dropdown-menu">
								      <li><input type="radio" name="NAME" value="VALUE" checked="checked" id="button_add" ><label for="button_add">按钮</label></li>
								      <li><input type="radio" name="NAME" value="VALUE" id="menu_add" ><label for="menu_add" >菜单</label></li>
								    </ul>
								</div>								            
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="url_add_res" class="col-sm-3 control-label">URL路径</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" readonly="readonly"  id="url_add_res" placeholder="例子：/user">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="permission_add_res" class="col-sm-3 control-label">权限字符串</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" id="permission_add_res" placeholder="例子：user:add">
						    </div>
						  </div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btn-lg btn-block" id="add_resource_btn">确定</button>
				</div>
			</div>
		</div>
	</div>
	
 </body>
