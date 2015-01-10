
$(function()
{
	//显示器分辨率
	//alert(screen.height);
 	//alert(screen.width);
	
	
/*	$.post("user/test.do","",function(result){
		alert(result);
	},"json");*/
	
	
	/**
	 * 一、用户名：
	 * 1.用户名不能为空。
	 * 2.必须为"字母"、"数字"、"_"。
	 * 2.不能存在相同用户名。
	 * 二、邮箱：
	 * 1.邮箱不能为空。
	 * 2.校验邮箱格式。
	 * 2.邮箱是否被注册。
	 * 三、手机号码：
	 * 1.手机号码可以为空。
	 * 2.如输入，则校验号码格式。
	 * 四、密码：
	 * 1.密码不能为空。
	 * 2.长度为6-16。
	 * 五、确认密码：
	 * 与原始密码是否相同。
	 * 
	 * 
	 * 
	 */
	
	
	/**
	 * 1.enter提交
	 * 2.一对一 userExt扩展信息
	 * 3.用户列表显示
	 * 4.bing chrome plugin
	 * */
	
	//$(".alert-danger").hide();
	//$("#reg_panel_return").hide();
	
	
	//Enter注册
	$("input").keyup(function(event){
	
		//keyCode=13是enter键
		if(event.keyCode==13)
		{
			//模拟提交
			$("#register_btn").click();
		}
	});
	
	
	$("#register_btn").on("click",function()
	{
		var username = $("#name").val();
		var email = $("#email").val();
		var userpwd = $("#password").val();
		var userpwd_sure=$("#password_sure").val();
		
		var u = new User(username,email,userpwd,userpwd_sure);
		//用户输入全部正确则将提示框隐藏.
		if(checked(u))
		{
			$(".alert-danger").hide();
			addUser(u);
			//邮箱激活active
		}
		else
		{
			$(".alert-danger").show();
		}
		
			
	});
	
	
	function getInputInfo()
	{
		
	}
	
	
	
	function User(username,email,userpwd,userpwd_sure)
	{
		this.username = username;
		this.email = email;
		this.userpwd = userpwd;
		this.userpwd_sure = userpwd_sure;
		console.log("username="+username+",email="+email+",userpwd="+userpwd+",userpwd_sure="+userpwd_sure);
	}
	
	function checked(u)
	{
		var format_username = /^[a-zA-Z][a-zA-Z0-9_]{2,30}$/;  
		var format_email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		var format_userpwd = /^[a-z0-9_-]{6,18}$/;
		var flag = false;
		if(u.username=="")
		{
			groupDefault("email");
			groupDefault("password");
			groupDefault("password_sure");
			$(".icon-remove-sign").html(" 输入的用户名不能为空");
			groupError("username");
		}
		else if(!format_username.test(u.username))
		{
			groupDefault("email");
			groupDefault("password");
			groupDefault("password_sure");
			$(".icon-remove-sign").html(" 用户名必须为3-30个字符, 可以是字母、数字、下划线");
			groupError("username");
		}
		else if(isExist("username",u.username))
		{
			groupDefault("email");
			groupDefault("password");
			groupDefault("password_sure");
			$(".icon-remove-sign").html(" 输入的用户名已经存在，请重新输入");
			groupError("username");
		}
		else if(u.email=="")
		{
			groupSuccess("username");
			groupDefault("password");
			groupDefault("password_sure");
			$(".icon-remove-sign").html(" 输入的邮箱不能为空");
			groupError("email");
		}
		else if(!format_email.test(u.email))
		{
			groupSuccess("username");
			groupDefault("password");
			groupDefault("password_sure");
			$(".icon-remove-sign").html(" 输入邮件的格式不正确");
			groupError("email");
		}
		else if(isExist("email",u.email))
		{
			groupSuccess("username");
			groupDefault("password");
			groupDefault("password_sure");
			$(".icon-remove-sign").html(" 该邮箱地址已经被注册，请重新输入");
			groupError("email");
		}
		else if(u.userpwd=="")
		{
			groupSuccess("username");
			groupSuccess("email");
			groupDefault("password_sure");
			$(".icon-remove-sign").html(" 输入的密码不能为空");
			groupError("password");
		}
		else if(!format_userpwd.test(u.userpwd))
		{
			groupSuccess("username");
			groupSuccess("email");
			groupDefault("password_sure");
			$(".icon-remove-sign").html(" 输入的密码长度不能小于6且不能大于16");
			groupError("password");
		}
		else if(u.userpwd_sure=="" || u.userpwd_sure!=u.userpwd)
		{
			groupSuccess("username");
			groupSuccess("email");
			groupSuccess("password");
			$(".icon-remove-sign").html(" 两次填写的密码不一致");
			groupError("password_sure");
		}
		else
		{
			groupSuccess("username");
			groupSuccess("email");
			groupSuccess("password");
			groupSuccess("password_sure");
			flag = true;
			
		}
		
			
		return flag;
	}
	
	
	
	
	
	/**取消输入框消息提示**/
	function groupDefault(groupName)
	{
		
		if(null!=$("#"+groupName+"_group i"))
		{
			$("#"+groupName+"_group").attr("class","form-group");
			$("#"+groupName+"_group i").remove();
		}
	}
	
	/**输入框错误提示**/
	function groupError(groupName)
	{
		groupDefault(groupName);
		$("#"+groupName+"_group").attr("class","form-group has-error has-feedback");
		$("#"+groupName+"_group").append("<i class='glyphicon glyphicon-remove form-control-feedback'></i>");
		
	}
	
	/**输入框正确提示**/
	function groupSuccess(groupName)
	{
		groupDefault(groupName);
		$("#"+groupName+"_group").attr("class","form-group has-success has-feedback");
		$("#"+groupName+"_group").append("<i class='glyphicon glyphicon-ok form-control-feedback'></i>");
	}
	
				
	/**
	 * 判断某个值是否存在
	 * attr:属性 用户名？邮箱
	 * value:值
	 */
	function isExist(attr,value)
	{
		var flag = false;
		var data = {"attr":attr,"value":value};
		$.ajax(
		{
			type:"post",
			url:"user/checked.do",
			data:data,
			dataType:"json",
			async:false,  //同步，否则还没得到success返回的值，就会直接下面的return。
			success:function(result)
			{
				flag = result;
			},
			error:function(result)
			{
				alert("Ajax返回错误");
			}
		});
		
		return flag;
	}
		

	/**添加用户**/
	function addUser(user)
	{
		$.ajax(
		{
			type:"post",
			url:"user/add.do",
			data:user,  
			dataType:"json",
			success:function(result)
			{
				$("#reg_panel").hide();
				$("#reg_panel_return").show();
				$("#email_return").html(result.email);
				setTimeout(_redirectIndex(result),5000);
			},
			error:function(result)
			{
				alert("Ajax返回错误");
			}
		});
	}
	
	/**跳转到首页**/
	function redirectIndex(user)
	{
		
		location.href="http://localhost:8888/MyBlog_2014-12-04/article/showArticles?username="+user.username;
	}

	/**通过该函数实现setTimeout可传参的效果**/
	function _redirectIndex(user)
	{
		return function()
		{
			redirectIndex(user);
		}
	}
});

