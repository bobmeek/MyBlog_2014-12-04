<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/front_frame/bootstrap/css/bootstrap.css" />
    <style>
        html {
            height: 100%;
        }
        body {
            display: -webkit-flex; 	/* NEW, Chrome 21+ */
            display: flex; 		/* NEW: Opera 12.1, Firefox 22+ */
            -webkit-align-items: center;
            align-items: center;
            -webkit-box-pack: center;
            -webkit-justify-content: center;
            justify-content: center;
            margin: 0;
            height: 100%;
            width: 100%; /* needed for Firefox */
        }
        .container {
        	width:500px;
        	height:500px;
        	border:1px solid red;
            display: flex;
            -webkit-box-align: center; 
            -webkit-align-items: center;
            align-items: center;
            -webkit-justify-content: center;

        }
	
		div.container ul
		{
		    list-style:none; /* 去掉ul前面的符号 */
		    margin: 0px; /* 与外界元素的距离为0 */
		    padding: 0px; /* 与内部元素的距离为0 */
		    width: auto; /* 宽度根据元素内容调整 */
		    line-height: 30px;
		    
		    
		}
		/* 所有class为menu的div中的ul中的li样式 */
		div.container ul li
		{
		    float:left; /* 向左漂移，将竖排变为横排 */
		}

    </style>
</head>
<body>
<div class="container" >
	<form class="form-horizontal" action="" >
		
		
		<ul>
			<li style="width:80px;border:;text-align: right;margin-right: 10px;">用户名</li>
			<li><input type="text" class="" name="username"></li>
		</ul>
		<ul>
			<li style="width:80px;border:;text-align: right;margin-right: 10px;">密码</li>
			<li><input type="password" class="" name="userpwd"></li>
		</ul>
		
	</form>
</div>
</body>
</html>
