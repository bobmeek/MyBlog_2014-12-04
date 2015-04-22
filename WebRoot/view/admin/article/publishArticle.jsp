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
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!-- 引入Simditor编辑器相关文件 -->
	<script src="resources/front_frame/simditor/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/front_frame/simditor/js/module.js"></script>
	<script type="text/javascript" src="resources/front_frame/simditor/js/hotkeys.js"></script>
	<script type="text/javascript" src="resources/front_frame/simditor/js/uploader.js"></script>
	<script type="text/javascript" src="resources/front_frame/simditor/js/simditor.js"></script>
	<script type="text/javascript" src="resources/front_frame/simditor/js/simditor-dropzone.js"></script>
	<script type="text/javascript" src="resources/front_frame/simditor/js/marked.js"></script>
	<script type="text/javascript" src="resources/front_frame/simditor/js/simditor-markdown.js"></script>
	<!-- <script type="text/javascript" src="resources/front_frame/simditor/js/simditor-autosave.js"></script> -->

  </head>
  
  <body>
	
		<div id="left"><!-- 左侧区域 -->
			<div class="create_newCategpry"><!-- 新建栏目区域 -->
				<a href="javascript:void(0)"  class="create_actile">+新建栏目</a>
			</div>
			<div class="create_category_form" style="display: none"><!-- 新建栏目form表单区域 -->
					<form class="new_category_form">
						<input type="text"  id="article_category_name" class="category_name" name="category_name"  placeholder="请输入栏目名称 ..." /><br />
						<button type="button"  id="create_category_cancel" class="btn btn-default">取消</button>
						<button type="button" id="create_category_submit" class="btn btn-info" style="background: #E78170; border: 1px solid #E78170;">提交</button>
					</form>
				</div>
			<ul class="category_nav"><!-- 栏目区域 -->
				<!-- <li class="firstli"><a href="javascript:void(0)">前端开发<i class="icon-cog" ></i></a></li>
				<li><a href="javascript:void(0)">网页设计<i class="icon-cog"  style="display: none;"></i></a></li> 
				<li><a href="javascript:void(0)">移动开发<i class="icon-cog"  style="display: none;"></i></a></li>
				<li><a href="javascript:void(0)">操作系统<i class="icon-cog"  style="display: none;"></i></a></li>
				<li><a href="javascript:void(0)">编译原理<i class="icon-cog"  style="display: none;"></i></a></li>
				<li><a href="javascript:void(0)">数据结构<i class="icon-cog"  style="display: none;"></i></a></li>
				<li><a href="javascript:void(0)">软件教程<i class="icon-cog"  style="display: none;"></i></a></li> -->
			</ul>
			<div class="arrow" style="display: none;"><!-- 弹出框区域 -->
			<ul>
				<li class="first_li"><a href="javascript:void(0)"><i class="icon-edit"></i>修改栏目名</a></li>
				<li class="last_li"><a href="javascript:void(0)"><i class="icon-trash"></i>删除栏目</a></li>
			</ul>
			<div class="bottomarrow"></div><!-- 弹出框小箭头 -->
		</div><!-- 弹出框区域结束 -->
		
		</div><!-- 左侧区域结束 -->
		
		<div class="update_category" style="display: none;"><!-- 修改栏目区域 -->
			<div class="modal_header">
				<p>修改栏目名</p>
			</div>
			<div class="modal_body">
				<form action="">
					<input type="text" class="c_name" size="30" name="name">
				</form>
			</div>
			<div class="modal_footer">
				<button type="button" id="cancel" class="btn btn-default">取消</button>
				<button type="button" id="commit" class="btn btn-default">提交</button>
			</div>
		</div><!-- 修改栏目区域结束 -->
		
		<!-- <div class="cd-popup" role="alert" style="display: none;">删除栏目对话框
			<div class="cd-popup-container">
				<p>确认删除该栏目吗？点击确认按钮相关文章将会一同删除，该操作无法逆转。</p>
				<ul class="cd-buttons">
					<li><a href="#0">确认</a></li>
					<li><a href="#0">取消</a></li>
				</ul>
				<a href="#0" class="cd-popup-close img-replace">Close</a>
			</div>
		</div> -->
		
		<!-- <a class="btn" data-toggle="modal" href="#myModal">点击触发对话框</a>

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
		</div> -->
		
		<div id="middle"><!-- 中间区域 -->
			<div class="newnote">
				<a href="javascript:void(0);"><i class="icon-pencil"></i><span class="addarticle">+新建文章</span></a>
			</div>
			<ul class="note_list">
				<!-- <li>
					<i class="icon-file icon-3x"></i>文件小图标
					<p class="abbreviate">我来教大家学习Android，然后试着做一个手机APP应用。</p>文章内容
					<span class="note_title">无标题文章</span>文章标题
					<p class="note_wordage">字数: 0</p>文章字数
					<i class="icon-cog" ></i>文章设置小图标
				</li>
				<li>
					<i class="icon-file icon-3x"></i>文件小图标
					<p class="abbreviate">我来教大家学习Android，然后试着做一个手机APP应用。</p>文章内容
					<span class="note_title">无标题文章</span>文章标题
					<p class="note_wordage">字数: 0</p>文章字数
					<i class="icon-cog" ></i>文章设置小图标
				</li>
				<li>
					<i class="icon-file icon-3x"></i>文件小图标
					<p class="abbreviate">我来教大家学习Android，然后试着做一个手机APP应用。</p>文章内容
					<span class="note_title">无标题文章</span>文章标题
					<p class="note_wordage">字数: 0</p>文章字数
					<i class="icon-cog" ></i>文章设置小图标
				</li> -->
				
			</ul>
			<div class="middle_arrow" style="display: none;"><!-- 弹出框区域 -->
			<ul>
				<li class="middle_first_li"><a href="javascript:void(0)"><i class=" icon-share-alt"></i>直接发布</a></li>
				<li class="middle_mide_li"><a href="javascript:void(0)"><i class="icon-folder-open"></i>移动文章</a></li>
				<li class="middle_last_li"><a href="javascript:void(0)"><i class="icon-trash"></i>删除文章</a></li>
			</ul>
			<div class="middle_bottomarrow"></div><!-- 弹出框小箭头 -->
		</div><!-- 弹出框区域结束 -->
		</div>
		
		<div id="right"><!-- 右侧区域 -->
			<form action="">
				<input type="text"  class="text_title"  value="无标题文章"  />
			</form>
			<textarea id="editor" placeholder="这里输入内容"  data-autosave="editor-content"  autofocus ></textarea>
		</div>
		
		<script type="text/javascript">
	
		/* var editor = new Simditor({
		  textarea: $('#editor')
		}); */
		
		$(function(){  
		   /*  toolbar = [ 'title', 'bold', 'italic', 'underline', 'strikethrough',  
		            'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|',  
		            'link', 'image', 'hr', '|', 'indent', 'outdent' ];   */
		            toolbar = [ 'title', 'bold', 'italic', 'underline', 
		    		            'color', '|', 'ol', 'ul', 'blockquote', 'code', '|',  
		    		            'link', 'image', '|', 'indent', 'outdent' ];  
		    var editor = new Simditor( {  
		        textarea : $('#editor'),  
		        placeholder : '这里输入内容...',  
		        pasteImage: true,
		        toolbar : toolbar,  //工具栏  
		        defaultImage : 'resources/upload/img/article/6.jpg', //编辑器插入图片时使用的默认图片
		        upload:{  
		            url: 'article/upload', //文件上传的接口地址  
		            params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交  
		            fileKey: 'fileDataFileName', //服务器端获取文件数据的参数名  
		            connectionCount: 3,  
		            leaveConfirm: '正在上传文件'
		        },
                markdown: true,
		    });  
		    
		   });
		
	</script>
	
		
  </body>
  
</html>