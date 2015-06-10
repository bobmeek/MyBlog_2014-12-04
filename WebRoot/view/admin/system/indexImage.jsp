<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>首页图片管理 </title>
</head>
<body>
	<div style='width:100%;height:50px;'>
		<div class='' style='float:left;with:300px;height:50px;margin-left:-14px;'>
			<ol class='breadcrumb'>
			  <li><a href='javascript:void(0)'>系统管理</a></li>
			  <li class='active'>首页图片管理</li>
			</ol>
		</div>
		<div style="float:right;margin-bottom:10px;">
			<a href="#add_index_img_modal" data-target="#add_index_img_modal" data-toggle="modal" class="btn btn-primary btn-lg index_image_add">添加宣传图片</a>			
		</div>
	</div>
	
	
	
	<!-- 显示文章信息 -->
	<div style="height:500px;">
		<table class="table table-responsive table-striped table-bordered table-hover" id="allIndexImage">
			<thead>
				<tr>
					<th style='display: none;'>ID</th>
					<th>图片标题</th>
					<th>启用状态</th>
					<th>链接类型</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	
	
	
	
	
	<div class="modal" id="add_index_img_modal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" id='indexImgModalClose' class="close" data-dismiss="modal">
						&times;
					</button>
					<h2 id='indexImgModalTitle' class="modal-title" style="text-align: center">添加宣传图片</h2>
				</div>
				<div class="modal-body" style="height:550px;margin-top:20px;">
					<input type="file"  id="propagandaImgFile" name="propagandaImg" class="btn-primary"  style="display: none;" >
					<!-- <button class="btn btn-primary" title="上传首页宣传图片" id="indexImgBtn">上传首页宣传图片</button> -->
					<div id='indexImageImgDIV' style='height:300px;border:1px solid #c5c5c5;cursor: pointer;'>
						<img src="" id='indexImageImg' height="300px" style='max-width:100%;margin-left:30%' />
						<i id='indexImgHolder' class='icon-picture icon-5x' style='color:#c5c5c5'>添加图片</i>
					</div>
					
					<div style='margin-top:10px;'>
						<form class="form-horizontal">
						  <div class="form-group">
						    <label for="indexImgTitle" class="col-sm-1 control-label">图片名称</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control input-lg" id="indexImgTitle" placeholder="图片名称">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="indexArticleLink" class="col-sm-1 control-label">文章链接</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control input-lg" id="indexArticleLink" placeholder="文章链接">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="indexImgType" class="col-sm-1 control-label">链接类型</label>
						    <div class="col-sm-10">
						    	<label class="radio-inline">
							      <input type='radio' name='indexLinkType' value='1' checked="checked" />站内链接
							    </label>
							    <label class="radio-inline">
							      <input type='radio' name='indexLinkType' value='0' />站外链接
							    </label>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="indexImgStatus" class="col-sm-1 control-label">启用状态</label>
						    <div class="col-sm-10">
						        <label class="radio-inline">
							     	<input type='radio' name='indexImageStatus' value='1' checked="checked" />启用
						     	</label>
						     	<label class="radio-inline">
									<input type='radio' name='indexImageStatus' value='0' />停用
							    </label>
						    </div>
						  </div>
						  
						</form>
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" id="saveIndeximgBtn" class="btn btn-primary btn-lg btn-block" >确定</button>
					<button type="button" id="updateIndeximgBtn" class="btn btn-primary btn-lg btn-block" style='display: none;'>更新</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
