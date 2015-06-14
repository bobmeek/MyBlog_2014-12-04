<html>
<head>
	<title>学院概况-汉口学院国际交流学院</title>
	 <link rel="stylesheet" href="${basePath}/resources/front_frame/bootstrap/css/font-awesome.min.css"><!-- 图标文件 -->

	
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
								<#if menu.name==childMenuName>
									<li class='active'>
										<a href="${basePath}/nav/${parentMenuName}/${menu.name}/1" title="${menu.name}">${menu.name}</a>
									</li>
								<#else>
									<li>
										<a href="${basePath}/nav/${parentMenuName}/${menu.name}/1" title="${menu.name}">${menu.name}</a>
									</li>
								</#if>
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
						<ul class="list-art"><!-- 右侧导航内容列表开始 -->
						    <#if articles?exists>
						        <#list articles as article>
						            <li>
						                <span>${(article.releaseDate?date("yyyy-MM-dd"))}   </span><a href="${basePath}/nav/${childMenuName}/${currentPage}/${article.id}/${article.title}">${article.title}</a>
						            </li>
						        </#list>
						    </#if>
						</ul><!-- 右侧导航内容列表结束 -->
			
						<div class="pagination"><!-- 分页开始 -->
							<#list 1..totalPage as p>
								<#if p==currentPage>
									<span class="active">${p}</span>
									<#else>
									<a href="${basePath}/nav/${parentMenuName}/${childMenuName}/${p}">${p}</a>
								</#if>
							</#list>
						<a href="#" class="next">&gt;</a>共${totalCount}条信息
						
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