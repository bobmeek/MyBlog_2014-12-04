<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

	<title>博客首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="resources/front_frame/bootstrap/css/bootstrap2.css" rel="stylesheet" />
	<link href="resources/front_base/css/index.css" rel="stylesheet" /><!-- 首页CSS文件 -->
	
</head>

	<body style="background-color: #F0F2F7;">
  
	<jsp:include page="public/header.jsp"></jsp:include><!-- 引入头部导航jsp文件 -->
		
	<div id="myCarousel" class="carousel slide">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class=""></li>
			<li data-target="#myCarousel" data-slide-to="1" class=""></li>
			<li data-target="#myCarousel" data-slide-to="2" class="active"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item">
				<img src="resources/front_base/img/index/style1.jpg" alt="">
				<div class="carousel-caption">
					<h4>First Thumbnail label</h4>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
				</div>
			</div>
			<div class="item">
				<img src="resources/front_base/img/index/style2.jpg" alt="">
				<div class="carousel-caption">
					<h4>Second Thumbnail label</h4>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
				</div>
			</div>
			<div class="item">
				<img src="resources/front_base/img/index/style2.jpg" alt="">
				<div class="carousel-caption">
					<h4>Second Thumbnail label</h4>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
				</div>
			</div>
			<div class="item active">
				<img src="resources/front_base/img/index/style3.jpg" alt="">
				<div class="carousel-caption">
					<h4>Third Thumbnail label</h4>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" data-slide="prev"></a>
		<a class="right carousel-control" href="#myCarousel" data-slide="next"></a>
	</div>

	<div id="main"><!-- 中间信息区域 -->
			<div id="left"><!-- 中间信息左侧区域 -->
				<div id="news_1">
					<span><a href="#" class="news_title"> 一加手机官网域名跳转至加多宝 合作还是被黑？</a></span>
					<span class="news_year">2015年3月13日</span>
					<div class="news_img"><img src="resources/front_base/img/index/news_2.jpg" style="width: 648px; height: 300px; border-top: 1px solid #dcdcdc; padding-top: 10px;"></div>
					<p class="news_content">9月16日讯，现在访问一加手机官网域名oneplus.cn时，发现其首页被加多宝宣传图所占据，点击图片后将直接 […]</p>
					<div class="news_tag">
						<span>分类：<span class="news_cat">域名新况</span></span>
						<span>标签：</span>
						<span>评论：<span class="news_com">33条评论</span></span>
						<span>浏览：<span class="news_scan">520</span></span>
						<span class="news_reading">阅读全文</span>					
					</div>
				</div>
			</div><!-- 中间左边区域结束 -->
			<div id="right"><!-- 中间右边区域 -->
				<!-- <div id="advertising">
					<span>广告也支持！</span>
					<div class="gg"></div>
				</div> -->
				<!-- <div class="subscription">
					<p class="sub_contribute">欢迎订阅捐赠</p>
					<span>邮箱订阅：</span>
					<span>捐助本站：</span>
					<span>标志申明：</span>
				</div> -->
				<div class="remenwenzhang"><!-- 热门文章区域 -->
					<span>热门文章</span>
					<ul>
						<li class="li_top">用NativeScript创建JavaScript原生移动应用</li>
						<li>JavaScript性能优化小知识总结</li>
						<li>2015值得关注的几个WEB技术</li>
						<li>Using jQuery plugins with npm</li>
						<li>延长 XSS 生命期 – EtherDream – lib</li>
						<li>Riot.js — 1Kb 大小的 JavaScript 的 MVP 框架</li>
						<li>全栈工程师的武器——MEAN</li>
						<li>使用 SVG 制作单选和多选框动画</li>
					</ul>
				</div><!-- 热门文章区域结束 -->
				<div class="rementag"><!-- 热门标签区域 -->
					<span>热门标签</span>
					<ul>
						<li><a href="#">用户体验</a></li>
						<li><a href="#">招聘/求职</a></li>
						<li><a href="#">设计思路</a></li>
						<li><a href="#">网页设计</a></li>
						<li><a href="#">Java</a></li>
						<li><a href="#">PHP</a></li>
						<li><a href="#">mysql</a></li>
						<li><a href="#">javascript</a></li>
						<li><a href="#">jQuery</a></li>
						<li><a href="#">前端工具</a></li>
						<li><a href="#">前端资讯</a></li>
						<li><a href="#">性能优化</a></li>
						<li><a href="#">前端工具</a></li>
						<li><a href="#">前端资讯</a></li>
						<li><a href="#">性能优化</a></li>
						<li><a href="#">前端工具</a></li>
						<li><a href="#">前端资讯</a></li>
						<li><a href="#">性能优化</a></li>
						<li><a href="#">前端工具</a></li>
						<li><a href="#">前端资讯</a></li>
						<li><a href="#">性能优化</a></li>
						<li><a href="#">前端工具</a></li>
						<li><a href="#">前端资讯</a></li>
						<li><a href="#">性能优化</a></li>
						<li><a href="#">前端工具</a></li>
						<li><a href="#">前端资讯</a></li>
						<li><a href="#">性能优化</a></li>
						<li><a href="#">前端工具</a></li>
						<li><a href="#">前端资讯</a></li>
						<li><a href="#">性能优化</a></li>
					</ul>
				</div><!-- 热门标签结束 -->
			</div><!-- 中间右边区域结束 -->
			<div id="pagination"><!-- 分页区域 -->
				<ul>
					<li class="prev"><a href="#">上一页</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li class="next"><a href="#">下一页</a></li>
				</ul>
			</div>
		</div>
		
		<jsp:include page="public/footer.jsp"></jsp:include><!-- 引入尾部版权区jsp文件 -->
		<a href="#0" class="cd-top">Top</a><!-- 返回顶部 -->
		
  </body>
  	<script type="text/javascript" src="resources/front_frame/bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="resources/front_frame/bootstrap/js/bootstrap-carousel.js"></script><!-- bootstrap轮播图js文件 -->
	<script type="text/javascript" src="resources/front_base/js/top.js"></script><!-- 返回顶部js文件 --> 
	<script type="text/javascript">   
		$('#myCarousel').carousel('next');  
	</script>  
</html>