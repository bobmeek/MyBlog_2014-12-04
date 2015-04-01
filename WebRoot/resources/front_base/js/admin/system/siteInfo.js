/**
 * 网站信息
 */
$(function(){
	
	function SiteInfo(id,siteName,mainTitle,subTitle,footerTitle,copyright,pageCount,hotPageCount,target,navCount){
		this.id = id;
		this.siteName = siteName;
		this.mainTitle = mainTitle;
		this.subTitle = subTitle;
		this.footerTitle = footerTitle;
		this.copyright = copyright;
		this.navCount = navCount;
		this.pageCount = pageCount;
		this.hotPageCount = hotPageCount;
		this.target = target;
		
	}
	
	$(document).on("click","#siteInfo",function(e){
		showSiteInfo();
	});
	
	
	/**显示网站信息**/
	function showSiteInfo(){
		
		$.post('siteinfo/show','',function(result){
			$('#siteId').val(result.id);
			$('#siteName').val(result.siteName);
			$('#mainTitle').val(result.mainTitle);
			$('#subTitle').val(result.subTitle);
			$('#footerTitle').val(result.footerTitle);
			$('#copyright').val(result.copyright);
			$('#navCount').val(result.navCount);
			$('#pageCount').val(result.pageCount);
			$('#hotPageCount').val(result.hotPageCount);
			debugger;
			//将#showTarget内容置空会将<i></i>一并置空,需要想个办法.
			$('#showTarget').text('');
			var target = result.target.trim()=='_self'?'本窗口':'新窗口';
			$('#showTarget').html(target+'<i class="caret"></i>');
			//将显示的打开方式选中
			var lis = $("#showTarget~ul").children("li");
			for(var i = 0;i<lis.length;i++)if(target==$(lis[i]).text()) $(lis[i]).children("input").prop("checked","true");
			
			
		},'json');
		
	}
	
	//保存网站信息
	$(document).on('click','#saveSiteInfo',function(e){
		var $siteId = $('#siteId').val();
		var $siteName = $('#siteName').val();
		var $mainTitle = $('#mainTitle').val();
		var $subTitle = $('#subTitle').val();
		var $footerTitle = $('#footerTitle').val();
		var $copyright = $('#copyright').val();
		var $navCount = $('#navCount').val();
		var $pageCount = $('#pageCount').val();
		var $hotPageCount = $('#hotPageCount').val();
		var $target = $('#showTarget').text().trim()=='本窗口'?'_self':'_blank';
		var siteInfo = new SiteInfo($siteId,$siteName, $mainTitle, $subTitle, $footerTitle, $copyright,$pageCount,$hotPageCount,$target,$navCount);
		  
		$.post('siteinfo/update',siteInfo,function(result){
		},'json');
	});
});