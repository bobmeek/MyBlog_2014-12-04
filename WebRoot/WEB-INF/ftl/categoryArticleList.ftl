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
			
				<div class="sub-content-right"><!-- 内容右侧区域开始 -->
					<div class="sub-content-main">
						<div class="sub-content-title">
							<span class="content-title">${categoryMenuName}</span>
							<div class="sub-content-pagenav">
								<a href="${basePath}/index.html">首页</a>/<a class="cur" href="${basePath}/category/${categoryMenuName}/1">${categoryMenuName}</a> 
							</div>
						</div>
						
					<ul class="list-art"><!-- 右侧导航内容列表开始 -->
					    <#if articles?exists>
					        <#list articles as article>
					            <li>
					                <span>${(article.releaseDate?date("yyyy-MM-dd"))}   </span>
							         <#if article.highLight==1>
										<a href="${basePath}/category/${categoryMenuName}/${article.id}/${article.title}" style='color:red;font-weight:bold;'>${article.title}</a>
									<#else>
										<a href="${basePath}/category/${categoryMenuName}/${article.id}/${article.title}">${article.title}</a>
									</#if>
					            </li>
					        </#list>
					    </#if>
					</ul><!-- 右侧导航内容列表结束 -->
			
					<div class="pagination"><!-- 分页开始 -->
					
						<#list 1..totalPage as p>
							<#if currentPage==p>
								<span class="active">${currentPage}</span>
								<#else>
								<a href="${basePath}/category/${categoryMenuName}/${p}">${p}</a>	
							</#if>
						</#list>
						<a href="#" class="next">&gt;</a>共${totalCount}条信息 
						
						<!--<span class="active">1</span>
							<a href="#">2</a>
							<a href="#">3</a>
							<a href="#">4</a>
							<a href="#">5</a>
							<a href="#">6</a>
							<a href="#">7</a>
							<a href="#" class="next">&gt;</a>
							<a href="#" class="last">109</a>
							共2166条信息 -->
					</div><!-- 分页结束 -->
						
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