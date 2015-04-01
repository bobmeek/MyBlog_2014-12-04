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
	<style type="text/css">
		
		li{cursor:pointer;}
		.cur{background:green;}
		.firstli{background: green;}
		
	</style>
	
	<script type="text/javascript">
		
		window.onload = function()
		{
			 var aLi = document.getElementsByTagName("li"); //获得所有li元素
			 for (var i = 0; i < aLi.length; i++) //循环li元素的长度
			 {  
			  	aLi[i].onclick = function ()
			  	{
			   		for (var j = 0; j < aLi.length; j++)
			   		{
			   			aLi[j].className = "";
			   			this.className = "cur";
			   		}
			  	};
		 	}
		};
		
	</script>
	
  </head>
  
  <body>
  
		<div class="clMenu">
		    <ul>
		        <li class="firstli">新客网首页</li>
		        <li>js特效</li>
		        <li>photoshop</li>
		        <li>免费资源</li>
		    </ul>
		</div>
	
  </body>
  
</html>