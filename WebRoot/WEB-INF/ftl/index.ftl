<#import "spring.ftl" as s />
<!DOCTYPE>
<html>
	<head>
		<title>博客首页</title>
		<link href="resources/front_frame/bootstrap/css/bootstrap2.css" rel="stylesheet" />
		<link href="resources/front_base/css/index.css" rel="stylesheet" /><!-- 首页CSS文件 -->
	</head>  
	<body style="background-color: #F0F2F7;">
		<#include 'header.ftl'/>
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
				<#--判断是否为存在-->
				<#if articles?exists>
				<#list articles as article>
					<div class="news_1">
						<span class='news_title'><a href="${article.id}"  target='${siteInfo.target}'><span>${article.title}</span>${article.title}</a></span>
						<span class="news_year">${article.releaseDate?string("yyyy年MM月dd日")}</span>
						<div class="news_img"><img src="resources/front_base/img/index/news_2.jpg" style="width: 648px; height: 300px; border-top: 1px solid #dcdcdc; padding-top: 10px;"></div>
						<p class="news_content">
							<#--assign定义变量,如果是对象为字符串,那么需加""-->
							<#assign content="${article.content}" >
							<#assign contentLength="${content}" ?length >
							<#--不需要用"${}",因为返回的不是字符串类型,而是boolean类型-->
							<#if contentLength<50>
								${content}
								<#else>
								${content}[...]
							</#if>
							
						</p>
						<div class="news_tag">
							<span>分类：<span class="news_cat">${article.category.name}</span></span>
							<span>标签：</span>
							<span>评论：<span class="news_com">33条评论</span></span>
							<span>浏览：<span class="news_scan">${article.readCount}</span></span>
							<span class="news_reading"><a href='${article.id}' target='${siteInfo.target}'>阅读全文</a></span>					
						</div>
					</div>
				</#list>
				</#if>
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
						<#list hotArticles as article>
							<#if article_index==0>
								<li class="li_top"><a href='${article.id}' target='${siteInfo.target}'>${article.title}</a></li>
								<#elseif article_index lt hotPageCount>
								<li><a href='${article.id}' target='${siteInfo.target}'>${article.title}</a></li>
							</#if>
							
						</#list>
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
				<ul name='${currentPage}'>
					<#if hasPrePage>
					<li class="pre"><a>上一页</a></li>
					</#if>
					
					<#list 1..totalPage as i>
						<#if i_index==0>
							<li><a class='currentpage' style='background-color:#a1a3a6'>${i}</a></li>
							<#else>
							<li><a class='currentpage'>${i}</a></li>
						</#if>
					</#list>
					
					<#if hasNextPage>
					<li class="next"><a>下一页</a></li>
					</#if>
				</ul>
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
		$('#myCarousel').carousel('next');  
	</script>  
</html>