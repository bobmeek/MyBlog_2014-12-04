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
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/front_frame/bacheditor/css/stylesheet.css" media="screen">
    <link rel="stylesheet" href="resources/front_frame/bacheditor/css/pygment_trac.css">
    <link rel="stylesheet" href="resources/front_frame/bacheditor/css/editor.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/codemirror/4.6.0/codemirror.min.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.3/styles/default.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.3/highlight.min.js"></script>
    <!-- <script type="text/javascript" src="//upcdn.b0.upaiyun.com/libs/jquery/jquery-2.0.3.min.js"></script> -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/marked/0.3.2/marked.min.js"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/codemirror/4.6.0/codemirror.min.js"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/zeroclipboard/2.1.6/ZeroClipboard.min.js"></script>
    <script type="text/javascript" src="resources/front_frame/bacheditor/js/highlight.js"></script>
    <script type="text/javascript" src="resources/front_frame/bacheditor/js/fileupload.js"></script>
    <script type="text/javascript" src="resources/front_frame/bacheditor/js/modal.js"></script>
    <script type="text/javascript" src="resources/front_frame/bacheditor/js/MIDI.js"></script>
    <script type="text/javascript" src="resources/front_frame/bacheditor/js/bacheditor.js"></script>
	
	
		
  </head>
  
  <body>

	<h3>撰写新文章</h3><br /><br />
			<p style="margin-bottom: 0;">文章标题</p>
			<input type="text"  id="article_title" name="article_tag" style="width: 320px; height: 28px;" placeholder="标题：一句话描述清楚你要发表的文章标题" /><br /><br />
			<p style="margin-bottom: 0;">文章标签</p>
			<input type="text"  id="article_tag" name="article_tag" style="width: 320px; height: 28px;" placeholder="标签：标签如：php，java，多个标签以 , 分隔" /><br /><br />
			<p style="margin-bottom: 0;">分类目录</p>
		
	<div id="mainbody">
		<!-- <input type="checkbox">
			<span class="label label-info">Bootstrap</span>
			<input type="checkbox">	
			<span class="label label-info">Bootstrap</span>
			<input type="checkbox">
			<span class="label label-info">Bootstrap</span>
			<input type="checkbox">	
			<span class="label label-info">Bootstrap</span> -->
	</div>		
			

	<div class="wrapper">
		<header> </header>
		<div id="container">
			<div class="editor" id="editor">
				<textarea id="myEditor"></textarea>
			</div>
		</div>
	</div>
	<footer>

    </footer>

	<div class="current-section">
		<p class="name"></p>
	</div>
	<!-- <button type="button" class="btn btn-default btn-lg">发布文章</button> -->
	<button type="button" id="publish_article_button" class="btn btn-default btn-lg btn-block">发布文章</button>
	<script>
 		$(function() 
 		{
 			var myEditor = new Editor();
 			myEditor.render('#myEditor');
 		});
	</script>
	<script type="text/javascript" src="resources/front_base/js/admin/article/addArticle.js"></script>
</body>
</html>