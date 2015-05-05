<!DOCTYPE html>
<html>
  <head>
    <title>汉口学院国际交流学院</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="汉口学院国际学院是在贯彻落实《国家中长期教育改革和发展规划纲要》中应运而起，以“发展与世界各国的教育文化交流与合作 ”为宗旨，致力于培养国际化、复合型人才的二级学院；是汉口学院执行涉外政策、协调国际交流与合作事务的重要职能部门。">
	<meta name="author" content="汉口学院国际交流学院">
	<meta http-equiv="X-Ua-Compatible" content="IE=edge,chrome=1" />
	<meta name="renderer" content="webkit" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css"  href="resources/front_base/css/index.css" /><!-- 首页页面css文件 -->
	<script type="text/javascript" src="resources/front_frame/jquery/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="resources/front_frame/bgstretcher/js/jquery-bgstretcher-3.3.0.min.js"></script><!-- 轮播图js文件 -->
			
  </head>
  
  <body>
		
		<div id="top"><!-- 顶部区域开始 -->
			<div class="container" style="width: 1010px; max-width:1010px; height:40px; margin: 0 auto;">
				<div class="top-left"><!-- 顶部左侧区域开始 -->
					<ul>
						<li class="desktop-hide"><a href="javascript:void(0);"  title="" class="sprit">下载中心</a></li>
						<li class="desktop-hide"><a href="javascript:void(0);"  title="">办理指南</a></li>
					</ul>
				</div><!-- 顶部左侧区域结束 -->
				
				<div class="top-right" style="height: 40px;"><!-- 顶部右侧区域开始 -->
				    <a href="javascript:void(0);"><img src="resources/front_base/img/index/infoportal.png"><span class="desktophd-hide">在线报名</span></a>
				    <a href="javascript:void(0);"><img src="resources/front_base/img/index/icon-briefcase.png"><span class="desktophd-hide">录取查询</span></a>
	
				    <div class="searchbox"><!-- 搜索区域 -->
					    <form method="get" action="">
					      <input type="text" value="请输入关键字..." name="s" style="background: #6e5736;" class="inputtext" id="s" 
					      onfocus="if (value =='请输入关键字...'){value =''}" onblur="if (value ==''){value='请输入关键字...'}">
					      <input type="image" src="resources/front_base/img/index/search-btn.png" value="" class="submit" name="INTEXT" id="search_btn">
					    </form>
					 </div><!-- 搜索区域结束 -->
			</div><!-- 顶部右侧区域结束 -->
		</div>
	</div><!-- 顶部区域结束 -->
	
	
	<div id="head"><!-- 头部区域开始 -->
		<div class="container phablet-hide">
        	<div class="nine columns">
				<ul class="head-nav" style="z-index: 10000000;"><!-- 导航区域开始 -->
					<#list navMenuMap?keys as menu>
                        <li>
                            <a href="menu/${menu}/" title="${menu}">${menu}</a>
                            <#assign navMenuList=navMenuMap[menu] />
                            <#if navMenuList?exists>
                            <table>
                                <#list navMenuList as childMenu>
                                     <tr><td><a href="menu/${menu}/${childMenu}">${childMenu}</a></td></tr>
                                </#list>
                            </table>
                            </#if>
                        </li>
                    </#list>
				</ul><!-- 导航区域结束 -->
			</div>
		</div>
	</div>
	
	
	<ul id="navlist" class="tablet-hide">
	      <li><a class="prev" href="javascript:void(0);">上一张</a></li>
	      <li><a class="next" href="javascript:void(0);">下一张</a></li>
	</ul>
	
	 <div id="infobox">
		<div class="container">
		<div class="row" style="margin-top: 30px;"><!-- 校园新闻动态区域开始 -->
			<div class="three columns infobox">
				<div class="infoboxtitle"> <img src="resources/front_base/img/index/cooperation2.png"><a href="javascript:void(0);">更多</a></div>
				<ul>
						<li><a href="http://gj.hkxy.edu.cn/xinwenzhongxin/Showarticle.asp?articleID=235" target="_blank" title="罗爱平董事长会见檀国大学金周昌教授">罗爱平董事长会见檀国大学金周昌教授</a></li>
						<li><a href="http://gj.hkxy.edu.cn/xinwenzhongxin/Showarticle.asp?articleID=231" target="_blank" title="韩国檀国大学名誉教授金裕赫会长一行访问我校">韩国檀国大学名誉教授金裕赫会长一行访问我校</a></li>
						<li><a href="http://gj.hkxy.edu.cn/xinwenzhongxin/Showarticle.asp?articleID=230" target="_blank" title="美国乔治福克斯大学副校长彭长徽博士一行访问我校">美国乔治福克斯大学副校长彭长徽博士一行访问我校</a></li>
						<li><a href="http://gj.hkxy.edu.cn/xinwenzhongxin/Showarticle.asp?articleID=223" target="_blank" title="汉口学院招收赴韩国青云大学留学生招生简章">汉口学院招收赴韩国青云大学留学生招生简章</a></li>
						<li><a href="http://gj.hkxy.edu.cn/xinwenzhongxin/Showarticle.asp?articleID=222" target="_blank" title="汉口学院招收赴英国提赛德大学留学生招生简章">汉口学院招收赴英国提赛德大学留学生招生简章</a></li>
				</ul>
			</div>
			<div class="three columns infobox">
		  		<div class="infoboxtitle"><img src="resources/front_base/img/index/news.png"><a href="javascript:void(0);" >更多</a></div>
		 			 <ul>
		 			    <li><a href="javascript:void(0);"  title="文科首个“千人计划”特聘教授主编出版环境法著作">文科首个“千人计划”特聘教授主编出版环境法著作</a></li>
					    <li><a href="javascript:void(0);"  title="“五大方向”助力湖北省长江经济带发展">“五大方向”助力湖北省长江经济带发展</a></li>
					    <li><a href="javascript:void(0);"  title="国内外学者研讨系统工程和管理科学">国内外学者研讨系统工程和管理科学</a></li>
					    <li><a href="javascript:void(0);"  title="我校为亚洲高等教育规划献策">我校为亚洲高等教育规划献策</a></li>
					    <li><a href="javascript:void(0);"  title="谭崇台：中国发展经济学引路人">谭崇台：中国发展经济学引路人</a></li>
		  			</ul>
			</div>
			<div class="three columns infobox">
		  		<div class="infoboxtitle"><img src="resources/front_base/img/index/notice.png"><a href="javascript:void(0);" >更多</a></div>
		  			<ul>
					    <li><a href="http://gj.hkxy.edu.cn/xinwenzhongxin/Showarticle.asp?articleID=234" target="_blank" title="2015年大学英语教师教学能力培养预通知">2015年大学英语教师教学能力培养预通知</a></li>
					    <li><a href="http://gj.hkxy.edu.cn/xinwenzhongxin/Showarticle.asp?articleID=233" target="_blank" title="孔子学院总部公开招聘2015年度外派汉语教师">孔子学院总部公开招聘2015年度外派汉语教师</a></li>
					    <li><a href="http://gj.hkxy.edu.cn/xinwenzhongxin/Showarticle.asp?articleID=232" target="_blank" title="关于湖北省2014年度外国文教专家聘请资格单位年检情况的通报">关于湖北省2014年度外国文教专家聘请资格单位年检情况的通报</a></li>
					    <li><a href="http://gj.hkxy.edu.cn/xinwenzhongxin/Showarticle.asp?articleID=229" target="_blank" title="教育部关于认真学习贯彻全国留学工作会议精神的通知">教育部关于认真学习贯彻全国留学工作会议精神的通知</a></li>
					    <li><a href="http://gj.hkxy.edu.cn/xinwenzhongxin/Showarticle.asp?articleID=224" target="_blank" title="关于总结出国留学情况的通知">关于总结出国留学情况的通知</a></li>
		  		</ul>
			</div>
			<div class="three columns infobox ljg">
		  		<div class="infoboxtitle"><img src="resources/front_base/img/index/topics.png"><a href="javascript:void(0);" >更多</a></div>
		  		<a class="infobox-speciallink" href="javascript:void(0);"><img src="resources/front_base/img/index/1.jpg" class="desktop-hide">汉口学院形象片</a>
		  			<ul>
					    <li><a href="javascript:void(0);">文明创建专题网</a></li>
					    <li><a href="javascript:void(0);" >群众路线教育实践活动</a></li>
		  			</ul>
			</div>
		</div><!-- 校园新闻动态区域结束 -->
		
		<div class="row exlinks"><!-- 快速入口链接区域开始 -->
	  		  <a href="javascript:void(0);"  title="教育部留学服务中心" >教育部留学服务中心</a>
			  <a href="javascript:void(0);"  title="湖北省外国专家局" >湖北省外国专家局</a>
			  <a href="javascript:void(0);"  title="中华人民共和国外交部">中华人民共和国外交部</a>
			  <a href="javascript:void(0);"   title="武汉市人民政府外事办公室" >武汉市人民政府外事办公室</a>
		</div><!-- 快速入口链接区域结束 -->
	</div>
