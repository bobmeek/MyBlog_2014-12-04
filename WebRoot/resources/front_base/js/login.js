$(function()
{
	
	
	
	//$(".alert-danger").hide();
	
	//Enter登录
	$("input").keyup(function(event){
	
		if(event.keyCode==13)
			$("#login_btn").click();
	});
	
	$("#login_btn").on("click",function()
	{
		var username = $("#username").val();
		var userpwd = $("#userpwd").val();
		var u = new User(username,userpwd);
		if(u.checked())
		{
			$(".alert-danger").hide();
			location.href="http://localhost:8888/MyBlog_2014-12-04/article/showArticles?username="+username;
		}
		else
		{
			$(".alert-danger").show();
		}
		console.log("username:"+username+"==userpwd:"+userpwd);
	});
	
	
	
	
	
	
	
	function User(username,userpwd)
	{
		this.username = username;
		this.userpwd = userpwd;
		
		if(!User.prototype.checked)
		{
			User.prototype.checked = function()
			{
				var format_userpwd = /^[a-z0-9_-]{6,18}$/;
				var flag = false;
				if(this.username=="")
					$(".icon-remove-sign").html(" 输入的用户名不能为空");
				else if(this.userpwd=="")
					$(".icon-remove-sign").html(" 输入的密码不能为空");
				else if(!format_userpwd.test(this.userpwd))
					$(".icon-remove-sign").html(" 输入的密码长度不能小于6且不能大于16");
				else
				{
					//先校验该用户名或者该邮箱，如没有，则提示不存在该用户。   
					//如果有该用户，则提示用户名或者密码错误。
					var result = validate(this);  
					if(result==-1)
						$(".icon-remove-sign").html(" 没有该用户");
					else if(result==0)
						$(".icon-remove-sign").html(" 密码不正确");
					else if(result==1)
						flag = true;
				}
					
				return flag;
					
			}
		}
		
	}
	
	/**校验用户名密码是否正确**/
	function validate(user)
	{
		var data = {"attr":user.username,"userpwd":user.userpwd};
		var num = 0;
		$.ajax({
			type:"post",
			url:"user/login.do",
			data:data,
			dataType:"json",
			//同步，否则还没得到success返回的值，就会直接下面的return。
			async:false,  
			success:function(result)
			{
				debugger;
				num = result;
				
			},
			error:function(result)
			{
				num = result;
				alert("Ajax返回错误");
			}
		});
		
		return num; 
	}
	
});