<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="resources/front_base/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="resources/front_frame/jcrop/js/jquery.Jcrop.js"></script>
	<script type="text/javascript">
	
	
	
	$(function(){
		
		
		$(":file").on("change",function(event){
			
			$("#head_img").prop("src","resources/front_base/img/head/02.jpg");
			alert($(this).val());
		});
		
	});
		
		
	
	
	</script>

  </head>
  
  <body>
  	<div>
  		<img src="resources/front_base/img/head/01.jpg" id="head_img" />
  	</div>
  	<div>
  		<input type="file" />
  		<button type="button">上传</button>
  	</div>
  </body>
</html>
