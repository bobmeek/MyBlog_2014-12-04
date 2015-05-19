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
	<link rel="stylesheet" type="text/css"  href="${basePath}/resources/front_base/css/index.css" /><!-- 首页页面css文件 -->
	 <!--<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">-->s
	 <link rel="stylesheet" href="${basePath}/resources/front_frame/bootstrap/css/font-awesome.css">
	<script type="text/javascript" src="${basePath}/resources/front_frame/jquery/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${basePath}/resources/front_frame/bgstretcher/js/jquery-bgstretcher-3.3.0.min.js"></script><!-- 轮播图js文件 -->
			
  </head>
  
  <body>
		
		<div id="top"><!-- 顶部区域开始 -->
			<div class="container" style="width: 1010px; max-width:1010px; height:40px; margin: 0 auto;">
				<div class="top-left"><!-- 顶部左侧区域开始 -->
					<a href="javascript:void(0);" ><img  src="${basePath}/resources/front_base/img/index/111.png" style="display: inline;" width="24px;" height="24px;"><span class="desktophd-hide">出国出境办理指南</span></a>
					<a href="javascript:void(0);" ><img  src="${basePath}/resources/front_base/img/index/222.png" style="display: inline;" width="24px;" height="24px;"><span class="desktophd-hide">下载中心</span></a>
					<a href="javascript:void(0);" ><img  src="${basePath}/resources/front_base/img/index/333.png" style="display: inline;" width="24px;" height="24px;"><span class="desktophd-hide">成绩查询</span></a>
				</div><!-- 顶部左侧区域结束 -->
				
				<div class="top-right" style="height: 40px;"><!-- 顶部右侧区域开始 -->
				    <a href="javascript:void(0);" ><img  src="${basePath}/resources/front_base/img/index/444.png" style="display: inline;" width="24px;" height="24px;"><span class="desktophd-hide">录取查询</span></a>
				    <a href="javascript:void(0);" ><img  src="${basePath}/resources/front_base/img/index/555.png" style="display: inline;" width="24px;" height="24px;"><span class="desktophd-hide">在线报名</span></a>
	
				    <div class="searchbox"><!-- 搜索区域 -->
					    <form method="get" action="">
					      <input type="text" value="请输入关键字..." name="s" style="background: none;  border: 1px solid #3277ae; border-radius: 10px; border-color: #3277ae;" class="inputtext" id="s" 
					      onfocus="if (value =='请输入关键字...'){value =''}" onblur="if (value ==''){value='请输入关键字...'}">
					      <i class="fa fa-search fa-lg" style="color: #679ad3;"></i>
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
                            <a href="nav/${menu}/1" title="${menu}">${menu}</a>
                            <#assign navMenuList=navMenuMap[menu] />
                            <#if navMenuList?exists>
                            <table>
                                <#list navMenuList as childMenu>
                                     <tr><td><a href="nav/${menu}/${childMenu}/1">${childMenu}</a></td></tr>
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
			
		
			
            <#list categoryMenuMap?keys as menu>
            <#assign articles=categoryMenuMap[menu] />
	            <#if articles?exists>
				<div class="three columns infobox">
					<div class="infoboxtitle"><span>${menu}</span><span class="en">COOPERATION</span><a class="more" href="category/${menu}/1">更多 ></a></div>
					<ul>
					<#list articles as article>
						<li><a  href="category/${menu}/${article.id}/${article.title}" target="_blank" title="${article.title}">${article.title}</a></li>
					</#list>
					</ul>
				</div>
				</#if>
			</#list> 
			
			<div class="three columns infobox ljg">
		  		<div class="infoboxtitle"><!-- <img src="images/topics.png"> --><span>服务中心</span><span class="en"> ENTRANCE</span><a class="more" href="javascript:void(0);" >更多 ></a></div>
		  		<a class="infobox-speciallink" href="javascript:void(0);" title="语言培训中心"><img  src="resources/front_base/img/index/019-48.png" style="display: inline;" width="24px;" height="24px;">语言培训中心</a>
		  		<a class="infobox-speciallink" href="javascript:void(0);" title="驻巴黎欧盟办事处"><img  src="resources/front_base/img/index/trio_man_lead-48.png" style="display: inline;" width="24px;" height="24px;">驻巴黎欧盟办事处</a>
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

	<#include "footer.ftl">
	
    <script type="text/javascript">
	    $(document).ready(function() {
	    $("body").bgStretcher({
	          images: ["resources/front_base/img/index/sliderbg1.jpg","resources/front_base/img/index/sliderbg2.jpg","resources/front_base/img/index/sliderbg3.jpg","resources/front_base/img/index/sliderbg1.jpg"],
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