/*
	*//** 文档加载完成时Ajax请求显示分类栏目信息 **//*
	$(document).ready(function()
	{
		$.post("category/showCategory", null, function(result)
		{
			var categorys = result.categorys;
			$.each(categorys, function(i, category)
			{
				var content = "<input type='checkbox' id=" + category.name + ">" +  "<span class='label label-info'>"  + category.name + "</span> ";
				$("#mainbody").append(content);	
			});
		});
	});
		
		
	*//** 添加文章 **//*
	$("#publish_article_button").on("click", function()
	{
		var article_title = $("#article_title").val(); //获取文章标题
		var article_tag = $("#article_tag").val(); //获取文章标签
		var article_content =  $("div #myEditor").html(); //获取文章内容
		//var article_category = new Array();
		var article_category = ""; //文章目录
		
		$(":checkbox").on("click", function(event)
		{
			alert(event.target.id);
			//article_category.push(event.target.id);
			article_category = event.target.id;
		});
		
		$.post("article/addArticle", {"article_title": article_title, "article_tag": article_tag, 
			"article_content": article_content, "article_category": article_category}, function(result)
		{
				alert(result);
		});
	});	
	
		
		
	
		
		
		

	

	
	
	
	*/