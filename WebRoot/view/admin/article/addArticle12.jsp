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
	
		body
		{
			padding: 0;
			margin: 0; 
			background-color: #FFF;
		}
		
		.arrow
		{
			width: 160px;
			height: 82px;
			color: white;
			background-color: #FFF;
			border-radius: 5px;
			position: relative;
			box-shadow: 10px 10px 5px #D9D9D9;
			-moz-box-shadow: 10px 10px 5px #D9D9D9;
		}
		
		.bottomarrow
		{
			  width: 0;
			  height: 0;
			  position: absolute; 
			  left: 120px;
			  bottom: 82px;
			  border:  transparent 16px solid;
			  border-bottom: #FFF 16px solid; 
			  border-bottom-color: red;
			  box-shadow: 5px #D9D9D9;
			-moz-box-shadow: 10px  5px #D9D9D9;
		}
		
		/* .div1
		{
			border: blue 160px solid;
			width: 16px;
			border-top: #FFF 100px solid; 
		}
		
		.div2
		{
			margin-top: 50px;
			width: 50px;
			height: 50px;
			border: 15px solid green;
		}	 */
	
	</style>

	<script type="text/javascript">
	
	</script>

  </head>
  
  
  
  <body style="background-color: #FFF;">
  
  	<div  class="arrow">
  		<div class="bottomarrow"></div>
  	</div>
  
  
  	<div class="div1"></div>
  		<div class="div2"></div>
  
  </body>
  
</html>