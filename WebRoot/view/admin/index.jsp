<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%  
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
 
<title>后台管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="resources/front_frame/bootstrap/css/bootstrap.css" />
<!-- 小图标素材 -->
<link rel="stylesheet" href="resources/front_frame/bootstrap/css/font-awesome.css">
<!-- 可多选的下拉框 -->
<link rel="stylesheet" href="resources/front_frame/boostrap_dropdowns+/css/dropdowns-enhancement.css" />
<!-- bootstrap风格的树结构 -->
<link rel="stylesheet" href="resources/front_frame/bootstrap_treegrid/css/treegird.bootstrap3.css" />
<!-- datetimepicker -->
<link rel='stylesheet' type='text/css' href='resources/front_frame/bootstrap_datetimepicker/build/css/bootstrap-datetimepicker.css'>

<!-- zTree插件样式 -->
<link rel="stylesheet" href="resources/front_frame/ztree/css/zTreeStyle.css" />
<!-- zTree插件Metro风格样式 -->
<link rel="stylesheet" href="resources/front_frame/ztree/css/metroStyle/metroStyle.css" />


<!-- 弹出框 -->
<link rel="stylesheet" href="resources/front_frame/jquery_confirm/css/jquery-confirm.css" />	<!-- 引入jQuery模态对话框插件 -->

<!-- 左侧导航菜单 -->
<link rel="stylesheet" href="resources/front_base/css/tree-menu.css">
<!-- 文章管理样式 -->
<link rel="stylesheet" href="resources/front_base/css/publishArticle.css" />

<!-- 会引起bootstrap某些样式发生变化 -->
<!-- <link rel="stylesheet" href="resources/front_base/css/reset.css" /> -->

</head>

