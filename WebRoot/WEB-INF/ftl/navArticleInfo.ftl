<html>
<head>
	<title>学院概况-汉口学院国际交流学院</title>
	<link rel="stylesheet" type="text/css"  href="${basePath}/resources/front_base/css/normalize.css" /><!-- 主页面初始化CSS样式表1 -->
	<link rel="stylesheet" type="text/css"  href="${basePath}/resources/front_base/css/skeleton.css" /><!-- 主页面初始化CSS样式表2 -->
    <link rel="stylesheet" type="text/css" href="${basePath}/resources/front_base/css/articleInfo.css" /><!-- 二级页面CSS样式表 -->
	<!--<link rel="stylesheet" type="text/css" href="${basePath}/resources/front_frame/bootstrap/css/font-awesome.min.css" />-->
	 <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	
</head>
<body>
	
		<#include "top.ftl">
		
		<div id="sub-content"><!-- 中间大块区域 -->
		
			<div class="container con"><!-- 内容区域开始 -->
			
				<div class="sub-content-left"><!-- 内容左测区域开始 -->
					<ul class="sub-content-nav"><!-- 内容左侧区域导航开始 -->
						<h3><span>${parentMenuName}</span></h3>
						<#if menus?exists>
							<#list menus as menu>
								<li>
									<a href="${basePath}/nav/${parentMenuName}/${menu.name}/1" title="${menu.name}">${menu.name}</a>
								</li>
							</#list>
						</#if>
					</ul><!-- 内容左侧区域导航结束 -->
				</div><!-- 内容左测区域结束 -->
				
				<div class="sub-content-right"><!-- 内容右侧区域开始 -->
					<div class="sub-content-main">
						<div class="sub-content-title">
							<span class="content-title">${childMenuName}</span>
							<div class="sub-content-pagenav">
								<a href="${basePath}/index.html">首页</a>/<a class="cur" href="${basePath}/nav/${parentMenuName}/${childMenuName}/1">${childMenuName}</a> 
							</div>
						</div>
						<!--<div class="sub-content-p">
							<div class="sub-content">
								<div class="sub-contents">
									 <font style="line-height: 200%">
									 		<p>
									 			<font style="font-size: 10.5pt">
									 				<#if article?exists>
									 					${article.content}
									 				</#if>
									 			</font>
									 		</p>
									 		<#if article?exists>
										 		<#if article.releaseDate?exists>
										 			<p align="right"><font style="font-size: 10.5pt">（${(article.releaseDate?date("yyyy-MM-dd"))?string("yyyy年MM月dd日")}更新）</font></p>
										 		</#if>
									 		</#if>
								</div>
							</div>
						</div>-->
						
						<div class="content-art">
							<h1>${article.title}</h1>
							<div class="attr">发布时间：${(article.releaseDate?date("yyyy-MM-dd"))?string("yyyy-MM-dd hh:mm:ss")} 浏览次数：621</div>
						</div>
						
						
						<div class="sub-content-p">
							<div class="sub-content">
								<div class="sub-contents">
									 <font style="line-height: 200%">
									 		<p><font style="font-size: 10.5pt">${article.content}</font></p> 
									 		<p align="right"><font style="font-size: 10.5pt">（${(article.releaseDate?date("yyyy-MM-dd"))?string("yyyy年MM月dd日")}更新）
									 </font></p></font>
								</div>
							</div>
						</div>
						
					</div>
				</div><!-- 内容右侧区域结束 -->
						
					</div>
				</div><!-- 内容右侧区域结束 -->
				
			</div><!-- 内容区域结束 -->
			
			<div class="footerbg desktop-hide"><!-- 内容区域底部图片，目前处于占位中 ... -->
				<div class="footerbg-left"></div>
				<div class="footerbg-right"></div>
			</div>
			
		</div><!-- 中间大块区域结束 -->
		
		<#include "footer.ftl">
	
</body>
</html>