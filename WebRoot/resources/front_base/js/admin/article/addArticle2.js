
	/** 文档加载完成时Ajax请求显示分类栏目信息 **/
	$(document).ready(function()
	{
		$("#create_category_aid").click(function() //点击新建栏目按钮显示/隐藏栏目信息
		{
			$("#article_category_name").val(""); //清空文本框内容并获取焦点
			$("#article_category_name")[0].focus();
			
			$(".create_category_form").toggle(700);
		});
			
		$("#create_category_cancel").click(function() //点击取消按钮隐藏栏目信息
		{
			$(".create_category_form").hide(700);
		});
				
		$("#create_category_submit").on("click", function() //点击提交按钮
		{
			var category_name = $("#article_category_name").val(); //获取输入的栏目名称
			
			if(category_name != null || category_name != "")
			{
				$.post("category/addCategoryName", {"category_name": category_name}, function(result)
				{
					var content = "<li><i class='icon-book icon-large'></i>&nbsp;&nbsp;<a href='javascript:void(0);' class='category_class' id=" +result.c_cid + ">" + category_name + "</a></li>";
					$(".menu_nav").prepend(content);	//将输入的栏目名称添加到指定标签元素的开头部分
					$(".create_category_form").hide(700);
				});
			}
		});  
		
		
		/** 左侧栏请求显示栏目名称 **/
		$.post("category/showCategory", null, function(result)
		{
			var categorys = result.categorys;
			$.each(categorys, function(i, category)
			{
				var content = "<li><a href='javascript:void(0);' class='category_class'  id=" +category.id + "><i class='icon-book icon-large'></i>&nbsp; " + category.name +  "</a></li>";
				$(".menu_nav").append(content);	
			});
		});
		
		/** 刷新默认显示第一栏目的文章信息**/
		$.post("category/showArticleByCid", {"categoryid": 1}, function(result)
		{
			$("div #dropdown_menu ul").children(0).eq(0).css("background-color", "#ccc");
			var categorys = result.categorys; 
			if(categorys.length == 0)
			{
				$("#rbody_article_title").attr("value", ""); 
				$("#editor .CodeMirror-code pre  span").text("");
				$("#editor .editor-preview").html("");
			}
			$("div #mainbody hr").html(""); //清空文章内容
			$.each(categorys, function(i, category)
			{
				$.each(category.articles, function(n, article)
				{
					var article_id = article.id; //获取文章id
					var article_title =  article.title; //获取文章标题
					var article_content = article.content; //获取文章内容
					var content = "<div class='create_article_div' style='border: 1px solid #ccc; width: 370px; height: 90px;' id="+ article_id +">" + 
					"<i class='icon-file icon-3x'></i><a href='javascript:void(0);' style='font-size: 18px; font-weight: bold;' id="+ article_id +">" + article_title + "</a>" +
					"<p style='font-size: 12px;' class=" + article_id  + ">" + article_content + "</p></div>";
					$("div #mainbody hr").append(content); //动态添加文章标题文章内容到中间文章信息部分
					if(n == 0) //文章标题、内容只显示最新的一条文章
					{
						$("#rbody_article_title").attr("value", article_title); //动态添加文章标题到右侧	
						$("#rbody_article_title").attr("name", article_id); //设置文章标题的name属性
						$("#editor .CodeMirror-code pre  span").html(article_content); //动态添加文章内容正文到右侧
						$("#editor .editor-preview").html(article_content);  //动态添加文章内容到右侧文章预览部分
					}
					textOverflow(); //文字溢出处理方法
					$("#mainbody div:eq(1)").css("background-color", "#ccc"); //设置mainbody下第2个div的背景颜色
				});
			});
		});
		
		var global_categoryid= ""; //全局栏目id
		
		/** 点击左侧栏目动态显示文章信息 **/
		$("div #dropdown_menu ul").on("click", function(event)
		{
			var divtag = $("div #dropdown_menu ul li"); //点击栏目显示背景色
			var divlength = divtag.length;
			for(var i = 0; i < divtag.length; i++)
			{
				divtag[i].onclick = function()
				{
					for(var k = 0; k < divlength; k++)
					{
						divtag[k].style.backgroundColor = "";
					}
					this.style.backgroundColor = "#ccc";
				};
			}
			
			var categoryid =  event.target.id; //获取点击栏目的id
			global_categoryid = categoryid;
			
			//<i class='icon-cog' style='float: right; padding-right: 70px;'></i>
			
			
			$.post("category/showArticleByCid", {"categoryid": categoryid}, function(result)
			{
				var categorys = result.categorys; 
				if(categorys.length == 0) //栏目下的文章为空默认不显示内容
				{
					$("#rbody_article_title").attr("value", "");  
					$("#editor .CodeMirror-code pre  span").html("");
					$("#editor .editor-preview").html(""); 
				}
				$("div #mainbody hr").html(""); //清空文章内容
				$.each(categorys, function(i, category)
				{
					$.each(category.articles, function(n, article)
					{
						var article_id = article.id; //获取文章id
						var article_title =  article.title; //获取文章标题
						var article_content = article.content; //获取文章内容
						if(article_content == "" || article_content == null)
						{
							article_content = " ";
						}
						var content = "<div class='create_article_div' style='border: 1px solid #ccc; width: 370px; height: 90px;' id="+ article_id +">" + 
						"<i class='icon-file icon-3x'></i><a href='javascript:void(0);' style='font-size: 18px; font-weight: bold;' id="+ article_id +">" + article_title + "</a>" +
						"<p style='font-size: 12px;' class=" + article_id  + ">" + article_content + "</p></div>";

						$("div #mainbody hr").append(content); //动态添加文章标题文章内容到中间文章信息部分
						if(n == 0) //文章标题、内容只显示最新的一条文章
						{
							$("#rbody_article_title").attr("value", article_title); //动态添加文章标题到右侧	
							$("#rbody_article_title").attr("name", article_id); //设置文章标题的name属性
							$("#editor .CodeMirror-code pre  span").html(article_content); //动态添加文章内容正文到右侧
							$("#editor .editor-preview").html(article_content);  //动态添加文章内容到右侧文章预览部分
						}
						textOverflow(); //文字溢出处理方法
						$("#mainbody div:eq(1)").css("background-color", "#ccc"); //设置mainbody下第2个div的背景颜色
					});
				});
			});
		});
		
		/** 文字溢出处理 **/
		function  textOverflow()
		{
			$(".create_article_div p").each(function() //文章内容超出指定字符以"..."表示
			{
				var maxwidth = 28;
		        if($(this).text().length > maxwidth)
		        {
		            $(this).text($(this).text().substring(0, maxwidth));
		            $(this).html($(this).html() + '...');
		        }
			});
		}

		
		/** 点击中间文章信息部分切换文章 **/
		var articleDivId = 0;
		$(".create_article_div").live("click", function(event)
		{
			articleDivId = this.id; //获取div id
			//alert($(this).children("a").attr("id")); //获取当前元素子元素a标签的id值
			var divtag = $(".create_article_div");	
			var divlength = divtag.length; //alert("div length = " + divlength);	
			
			for(var i = 0; i < divlength; i++)
			{
				divtag[i].onclick = function()
				{
					for(var k = 0; k < divlength; k++)
					{
						divtag[k].style.backgroundColor = "";
					}
					this.style.backgroundColor = "#ccc"; //被点击的div将改变其背景颜色
					var article_id = $(this).attr("id"); //获取点击文章的id
					
					$.post("article/showArticleByAid", {"article_id": article_id}, function(result)
					{
						$("#rbody_article_title").attr("value", result.article.title); //动态显示文章标题
						$("#editor .CodeMirror-code pre  span").html(result.article.content); //动态显示文章内容
						$("#editor .editor-preview").html(result.article.content); //动态显示文章预览内容
					});
				};
			};
		});
		
		/** 监听input和textarea **/
		$(document).on("input propertychange", "#rbody_article_title", function() //监听标题输入框改变事件
		{
			$("#mainbody div #" + articleDivId).html(this.value); //将右侧标题输入框输入的值传送给中间文章标题部分
		});
		$(document).on("input propertychange", "textarea", function()
		{
			$("#mainbody div ." + articleDivId).html(this.value); //将右侧textarea输入的值传送给中间文章内容部分
			textOverflow(); //调用文字溢出处理方法
		});
		
		/** 新建文章 **/
		$(document).on("click", "#a_create_article", function()
		{
			$.post("article/saveArticle", {"title": "无标题文章", "id_category": global_categoryid}, function(result)
			{
				var save_articleid =  result.save_articleid; //返回保存文章的id
				var content = "<div class='create_article_div' style='border: 1px solid #ccc; width: 370px; height: 90px;' id=" + save_articleid + ">" + 
				"<a href='javascript:void(0);' style='font-size: 18px; font-weight: bold;' id=" + save_articleid + ">" + '无标题文章' + "</a>" +	
				"<p style='font-size: 12px;' class=" + save_articleid + "></p></div>";
				$("div #mainbody hr").prepend(content); //动态添加文章标题文章内容到中间文章信息部分
				//$("#mainbody div:eq(1)").css("background-color", "#ccc"); 
				$("#" + save_articleid).css("background-color", "#ccc");  $("#rbody_article_title").attr("value", "无标题文章"); //*******
				//$("#rbody_article_title").attr("value", "");  
				$("#editor .CodeMirror-code pre  span").html("");
				$("#editor .editor-preview").html(""); 
			});
		});
		
		//var global_article_title = "";
		//var global_article_content = "";
		
		$(document).on("change", "#rbody_article_title, #editor", function()
		{	
			setInterval("saveArticle()", 1000); //每隔1秒钟执行一次saveArticle函数
			$(function saveArticle()
			{
				article_title = $("#rbody_article_title").val(); //获取文章标题
				article_content = $("#editor .CodeMirror-code pre  span").html(); //获取文章内容
				$.post("article/updateArticle", {"title": article_title, "content": article_content, "id": articleDivId}, function(result)
				{
					
				});
			});
		});
		
		/** 发布文章 **/
		$(document).on("click", "#published_articles", function()
		{
			$.post("article/publishArticle", "", function(result)
			{
			});
		});
	});
	
	
		
	
	