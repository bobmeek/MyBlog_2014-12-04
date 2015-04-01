<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文本编辑器测试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="resources/front_frame/bootstrap/css/font-awesome.css" />
	<link rel="stylesheet" href="resources/front_frame/simditor/css/simditor.css" />
	
	<script src="resources/front_frame/simditor/js/jquery.min.js"></script>
	<script src="resources/front_frame/simditor/js/module.js"></script>
	<script src="resources/front_frame/simditor/js/hotkeys.js"></script>
	<script src="resources/front_frame/simditor/js/uploader.js"></script>
	<script src="resources/front_frame/simditor/js/simditor.js"></script>
	<script src="resources/front_frame/simditor/js/marked.js"></script>
	<script src="resources/front_frame/simditor/js/simditor-markdown.js"></script>
	
  </head>
  
  <body>
  
		<textarea id="editor" placeholder="这里输入内容" autofocus></textarea>
		
		
		
		<script type="text/javascript">
	
		/* var editor = new Simditor({
		  textarea: $('#editor')
		}); */
		
		$(function(){  
		    toolbar = [ 'title', 'bold', 'italic', 'underline', 'strikethrough',  
		            'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|',  
		            'link', 'image', 'hr', '|', 'indent', 'outdent' ];  
		    var editor = new Simditor( {  
		        textarea : $('#editor'),  
		        placeholder : '这里输入内容...',  
		        toolbar : toolbar,  //工具栏  
		        defaultImage : 'simditor-2.0.1/images/image.png', //编辑器插入图片时使用的默认图片  
		        upload : {  
		            url : 'ImgUpload.action', //文件上传的接口地址  
		            params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交  
		            fileKey: 'fileDataFileName', //服务器端获取文件数据的参数名  
		            connectionCount: 3,  
		            leaveConfirm: '正在上传文件' 
		        },
                markdown: true
		    });  
		   });
		
	</script>
</body>
  
</html>