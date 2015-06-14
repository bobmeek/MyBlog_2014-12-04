$(function(){
	
	$(document).on("click","#registrationInfo",function(e){
		show(1);
	});
	
	
	//总页数
	var totalPage = 0;
	//当前页数
	var currentPage = 1;
	//查出来的条数
	var findPageCount = 0;
	function show(currentPage){
		debugger;
		$.post('registration/show/'+currentPage,'',function(result){
			debugger;
			findPageCount = result.registrations.length;
			totalNum = result.totalCount;
			totalPage = result.totalPage;
			currentPage = result.currentPage;
			var hasPrePage = result.hasPrePage;
			var hasNextPage = result.hasNextPage;
			hasPrePage?$("#registration_pre").attr("class","previous enabled"):$("#registration_pre").attr("class","previous disabled");
			hasNextPage?$("#registration_next").attr("class","next enabled"):$("#registration_next").attr("class","next disabled");
			
			$("#allRegistrations tbody").html('');
			$.each(result.registrations, function(i, registration){
				debugger;
				var gender = registration.gender==0?'女':'男';
				var time = registration.time;
				//将json字符串数据存入data-*中,但该json串中不能有空格.因该json串中time属性有空格,现将其替换为*,在后面再改为空格.
				registration.time = registration.time.replace(/\s/g,'*');
				var jRegistration = JSON.stringify(registration);
				 
				var content = "<tr data-registration="+jRegistration+">" + "<td style='display: none'>" + registration.id + "</td>"
				+ "<td><input type='checkbox' value="+registration.id+"></td>" 
				+ "<td>" + registration.name + "</td>" 
				+ "<td>" + gender  + "</td>" 
				+ "<td>" + registration.province + "</td>"
				+ "<td>" + registration.qq + "</td>"
				+ "<td>" + registration.phone + "</td>"
				+ "<td>" + registration.professional + "</td>"
				+ "<td>" + registration.homeAddress + "</td>"
//				+ "<td>" + registration.totalScores + "</td>"
//				+ "<td>" + registration.englishScores + "</td>"
//				+ "<td>" + registration.ticketNumber + "</td>"
//				+ "<td>" + registration.registrationNumber + "</td>"
//				+ "<td>" + registration.idNumber + "</td>"
				+ "<td>" + time + "</td>"
				+ "<td>"  
				+ "<a href='#registrationModal' data-target='#registrationModal' data-toggle='modal'  class='btn btn-success registration_update'>详细</a>" 
				+ "<button type='button' id='deleteRegistrationBtn' class='btn btn-danger delete'>删除</button>"
				+ "</td>"
				+ "</tr>";
				sessionStorage.setItem(registration.id,jRegistration);
				$("#allRegistrations tbody").append(content);
			});	
		},'json');
	}
	
	//下一页
	$("#registration_next").on("click",function(){
		debugger;
		currentPage==totalPage?show(totalPage):show(++currentPage);
	});
	//上一页
	$("#registration_pre").on("click",function(){
		currentPage==1?show(currentPage):show(--currentPage);
	});
	
	

	/**添加报名信息**/
	$(document).on('click','#saveRegistrationBtn',function(e){
		var registration = new Object();
		registration.name = $('#registrationNameUpdate').val();
		registration.province = $('#registrationProvinceUpdate').val();
		registration.qq = $('#registrationQQUpdate').val();
		registration.phone = $('#registrationPhoneUpdate').val();
		registration.professional = $('#registrationProfessionalUpdate').val();
		registration.homeAddress = $('#registrationHomeAddressUpdate').val();
		registration.totalScores = new Number($('#registrationTotalScoresUpdate').val());
		registration.englishScores = new Number($('#registrationEnglishScoresUpdate').val());
		registration.ticketNumber = $('#registrationTicketNumberUpdate').val();
		registration.registrationNumber = $('#registrationNumberUpdate').val();
		registration.idNumber = $('#registrationIdNumberUpdate').val();
		registration.time = Time(time = + new Date, "%y-%M-%d %h:%m");
		registration.gender = $('input[name=registrationGenderUpdate]:checked').val();
		debugger;
		if(!checkIdNumber(registration.idNumber)){
			$.post('registration/save/',registration,function(result){
				operateAfterHandler();
				show(currentPage);
			},'json');
		}else{
			alert('该学生已经注册!');
		}
		
		
	});
	
	/**校验报名学生是否唯一**/
	function checkIdNumber(idNumber){
		var flag = false;
		$.ajax({
	        type:'POST',
	        url:'registration/checked/'+idNumber,
	        dataType:'json',
	        async:false,
	        success:function(result){
	            flag = result;
	        }
	    });
		return flag;
	}
	
	
	/**弹出修改界面**/
	$(document).on('click','.registration_update',function(e){
		//修改模态框标题为编辑报名信息
		$('#registrationTitle').text('编辑报名信息');
		//更新按钮显示
		$('#updateRegistrationBtn').show();
		//保存按钮隐藏
		$('#saveRegistrationBtn').hide();
		//报名时间显示 - 编辑报名信息时应出现 
		$('#registrationTimeFormGroup').show();
		var $registration = $(this).closest('tr').data('registration');
		$('#registrationNameUpdate').val($registration.name);
		$('#registrationProvinceUpdate').val($registration.province);
		$('#registrationQQUpdate').val($registration.qq);
		$('#registrationPhoneUpdate').val($registration.phone);
		$('#registrationProfessionalUpdate').val($registration.professional);
		$('#registrationHomeAddressUpdate').val($registration.homeAddress);
		$('#registrationTotalScoresUpdate').val($registration.totalScores);
		$('#registrationEnglishScoresUpdate').val($registration.englishScores);
		$('#registrationTicketNumberUpdate').val($registration.ticketNumber);
		$('#registrationNumberUpdate').val($registration.registrationNumber);
		$('#registrationIdNumberUpdate').val($registration.idNumber);
		$('#registrationTimeUpdate').val($registration.time.replace('*',' '));
		$('input[name=registrationGenderUpdate][value='+$registration.gender+']').prop('checked',true);
		sessionStorage.setItem('updateRegistration',JSON.stringify($registration));
	});
	
	/**编辑报名信息**/
	$(document).on('click','#updateRegistrationBtn',function(e){
		var $registration = JSON.parse(sessionStorage.getItem('updateRegistration'));
		
		$registration.name = $('#registrationNameUpdate').val();
		$registration.province = $('#registrationProvinceUpdate').val();
		$registration.qq = $('#registrationQQUpdate').val();
		$registration.phone = $('#registrationPhoneUpdate').val();
		$registration.professional = $('#registrationProfessionalUpdate').val();
		$registration.homeAddress = $('#registrationHomeAddressUpdate').val();
		$registration.totalScores = $('#registrationTotalScoresUpdate').val();
		$registration.englishScores = $('#registrationEnglishScoresUpdate').val();
		$registration.ticketNumber = $('#registrationTicketNumberUpdate').val();
		$registration.registrationNumber = $('#registrationNumberUpdate').val();
		$registration.idNumber = $('#registrationIdNumberUpdate').val();
		debugger;
		$registration.time = $('#registrationTimeUpdate').val();
		$registration.gender = $('input[name=registrationGenderUpdate]:checked').val();
		if(!checkIdNumber($registration.idNumber)){
			$.post('registration/update/',$registration,function(result){
				operateAfterHandler();
				show(currentPage);
			},'json');
		}else{
			alert('该学生已经注册!');
		}
		
	});
	
	
	
	
	
	
	/**删除**/
	$(document).on('click','#deleteRegistrationBtn',remove);
	function remove(){
		var $registration = $(this).closest('tr').data('registration');
		var id = $registration.id;
		$.post('registration/delete/'+id,"",function(result){
			operateAfterHandler();
			findPageCount==1?show(--currentPage):show(currentPage);
		},'json');
	}
	
	
	//全选，取消全选
	$(document).on("click","#allRegistrationsCheck",function(event){
		
		$("input:checkbox").attr("checked",this.checked);
		
	});
	
	//批量删除
	$(document).on("click","#batchDeleteRegistration",function(){
		var registrationsChecked = $("#allRegistrations input:checked");
		var idArr = new Array();
		$.each(registrationsChecked,function(n,registration){
			var value = $(registration).val();
			if("on"!=value && ""!=value && null!=value)
				idArr.push(parseInt(value));
		
		});
		
		if(idArr.length>0)
		{
			debugger;
			$.ajax({
				url:"registration/delete/idArr",
				type:"post",
				data:JSON.stringify(idArr),
				dataType:"json",
				contentType:"application/json", 
				success:function(result){
					//如果删除的条数  = 本页实际查出来的条数 则将页数-1
					idArr.length==findPageCount?show(--currentPage):show(currentPage);
					$("#allRegistrationsCheck").attr("checked",false);
				}
				
			});
		}
		else	
		{
			alert("请选择要删除的用户");
		}
	});
	
	
	
	
	
	 /**点击关闭小图标触**/
	 $("#registrationClose").on("click",function(){
		 operateAfterHandler();
		});
	
	/**保存或者更新操作之后的处理,如清空文本框,改变按钮等等**/
	 function operateAfterHandler(){
		//修改模态框标题为编辑报名信息
		$('#registrationTitle').text('添加报名信息');
		//更新按钮隐藏
		$('#updateRegistrationBtn').hide();
		//保存按钮显示
		$('#saveRegistrationBtn').show();
		
		//报名时间隐藏  - 在添加报名信息时不应出现
		$('#registrationTimeFormGroup').hide();
		
		 //模态框隐藏
		$("#registrationModal").modal("hide");
		//启用状态默认显示启用
		$('input[name=registrationGenderUpdate][value=1]').prop('checked',true);
		$('#registrationModal input[type=text]').each(function(inputText){
			$(this).val('');
		});
		
	 }
	
});