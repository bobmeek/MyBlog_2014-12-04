
	var liId;
	var lival;
	var liIndex;
	var global_categoryid;
	var actid;
	var categoryFirstId;
	
	$(document).ready(function()
	{
		showCategory();
		$(document).on("click", ".category_nav li", function(event) //栏目li点击事件
		{
			$("#left .category_nav .icon-cog").hide();	
			
			$($(this).children()[0].children[0]).show(); //当前点击的li设置按钮显示
			$(this).css("background-color", "#E78170").siblings().css("background-color", "#ECF0F1");
			lival = $(this).text();
			liId = $(this).children().attr("id");
			liIndex = $(this).index();
		});
		
		$(document).on("click", "#left .category_nav  .icon-cog", function() //栏目设置按钮事件
		{
			$(".arrow").toggle();
			var offset = $(this).offset();
			$(".arrow").css({position: "absolute", right: "0", top: offset.top - 56});
		});
		
		$(document).on("click", "#middle .icon-cog", function(event) //中间区域设置按钮事件
		{
			$(".middle_arrow").toggle();
			var offset = $(this).offset();
			$(".middle_arrow").css({position: "absolute", right: "748", top: offset.top + 30});
		});
		
		$(".first_li").click(function() //修改栏目事件
		{
			$("#left").hide();
			$("#middle").hide();
			$("#right").hide();
			$(".update_category").show();
			$(".c_name").val(lival).select();
		});
		
		$("#cancel").click(function() //修改栏目取消按钮事件
		{
			$(".update_category").hide();
			$("#left").show();
			$("#middle").show();
			$("#right").show();
			$(".arrow").hide();
		});
		
		$("#commit").on("click", function(event) //修改栏目提交按钮事件
		{
			var c_name = $(".c_name").val();
			$.post("category/updateCategory", {"category_id": liId , "category_name": c_name}, function(result)
			{
				$(".update_category").hide();
				$("#left").show();
				$("#middle").show();
				$("#right").show();
				$(".arrow").hide();
				
				$("#left .category_nav li #" + liId).text(c_name).append("<i class='icon-cog' style='display: block'>");
			});
		});
		
		$(document).on("click", ".create_actile", function() //新建栏目事件
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
		
		$(document).on("click", "#create_category_submit", function() //新建栏目提交事件
		{
			var  category_name =  $(".category_name").val();
			if(category_name != null || category_name != "")
			{
				$.post("category/add1", {"category_name": category_name}, function(result)
				{
					var content = "<li><a href='javascript:void(0)' id="+ result.c_cid +">"+ result.category_name + " <i class='icon-cog' style='display: block;'></i></a></li>";
					$(".category_nav").prepend(content);
					global_categoryid =  result.c_cid;
					$(".category_nav li").css("background-color", "");
					$(".category_nav li").find(".icon-cog").hide();
					$(".category_nav li:first").css("background-color", "#E78170");
					$(".category_nav li:first").find(".icon-cog").show();
					
					$(".create_category_form").hide();
					$(".category_nav").css({position: "absolute", top: "63"});
					$(".note_list").html("");
					$(".text_title").val("");
					$(".simditor-body").html("");
				});
			}
		});
		
		/** 左侧栏请求显示栏目名称 **/
		function showCategory()
		{
			$.post("category/showCategory", null, function(result)
			{
				var categorys = result.categorys;
				categoryFirstId = categorys[0].id; 
				
				//categoryFirstId = paarseInt($(".category_nav li a:first").attr("id"));    alert("categoryFirstId1 === " + categoryFirstId);
				$.each(categorys, function(i, category)
				{
					$(".category_nav li:first").addClass("firstli").children().children().show(); //显示栏目第一行设置按钮
					$(".category_nav li:first").css("background-color", "#E78170");
					var content = "<li><a href='javascript:void(0)' id="+ category.id + ">"+ category.name + " <i class='icon-cog' style='display: none;'></i></a></li>";
					$(".category_nav").append(content);
				});
				showArticle();
			});
		}
		
		/** 刷新页面时默认显示第一个栏目的文章内容 */
		function showArticle()
		{
			$.post("category/showArticleByCid", {"categoryid": categoryFirstId}, function(result)
			{
				//alert("水水水水" +parseInt(result.artidFirstId - result.artidFirstId) + 40);
				//alert("categoryFirstId2 === " + categoryFirstId);
				//alert($(".category_nav li a:first").attr("id"));
				//actid = parseInt(result.artidFirstId - result.artidFirstId) + 40;
				global_categoryid = parseInt($(".category_nav li a:first").attr("id")); //刷新页面新建文章所需的栏目ID
				var categorys = result.categorys; 
				$(".note_list").html(""); //清空文章内容
				$(".simditor-placeholder").text("");
//									alert("xxx" +  result.artidFirstId);
				
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
						
						var content = "<li id=" + article_id +"><i class='icon-file icon-3x'></i><p class='abbreviate'>"+ removeHTMLTag(article_content) + 
						"</p><span class='note_title'>"+ article_title  +"</span><p class='note_wordage'></p><i class='icon-cog'></i></li>";
						$(".note_list").append(content);
						
						var text = $(".note_list li span:first").text();
						$(".text_title").val(text); //将中间区域的第一个文章标题添加到右侧文本框标题中显示
						var articleFirstContent =  result.articleFirstContent;
						$(".simditor-body").html(articleFirstContent); //将中间区域的第一个文章内容添加到右侧textarea中显示
						
						textOverflow(); //文字溢出处理方法
					});
				});
			});
		}
	});
	
	
	var testid;
	/** 点击左侧栏目动态显示文章信息 **/
	$(document).on("click", "#left .category_nav", function(event)
	{
		var categoryid =  event.target.id; //获取点击栏目的id
		global_categoryid = categoryid;
		actid = event.target.id - event.target.id + 30;
		
		$.post("category/showArticleByCid", {"categoryid": categoryid}, function(result)
		{
			var categorys = result.categorys; 
			$(".note_list").html("");
			$(".text_title").val(""); 
			$(".simditor-body").html("");
			navFirstId = result.artidFirstId;
			
			$(document).on("input propertychange", ".text_title", function() //文章标题改变事件
			{
				if(actid == 30)
				{
					var textTitle = $(".text_title").val();
					$(".note_list #" + navFirstId + " .note_title").text(textTitle);
					//alert("navfirsrid = " + navFirstId);
				}
			});
			$(document).on("input propertychange", ".simditor-body", function()
			{
				if(actid == 30)
				{
					$(".note_list #" +  navFirstId + " .abbreviate").text($(".simditor-body").text());
					$(".note_list #" +  navFirstId + " .abbreviate").css("color", "#FFF");
					textOverflow();
				}
			});
			$(document).on("input propertychange", ".text_title, .simditor-body", function()
			{
				if(actid == 30)
				{
					setInterval("saveArticle3()", 1000); 
					function saveArticle3()
					{
						article_title = $(".text_title").val();
						articleTitleOverflow();
						article_content = $(".simditor-body").html();
						//alert("navFirstId = " + navFirstId);
						$.post("article/updateArticle", {"title": article_title, "content": article_content, "id": navFirstId}, function(result)
						{
						});
					};
				}
			});
			
			if(categorys == "")
			{
				$(".text_title")[0].style.visibility="hidden";
				$(".simditor-body")[0].style.visibility="hidden";
				$(".simditor-toolbar")[0].style.visibility="hidden";
			}
			else
			{
				$(".text_title")[0].style.visibility="visible";
				$(".simditor-body")[0].style.visibility="visible";
				$(".simditor-toolbar")[0].style.visibility="visible";
			}
			
			$.each(categorys, function(i, category)
			{
				$.each(category.articles, function(n, article)
				{
					var article_id = article.id; //获取文章id
					var article_title =  article.title; //获取文章标题
					var article_content = article.content; //获取文章内容
					
					if(article_content == null)
					{
						article_content = " ";
					}
					
					var content = "<li id="+ article_id+"><i class='icon-file icon-3x'></i><p class='abbreviate'>"+ removeHTMLTag(article_content) + 
					"</p><span class='note_title'>"+ article_title  +"</span><p class='note_wordage'></p><i class='icon-cog'></i></li>";
					$(".note_list").append(content);
					
					var text = $(".note_list li span:first").text();
					$(".text_title").val(text); //将中间区域的第一个文章标题添加到右侧文本框标题中显示
					var articleFirstContent =  result.articleFirstContent;
					$(".simditor-body").html(articleFirstContent); //将中间区域的第一个文章内容添加到右侧textarea中显示
					
					$(".note_list li:first").css("background-color", "#D1C091");
					$(".note_list li:first").children().show();
					$(".note_list li").children().eq(0).css("color", "#FFF");
					$(".note_list li").children().eq(1).css("color", "#FFF");
					$(".note_list li").children().eq(2).css("color", "#FFF");
					
					//var navFirstId;
					//navFirstId =  $(".note_list li:first").attr("id");
					
					textOverflow(); //文字溢出处理方法
					articleTitleOverflow();
				});
			});
		});
	});
	
	
	/** 去除HTML标签*/
	function removeHTMLTag(str) 
	{
        str = str.replace(/<\/?[^>]*>/g,''); //去除HTML tag
        str = str.replace(/[ | ]*\n/g,'\n'); //去除行尾空白
        //str = str.replace(/\n[\s| | ]*\r/g,'\n'); //去除多余空行
        str=str.replace(/ /ig,''); //去掉 
        return str;
	}
	
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
	
	function articleTitleOverflow()
	{
		$(".note_title").each(function()
		{
			var maxwidth = 15;
	        if($(this).text().length > maxwidth)
	        {
	            $(this).text($(this).text().substring(0, maxwidth));
	            $(this).html($(this).html() + '...');
	        }
		});
	}
	
	
	
	/** 新建文章 **/
	$(document).on("click", ".addarticle", function(event)
	{
		actid =  event.target.id + 10;
		
		$.post("article/saveArticle", {"title": "无标题文章", "id_category": global_categoryid}, function(result)
		{
			var content = "<li id="+ result.save_articleid +"><i class='icon-file icon-3x'></i><p class='abbreviate'></p><span class='note_title'>"+ '无标题文章'  +"</span><p class='note_wordage'></p><i class='icon-cog'></i></li>";
			$(".note_list").prepend(content);
			$(".text_title")[0].style.visibility="visible";
			$(".simditor-body")[0].style.visibility="visible";
			$(".simditor-toolbar")[0].style.visibility="visible";
			
			
			$(".note_list li:lt(1)").css("background-color", "#D1C091");
			$(".note_list li:gt(0)").css("background-color", "");
			$(".note_list li i:first-child").css("color", "#D1C091");
			$(".note_list li:lt(1)").children().eq(0).css("color", "#FFF"); 
			$(".note_list li .note_title").css("color", "#555"); 
			$(".note_list li .abbreviate").css("color", "#555"); 
			$(".note_list li:lt(1)").children().eq(2).css("color", "#FFF"); 
			$(".note_list li .icon-cog").hide(); 
			$(".note_list li:lt(1)").children().eq(4).show();
			
			save_articleId = result.save_articleid; //保存新建文章返回的id
			
			$(".text_title").val("无标题文章");
			$(".simditor-body").text(""); //将中间区域的第一个文章内容添加到右侧textarea中显示
			
			$(document).on("input propertychange", ".text_title", function() //文章标题改变事件
			{
				if(actid == 10)
				{
					var textTitle = $(".text_title").val();
					$(".note_list #" + save_articleId + " .note_title").text(textTitle);
				}
			});
			
			$(document).on("input propertychange", ".simditor-body", function()
			{
				if(actid == 10)
				{
					$(".note_list #" +  save_articleId + " .abbreviate").text($(".simditor-body").text());
					$(".note_list #" +  save_articleId + " .abbreviate").css("color", "#FFF");
				}
				textOverflow();
			});
			
			$(document).on("input propertychange", ".text_title, .simditor-body", function()
			{
				if(actid == 10)
				{
					setInterval("saveArticle2()", 1000); 
					function saveArticle2()
					{
						article_title = $(".text_title").val();
						articleTitleOverflow();
						article_content = $(".simditor-body").html();
						alert("content === " + article_content);
						$.post("article/updateArticle", {"title": article_title, "content": article_content, "id": save_articleId}, function(result)
						{
						});
					};
				}
			});
		});
	});
	
	var artId;
	
	/** 点击中间文章信息部分切换文章 **/
	$(document).on("click", "#middle ul li", function(event)
	{
		actid = event.target.id - event.target.id + 20;
		//artId = event.target.id; //获取当前点击li的id
		var article_id = $(this).attr("id");
		artId = $(this).attr("id");
		
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
			$(".simditor-body").html(""); 
			$(".text_title").val(result.article.title);
			$(".simditor-body").html(result.article.content); 
		});
	});
	
	
	$(document).on("input propertychange", ".text_title", function()
	{
		if(actid == 20)
		{
			var textTitle = $(".text_title").val();
			$(".note_list #" + artId + " .note_title").text(textTitle);
		}
	});
	
	$(document).on("input propertychange", ".simditor-body", function()
	{
		if(actid == 20)
		{
			var abbreviate = $(".simditor-body").text();
			$(".note_list #" + artId + " .abbreviate").text(abbreviate);
			textOverflow();
		}
	});
	
	$(document).on("input propertychange", ".text_title, .simditor-body", function()
	{	
		if(actid == 20)
		{
			setInterval("saveArticle()", 1000); 
			function saveArticle()
			{
				article_title = $(".text_title").val();
				articleTitleOverflow();
				article_content = $(".simditor-body").html();
				alert("content === " + article_content);
				$.post("article/updateArticle", {"title": article_title, "content": article_content, "id": artId}, function(result)
				{
					
				});
			};
		}
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
	
















