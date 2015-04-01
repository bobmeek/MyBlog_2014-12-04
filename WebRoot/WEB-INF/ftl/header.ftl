<html>
<head>
</head>
<body>
	<div id="top"><!-- 顶部区域 -->
		<div id="top_menu"><!-- 顶部导航区域 -->
			<ul class="nav">
				<li><a href="index.html" class="index">首页</a></li>
				<#list categorys as category>
					<#if category.status==1 && category_index lt siteInfo.navCount-1>
						<li><a href="category/${category.name}" target='${siteInfo.target}'>${category.name}</a></li>
					</#if>
				</#list>
			</ul>				
		</div><!-- 顶部导航区域结束 -->
	</div><!-- 顶部区域结束 -->
</body>
</html>