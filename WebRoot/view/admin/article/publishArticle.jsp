<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>

<html>
<head>
<base href="<%=basePath%>">

<title>发布文章</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- 引入Simditor编辑器相关文件 -->


</head>

<body>
	<div style="width:100%;height:50px;">
		<div class=""
			style="float:left;with:300px;height:50px;margin-left:-14px;">
			<ol class="breadcrumb">
				<li><a href="javascript:void(0)">文章管理</a></li>
				<li class="active" id='publishArticleBreadcrumb'>发布文章</li>
			</ol>
		</div>
	</div>

	<div style='width:80%;margin:0px auto;background-color: white;'>
		<form class="form-horizontal">
			<div class="form-group">
				<label for="articleTitle" class="col-sm-2 control-label">文章标题</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="saveArticleTitle">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">文章分类</label>
				<div class="col-sm-3" >
					<input type="text" class="form-control" id="saveArticleMenu">
					<div id='articleMenuTreeDIV' style='position:absolute;z-index: 2;'>
						<ul id='articleMenuTree' class='ztree' style='display: none;'></ul>
					</div>
				</div>
				
			</div>
			
			
		</form>
		<div >
			<textarea id="editor"  placeholder="这里输入内容" autofocus></textarea>	
		</div>
		
		
		<div style='text-align: center;margin-top:10px;padding-bottom:20px;'>
			<button id='saveArticle' type="button" class="btn btn-primary btn-lg"><i class='icon-save icon-large'></i><span>保存</span></button>
			<button id='updateArticle' type="button" class="btn btn-primary btn-lg" style='display: none;'><i class='icon-save icon-large'></i><span>更新</span></button>
		</div>
	</div>
	
</body>

</html>