</div>


	<div id="footer"><!-- 底部区域开始 -->
		<div class="container">
			<div class="row">
				<div class="six columns text">地址：湖北省武汉市江夏区文化大道299号 邮编：430212&nbsp;&nbsp; 鄂ICP备05016648</div>
				<div class="six columns footerlinks phablet-hide" style="width: 30%;float: right">
					<div class="linkitem">
						<img src="resources/front_base/img/index/weixin.png"><span class="tablet-hide"><a href="javascript:void(0)">官方微信</a></span>
						<div id="whuwechat" class="qr">
							<a href="#"><img src="resources/front_base/img/index/whuwechat.jpg"></a>
						</div>
					</div>
					<div class="linkitem">
						<img src="resources/front_base/img/index/weibo.png"></a><span class="tablet-hide"><a href="http://weibo.com/hankouuniversity" target="_blank">官方微博</a></span>
						<div id="whuweibo" class="qr">
							<a href="#"><img src="resources/front_base/img/index/whuweibo.png"></a>
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
	
	
    <script type="text/javascript">
    
	    $(document).ready(function() {
		    $("body").bgStretcher({
		          images: ["resources/front_base/img/index/max-school2.jpg","resources/front_base/img/index/bgxg05.jpg","resources/front_base/img/index/mac.jpg","resources/front_base/img/index/bgxg05.jpg"],
		          imageWidth: 1280,
		          imageHeight: 800,
		          transitionEffect: 'fade',
		          sequenceMode: 'normal',
		          nextSlideDelay: '8000',
		          preloadImg: true,
		          buttonNext: ".next",
		          buttonPrev: ".prev"
		      });
	    });
	    
    </script>
	
</body>
</html>