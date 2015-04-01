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
			}
			
			.arrow
			{
				width: 160px;
				height: 82px;
				color: white;
				background-color: #FFF;
				border-radius: 5px;
				position: relative;
			}
			
			.arrow ul
			{
				list-style-type: none;
				padding-left: 0;
				/* width: 160px;
				height: 82px; */
			}
			
			.arrow ul li a
			{
				display: block;
				text-decoration: none;
				color: #3f3f3f;
				width: 160px;
				height: 41px;
				line-height: 41px;
				padding-left: 39px;
				border-bottom: 1px solid #e3e3e3;
				outline: none; /* 取消点击链接出现的虚线框 */
			}
			
			.bottomarrow
			{
				 /*  width: 0;
				  height: 0; */
				  position: absolute; /* 箭头div相对于父div(arrow)进行绝对定位 */
				  left: 120px;
				  bottom: 82px;
				  border: transparent 16px solid; /* 透明10像素实线的边框(中间的像素可以控制箭头的宽度) */
				  border-bottom: #FFF 16px solid; /* 红色10像素实线的箭头(中间的像素可以控制箭头的高度)#4f4f4f*/
			}
			
			.arrow li a:hover, .arrow li a:focus
			{
				color: white;
				background-color: #4f4f4f;
				background-image: linear-gradient(to bottom, #555, #484848);
				background-repeat: repeat-x;
				text-decoration: none;
			}
			
			.icon-edit
			{
				padding-right: 5px;
			}
			
			.icon-trash
			{
				padding-right: 5px;
			}
	
	</style>
	
	
  </head>
  
  <body>
  		<div id="div1">
		<div class="arrow">
			<ul>
				<li class="first_li"><a href="javascript:void(0)"><i class="icon-edit"></i>修改栏目</a></li>
				<li class="last_li"><a href="javascript:void(0)"><i class="icon-trash"></i>删除栏目</a></li>
			</ul>
			<div class="bottomarrow"></div>
		</div>
		</div>
	
  </body>
  
</html>