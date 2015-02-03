<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head lang="en">
  	<meta charset="UTF-8">
    <title>登录</title>
	<style type="text/css">
        html{overflow-y:scroll;vertical-align:baseline;}
        body{font-family:Microsoft YaHei,Segoe UI,Tahoma,Arial,Verdana,sans-serif;font-size:12px;color:#fff;height:100%;line-height:1;background:#999}
        *{margin:0;padding:0}
        ul,li{list-style:none}
        h1{font-size:30px;font-weight:700;text-shadow:0 1px 4px rgba(0,0,0,.2)}
        .login-box{width:410px;margin:120px auto 0 auto;text-align:center;padding:30px;background:url(<%=request.getContextPath()%>/resources/front_base/img/login/mask.png);border-radius:10px;}
        .login-box .username,.login-box .userpwd,.login-box .code,.login-box .remember{font-size:16px;text-shadow:0 1px 2px rgba(0,0,0,.1)}
        .login-box .remember input{box-shadow:none;width:15px;height:15px;margin-top:25px}
        .login-box .remember{padding-left:40px}
        .login-box .remember label{display:inline-block;height:42px;width:70px;line-height:34px;text-align:left}
        .login-box label{display:inline-block;width:100px;text-align:right;vertical-align:middle}
        .login-box #code{width:120px}
        .login-box .codeImg{float:right;margin-top:26px;}
        .login-box img{width:148px;height:42px;border:none}
        input[type=text],input[type=password]{width:270px;height:42px;margin-top:25px;padding:0px 15px;border:1px solid rgba(255,255,255,.15);border-radius:6px;color:#fff;letter-spacing:2px;font-size:16px;background:transparent;}
        button{cursor:pointer;width:100%;height:44px;padding:0;background:#ef4300;border:1px solid #ff730e;border-radius:6px;font-weight:700;color:#fff;font-size:24px;letter-spacing:15px;text-shadow:0 1px 2px rgba(0,0,0,.1)}
        input:focus{outline:none;box-shadow:0 2px 3px 0 rgba(0,0,0,.1) inset,0 2px 7px 0 rgba(0,0,0,.2)}
        button:hover{box-shadow:0 15px 30px 0 rgba(255,255,255,.15) inset,0 2px 7px 0 rgba(0,0,0,.2)}
        .screenbg{position:fixed;bottom:0;left:0;z-index:-999;overflow:hidden;width:100%;height:100%;min-height:100%;}
        .screenbg ul li{display:block;list-style:none;position:fixed;overflow:hidden;top:0;left:0;width:100%;height:100%;z-index:-1000;float:right;}
        .screenbg ul a{left:0;top:0;width:100%;height:100%;display:inline-block;margin:0;padding:0;cursor:default;}
        .screenbg a img{vertical-align:middle;display:inline;border:none;display:block;list-style:none;position:fixed;overflow:hidden;top:0;left:0;width:100%;height:100%;z-index:-1000;float:right;}
        .bottom{margin:8px auto 0 auto;width:100%;position:fixed;text-align:center;bottom:0;left:0;overflow:hidden;padding-bottom:8px;color:#ccc;word-spacing:3px;zoom:1;}
        .bottom a{color:#FFF;text-decoration:none;}
        .bottom a:hover{text-decoration:underline;}
    </style>
	

  </head>
  
<body>
<div style="color:red; font-size:22px;">${message_login}</div>
    <div class="login-box">
    	<h1>Myblog系统后台登录</h1>
	    <form action="<%=request.getContextPath()%>/user/login" method="post">
	        <div class="username">
	            <label>管理员账号：</label>
	            <input type="text" name="username" tabindex="1" autocomplete="off" />
	        </div>
	        <div class="userpwd">
	            <label>密  码：</label>
	            <input type="password" name="userpwd" maxlength="16" tabindex="2"/>
	        </div>
	        <div class="code">
         		<label>验证码：</label>
            	<input type="text" name="verifyCode" maxlength="4" id="code" tabindex="3"/>
	            <div class="codeImg">
	                <img id="verifyCodeImage"  src="<%=request.getContextPath()%>/user/getVerifyCodeImage" />
	            </div>
	        </div>
	        <div class="remember">
	       		<input type="checkbox" id="remember" tabindex="4">
	        <label>记住密码</label>
	    	</div>
	        <div class="login">
	            <button type="submit" tabindex="5">登录</button>
	        </div>
	    </form>
	</div>


<div class="screenbg">
    <ul>
        <li><a href="javascript:;"><img src="<%=request.getContextPath()%>/resources/front_base/img/login/0_5.jpg"></a></li>
        <li><a href="javascript:;"><img src="<%=request.getContextPath()%>/resources/front_base/img/login/0_1.jpg"></a></li>
        <li><a href="javascript:;"><img src="<%=request.getContextPath()%>/resources/front_base/img/login/0_2.jpg"></a></li>
    </ul>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/front_base/js/jquery-1.8.3.js"></script>
<script>  
 	$(function(){
 		
 	    $(".screenbg ul li").each(function(){
 	        $(this).css("opacity","0");
 	    });
 	    
 	    $(".screenbg ul li:first").css("opacity","1");
 	    var index = 0;
 	    var t;
 	    var li = $(".screenbg ul li");
 	    var number = li.size();
 	    function change(index){
 	        li.css("visibility","visible");
 	        li.eq(index).siblings().animate({opacity:0},3000);
 	        li.eq(index).animate({opacity:1},3000);
 	    }
 	    function show(){
 	        index = index + 1;
 	        if(index<=number-1){
 	            change(index);
 	        }else{
 	            index = 0;
 	            change(index);
 	        }
 	    }
 	    t = setInterval(show,8000);
		/*根据窗口宽度生成图片宽度 */
 	    var width = $(window).width();
 	    $(".screenbg ul img").css("width",width+"px");
	    
 	    //单击刷新验证码,后缀加一个时间参数可防止因缓存请求不了。
		$("#verifyCodeImage").on("click",function()
		{
			this.src = '${pageContext.request.contextPath}/user/getVerifyCodeImage?time='+new Date().getTime();
		});
 	}); 
	
</script>  
</body>
</html>