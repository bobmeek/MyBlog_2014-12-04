<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>网站信息管理</title>
</head>
<body>
	<div style='width:100%;height:50px;'>
		<div class='' style='float:left;with:300px;height:50px;margin-left:-14px;'>
			<ol class='breadcrumb'>
			  <li><a href='javascript:void(0)'>系统管理</a></li>
			  <li class='active'>网站信息管理</li>
			</ol>
		</div>
	</div>
	
	<div style='width:1000px;margin-left:-15px;'>
		<form class='form-horizontal'>
		  <div class='form-group'>
		    <label for='siteName' class='col-sm-2 control-label'>网站名称</label>
		    <div class='col-sm-10'>
		      <input type='text' class='form-control' style='display: none;' id='siteId'>
		      <input type='text' class='form-control' id='siteName' placeholder='网站名称'>
		    </div>
		  </div>
		  <div class='form-group'>
		    <label for='mainTitle' class='col-sm-2 control-label'>主标题</label>
		    <div class='col-sm-10'>
		      <input type='text' class='form-control' id='mainTitle' placeholder='主标题'>
		    </div>
		  </div>
		  <div class='form-group'>
		    <label for='subTitle' class='col-sm-2 control-label'>副标题</label>
		    <div class='col-sm-10'>
		      <input type='text' class='form-control' id='subTitle' placeholder='副标题'>
		    </div>
		  </div>
		   <div class='form-group'>
		    <label for='footerTitle' class='col-sm-2 control-label'>页脚标题</label>
		    <div class='col-sm-10'>
		      <input type='text' class='form-control' id='footerTitle' placeholder='页脚标题'>
		    </div>
		  </div>
		  <div class='form-group'>
		    <label for='copyright' class='col-sm-2 control-label'>版权信息</label>
		    <div class='col-sm-10'>
		      <input type='text' class='form-control' id='copyright' placeholder='版权信息'>
		    </div>
		  </div>
		  <div class='form-group'>
		    <label for='navCount' class='col-sm-2 control-label'>首页显示的导航数</label>
		    <div class='col-sm-2'>
		      <input type='text' class='form-control' id='navCount'>
		    </div>
		  </div>
		  <div class='form-group'>
		    <label for='pageCount' class='col-sm-2 control-label'>首页显示的文章数</label>
		    <div class='col-sm-2'>
		      <input type='text' class='form-control' id='pageCount'>
		    </div>
		  </div>
		  <div class='form-group'>
		    <label for='hotPageCount' class='col-sm-2 control-label'>首页显示的热门文章数</label>
		    <div class='col-sm-2'>
		      <input type='text' class='form-control' id='hotPageCount'>
		    </div>
		  </div>
		  <div class='form-group'>
		    <label for='target' class='col-sm-2 control-label'>打开文章的方式</label>
		    <div class='col-sm-10'>
		      <div class="btn-group">
				  <button id='showTarget' data-toggle="dropdown" class="btn btn-default dropdown-toggle">本窗口<i class="caret"></i></button>
				  <ul class="dropdown-menu">
					  <li><input type="radio" id="self" name="NAME" value="VALUE" ><label for="self">本窗口</label></li>
				      <li><input type="radio" id="blank" name="NAME" value="VALUE"><label for="blank">新窗口</label></li>
				  </ul>
			  </div>
		    </div>
		  </div>
		</form>
	</div>
	
	
	<button id='saveSiteInfo' class='btn btn-primary' style="margin-left:500px;">保存</button>
</body>
</html>