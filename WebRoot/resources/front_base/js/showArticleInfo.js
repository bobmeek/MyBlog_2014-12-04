$(document).ready(function() {
	//获取文章内容中的所有图片
	$('.sub-content-main img').each(function(i){
		//在每个图片外层包上一个a标签
		var a = "<a href='" + this.src + "' class='' target='_bank' onclick='return hs.expand(this)' ></a>";
		$(this).addClass('sub-content-image');
		//把所有匹配的元素用指定的内容或元素包裹起来 
		$(this).wrapAll(a);  
	});
	
	
	hs.graphicsDir = '/MyBlog_2014-12-04/resources/front_frame/highslide/highslide/graphics/';
	hs.wrapperClassName = 'borderless';
	hs.showCredits = false;
	//显示在屏幕中间
	hs.align = 'center';
	//灰色遮罩
	hs.dimmingOpacity = 0.75;
	hs.registerOverlay({
		//右上角关闭按钮
		html: '<div class="closebutton" onclick="return hs.close(this)" title="关闭"></div>',
		position: 'top right',
		fade: 2 
	});

	//国际化
	hs.lang={  
		    loadingText : '加载中...',  
		    loadingTitle : '点击关闭',  
		    focusTitle : 'Click to bring to front',  
		    fullExpandTitle : '查看原图',  
		    creditsText : 'Powered by <i>Highslide JS</i>',
		    restoreTitle : '单击右下角查看原图'
	};  
	
	
//	hs.transitions = ['expand', 'crossfade'];
//	hs.outlineType = 'rounded-white';
//	hs.wrapperClassName = 'borderless';
//	hs.fadeInOut = true;
//	hs.useBox = true;
//	hs.width = 1366;
//	hs.height = 768;
//	hs.addSlideshow({
//		//slideshowGroup: 'group1',
//		interval: 5000,
//		repeat: false,
//		useControls: true,
//		fixedControls: 'fit',
//		overlayOptions: {
//			opacity: 1,
//			position: 'bottom center',
//			hideOnMouseOut: true
//		}
//	});
	
	
	
});
