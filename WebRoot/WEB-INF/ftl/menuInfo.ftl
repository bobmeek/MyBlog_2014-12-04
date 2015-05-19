<!DOCTYPE>
<html>
	<head>
		<title></title>
	</head>  
	<body>
		<ul>
		<#if menus?exists>
			<#list menus as menu>
				<li>
		           <a href="${menu}">${menu}</a>
				</li>
			</#list>
		</#if>
		</ul>
		<hr/>
		<ul>
		<#if articles?exists>
			<#list articles as article>
				<li><a href='${basePath}/article/${article.id}/${article.title}'>${article.title}</a></li>
			</#list>
		</#if>
		</ul>
	</body>  
	<script type="text/javascript" src="${basePath}/resources/front_frame/bootstrap/js/jquery.js"></script>
	
	
	<script type="text/javascript">   
	</script>  
</html>