
	var liId;
	var lival;
	var liIndex;
	var global_categoryid;
	$(document).ready(function()
	{
		$(".category_nav li").click(function(event) //li列表行事件
		{
			$(".icon-cog").hide();
			$($(this).children()[0].children[0]).show(); //当前点击的li设置按钮显示
			$(this).css("background-color", "#E78170").siblings().css("background-color", "#ECF0F1");
			lival = $(this).text();
			liId = $(this).children().attr("id");
			liIndex = $(this).index();
		});
		
		$(".icon-cog").click(function() //设置按钮事件
		{
			$(".arrow").toggle();
			var x = $(this).position();
			$(".arrow").css({position: "absolute", right: "0", top: x.top + 96}); //控制弹出框出现的位置
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
			$(".text_title").val("无标题文章");
			$(".simditor-body p").text(""); //将中间区域的第一个文章内容添加到右侧textarea中显示
		});
	});
	
	var artId;
	
	/** 点击中间文章信息部分切换文章 **/
	$(document).on("click", "#middle ul li", function(event)
	{
	
		artId = event.target.id;
		var article_id = $(this).attr("id"); //获取点击文章的id
		$.post("article/showArticleByAid", {"article_id": article_id}, function(result)
		{
			$(".text_title").val(result.article.title);
			$(".simditor-body p").text(result.article.content); 
		});
	});
	
	/** 监听input和textarea **/
	$(document).on("input propertychange", ".text_title", function() //监听标题输入框改变事件
	{
		var text = $(".text_title").val();
		//$(".note_list #" + artId).text(text);
		
		//$("#mainbody div #" + articleDivId).html(this.value); //将右侧标题输入框输入的值传送给中间文章标题部分
	});
	$(document).on("input propertychange", "textarea", function()
	{
		$("#mainbody div ." + articleDivId).html(this.value); //将右侧textarea输入的值传送给中间文章内容部分
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
	

















