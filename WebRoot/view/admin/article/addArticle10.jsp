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
	<link rel="stylesheet" href="resources/front_frame/bootstrap/css/bootstrap.css" />
	<script src="resources/front_frame/bootstrap/js/bootstrap.js"></script>
	<script src="resources/front_base/js/jquery-1.8.3.js"></script>	
	<script src="resources/front_frame/bootstrap/js/modal.js"></script>
	
  </head>
  
  <body>

	<a class="btn" data-toggle="modal" href="#myModal">点击触发对话框</a>

	<div class="modal" id="myModal">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">×</a>
			<h3>对话框标题</h3>
		</div>
		<div class="modal-body">
			<p>对话框内容</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">关闭</a> <a href="#"
				class="btn btn-primary" data-dismiss="modal">保存更新</a>
		</div>
	</div>

</body>
  
</html>