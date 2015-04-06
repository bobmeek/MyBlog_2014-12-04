
	var liId;
	var lival;
	var liIndex;
	var global_categoryid;
	$(document).ready(function()
	{
		$(".category_nav li").click(function(event) //li列表行事件
		{
			$("#left .category_nav .icon-cog").hide();	
			
			//$("#left .arrow").attr("style", "display:none");
		
			$($(this).children()[0].children[0]).show(); //当前点击的li设置按钮显示
			$(this).css("background-color", "#E78170").siblings().css("background-color", "#ECF0F1");
			lival = $(this).text();
			liId = $(this).children().attr("id");
			liIndex = $(this).index();
		});
		
		$("#left .category_nav  .icon-cog").click(function() //栏目设置按钮事件
		{
			$(".arrow").toggle();
			var offset = $(this).offset();
			$(".arrow").css({position: "absolute", right: "0", top: offset.top- 56}); //控制弹出框出现的位置
		});
		
		/*$("#middle .icon-cog").click(function() //文章设置按钮事件
		{
			alert("aaa");
			$(".middle_arrow").toggle();
			var offset = $(this).offset();
			$(".middle_arrow").css({position: "absolute", right: "0", top: offset.top- 56}); //控制弹出框出现的位置
		});*/
		
		$(document).on("click", "#middle .icon-cog", function(event)
		{
			$(".middle_arrow").toggle();
			var offset = $(this).offset();
			$(".middle_arrow").css({position: "absolute", right: "748", top: offset.top+30}); //控制弹出框出现的位置
		});
		
		$(".first_li").click(function() //修改链接事件
		{
			$("#left").hide();
			$("#middle").hide();
			$("#right").hide();
			$(".update_category").show();
			$(".c_name").val(lival).select();
		});
		
		$("#cancel").click(function() //取消按钮事件
		{
			$(".update_category").hide();
			$("#left").show();
			$("#middle").show();
			$("#right").show();
			$(".arrow").hide();
		});
		
		$(".create_actile").click(function() //新建栏目事件
		{
			$(".create_category_form").show(1000);
			$(".category_nav").css({position: "absolute", top: "135"});
			$(".category_name").select();
		});
		
		$("#create_category_cancel").click(function() //新建栏目取消事件
		{
			$(".create_category_form").hide(100);
			$(".category_nav").css({position: "absolute", top: "63"});
		});
		
		$("#create_category_submit").on("click", function() //新建栏目提交事件
		{
			var  category_name =  $(".category_name").val();
			if(category_name != null || category_name != "")
			{
				$.post("category/addCategoryName", {"category_name": category_name}, function(result)
				{
					//<li><a href="javascript:void(0)">网页设计<i class="icon-cog"  style="display: none;"></i></a></li>
					var content = "<li><a href='javascript:void(0)' id="+ category.id + ">"+ category.name + " <i class='icon-cog' style='display: none;'></i></a></li>";
					$(".category_nav").prepend(content);
					$(".new_category_form").hide();
					$(".category_nav").css({position: "absolute", top: "63"});
				});
			}
		});
		
		/** 刷新页面时默认显示第一个栏目的文章内容 */
		$.post("category/showArticleByCid", {"categoryid": 1}, function(result)
		{
			var categorys = result.categorys; 
			$(".note_list").html(""); //清空文章内容
			$.each(categorys, function(i, category)
			{
				$.each(category.articles, function(n, article)
				{
					var article_id = article.id; //获取文章id
					var article_title =  article.title; //获取文章标题
					var article_content = article.content; //获取文章内容
					$(".note_list li:first").css("background-color", "#D1C091");
					$(".note_list li").children().eq(0).css("color", "#FFF");
					$(".note_list li").children().eq(1).css("color", "#FFF");
					$(".note_list li").children().eq(2).css("color", "#FFF");
					$(".note_list li:first").children().show();
					var content = "<li><i class='icon-file icon-3x'></i><p class='abbreviate'>"+ article_content + 
					"</p><span class='note_title'>"+ article_title  +"</span><p class='note_wordage'></p><i class='icon-cog'></i></li>";
					$(".note_list").append(content);
					
					var text = $(".note_list li span:first").text();
					$(".text_title").val(text); //将中间区域的第一个文章标题添加到右侧文本框标题中显示
					var text2 = $(".note_list li .abbreviate:first").text();
					$("#editor").attr("placeholder", "");
					$(".simditor-body p").text(text2); //将中间区域的第一个文章内容添加到右侧textarea中显示
					
					textOverflow(); //文字溢出处理方法
				});
			});
		});
	});
	
	/** 左侧栏请求显示栏目名称 **/
	$.post("category/showCategory", null, function(result)
	{
		var categorys = result.categorys;
		$.each(categorys, function(i, category)
		{
			$(".category_nav li:first").addClass("firstli").children().children().show();
			var content = "<li><a href='javascript:void(0)' id="+ category.id + ">"+ category.name + " <i class='icon-cog' style='display: none;'></i></a></li>";
			$(".category_nav").append(content);
		});
	});
	
	
	$("#commit").on("click", function(event) //提交按钮事件
	{
		var c_name = $(".c_name").val();
		$.post("category/updateCategory", {"category_id": liId , "category_name": c_name}, function(result)
		{
			$(".update_category").hide();
			$("#left").show();
			$(".arrow").hide();
			//$('#div1').find('div').eq( $(this).index() ).css('display','block');
			//alert($(".category_nav li").index(liIndex));
			$("#left").find(".category_nav li").eq(liIndex).text(c_name);
		});
	});
	
	/** 点击左侧栏目动态显示文章信息 **/
	$("#left .category_nav").on("click", function(event)
	{
		var categoryid =  event.target.id; //获取点击栏目的id
		global_categoryid = categoryid;
		
		$.post("category/showArticleByCid", {"categoryid": categoryid}, function(result)
		{
			var categorys = result.categorys; 
			$(".note_list").html(""); //清空文章内容
			$.each(categorys, function(i, category)
			{
				$.each(category.articles, function(n, article)
				{
					var article_id = article.id; //获取文章id
					var article_title =  article.title; //获取文章标题
					var article_content = article.content; //获取文章内容
					
					var content = "<li id="+ article_id+"><i class='icon-file icon-3x'></i><p class='abbreviate'>"+ article_content + 
					"</p><span class='note_title'>"+ article_title  +"</span><p class='note_wordage'></p><i class='icon-cog'></i></li>";
					$(".note_list").append(content);
					
					var text = $(".note_list li span:first").text();
					$(".text_title").val(text); //将中间区域的第一个文章标题添加到右侧文本框标题中显示
					var text2 = $(".note_list li .abbreviate:first").text();
					$("#editor").attr("placeholder", "");
					$(".simditor-body p").text(text2); //将中间区域的第一个文章内容添加到右侧textarea中显示
					
					$(".note_list li:first").css("background-color", "#D1C091");
					$(".note_list li:first").children().show();
					$(".note_list li").children().eq(0).css("color", "#FFF");
					$(".note_list li").children().eq(1).css("color", "#FFF");
					$(".note_list li").children().eq(2).css("color", "#FFF");
					
					
					textOverflow(); //文字溢出处理方法
				});
			});
		});
	});
	
	/** 文字溢出处理 **/
	function  textOverflow()
	{
		$(".abbreviate").each(function()
		{
			var maxwidth = 26;
	        if($(this).text().length > maxwidth)
	        {
	            $(this).text($(this).text().substring(0, maxwidth));
	            $(this).html($(this).html() + '...');
	        }
		});
	}
	
	
	/** 新建文章 **/
	$(".addarticle").click(function(event)
	{
		$.post("article/saveArticle", {"title": "无标题文章", "id_category": global_categoryid}, function(result)
		{
			var content = "<li><i class='icon-file icon-3x'></i><p class='abbreviate'></p><span class='note_title'>"+ '无标题文章'  +"</span><p class='note_wordage'></p><i class='icon-cog'></i></li>";
			$(".note_list").prepend(content);
			
			$(".note_list li:lt(1)").css("background-color", "#D1C091");
			$(".note_list li:gt(0)").css("background-color", "");
			$(".note_list li i:first-child").css("color", "#D1C091");
			$(".note_list li:lt(1)").children().eq(0).css("color", "#FFF"); 
			$(".note_list li .note_title").css("color", "#555"); 
			$(".note_list li .abbreviate").css("color", "#555"); 
			$(".note_list li:lt(1)").children().eq(2).css("color", "#FFF"); 
			$(".note_list li .icon-cog").hide(); 
			$(".note_list li:lt(1)").children().eq(4).show();
			
			$(".text_title").val("无标题文章");
			$(".simditor-body p").text(""); //将中间区域的第一个文章内容添加到右侧textarea中显示
		});
	});
	
	var artId = 0;
	
	/** 点击中间文章信息部分切换文章 **/
	$(document).on("click", "#middle ul li", function(event)
	{
	
		artId = event.target.id; //获取当前点击li的id
		var article_id = $(this).attr("id");
		
		$(".note_list li").css("background-color", "");
		$(this).css("background-color", "#D1C091");
		$(".note_list li i:first-child").css("color", "#D1C091");
		$(this).children().eq(0).css("color", "#FFF");
		$(".note_list li .abbreviate").css("color", "#555");
		$(this).children().eq(1).css("color", "#FFF");
		$(".note_list li .note_title").css("color", "#555");
		$(this).children().eq(2).css("color", "#FFF");
		$(".note_list li .icon-cog").hide();
		$(this).children().eq(4).show();
		
		$.post("article/showArticleByAid", {"article_id": article_id}, function(result)
		{
			$(".text_title").val(result.article.title);
			$(".simditor-body p").text(result.article.content); 
		});
	});
	
	
	$(document).on("input propertychange", ".text_title", function()
	{
		var textTitle = $(".text_title").val();
		$(".note_list #" + artId + " .note_title").text(textTitle);
	});
	$(document).on("input propertychange", ".simditor-body", function()
	{
		$(".note_list #" + artId + " .abbreviate").text($(".simditor-body p").text());
		textOverflow(); //调用文字溢出处理方法
	});

	/*$(".last_li").on("click", function()
	{
		alert("aaa");
		$.confirm({
	    	backgroundDismiss: true,
		    content: '确认删除该栏目吗？点击确认按钮相关文章将会一同删除，该操作无法逆转。',
	    	animation: 'zoom',
	    	icon: 'fa fa-warning',
	    	title: '删除操作',
	    	confirmButton: 'OKAY',
	        cancelButton: 'CANCEL',
	        backgroundDismiss: false
	    });
	});*/
	

















