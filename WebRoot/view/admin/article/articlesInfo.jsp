<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文章信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
	
		table th
		{
			text-align:center;
		}
		
		table td
		{
			text-align:center;
		}
	
	</style>

  </head>
  
  <body>
	
	<!-- 文章信息头部 -->
	<div style="width:100%;height:50px;">
		<div class="" style="float:left;with:300px;height:50px;margin-left:-14px;">
			<ol class="breadcrumb">
			  <li><a href="javascript:void(0)">文章管理</a></li>
			  <li class="active">文章信息</li>
			</ol>
		</div>
		<!-- <div style="float:right;margin-bottom:10px;">
			<a href="javascript:void(0)" class="btn btn-danger btn-lg" id="delete_user_link">删除文章</a>
			<a href="#add_user_modal" data-target="#add_user_modal" data-toggle="modal" class="btn btn-primary btn-lg" id="add_user_link">添加文章</a>
		</div> -->
	</div>	
	
	<select name="批量操作">
			<option value="1" selected="selected">批量操作</option>
			<option value="2" id="delete_article_link">批量删除</option>
	</select>
	<button type="button" id="delete_article_button" class="btn btn-info" onclick="searchTags();">删除</button>
	<div style="float: right; margin-top: -9px;">
			<input type="text"  id="article_text" name="searchTag" style="width: 300px; height: 28px;"/>
			<button type="button" id="search_article_button" class="btn btn-info" onclick="searchTags();">搜索文章</button>
		</div>
	
	<!-- 显示文章信息 -->
	<div style="height:500px;">
		<table class="table table-responsive table-striped table-bordered table-hover" id="allArticles">
			<thead>
				<tr>
					<th style="display: none;">文章序列</th><!-- 该列被隐藏 -->
					<th><input type="checkbox" id="allArticles_check"></th>
					<th>文章标题</th>
					<th>文章作者</th>
					<th>分类目录</th>
					<th>文章标签</th>
					<th>发布时间</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
	
	<!-- 分页部分 -->
	<div class="article-page" id="article_page">
		<nav>	
		  <ul class="pager">
	   		<li class="previous" id="article_pre"><a href="javascript:void(0)">&larr; 前一页</a></li>
	  	  	<li class="next" id="article_next"><a href="javascript:void(0)">下一页 &rarr;</a></li>
		  </ul>
		</nav>
	</div>

  </body>
</html>