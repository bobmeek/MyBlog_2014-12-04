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
<!-- 				 					<input type="text" class="form-control in" style="display: none;" id="type_res_text_update"/> -->
				 					<div class="btn-group in" style="display: none;" id="type_res_text_update">
									  <button data-toggle="dropdown" class="btn btn-default dropdown-toggle">按钮<span class="caret"></span></button>
									    <ul class="dropdown-menu">
  									      <li><input type="radio" id="menu" name="NAME" value="VALUE"><label for="menu">菜单</label></li>
									      <li><input type="radio" id="betton" name="NAME" value="VALUE" checked="checked"><label for="betton">按钮</label></li>
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
	
	
 </body>
