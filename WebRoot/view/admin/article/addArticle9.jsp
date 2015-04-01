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
	<link rel="stylesheet" href="resources/front_base/css/reset.css" />
	<link rel="stylesheet" href="resources/front_base/css/style.css" />
	
	<style type="text/css">
		.cd-popup {
  opacity: 0;
  visibility: hidden;
  transition: opacity 0.3s 0s, visibility 0s 0.3s;
}
.cd-popup.is-visible {
  opacity: 1;
  visibility: visible;
  transition: opacity 0.3s 0s, visibility 0s 0s;
}
.cd-popup-container {
  transform: translateY(-40px);
  transition-property: transform;
  transition-duration: 0.3s;
}
.is-visible .cd-popup-container {
  transform: translateY(0);
}
	
	</style>

	<script type="text/javascript">
	jQuery(document).ready(function($){
		  //open popup
		  $('.cd-popup-trigger').on('click', function(event){
		    //event.preventDefault();
		    $('.cd-popup').addClass('is-visible');
		  });
		  //close popup
		  $('.cd-popup').on('click', function(event){
		    if( $(event.target).is('.cd-popup-close') || $(event.target).is('.cd-popup') ) {
		      event.preventDefault();
		      $(this).removeClass('is-visible');
		    }
		  });
		  //close popup when clicking the esc keyboard button
		  $(document).keyup(function(event){
		      if(event.which=='27'){
		        $('.cd-popup').removeClass('is-visible');
		      }
		    });
		});
	
	</script>

  </head>
  
  
  
  <body>
  
<a href="#0" class="cd-popup-trigger">View Pop-up</a>

<div class="cd-popup" role="alert">
	<div class="cd-popup-container">
		<p>确认删除该栏目吗？点击确认按钮相关文章将会一同删除，该操作无法逆转。</p>
		<ul class="cd-buttons">
			<li><a href="#0">确认</a></li>
			<li><a href="#0">取消</a></li>
		</ul>
		<a href="#0" class="cd-popup-close img-replace">Close</a>
	</div> <!-- cd-popup-container -->
</div> <!-- cd-popup -->
  
  <script src="resources/front_base/js/jquery-1.8.3.js"></script>
  <script src="resources/front_base/js/main.js"></script>
  </body>
  
</html>