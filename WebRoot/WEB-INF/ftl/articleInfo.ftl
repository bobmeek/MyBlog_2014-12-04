<html>
<head>
	<title>学院概况-汉口学院国际交流学院</title>
	<link rel="stylesheet" type="text/css"  href="../../resources/front_base/css/normalize.css" /><!-- 主页面初始化CSS样式表1 -->
	<link rel="stylesheet" type="text/css"  href="../../resources/front_base/css/skeleton.css" /><!-- 主页面初始化CSS样式表2 -->
    <link rel="stylesheet" type="text/css" href="../../resources/front_base/css/articleInfo.css" /><!-- 二级页面CSS样式表 -->
	
</head>
<body>
	
		<div id="top"><!-- 顶部区域开始 -->
				<div class="container" style="width: 1010px; max-width:1010px; height:40px; margin: 0 auto;">
					<div class="top-left"><!-- 顶部左侧区域开始 -->
						<ul>
						<li class="desktop-hide"><a href="javascript:void(0);"  title="" class="sprit">下载中心</a></li>
						<li class="desktop-hide"><a href="javascript:void(0);"  title="" class="sprit">办理指南</a></li>
					</ul>
					</div><!-- 顶部左侧区域结束 -->
					
					<div class="top-right" style="height: 40px;"><!-- 顶部右侧区域开始 -->
						<a href="javascript:void(0);"><img src="../../resources/front_base/img/index/infoportal.png"><span class="desktophd-hide">在线报名</span></a>
				        <a href="javascript:void(0);"><img src="../../resources/front_base/img/index/icon-briefcase.png"><span class="desktophd-hide">录取查询</span></a>
		
					    <div class="searchbox"><!-- 搜索区域 -->
						    <form method="get" action="">
						      <input type="text" value="请输入关键字..." name="s" style="background: #6e5736;" class="inputtext" id="s" 
						      onfocus="if (value =='请输入关键字...'){value =''}" onblur="if (value ==''){value='请输入关键字...'}">
						      <input type="image" src="../../resources/front_base/img/index/search-btn.png" value="" class="submit" name="INTEXT" id="search_btn">
						    </form>
						 </div><!-- 搜索区域结束 -->
				</div><!-- 顶部右侧区域结束 -->
			</div>
		</div><!-- 顶部区域结束 -->
		
		
		<div id="subhead"><!-- 副标题区域开始 -->
			<div class="subhead-bg">
					<div class="menus"><!-- 导航菜单开始 -->
						<ul>
							<li><a href="second.html" title="学院概况" class="menupa">学院概况</a>
								<table>
									<tbody>
										<tr>
											<td><a href="#" title="学院简介">学院简介</a></td>
										</tr>
										<tr>
											<td><a href="#" title="领导寄语">领导寄语</a></td>
										</tr>
										<tr>
											<td><a href="#" title="学院制度">学院制度</a></td>
										</tr>
										<tr>
											<td><a href=# title="学院文化">学院文化</a></td>
										</tr>
										<tr>
											<td><a href="#" title="统计概览">统计概览</a></td>
										</tr>
									</tbody>
								</table>
							</li>
							<li><a href="#" title="合作项目" class="menupa">合作项目</a>
								<table>
									<tbody>
										<tr>
											<td><a href="#" title="本硕连读硕士项目">本硕连读硕士项目</a></td>
										</tr>
										<tr>
											<td><a href="#" title="中外合作办学项目">中外合作办学项目</a></td>
										</tr>
										<tr>
											<td><a href="#" title="韩国项目">韩国项目</a></td>
										</tr>
										<tr>
											<td style="border-width:0px"><a href="#" title="澳新项目">澳新项目</a></td>
										</tr>
									</tbody>
								</table>
							</li>
							<li><a href="#" title="国际教育动态" class="menupa">国际教育动态</a></li>
							<li><a href="#" title="留学风采" class="menupa">留学风采</a></li>
							<li><a href="#" title="学术科研" class="menupa">学术科研</a></li>
							<li><a href="#" title="联系我们" class="menupa">联系我们</a></li>
				</ul>
			</div><!-- 导航菜单结束 -->
			</div>
		</div><!-- 副标题区域结束 -->
		
		
		<div id="sub-content"><!-- 中间大块区域 -->
		
			<div class="container con"><!-- 内容区域开始 -->
			
				<div class="sub-content-left"><!-- 内容左测区域开始 -->
					<ul class="sub-content-nav"><!-- 内容左侧区域导航开始 -->
						<h3><span>${parentMenuName}</span></h3>
						<#if menus?exists>
							<#list menus as menu>
								<li>
									<a href="../../menu/${parentMenuName}/${menu.name}" title="${menu.name}">${menu.name}</a>
								</li>
							</#list>
						</#if>
					</ul><!-- 内容左侧区域导航结束 -->
				</div><!-- 内容左测区域结束 -->
				
				<div class="sub-content-right"><!-- 内容右侧区域开始 -->
					<div class="sub-content-main">
						<div class="sub-content-title">
							<span class="content-title">${childMenuName}</span>
							<div class="sub-content-pagenav">
								<a href="../../index.html">首页</a>/<a class="cur" href="#">${childMenuName}</a> 
							</div>
						</div>
						<div class="sub-content-p">
							<div class="sub-content">
								<div class="sub-contents">
									 <font style="line-height: 200%">
									 		<p>
									 			<font style="font-size: 10.5pt">
									 				<#if article?exists>
									 					${article.content}
									 				</#if>
									 			</font>
									 		</p>
									 		<#if article?exists>
										 		<#if article.releaseDate?exists>
										 			<p align="right"><font style="font-size: 10.5pt">（${(article.releaseDate?date("yyyy-MM-dd"))?string("yyyy年MM月dd日")}更新）</font></p>
										 		</#if>
									 		</#if>
								</div>
							</div>
						</div>
					</div>
				</div><!-- 内容右侧区域结束 -->
				
			</div><!-- 内容区域结束 -->
			
			<div class="footerbg desktop-hide"><!-- 内容区域底部图片，目前处于占位中 ... -->
				<div class="footerbg-left"></div>
				<div class="footerbg-right"></div>
			</div>
			
		</div><!-- 中间大块区域结束 -->
		
		<div id="footer"><!-- 底部区域开始 -->
		<div class="container">
			<div class="row">
				<div class="six columns text">地址：湖北省武汉市江夏区文化大道299号 邮编：430212&nbsp;&nbsp; 鄂ICP备05016648</div>
				<div class="six columns footerlinks phablet-hide" style="width: 30%;float: right">
					<div class="linkitem">
						<img src="../../resources/front_base/img/index/weixin.png"><span class="tablet-hide"><a href="javascript:void(0)">官方微信</a></span>
						<div id="whuwechat" class="qr">
							<a href="#"><img src="../../resources/front_base/img/index/whuwechat.jpg"></a>
						</div>
					</div>
					<div class="linkitem">
						<img src="../../resources/front_base/img/index/weibo.png"></a><span class="tablet-hide"><a href="http://weibo.com/hankouuniversity" target="_blank">官方微博</a></span>
						<div id="whuweibo" class="qr">
							<a href="#"><img src="../../resources/front_base/img/index/whuweibo.png"></a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="seven columns text">Copyright 汉口学院2015&nbsp;&nbsp;&nbsp; Designed by MONOKEROS&nbsp;&nbsp;&nbsp;技术支持 <a href="javascript:void(0);" style="color: #886e4a">信息中心</a></div>
				<div class="five columns footerlinks phablet-hide">
					<a href="javascript:void(0);">&nbsp;旧版主页<a href="mailto:wlxxs@whu.edu.cn">&nbsp;联系我们 | <a href="javascript:void(0);">网络导航 | </a></a></a>
				</div>
			</div>
		</div>
	</div><!-- 底部区域结束 -->
	
</body>
</html>