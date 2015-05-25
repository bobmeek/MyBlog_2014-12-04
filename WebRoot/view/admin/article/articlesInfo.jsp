<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
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
		
	</div>	
	
	
	<div class="form-group">
		<div class="col-sm-1">
			<select id='articleCategorySelect' name="栏目筛选" class="form-control">
					
			</select>
		</div>
	</div>	
			
	<div style="float: right; float: right;margin-top:-20px; ">
			<input type="text"  id="searchArticleText" name="searchTag" style="width: 300px; height: 28px;margin-bottom:10px;"/>
			<button type="button" id="search_article_button" style='margin-bottom:10px;' class="btn btn-info" onclick="searchTags();">搜索文章</button>
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
					<th>所属栏目</th>
					<th>发布时间</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
	
	<!-- 分页部分 -->
	<div class="page-pos" id="article_page">
		<nav>	
		  <ul class="pager">
	   		<li class="previous" id="article_pre"><a href="javascript:void(0)">&larr; 前一页</a></li>
	  	  	<li class="next" id="article_next"><a href="javascript:void(0)">下一页 &rarr;</a></li>
		  </ul>
		</nav>
	</div>


	<div class="modal fade" id="show_article_modal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true" id="close_show_article">&times;</span><span class="sr-only">Close</span>
					</button>
					<h2 class="modal-title" style="text-align: center">文章详细信息</h2>
				</div>
				<div class="modal-body">
					<textarea id="detailEditor" placeholder="这里输入内容" autofocus></textarea>
					<!--<script id="detailEditor" name="content" type="text/plain">
     				  	 这里写你的初始化内容
   					</script>-->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btn-lg btn-block" id="add_role_btn">确定</button>
				</div>
			</div>
		</div>
	</div>

  </body>
</html>