<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>首页菜单管理 </title>
</head>
<body>
	<div style='width:100%;height:50px;'>
		<div class='' style='float:left;with:300px;height:50px;margin-left:-14px;'>
			<ol class='breadcrumb'>
			  <li><a href='javascript:void(0)'>系统管理</a></li>
			  <li class='active'>首页菜单管理</li>
			</ol>
		</div>
		<div style="float:right;margin-bottom:10px;">
			<a href="#add_children_menu_modal" data-target="#add_children_menu_modal" data-toggle="modal" class="btn btn-primary btn-lg children_menu_add">添加子菜单</a>			
		</div>
	</div>
	
	<div class='index_menu'>
		<div class='index_menu_tree'>
			<ul id='indexMenuTree' class='ztree' style='width:250px;height:700px;background-color:#f0f0f0;border:none;overflow-y:hidden;'></ul>
		</div>
		
		<!-- 显示子菜单 -->
		<div class='index_menu_menu'>
			<table style='width:80%' style='float:right;' class="table table-responsive table-striped table-bordered table-hover" id="allMenu">
				<thead>
					<tr>
						<th style="display:none ;">ID</th>
						<th>菜单名称</th>
						<th>菜单类型</th>
						<th>菜单状态</th>
						<th style="display: ;">父ID</th>
						<th style="display: ;">菜单顺序</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
		
	</div>
	
	
	<!--添加子菜单-->
	<div class="modal" id="add_children_menu_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						&times;
					</button>
					<h2 class="modal-title" style="text-align: center">添加子菜单</h2>
				</div>
				<div class="modal-body" style="height:300px;margin-top:20px;">
					<form class="form-horizontal" action="">
						 <div class="form-group" style="display: none;">
						    <label for="parentid_add_menu" class="col-sm-3 control-label">父菜单ID</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" id="parentid_add_menu"  placeholder="父节点ID">
						    </div>
						 </div>
						 <div class="form-group">
						    <label for="parentname_add_menu" class="col-sm-2 control-label">父菜单名称</label>
						    <div class="col-sm-9">
						    	<div class="input-group">
									<div class="input-group-addon">
										<i class="icon-list-alt icon-large"></i>
									</div>
									<input type="text" id="parentname_add_menu" class="form-control input-lg" disabled="disabled">
								</div>
						    </div>
						 </div>
						  
						<div class="form-group">
							<label for="childrenname_add_menu" class="col-sm-2 control-label">子菜单名称</label>
							<div class="col-sm-9">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="icon-list-alt icon-large"></i>
									</div>
									<input id="childrenname_add_menu" type="text" class="form-control input-lg" placeholder="请输入子菜单名称">
								</div>
							</div>
						</div>
						<div class="form-group">
						    <label class="col-sm-2 control-label">菜单类型</label>
						    <div class="col-sm-9" style='margin-top:-8px;'>
								<div class="btn-group">
								  <button data-toggle="dropdown" class="btn btn-default dropdown-toggle" id="indexmenu_add_span">导航菜单<span class="caret"></span></button>
								    <ul class="dropdown-menu">
								      <li><input type="radio" name="NAME" value="VALUE" checked="checked" id="indexmenu_add_btn" ><label for="indexmenu_add_btn">导航菜单</label></li>
								      <li><input type="radio" name="NAME" value="VALUE" id="indexmenu_add_txt" ><label for="indexmenu_add_txt" >栏目菜单</label></li>
								    </ul>
								</div>								            
						    </div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btn-lg btn-block" id="add_children_menu_btn">确定</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	<!--修改子菜单-->
	<div class="modal fade" id="detail_children_menu_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						&times;
					</button>
					<h2 class="modal-title" style="text-align: center">修改菜单</h2>
				</div>
				<div class="modal-body" style="height:100px;margin-top:20px;">
					<form class="form-horizontal" action="">
						  <div class="form-group">
						    <label for="name_detail_menu" class="col-sm-2 control-label">菜单名称</label>
						    <div class="col-sm-9">
						    	<div class="input-group">
									<div class="input-group-addon">
										<i class="icon-list-alt icon-large"></i>
									</div>
									<input type="text" id="name_detail_menu" class="form-control input-lg" placeholder="请输入菜单名称">
								</div>
						    </div>
						  </div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btn-lg btn-block" id="detail_children_menu_btn">确定</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>