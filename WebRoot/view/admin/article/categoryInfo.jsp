<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'categoryInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div style="width:100%;height:50px;">
		<div class="" style="float:left;with:300px;height:50px;margin-left:-14px;">
			<ol class="breadcrumb">
			  <li><a href="javascript:void(0)">文章管理</a></li>
			  <li class="active">栏目信息</li>
			</ol>
		</div>
		<div style="float:right;margin-bottom:10px;">
			<a href="#add_category_modal" data-target="#add_category_modal" data-toggle="modal" class="btn btn-primary btn-lg" id="add_category_link">添加栏目</a>			
		</div>
	</div>
	
	
	<!-- 显示用户 -->
	<div style="height:500px;">
		<table class="table table-responsive table-striped table-bordered table-hover" id="allCategory">
			<thead>
				<tr>
					<th style="display: ;">ID</th>
					<th>栏目名称</th>
					<th>栏目类型</th>
					<th>栏目状态</th>
					<th style="display: ;">栏目顺序</th>
					<th>操作</th>
				</tr>
			</thead>
			
			<tbody>
			</tbody>
		</table>
	</div>
	
	
	<!--添加栏目 -->
	<div class="modal fade" id="add_category_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						&times;
					</button>
					<h2 class="modal-title" style="text-align: center">添加栏目</h2>
				</div>
				<div class="modal-body" style="height:70px;margin-top:20px;">
					<form class="form-horizontal" action="">
						<div class="form-group">
							<label for="categoryname_text_add" class="col-sm-2 control-label">栏目名称</label>

							<div class="col-sm-9">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="icon-list-alt icon-large"></i>
									</div>
									<input id="categoryname_text_add" type="text" class="form-control input-lg" placeholder="请输入栏目 名称">
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btn-lg btn-block" id="add_category_btn">确定</button>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