<body>
	<nav class="side_nav navbar navbar-fixed-top navbar-inverse" role="navigation"> <!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#nav-top">
			<div>菜单</div>
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>

		</button>
		<!-- <a class="navbar-brand" href="#">MsOnLine</a> -->
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="nav-top">
		<ul class="nav navbar-nav" id="accordion" data-toggle="buttons">
			<shiro:hasAnyRoles name="ROLE_Author,ROLE_System,ROLE_CEO">
			<li class="panel">
				<a href="#topic_manage" class="dropdown-toggle collapsed" data-toggle="collapse" data-parent="#accordion"><i class="icon-book icon-large"></i> 文章管理<b
					class="caret"></b></a>
				<ul id="topic_manage" class="list-unstyled sednav collapse" style="height: 0px;">
					<shiro:hasPermission name="article:add">
					<li><a href="#" id="publishArticle">发布文章</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="article:*">
					<li><a href="#" id="articlesInfo">文章信息</a></li>
					</shiro:hasPermission>
				</ul>
			</li>
			</shiro:hasAnyRoles>
			<shiro:hasPermission name="user:*">
			<li class="panel">
				<a href="#users_manage" class="dropdown-toggle collapsed" data-toggle="collapse" data-parent="#accordion">
					<i class="icon-user icon-large"></i> 用户管理<b class="caret"></b>
				</a>
				<ul id="users_manage" class="collapse list-unstyled sednav">
					<!-- <li><a href="#" id="personInfo">个人资料</a></li> -->
					<!-- <li><a href="#">密码修改</a></li> -->
					<li><a href="#" id="usersInfo">用户信息管理</a></li>
					<li><a href="#" id="usersRole">用户角色管理</a></li>
					<li><a href="#" id="usersResource">用户资源管理</a></li>
				</ul>
			</li>
			</shiro:hasPermission>
			<shiro:hasPermission name="*">
			<li class="panel">
				<a href="#student_manage" class="dropdown-toggle collapsed" data-toggle="collapse" data-parent="#accordion">
					<i class="icon-user icon-large"></i>学生管理<b class="caret"></b>
				</a>
				<ul id="student_manage" class="collapse list-unstyled sednav">
					<li><a href="#" id="registrationInfo">报名信息管理</a></li>
				</ul>
			</li>
			</shiro:hasPermission>
			<shiro:hasPermission name="system:*">
			<li class="panel">
				<a href="#system_manage"  class="dropdown-toggle collapsed"  data-toggle="collapse" data-parent="#accordion"><i class="icon-cogs icon-large"></i> 系统配置<b
					class="caret"></b></a>
				<ul id="system_manage" class="list-unstyled sednav collapse" style="height: 0px;">
					<li><a href="#" id='links'>超级链接管理</a></li>
					<li><a href="#" id='siteInfo'>网站信息管理</a></li>
					<li><a href="#" id='indexMenu'>首页菜单管理</a></li>
					<li><a href="#" id='indexImage'>首页图片管理</a></li>
					<li><a href="#" id='dataBackup'>网站数据备份</a></li>
					<li><a href="#" id='systemClear'>系统清理管理</a></li>
				</ul>
			</li>
			</shiro:hasPermission>
		</ul>
	</div>
	</nav>


	<div class="containerk">
		<div class="row top_info">
			<div class="col-xs-6 " style="float:right;">
				<div class="btn-group users_info">
					<button type="button" style='margin-top:-3px;' class="btn btn-default dropdown-toggle " data-toggle="dropdown">
						<span class="glyphicon glyphicon-user"></span> <span id='currentUser'><shiro:principal/></span> <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">信息</a></li>
						<li><a href="#">设置</a></li>
						<li class="divider"></li>
						<li><a href="<%=request.getContextPath()%>/admin/logout">退出登录</a></li>
					</ul>
				</div>
				<div class="btn-group users_info" style="padding-top: 8px;padding-right:50px;">
					<i class="icon-flag" style="margin-right:20px;"> 2015.01.09</i> 
					<i class="icon-time"> 2015.01</i> 
				</div>					
			</div>
		</div>
		
		<div id="show" >
			<div id="publishArticlePage" class="page" style="display:visibility;">
				<jsp:include page="article/publishArticle.jsp" flush="true"></jsp:include>
			</div>
			<div id="articlesInfoPage" class="page" style="display:none;">
				<jsp:include page="article/articlesInfo.jsp" flush="true"></jsp:include>
			</div>
			<div id="categoryInfoPage" class="page" style="display:none;">
				<jsp:include page="article/categoryInfo.jsp" flush="true"></jsp:include>
			</div>
			<div id="personInfoPage" class="page" style="display:none;">
				<jsp:include page="user/personInfo.jsp" flush="true"></jsp:include>
			</div>		
			<div id="usersInfoPage" class="page" style="display:none;">
				<jsp:include page="user/usersInfo.jsp" flush="true"></jsp:include>
			</div>
			<div id="usersRolePage" class="page" style="display:none;">
				<jsp:include page="user/usersRole.jsp" flush="true"></jsp:include>
			</div>
			<div id="usersResourcePage" class="page" style="display: none;">
				<jsp:include page="user/usersResource.jsp" flush="true"></jsp:include>
			</div>
			<div id="registrationInfoPage" class="page" style="display:none;">
				<jsp:include page="student/registrationInfo.jsp" flush="true"></jsp:include>
			</div>
			
			<div id="dataBackupPage" class="page" style="display:none;">
				<jsp:include page="system/dataBackup.jsp" flush="true"></jsp:include>
			</div>
			<div id="linksPage" class="page" style="display:none;">
				<jsp:include page="system/links.jsp" flush="true"></jsp:include>
			</div>
			<div id="siteInfoPage" class="page" style="display: none;">
				<jsp:include page="system/siteInfo.jsp" flush="true"></jsp:include>
			</div>
			<div id="indexMenuPage" class="page" style="display: none;">
				<jsp:include page="system/indexMenu.jsp" flush="true"></jsp:include>
			</div>
			<div id="indexImagePage" class="page" style="display: none;">
				<jsp:include page="system/indexImage.jsp" flush="true"></jsp:include>
			</div>
		</div>
		
	</div>
	
	
	<!-- jquery主文件 -->
	<!-- <script type="text/javascript" src="resources/front_frame/jquery/jquery-1.8.3.js"></script> -->
	<script src="resources/front_frame/simditor/js/jquery.min.js"></script>
	<!-- jqueryUI主文件 -->
	<script type="text/javascript" src="resources/front_frame/jquery-ui/jquery-ui.js"></script>
	<!-- bootstrap主文件 -->
	<script type="text/javascript" src="resources/front_frame/bootstrap/js/bootstrap.js"></script>
	<!-- 可多选的下拉框 -->
	<script type="text/javascript" src="resources/front_frame/boostrap_dropdowns+/js/dropdowns-enhancement.js"></script>
	<!-- 树状的表格 -->
	<script type="text/javascript" src="resources/front_frame/bootstrap_treegrid/js/jquery.treegrid.js"></script>
	<script type="text/javascript" src="resources/front_frame/bootstrap_treegrid/js/jquery.treegrid.bootstrap3.js"></script>
	<!-- bootstrap样式的input-file -->
	<script type="text/javascript" src="resources/front_frame/bootstrap/js/bootstrap.file-input.js"></script>
	<!-- zTree -->
	<script type="text/javascript" src="resources/front_frame/ztree/js/jquery.ztree.all-3.5.js"></script>
	<!-- ajax上传 -->
	<script type="text/javascript" src="resources/front_frame/jquery/ajaxfileupload.js"></script>
	<!-- 格式化时间 -->
	<script type="text/javascript" src="resources/front_frame/time.js"></script>
	<!-- bootstrap时间插件 -->
	<script type='text/javascript' src='resources/front_frame/bootstrap_datetimepicker/src/js/moment.js'></script>
    <script type='text/javascript' src='resources/front_frame/bootstrap_datetimepicker/src/js/bootstrap-datetimepicker.js'></script>
    <script type='text/javascript' src='resources/front_frame/bootstrap_datetimepicker/src/js/bootstrap-datetimepicker.zh-CN.js'></script> 
	<!-- 第三方弹出框 -->
	<script type="text/javascript" src="resources/front_frame/jquery_confirm/js/jquery-confirm.js"></script>
	
	<!-- 百度UEditor -->
	<script type="text/javascript" src="resources/front_frame/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="resources/front_frame/ueditor/ueditor.all.js"></script>
	
	
	
	<!-- 引起bootstrap弹框失效 -->
	<!-- <script type="text/javascript" src="resources/front_frame/bootstrap/js/modal.js"></script>  -->
	<!-- 文章编辑器 -->
	
	
	<!-- 后台管理主文件 -->
	<script type="text/javascript" src="resources/front_base/js/admin/admin.js"></script>
	<!-- 所有文章信息 -->
	<script type="text/javascript" src="resources/front_base/js/admin/article/articlesInfo.js"></script>
	<!-- 个人用户文章信息 -->
	<script type="text/javascript" src="resources/front_base/js/admin/article/publishArticle.js"></script>
	<!-- 用户信息 -->
	<script type="text/javascript" src="resources/front_base/js/admin/user/usersInfo.js"></script>
	<!-- 用户角色 -->
	<script type="text/javascript" src="resources/front_base/js/admin/user/usersRole.js"></script>
	<!-- 用户资源 -->
	<script type="text/javascript" src="resources/front_base/js/admin/user/usersResource.js"></script>
	<!-- 报名信息 -->
	<script type="text/javascript" src="resources/front_base/js/admin/student/registrationInfo.js"></script>
	<!-- 网站所有信息备份 -->
	<script type="text/javascript" src="resources/front_base/js/admin/system/dataBackup.js"></script>
	<!-- 网站信息配置 -->
	<script type="text/javascript" src="resources/front_base/js/admin/system/siteInfo.js"></script>
	<!-- 首页菜单配置 -->
	<script type="text/javascript" src="resources/front_base/js/admin/system/indexMenu.js"></script>
	<!-- 首页图片配置 -->
	<script type="text/javascript" src="resources/front_base/js/admin/system/indexImage.js"></script>
	

	
</body>
</html>
