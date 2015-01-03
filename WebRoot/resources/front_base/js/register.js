
$(function()
{
	//显示器分辨率
	//alert(screen.height);
 	//alert(screen.width);
	
	
	
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
	
	
	$(".alert-danger").hide();
	$("#reg_panel_return").hide();
	
	$("#register_btn").on("click",function()
	{
		var username = $("#name").val();
		var mail = $("#mail").val();
		var phone = $("#phone").val();
		var birthday = $("#birthday").val();
		birthday = Math.round(new Date(birthday).getTime()/1000); 
		var sex = $("input:radio:checked").val();
		var userpwd = $("#password").val();
		var userpwd_sure=$("#password_sure").val();
		
		var u = new User(username,mail,phone,birthday,sex,userpwd,userpwd_sure);
		
		//用户输入全部正确则将提示框隐藏.
		if(u.checked())
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
	
	
	
	
	function User(username,mail,phone,birthday,sex,userpwd,userpwd_sure)
	{
		
		
		
		this.username = username;
		this.mail = mail;
		this.phone = phone;
		this.birthday = birthday;
		this.sex = sex;
		this.userpwd = userpwd;
		this.userpwd_sure = userpwd_sure;
		var space = "&nbsp;&nbsp;&nbsp;";
		console.log("username="+username+",mail="+mail+",phone="+phone+",birthday="+birthday+",sex="+sex+",userpwd="+userpwd+",userpwd_sure="+userpwd_sure);
		//判断User.prototype.validate是否存在，如果不存在就创建。

		if(!User.prototype.checked)
		{
			User.prototype.checked = function()
			{
				var format_username = /^[a-zA-Z][a-zA-Z0-9_]{2,30}$/;  
				var format_email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
				var format_phone = /^(13|14|15|18)\d{9}$/;
				var format_userpwd = /^[a-z0-9_-]{6,18}$/;
				var flag = false;
				debugger;
				if(this.username=="")
					$(".icon-remove-sign").html(" 输入的用户名不能为空");
				else if(!format_username.test(this.username))
					$(".icon-remove-sign").html(" 用户名必须为3-30个字符, 可以是字母、数字、下划线");
				else if(isExist("username",this.username))
					$(".icon-remove-sign").html(" 输入的用户名已经存在，请重新输入");
				else if(this.mail=="")
					$(".icon-remove-sign").html(" 输入的邮箱不能为空");
				else if(!format_email.test(this.mail))
					$(".icon-remove-sign").html(" 输入邮件的格式不正确");
				else if(isExist("mail",this.mail))
					$(".icon-remove-sign").html(" 该邮箱地址已经被注册，请重新输入");
				else if(this.phone!="" && !format_phone.test(this.phone))
						$(".icon-remove-sign").html(" 输入手机号的格式不正确");
				else if(this.userpwd=="")
					$(".icon-remove-sign").html(" 输入的密码不能为空");
				else if(!format_userpwd.test(this.userpwd))
					$(".icon-remove-sign").html(" 输入的密码长度不能小于6且不能大于16");
				else if(userpwd_sure=="" || this.userpwd_sure!=this.userpwd)
					$(".icon-remove-sign").html(" 两次填写的密码不一致");
				else
					flag = true;
				
					
				return flag;
					
			}
			
			
		}
		
	}
	
	
	
				
			/**
			 * 判断某个值是否存在
			 * attr:属性 用户名？邮箱
			 * value:值
			 */
			function isExist(attr,value)
			{
				var flag = false;
				
				var d = "attr="+attr+"&value="+value;
				debugger;
				$.ajax(
				{
					type:"post",
					url:"user/checked.do",
					data:d,
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
				console.log("log=="+JSON.stringify(user));
				$.ajax(
				{
					type:"post",
					url:"user/add.do",
//					data:$.toJSON(user),
					data:"username="+user.username+"&userpwd="+user.userpwd+"&mail="+user.mail,  
					dataType:"json",
					success:function(result)
					{
						//alert(result);
						$("#reg_panel").hide();
						$("#reg_panel_return").show();
						$("#mail_return").html(result.mail);
						setTimeout("location.href='http://localhost:8080/MyBlog_2014-12-04/article/showArticles'",5000);
					},
					error:function(result)
					{
						alert("Ajax返回错误");
					}
				});
			}
	

});

