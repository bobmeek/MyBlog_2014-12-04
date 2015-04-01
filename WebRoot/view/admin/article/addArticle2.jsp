<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发布文章</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- <link href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.css" rel="stylesheet"> -->
    <link rel="stylesheet" href="resources/front_frame/bacheditor/css/stylesheet.css" media="screen">
    <link rel="stylesheet" href="resources/front_frame/bacheditor/css/pygment_trac.css">
    <link rel="stylesheet" href="resources/front_frame/bacheditor/css/editor.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/codemirror/4.6.0/codemirror.min.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.3/styles/default.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.3/highlight.min.js"></script>
    <script type="text/javascript" src="//upcdn.b0.upaiyun.com/libs/jquery/jquery-2.0.3.min.js"></script>
    <!-- <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.js"></script> -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/marked/0.3.2/marked.min.js"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/codemirror/4.6.0/codemirror.min.js"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/zeroclipboard/2.1.6/ZeroClipboard.min.js"></script>
    <script type="text/javascript" src="resources/front_frame/bacheditor/js/highlight.js"></script>
    <script type="text/javascript" src="resources/front_frame/bacheditor/js/fileupload.js"></script>
    <script type="text/javascript" src="resources/front_frame/bacheditor/js/modal.js"></script>
    <script type="text/javascript" src="resources/front_frame/bacheditor/js/MIDI.js"></script>
    <script type="text/javascript" src="resources/front_frame/bacheditor/js/bacheditor.js"></script>
<!-- 	<script type="text/javascript" src="resources/front_base/js/jquery-1.8.3.js"></script>
	<link rel="stylesheet" href="resources/front_base/js/admin/article/addArticle2.css">
	 -->
  </head>
  
  <body>
	
		<div id="container_div">
			
			<!-- 左侧栏目部分 -->
			<div id="leftbody">
				<div id="create_category"><a href="javascript:void(0);" id="create_category_aid">+新建栏目</a></div>
				<div class="create_category_form" style="display: none">
					<form class="new_category_form">
						<input type="text"  id="article_category_name" name="category_name" style="width: 200px; height: 28px; margin-top: 10px;"   placeholder="请输入栏目名称 ..." /><br />
						<button type="button"  id="create_category_cancel" class="btn btn-default" style="margin-top: 10px;">取消</button>
						<button type="button" id="create_category_submit" class="btn btn-info" style="margin-top: 10px;">提交</button>
					</form>
				</div>
				
				<div id="dropdown_menu">
					<ul class="menu_nav">
					</ul>
				</div>
				
			</div>
			
			<!-- 中间新建文章部分 -->
			<div id="mainbody" style="overflow:auto;">
				<div id="create_article"><i class='icon-pencil icon-large'></i> <a id="a_create_article" href="javascript:void(0);">+新建文章</a></div>
				<hr />
				<!-- <div id="create_article_div" style="border: 1px solid #ccc; width: 370px; height: 90px; margin-bottom: 10px;">
					<a style="font-size: 18px; font-weight: bold;">无标题文章</a>
					<p>这是文章的内容</p>
				</div>
				<div id="create_article_div" style="border: 1px solid #ccc; width: 370px; height: 90px; margin-bottom: 10px;">
					<p  style="font-size: 18px; font-weight: bold;">无标题文章</p>
					<p>这是文章的内容</p>
				</div>
				<div id="create_article_div" style="border: 1px solid #ccc; width: 370px; height: 90px; margin-bottom: 10px;">
					<p  style="font-size: 18px; font-weight: bold;">无标题文章</p>
					<p>这是文章的内容</p>
				</div> -->
			</div>
			
			<!-- 右侧文章编辑部分 -->
			<div id="rightbody">
			<!-- <a id="published_articles" href="javascript:void(0);">发布文章</a> -->
			<!-- <span id="save_article" style="float: right; font-size: 12px;">已保存</span>
			<hr /> -->
				<!-- <div class="panel-heading">文章标题</div> -->
				<input type="text" id="rbody_article_title"  class="form-control" style="height: 70px; color: #555555; font-size: 18px; font-weight:bold;"><br />
				<div class="wrapper">
						<header> </header>
						<div id="container">
							<div class="editor" id="editor">
								<textarea id="myEditor"></textarea>
							</div>
						</div>
					</div>
					<footer></footer>
			
					<div class="current-section">
						<p class="name"></p>
					</div>

			</div>
			
		</div>
		
		<script>
	 		$(function() 
	 		{
	 			var myEditor = new Editor();
	 			myEditor.render('#myEditor');
	 		});
	</script>
	
	<script type="text/javascript" src="resources/front_base/js/admin/article/addArticle2.js"></script>
	
  </body>
</html>