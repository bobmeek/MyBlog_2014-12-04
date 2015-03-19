<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>footer</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    	
    	<div id="footer"><!-- 底部区域 -->
			<div class="sns">
				<ul>
					<li><a href="#"><img class="weibo"  src="resources/front_base/img/index/weibo.png" /></a></li>
					<li><a href="#"><img class="zhihu"  src="resources/front_base/img/index/zhihu.png" /></a></li>
					<li><a href="#"><img class="twitter"  src="resources/front_base/img/index/twitter.png" /></a></li>
					<li><a href="#"><img  class="rss"  src="resources/front_base/img/index/rss.png" /></a></li>
				</ul>
			</div>
			<span class="copyright">2011-2015 夏煜正 All Rights Reserved   /   Theme By Bob-Meek & Keven小卫</span>
		</div>
    	
  </body>
</html>