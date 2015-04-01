jQuery(document).ready(function($){
		var offset = 300,
		offset_opacity = 1200,
		scroll_top_duration = 700,
		$back_to_top = $('.cd-top');

	$(window).scroll(function(){
		( $(this).scrollTop() > offset ) ? $back_to_top.addClass('cd-is-visible') : $back_to_top.removeClass('cd-is-visible cd-fade-out');
		if( $(this).scrollTop() > offset_opacity ) { 
			$back_to_top.addClass('cd-fade-out');
		}
	});

	$back_to_top.on('click', function(event){
		event.preventDefault();
		$('body,html').animate({
			scrollTop: 0 ,
		 	}, scroll_top_duration
		);
	});
	

	

	//上一页
	$(document).on('click','.pre',function(e){
		var prePage = parseInt($($('#pagination').children()[0]).attr('name'))-1;
		showArticles(prePage);
	});
	
	//下一页
	$(document).on('click','.next',function(e){
		var nextPage = parseInt($($('#pagination').children()[0]).attr('name'))+1;
		showArticles(nextPage);
	});
	
	//选项页
	$(document).on('click','.currentpage',function(e){
		var currentPage = parseInt($(this).text());
		showArticles(currentPage);
	});
	
	
	
	/**
	 * 分页显示文章
	 */
	function showArticles(currentPage){
		$('#left').html('');
		$('#pagination').html('');
		$.post('currentPage/'+currentPage,{'pageCount':5,'currentPage':currentPage},function(result){
			var articles = result.articles;
			var hasPrePage = result.hasPrePage;
			var hasNextPage = result.hasNextPage;
			var totalPage = result.totalPage;
			var currentPage = result.currentPage;
			var target = result.target;
			$.each(articles,function(n,article){
				debugger;
				var content = article.content.length>50?article.content+'...':article.content;
				var time = Time(article.releaseDate, "%y年%M月%d日");
				var left = '<div class="news_1">'+
				'<span class="news_title"><a href="'+article.id+'"  target="'+target+'">'+article.title+'</a></span>'+
				'<span class="news_year">'+time+'</span>'+
				'<div class="news_img"> <img src="resources/front_base/img/index/news_2.jpg" style="width: 648px; height: 300px; border-top: 1px solid #dcdcdc; padding-top: 10px;"> </div>'+
				'<p class="news_content">'+content+'</p>'+
				'<div class="news_tag">'+
				'<span><span class="news_cat">'+article.category.name+'</span></span>'+
				'<span>标签：</span>'+
				'<span>评论：<span class="news_com">33条评论</span></span>'+
				'<span>浏览：<span class="news_scan">'+article.readCount+'</span></span>'+
				'<span class="news_reading"><a href="'+article.id+'" target="'+target+'">阅读全文</a></span>'+
				'</div>'+
				'</div>';
				$('#left').append(left);
			});
			
			var prePage = hasPrePage?'<li class="pre"><a>上一页</a><li>':'';
			var nextPage = hasNextPage?'<li class="next"><a>下一页</a></li>':'';
			var page = '';
			for(var i=1;i<=totalPage;i++)
				page+='<li><a class="currentpage">'+i+'</a></li>';
			var pagination = '<ul name="'+currentPage+'">'+prePage+page+nextPage+'</ul>';
			$('#pagination').html(pagination);
			if(currentPage<=1)
				currentPage=-1;
			$('#pagination').children('ul').children('li').eq(currentPage+1).children('a').css('background-color','#a1a3a6');
			
		},'json');
	}

});