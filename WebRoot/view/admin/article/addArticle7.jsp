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
	<link rel="stylesheet" href="resources/front_frame/bootstrap/css/bootstrap.min.css" />

	<style type="text/css">
			
			body
			{
				padding: 0;
				margin: 0;
			}
			
			.update_category
			{
				margin: 0 auto;
			}
			
			.update_category .modal_header p
			{
				color: #555;
				font-family: "lucida grande","lucida sans unicode",lucida,helvetica,"Hiragino Sans GB","Microsoft YaHei","WenQuanYi Micro Hei",sans-serif;
				font-size: 20px;
				font-weight: 700;
				line-height: 20px;
				text-align: center;
			}
			
			.modal_header
			{
				border-bottom: 1px solid #EEE;
				padding: 20px;
				text-align: center;
				
			}
			
			.modal_body
			{
				padding: 30px;
				text-align: center;
			}
			
			.modal_footer
			{
				padding: 0px 15px 40px 15px;
				text-align: center;
			}
			
			.modal_footer #commit
			{
				background-color: #15A7F0;
				border-top-left-radius: 4px;
				border-top-right-radius: 4px;
				border: 1px solid #15A7F0;
				box-shadow: none;
				color: #FFF;
				cursor: pointer;
				display: inline-block;
				font-size: 14px;
				font-weight: 400;
				line-height: 20px;
				margin: 0px 0px 5px 5px;
				padding-top: 5px;
				padding-right: 20px;
				vertical-align: middle;
				width: auto;
				text-shadow: none;
			}
			
			.modal_footer #cancel
			{
				background-color: #EEE;
				border-top-left-radius: 4px;
				border-top-right-radius: 4px;
				border: 1px solid #EEE;
				box-shadow: none;
				color: #555;
				cursor: pointer;
				display: inline-block;
				font-size: 14px;
				font-weight: 400;
				line-height: 20px;
				margin: 0px 0px 5px 5px;
				padding-top: 5px;
				padding-right: 20px;
				vertical-align: middle;
				width: auto;
				text-shadow: none;
			}
			
			/* .modal_body .c_name
			{
				background-color: #FFF;
				border-bottom-color: #CCC;
				border-bottom-left-radius: 4px;
				border-bottom-right-radius: 4px;
				border-bottom-style: solid;
				border-bottom-width: 1px;
				border-image-width: 1 1 1 1;
				border-left: 1px solid #CCC;
				border-right: 1px solid #CCC;
				border-top-color: #CCC;
				border-top-left-radius: 4px;
				border-top-right-radius: 4px;
				border-top-style: solid;
				border-top-width: 1px;
				box-shadow: rgba(0, 0, 0, 0.075) 0px 1px 1px 0px inset;
				color: #555;
				display: inline-block;
				font-size: 14px;
				font-weight: 400;
				height: 20px;
				line-height: 20px;
				padding: 4px 6px 4px 6px;
			} */
			
			/* .modal_body .c_name
			{
				border: 1px solid #CCC;
				box-shadow: rgba(0, 0, 0, 0.075) 0px 1px 1px 0px inset;
				height: 30px;
				border-radius: 5px;
			} */
			
			input 
			{
				transition: all 0.30s ease-in-out;  /* transition属性来实现input的变化 */
				-webkit-transition: all 0.30s ease-in-out;
				-moz-transition: all 0.30s ease-in-out;
				border: #35a5e5 1px solid;
				border-radius: 4px;  /* 用border-radius属性来做圆角效果 */
				outline: none;   /* safari和chrome的默认高亮无效 */
				height: 30px;
			}
			
			input:focus 
			{
				box-shadow: 0 0 5px rgba(81, 203, 238, 1);  /* 为了使其不像是阴影效果而达到发光的效果，因而采用了明亮的蓝色,同时也可以用RGBA，这样就可以控制颜色的透明度了。 */
				-webkit-box-shadow: 0 0 5px rgba(81, 203, 238, 1);
				-moz-box-shadow: 0 0 5px rgba(81, 203, 238, 1);
			}
					
	</style>
	
	<script type="text/javascript">
	
		/* $(":text").focus(function()
		{
			this.select();
		});	 */
		
		$(function()
		{
			$(":text").focus(function()
			{
				this.select();
			});
		});
	
	</script>
	
  </head>
  
  <body>
  
	
		<div class="update_category">
			<div class="modal_header">
				<p>修改栏目名</p>
			</div>
			<div class="modal_body">
				<form action="">
					<input type="text" class="c_name" size="30" name="name" value="111111">
				</form>
			</div>
			<div class="modal_footer">
				<button type="button" id="cancel" class="btn btn-default">取消</button>
				<button type="button" id="commit" class="btn btn-default">提交</button>
			</div>
		</div>
	
  </body>
  
</html>