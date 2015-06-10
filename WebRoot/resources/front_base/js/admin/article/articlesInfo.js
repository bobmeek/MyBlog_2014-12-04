
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
	
	//单击左边树显示栏目管理
	$(document).on("click","#articlesInfo",function(e){
		showCategory();
		showArticles(currentPage,1000000);
	});
	
	/**显示所有分类**/
	function showCategory(){
		$.post('article/show/category','',function(result){
			debugger;
			$('#articleCategorySelect').html('<option value="全部" selected="selected">全部</option>');
			$.each(result,function(n,menu){
				var content=menu.id==1?'':'<option id="'+menu.id+'" value="'+menu.name+'">'+menu.name+'</option>';
				$('#articleCategorySelect').append(content);
			});
			
		},'json');
	}
	
	var menuId = 1000000;
	$(document).on("change","#articleCategorySelect",function(e){
		debugger;
		menuId = $(this).val()=='全部'?1000000:$(this).find("option:selected").get(0).id;
		showArticles(1,menuId);
	});
	
	//总页数
	var totalPage = 0;
	//当前页数
	var currentPage = 1;
	//查出来的条数
	var findPageCount = 0;
	function showArticles(currentPage,menuId){
		$.post("article/show/allArticles", {"currentPage": currentPage, "menuId": menuId}, function(result){
			debugger;
			findPageCount = result.articles.length;
			totalNum = result.totalCount;
			totalPage = result.totalPage;
			currentPage = result.currentPage;
			var hasPrePage = result.hasPrePage;
			var hasNextPage = result.hasNextPage;
			hasPrePage?$("#article_pre").attr("class","previous enabled"):$("#article_pre").attr("class","previous disabled");
			hasNextPage?$("#article_next").attr("class","next enabled"):$("#article_next").attr("class","next disabled");
			$("#allArticles tbody").html('');
			$.each(result.articles, function(i, article){
						debugger;
						var jArticle = JSON.stringify(article);
						var privacy = article.privacy==0?'私密':'公开';
						var type = article.menu.type==0?'nav':'category';
						
						//预览链接拼接
						var href='';
						if(article.menu.type==0)
							href = type+'/'+article.menu.name+'/1/'+article.id+'/'+article.title;
						else
							href = type+'/'+article.menu.name+'/'+article.id+'/'+article.title;
						
						var content = "<tr>" + "<td style='display: none'>" + article.id + "</td>" 
						+ "<td><input type='checkbox' value="+ article.id + "></td>" 
						+ "<td style='vertical-align: middle;'>" + article.title + "</td>" 
						+ "<td style='vertical-align: middle;'>" + article.author + "</td>" 
						+  "<td style='vertical-align: middle;'>" + article.menu.name  + "</td>" 
						+ "<td style='vertical-align: middle;'>" + article.releaseDate + "</td>"
						+ "<td style='vertical-align: middle;'><button type='button' class='btn btn-info privacy_article_btn'>"+privacy+"</button></td>"
						+ "<td style='vertical-align: middle;'>" 
						+ "<a href="+href+"  class='btn btn-success article_show' target='_bank'>预览</a>"
						+ "<a href='#' data-target='#' data-toggle='modal'  class='btn btn-warning article_update'>修改</a>" 
						+ "<button type='button' id='delete_article_button' class='btn btn-danger delete'>删除</button>"
						+ "</td>"
						+ "</tr>";
						sessionStorage.setItem(article.id,jArticle);
						$("#allArticles tbody").append(content);
					});	
		},'json');
	}
	
	//下一页
	$("#article_next").on("click",function(){
		debugger;
		currentPage==totalPage?showArticles(totalPage,menuId):showArticles(++currentPage,menuId);
	});
	//上一页
	$("#article_pre").on("click",function(){
		currentPage==1?showArticles(currentPage,menuId):showArticles(--currentPage,menuId);
	});
	
	//停用/启用 用户
	$(document).on('click','.privacy_article_btn',function(e){
		debugger;
		var id = parseInt($($(this).closest('tr').children().get(0)).text());
		var article = JSON.parse(sessionStorage.getItem(id));
		article.privacy = $(this).text()=='私密'?1:0;
		article.articleTags = new Array();
		article.category=new Object();
		article.menu = new Object();
		$.post('article/update',article,function(result){
			showArticles(currentPage,menuId);
		},'json');
		
	});
	
	$(document).on('click','.article_update',function(e){
		debugger;
		var $id = $($(this).closest('tr').children().get(0)).text();
		updateArticle = sessionStorage.getItem($id);
		sessionStorage.setItem('updateArticle',updateArticle);
		sessionStorage.setItem('articleOperate','update');
		//模拟单击事件
		$('#publishArticle').trigger('click');
		
		
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
					+  "<td>" + ""  + "</td>" 
					+ "<td>" + article.tag.name +  "</td>"
					+ "<td>" + article.releaseDate + "</td>"
					+ "<td>" +  "<button type='button' id=" + article.id  + " name=" + article.id + " class='btn btn-info delete'>删除</button>" + "</td>"+ "</tr>";
					
					$("#allArticles tbody").append(content); //向tbody的尾部动态添加html内容
				});
			});
		}
	});
	
	
	/** 删除文章 **/
	$(document).on("click","#allArticles .delete",function(){
		debugger;
		var id = parseInt($(this).closest("tr").children().eq(0).text());
		
		$.post("article/delete/"+id,"",function(result){
			findPageCount==1?showArticles(--currentPage,menuId):showArticles(currentPage,menuId);
		},"json");
		
	});
	
	
	
	
	