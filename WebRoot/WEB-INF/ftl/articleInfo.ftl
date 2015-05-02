<!DOCTYPE>
<html>
	<head>
		<title>${article.title}</title>
		<link href="resources/front_frame/bootstrap/css/bootstrap2.css" rel="stylesheet" />
		<link href="resources/front_base/css/index.css" rel="stylesheet" /><!-- 首页CSS文件 -->
	</head>  
	<body style="background-color: #F0F2F7;">
		<#include 'header.ftl'/>
		
		<div id='main'>
			<div id='left'>
				<div class='' style='background-color: #FFF;width: 668px;'>
					<h3 class='single-title'>${article.title}</h3>
					<div class='single-info'>
						<span style='margin-left:5px;'>作者:${article.author}</span>
						<span style='margin-left:5px;'>时间:${article.releaseDate}</span>
						<span style='margin-left:5px;'>浏览:${article.readCount}</span>
					</div>
				</div>
				<div id='single-con'>${article.content}</div>
				<div></div>
			</div>
		</div>
		<#include 'footer.ftl'/><!-- 引入尾部版权区jsp文件 -->
		<a href="#0" class="cd-top">Top</a><!-- 返回顶部 -->
	</body>  
	<script type="text/javascript" src="resources/front_frame/bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="resources/front_frame/bootstrap/js/bootstrap-carousel.js"></script><!-- bootstrap轮播图js文件 -->
	<script type="text/javascript" src="resources/front_frame/time.js"></script><!-- 返回顶部js文件 -->
	<script type="text/javascript" src="resources/front_base/js/index.js"></script><!-- 返回顶部js文件 --> 
	
	<script type="text/javascript">   
	</script>  
</html>