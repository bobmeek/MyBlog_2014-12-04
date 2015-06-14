<html>
<head>
	<title>学院概况-汉口学院国际交流学院</title>
	
	<link rel="stylesheet" type="text/css"  href="${basePath}/resources/front_base/css/articleInfo.css" />
	
</head>
<body>
		<#include "top.ftl">
		
		<div id="sub-content"><!-- 中间大块区域 -->
		
			<div class="container con"><!-- 内容区域开始 -->
				<div class="sub-content-right"><!-- 内容右侧区域开始 -->
					<div class="sub-content-main">
						<div class="sub-content-title">
							<span class="content-title">${categoryMenuName}</span>
							<div class="sub-content-pagenav">
								<a href="${basePath}/index.html">首页</a>/<a class="cur" href="${basePath}/category/${categoryMenuName}/1">${categoryMenuName}</a> 
							</div>
						</div>
						
						<div class="content-art">
							<h1>${article.title}</h1>
							<div class="attr">发布时间：${(article.releaseDate?date("yyyy-MM-dd"))?string("yyyy-MM-dd hh:mm:ss")} 浏览次数：621</div>
						</div>
						
						
						<div class="sub-content-p">
							<div class="sub-content">
								<div class="sub-contents">
							 		${article.content}
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