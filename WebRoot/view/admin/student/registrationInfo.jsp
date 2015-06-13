<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册信息管理</title>
</head>
<body>
	<div style="width:100%;height:50px;">
			<div class="" style="float:left;with:300px;height:50px;margin-left:-14px;">
				<ol class="breadcrumb">
				  <li><a href="javascript:void(0)">学生管理</a></li>
				  <li class="active">报名信息管理</li>
				</ol>
			</div>
			<div style="float:right;margin-bottom:10px;">
				<a href="javascript:void(0)" class="btn btn-danger btn-lg" id="batchDeleteRegistration">批量删除报名信息</a>
				<a href="#registrationModal" data-target="#registrationModal" data-toggle="modal" class="btn btn-primary btn-lg" id="addRegistration">添加报名信息</a>
			</div>
	</div>

	<!-- 显示用户 -->
	<div style="height:500px;">
		<table class="table table-responsive table-striped table-bordered table-hover" id="allRegistrations">
			<thead>
				<tr>
					<th style="display: none;">ID</th>
					<th><input type="checkbox" id="allRegistrationsCheck"></th>
					<th>姓名</th>
					<th>性别</th>
					<th>省份</th>
					<th>QQ</th>
					<th>电话</th>
					<th>专业</th>
					<th>家庭地址</th>
					<!-- <th>总成绩</th>
					<th>英语成绩</th>
					<th>准考证号</th>
					<th>报名号</th>
					<th>身份证</th> -->
					<th>报名时间</th>
					<th>操作</th>
				</tr>
			</thead>
			
			<tbody>
			</tbody>
		</table>
	</div>
	<div class="page-pos" id="registration_page">
		<nav>	
		  <ul class="pager">
	   		<li class="previous" id="registration_pre"><a href="javascript:void(0)">&larr; 前一页</a></li>
	  	  	<li class="next" id="registration_next"><a href="javascript:void(0)">下一页 &rarr;</a></li>
		  </ul>
		</nav>
	</div>
	
	
	
	<!--编辑报名信息 -->
	<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="registrationModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true" id="registrationClose">&times;</span><span class="sr-only">Close</span>
					</button>
					<h2 class="modal-title" style="text-align: center" id="registrationTitle">报名信息</h2>
				</div>
				<div class="modal-body">
				<form class="form-horizontal">
						  <div class="form-group">
						    <label for="registrationNameUpdate" class="col-sm-2 control-label">姓名</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" id="registrationNameUpdate" placeholder="姓名">
						    </div>
						  </div>
						   <div class="form-group">
						    <label for="registrationGenderUpdate" class="col-sm-2 control-label">性别</label>
						    <div class="col-sm-10">
						        <label class="radio-inline">
							     	<input type='radio' name='registrationGenderUpdate' value='1' checked="checked" />男
						     	</label>
						     	<label class="radio-inline">
									<input type='radio' name='registrationGenderUpdate' value='0' />女
							    </label>
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="registrationProvinceUpdate" class="col-sm-2 control-label">省份</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" id="registrationProvinceUpdate" placeholder="省份">
						    </div>
						  </div>
						   <div class="form-group">
						    <label for="registrationHomeAddressUpdate" class="col-sm-2 control-label">家庭住址</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" id="registrationHomeAddressUpdate" placeholder="家庭住址">
						    </div>
						  </div>
						  
						  
						  <div class="form-group">
						    <label for="registrationQQUpdate" class="col-sm-2 control-label">QQ</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" id="registrationQQUpdate" placeholder="QQ">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="registrationPhoneUpdate" class="col-sm-2 control-label">电话</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" id="registrationPhoneUpdate" placeholder="电话">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="registrationProfessionalUpdate" class="col-sm-2 control-label">专业</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" id="registrationProfessionalUpdate" placeholder="专业">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="registrationTotalScoresUpdate" class="col-sm-2 control-label">总成绩</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" id="registrationTotalScoresUpdate" placeholder="总成绩">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="registrationEnglishScoresUpdate" class="col-sm-2 control-label">英语成绩</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" id="registrationEnglishScoresUpdate" placeholder="英语成绩">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="registrationTicketNumberUpdate" class="col-sm-2 control-label">准考证号 </label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" id="registrationTicketNumberUpdate" placeholder="准考证号">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="registrationNumberUpdate" class="col-sm-2 control-label">报名号</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" id="registrationNumberUpdate" placeholder="报名号">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="registrationIdNumberUpdate" class="col-sm-2 control-label">身份证号</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" id="registrationIdNumberUpdate" placeholder="身份证号">
						    </div>
						  </div>
						  <div class="form-group" id='registrationTimeFormGroup' style='display: none;'>
						    <label for="registrationTimeUpdate" class="col-sm-2 control-label">报名时间</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" id="registrationTimeUpdate" placeholder="报名时间">
						    </div>
						  </div>
						</form>
						
						
				
				</div>
				<div class="modal-footer">
					<div class="alert alert-danger" role="alert" style="text-align: left;display: none;">
						<h4>
							<i class="icon-remove-sign"> </i>
						</h4>
					</div>
					<button type="button" id="saveRegistrationBtn" class="btn btn-primary btn-lg btn-block">保存</button>
					<button type="button" id="updateRegistrationBtn" class="btn btn-primary btn-lg btn-block" style='display: none;'>更新</button>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>