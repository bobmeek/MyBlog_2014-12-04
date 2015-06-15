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
	
	<script type="text/javascript" src="${basePath}/resources/front_frame/jquery/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${basePath}/resources/front_frame/bgstretcher/js/jquery-bgstretcher-3.3.0.min.js"></script><!-- 轮播图js文件 -->
			
  </head>
  
  <body>
		
		<div id="top"><!-- 顶部区域开始 -->
		
			<a href="#"><img src="${basePath}/resources/front_base/img/index/dashiji.png"  style="display:block; position: absolute; top: 0; left: 30px; z-index: 99999; cursor: pointer;"/></a>
		
			<div class="container" style="width: 1010px; max-width:1010px; height:40px; margin: 0 auto;">
				<div class="top-left"><!-- 顶部左侧区域开始 -->
				
				</div><!-- 顶部左侧区域结束 -->
				
				<div class="top-right" style="height: 40px;"><!-- 顶部右侧区域开始 -->
				    <a href="javascript:void(0);" ><img  src="${basePath}/resources/front_base/img/index/444.png" style="display: inline;" width="24px;" height="24px;"><span class="desktophd-hide">录取查询</span></a>
				    <a href="${basePath}/view/registration.html" ><img  src="${basePath}/resources/front_base/img/index/555.png" style="display: inline;" width="24px;" height="24px;"><span class="desktophd-hide">在线报名</span></a>
	
				    <div class="searchbox"><!-- 搜索区域 -->
					    <form method="get" action="">
					      <input type="text" value="请输入搜索内容..." name="s" style="background: none;  border: 1px solid #4d90fe; border-radius: 5px;" class="inputtext" id="s" 
					      onfocus="if (value =='请输入搜索内容...'){value =''}" onblur="if (value ==''){value='请输入搜索内容...'}">
					      <input type="image" src="${basePath}/resources/front_base/img/index/search222.png" value="" class="submit" name="INTEXT" id="search_btn">
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
				<div class="infoboxtitle"><span>${menu}</span><span class="en">COOPERATION</span><a class="more" href="category/${menu}/1">更多></a></div>
				<ul>
				<#list articles as article>
					<#if article_index lt 5>
						<#if article.highLight==1>
							<li><a href="category/${menu}/${article.id}/${article.title}" target="_blank" style='color:red;font-weight:bold;' title="${article.title}">${article.title}</a></li>
						<#else>
							<li><a href="category/${menu}/${article.id}/${article.title}" target="_blank" title="${article.title}">${article.title}</a></li>
						</#if>
					</#if>
				</#list>
				
				</ul>
			</div>
			</#if>
		</#list> 
			
			<div class="three columns infobox ljg">
		  		<div class="infoboxtitle"><span>服务中心</span><span class="en"> SERVICE</span></div>
				<a class="infobox-speciallink"  href="javascript:void(0);" title="下载中心" ><img  src="resources/front_base/img/index/2221.png"><span class="desktophd-hide">下载中心</span></a>
				<a class="infobox-speciallink" href="javascript:void(0);"  title="成绩查询"><img  src="resources/front_base/img/index/333.png"><span class="desktophd-hide">成绩查询</span></a>
				<a class="infobox-speciallink" href="javascript:void(0);" title="语言培训中心"><img  src="resources/front_base/img/index/23.png">语言培训中心</a>
				<a  class="infobox-speciallink" href="cgcj.html" title="出国出境办理指南"><img  src="resources/front_base/img/index/111.png"><span class="desktophd-hide">出国出境办理指南</span></a>
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
	    $(function() {
	    	//宣传图片
	    	var propagandasPath = [];
	    	
	    	//下面这两个属性务必要配置
	    	//宣传图片所对应的文章链接
	    	var url = [];
	    	//链接类型(当前窗口打开-self/新窗口打开-_bank)
	    	var urlType = [];
	    	<#list indexImgs as indexImg>
	    		<#if indexImg.status==1>
	    			propagandasPath.push("${indexImg.imgPath}"); //需加引号
	    		</#if>
	    		url.push("${indexImg.articleLink}");
	    		<#if indexImg.type==0>
	    			urlType.push("_bank");
	    		<#elseif indexImg.type==1>
	    			urlType.push("_self");
	    		</#if>
	    	</#list>
		    $("body").bgStretcher({
		    	  images: propagandasPath,
		    	  url:url,
		    	  urlType:urlType,
		          //images: ["resources/front_base/img/index/sliderbg1.jpg","resources/front_base/img/index/sliderbg2.jpg","resources/front_base/img/index/sliderbg3.jpg","resources/front_base/img/index/sliderbg1.jpg"],
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