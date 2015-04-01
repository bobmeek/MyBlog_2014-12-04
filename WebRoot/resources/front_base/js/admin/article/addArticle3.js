
	var liId;
	var lival;
	var liIndex;
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
					var content = "<li><a href='javascript:void(0)'>"+  category_name +"<i class='icon-cog' style='display: none;'></i></a></li>";
					$(".category_nav").prepend(content);
					$(".new_category_form").hide();
					$(".category_nav").css({position: "absolute", top: "63"});
				});
			}
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
	

















