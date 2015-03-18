$(function(){
	
	
	$(".panel").on("click",function(event){
		var obj = $($(event.target).parent());
		if(obj.attr("class")=="panel")
		{
			//恢复原状
			$(".panel").css("background-color","#222222");
			//当前浏览项目高亮
			$($(event.target).closest("li")).css("background-color","CE5F48").css("border","solid 1px black");
		}
		
	});
	
	
	$(".panel ul").on("click",function(event){
		debugger;
		$(".page").hide();
		var id = event.target.id;
		$("#"+id+"Page").show();
		
		$("").html();
	});
	
	
	
	
	
});