
	function Article(id, title, author, content, releaseDate, readCount, commentCount, topLevel, privacy, id_category, id_tag_article_tag)
	{
		this.id = id;
		this.title = title;
		this.auth = author;
		this.releaseDate = releaseDate;
		this.readCount = readCount;
		this.commentCount = commentCount;
		this.topLevel = topLevel;
		this.privacy = privacy;
		this.id_category = id_category;
		this.id_tag_article_tag = id_tag_article_tag;
	}
	
	var totalNum = 0; //总条数
	var totalPage = 0; //总页数(总条数/每页显示多少条)
	var currentPage = 0; //当前页数
	var pageSize = 5; //每页显示条数(当前显示5条)
	var pageNo = currentPage * pageSize; //从第几条开始=当前页数*每页显示条数
	var findNumReality = 0; //实际查询出来的条数
	
	showArticles(pageNo, pageSize);
	
	/** 
	 * 显示文章信息 
	 * pageNo：定义的页码，从第几条开始显示
	 * pageSize：定义每页显示的条数
	 */
	function showArticles(pageNo, pageSize)
	{
		$("#allArticles_check").prop("checked", function()
		{
			return false; //将复选框checked属性设置为false默认不选中
		});
		
		$.post("article/show/allArticles.do", {"pageNo": pageNo, "pageSize": pageSize}, function(result)
		{
			var articles = result.articlePager.pageList; //获取文章集合
			totalNum = result.articlePager.totalNum; //获取文章总条数
			totalPage =  Math.ceil(totalNum/pageSize) - 1; //获取文章总页数
			
			if(totalPage < 1 || currentPage == totalPage)
			{
				$("#article_next").attr("class", "next disabled");  //总页数小于1或者当前页等于总页数就将下一页按钮置灰(详情请查阅Bootstrap分页组件)
			}
			else
			{
				$("#article_next").attr("class", "next"); //否则就可以点击下一页按钮显示下一页内容
			}
			findNumReality = articles.length; //实际查询条数
			
			$("#allArticles tbody").html(""); //必须填写这行代码，要不然查询出来的数据会叠加显示 ***
			
			$.each(articles, function(i, article) //jQuery循环动态填充数据
			{
				var content = "<tr>" + "<td style='display: none'>" + article.id + "</td>" 
				+ "<td><input type='checkbox' value="+ article.id + "></td>" 
				+ "<td>" + article.title + "</td>" 
				+ "<td>" + article.author + "</td>" 
				+  "<td>" + article.category.name  + "</td>" 
				+ "<td>" + article.tag.name +  "</td>"
				+ "<td>" + article.releaseDate + "</td>"
				+ "<td>" +  "<button type='button' id='delete_article_button' class='btn btn-info'>删除</button>" + "</td>"+ "</tr>";
				 
				$("#allArticles tbody").append(content); //向tbody的尾部动态添加html内容
			});	
		}, "json");
	};
		
	
	/** 上一页按钮实现 **/
	$("#article_pre").on("click", function()
	{
		currentPage --; //单击上一页按钮当前页-1
		
		if(currentPage > 0)
		{
			$("#article_next").attr("class", "next"); //当前页大于0下一页按钮可点击状态
			showArticles(currentPage * pageSize, pageSize); //点击上一页按钮将显示最新pageNo和每页要显示的条数信息
		}
		else
		{
			currentPage = 0; //否则表示当前页为第一页
			$("#article_next").attr("class", "next"); //下一页按钮可点击
			$(this).attr("class", "previous disabled");
			showArticles(currentPage * pageSize, pageSize);
		}
	});
	
	
	/** 下一页按钮实现 **/	
	$("#article_next").on("click", function()
	{
		currentPage ++; //单击下一页按钮当前页+1
		
		if(currentPage <= totalPage)
		{
			$("#article_pre").attr("class", "previous"); //当前页小于等于总页数上一页按钮可点击状态(没到最后一页或者到了最后一页上一页按钮都可以点击)
			showArticles(currentPage * pageSize, pageSize); //点击下一页按钮将显示最新pageNo和每页要显示的条数信息
			
			if(currentPage == totalPage)
			{
				$(this).attr("class", "next disabled"); //当前页等于总页数下一页按钮置灰，(表示已到了最后一页)
			}
		}
		else
		{
			currentPage = totalPage;
		}
	});
	
	
	/** 复选框全选，反全选 **/
	$("#allArticles_check").on("click", function()
	{
		$(":checkbox").attr("checked", this.checked); //allArticles_check点击事件触发，所有复选框都将被设置属性checked="checked"
	});
	
	
	/** 文章批量删除 **/
	$("#delete_article_link").on("click", function()
	{
		var articlesChecked = $("#allArticles input:checked"); //获取文章信息下所有被选中的input元素：<input type="checkbox" checked="checked" />
		var idArr = new Array(); //声明一个数组，用于储放id的值
		$.each(articlesChecked, function(i, articleChecked)
		{
			var value =  $(articleChecked).val(); //注意：顶复选框的val()值为"on"，我们需要排除它
			if("on" != value && "" != value && null  != value)
			{
				idArr.push(value); //将满足条件的id存入数组之中
			}
		});
		
		var prompt = confirm("你确认要批量删除选中的文章吗？");
		if(prompt == true)
		{
			if(idArr.length > 0) //只有数组的长度大于0我们才要发送Ajax请求
			{
				$.ajax(
				{
					url: "article/delete/idArr",
					type: "POST",
					data: JSON.stringify(idArr),
					dataType: "json", //预期服务器返回的数据类型
					contentType: "application/json", //发送信息至服务器时指定的内容编码类型
					success: function(result)
					{
						if(idArr.length == findNumReality) //删除的条数恰好等于总条数则将页数-1
						{
							showArticles((currentPage-1) * pageSize, pageSize);
						}
						else
						{
							showArticles(currentPage * pageSize, pageSize); //否则正常查询显示就好
						}
					}
				});
			}
			else
			{
				alert("请选中要批量删除的文章！");
			}
		}
		else
		{
			return;
		}
	});
	
	
	/** 搜索文章 **/
	$("#search_article_button").on("click", function()
	{
		var article_text = $("#article_text").val(); //获取搜索输入框信息
		
		if(article_text != "" && article_text != null) //输入框输入信息时我们才要发送Ajax请求
		{
			$.post("article/search/searchArticle", {"article_text": article_text}, function(result)
			{
				$("#allArticles tbody").html(""); //清空tbody下的所有html标记
				var articles = result.articles;
				$.each(articles, function(i, article)
				{
					var content = "<tr>" + "<td style='display: none'>" + article.id + "</td>" 
					+ "<td><input type='checkbox' value="+ article.id + "></td>" 
					+ "<td>" + article.title + "</td>" 
					+ "<td>" + article.author + "</td>" 
					+  "<td>" + article.category.name  + "</td>" 
					+ "<td>" + article.tag.name +  "</td>"
					+ "<td>" + article.releaseDate + "</td>"
					+ "<td>" +  "<button type='button' id=" + article.id  + " name=" + article.id + " class='btn btn-info'>删除</button>" + "</td>"+ "</tr>";
					
					$("#allArticles tbody").append(content); //向tbody的尾部动态添加html内容
				});
			});
		}
	});
	
	
	/** 删除文章 **/
	$("button").on("click", function(event)
	{	
		//alert(event.target.id);
		//alert($(this).name);
		//var id = event.target.id;
		
		$.post("article/delte/"+ id, null, function(result)
		{
			showArticles();
		});
	});
	
	
	
	
	