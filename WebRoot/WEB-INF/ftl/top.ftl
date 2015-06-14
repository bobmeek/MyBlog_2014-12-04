<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css"  href="${basePath}/resources/front_base/css/index.css" />
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
					      <input type="text" value="请输入关键字..." name="s" style="background: none;  border: 2px solid #3277ae; border-radius: 10px; border-color: #3277ae;" class="inputtext" id="s" 
					      onfocus="if (value =='请输入关键字...'){value =''}" onblur="if (value ==''){value='请输入关键字...'}">
					      <i class="fa fa-search fa-lg" style="color: #679ad3;"></i>
					    </form>
					 </div><!-- 搜索区域结束 -->
			</div><!-- 顶部右侧区域结束 -->
		</div>
	</div><!-- 顶部区域结束 -->
	
	<div id="subhead"><!-- 副标题区域开始 -->
			<#assign banner="banner_pub.png" />

			<#if programName=="美国项目">
				<#assign banner="banner_us.png" />
				<#elseif programName=="韩国项目">
				<#assign banner="banner_korea.png" />
				<#elseif programName=="欧盟项目">
				<#assign banner="banner_uk.png" />
				<#elseif programName=="澳新项目">
				<#assign banner="banner_aoxin.png" />
				<#else>
				<#assign banner="banner_pub.png" />
			</#if>
			<div class="subhead-bg" style='background: url(${basePath}/resources/front_base/img/program/${banner}); width: 1021px; height:134px; background-size: 100% 100%;'>
					<div class="menus"><!-- 导航菜单开始 -->
						<ul>
							<#list navMenuMap?keys as menu>
		                        <li>
		                            <a href="${basePath}/nav/${menu}/1" class="menupa" title="${menu}">${menu}</a>
		                            <#assign navMenuList=navMenuMap[menu] />
		                            <#if navMenuList?exists>
		                            <table>
		                                <#list navMenuList as childMenu>
		                                     <tr><td><a href="${basePath}/nav/${menu}/${childMenu}/1">${childMenu}</a></td></tr>
		                                </#list>
		                            </table>
		                            </#if>
		                        </li>
		                    </#list>
				</ul>
			</div><!-- 导航菜单结束 -->
			</div>
		</div><!-- 副标题区域结束 -->
		<script type="text/javascript" src="${basePath}/resources/front_frame/simditor/js/jquery.min.js"></script>
		<script type="text/javascript" src="${basePath}/resources/front_frame/highslide/highslide/highslide-full.js"></script>
<!-- 	<script type="text/javascript" src="resources/front_frame/highslide/highslide/highslide-with-gallery.js"></script> -->
<!-- 	<script type="text/javascript" src="resources/front_frame/highslide/highslide/highslide-with-html.js"></script> -->
		<script type="text/javascript" src="${basePath}/resources/front_frame/highslide/highslide/highslide.js"></script>
	
	
		<script type="text/javascript" src="${basePath}/resources/front_base/js/showArticleInfo.js"></script>

</body>
</html>