<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据备份</title>
</head>
<body>
	<div style="width:100%;height:50px;">
		<div class="" style="float:left;with:300px;height:50px;margin-left:-14px;">
			<ol class="breadcrumb">
			  <li><a href="javascript:void(0)">系统管理</a></li>
			  <li class="active">数据备份</li>
			</ol>
		</div>
		<div style="float:right;margin-bottom:10px;">
			<form class="form-inline">
			    <input type="text" id='fileName' class='form-control' placeholder='请输入备份文件名称'>
			    <a href="javascript:;" class="btn btn-primary" id="dataFileLinkBackup">备份网站数据</a>
			</form>
						
		</div>
	</div>
	
	<!-- 显示备份数据列表 -->
	<div style="height:500px;">
		<table class="table table-responsive table-striped table-bordered table-hover" id="allDataFiles">
			<thead>
				<tr>
					<th style="display: none;">ID</th>
					<th>备份文件名</th>
					<th>备份时间</th>
					<th>文件大小</th>
					<th>操作</th>
				</tr>
			</thead> 
			
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>