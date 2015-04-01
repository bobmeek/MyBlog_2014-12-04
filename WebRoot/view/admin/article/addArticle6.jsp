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
			
			.more_1{ display:none;}
.qy_more{width: 1050px;z-index: 22;margin-left:75px;}
#more_1{color:#5FA4C6; background:none; top:20px; left:1130px; padding:0px; margin-top:4px; position:absolute;}
.qy_more a {float:left;padding:3px 5px;}
.qy_more a:hover {float:left; background-color:#fce8d6;color: #666;padding:3px 5px;}
.posi_xs { position:relative; z-index:22;}
#more_1{cursor:pointer;}
.shadow{margin: 0 auto;background:#fff; 
filter:progid:DXImageTransform.Microsoft.Shadow(color=#e6e6e6,direction=120,strength=4);/*兼容
ie*/
-moz-box-shadow: 2px 2px 10px #e6e6e6;/* www.111cn.net兼容firefox*/
-webkit-box-shadow: 2px 2px 10px #e6e6e6;/*兼容safari或chrome*/
box-shadow:2px 2px 10px #e6e6e6;/*兼容opera或ie9*/
}
				
	</style>
	
	<script type="text/javascript">
		
	$(function(){
	     $("#more_1").click(function(){
	   
	  if($(".qy_more").hasClass("more_1"))
	  {
	  $(".qy_more").removeClass("more_1"); 
	  $(this).html("隐藏");
	  }
	  
	  else{
	   $(".qy_more").attr("class", " more_1 qy_more"); 
	      $(this).html("更多>>");
	  }
	  })
	  
	})
		
	</script>
	
  </head>
  
  <body>
  
  	<a id="more_1">更多>></a> 
<div class="more_1 qy_more ">
       <span class="cityjia"><a href="?cityid=2704&h=1" >佳木斯</a><span class="cityline">|</span></span><span class="cityjia">www.111cn.net<a href="?cityid=2715&h=1" >牡丹江</a><span class="cityline">|</span></span><span class="cityjia"><a href="?cityid=2727&h=1" >赣州</a><span class="cityline">|</span></span><span class="cityjia"><a href="?cityid=2751&h=1" >九江</a><span class="cityline">|</span></span><span class="cityjia"><a href="?cityid=2767&h=1" >吉安</a><span class="cityline">|</span></span><span class="cityjia"><a href="?cityid=2768&h=1" >上饶</a><span class="cityline">|</span></span><span class="cityjia"><a href="?cityid=2781&h=1" >宜春</a><span class="cityline">|</span></span>
        <div class="clear"></div>
 </div>
	
  </body>
  
</html>