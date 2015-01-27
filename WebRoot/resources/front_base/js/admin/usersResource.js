$(function(){

	
	/**
	 * bug：
	 * 1、当拦截类型为button时，url框应为只读。
	 */
	function Resource(id,name,type,url,permission,parentId,parentIds)
	{
		this.id = id;
		this.name = name;
		this.type = type;
		this.url = url;
		this.permission = permission;
		this.parentId = parentId;
		this.parentIds = parentIds;
	}
	
	
	function initTreeGrid()
	{
		$('.tree').treegrid({
        expanderExpandedClass: 'glyphicon glyphicon-minus',
        expanderCollapsedClass: 'glyphicon glyphicon-plus'
     });
	}
	
        
	$(document).on("click","#usersResource",function(e){
		showResources();
	});
	
	/**资源列表显示**/
	function showResources()
	{
		$.post("resource/show/allResources","",function(result){
		
			var allResourcesTbody = $("#allResources tbody");
			allResourcesTbody.html("");
			if(null!=result)
			{
				$.each(result,function(n,resource){
					
					debugger;
					//当拦截类型为菜单时，存在"添加子节点"按钮，当节点类型不为根节点时存在删除按钮
					var addChildrenLink = (resource.type=="menu")?"<a href='#add_resource_modal' data-target='#add_resource_modal' data-toggle='modal' class='btn btn-sm btn-warning resource_add' >添加子节点</a>":"";
					var deleteLink = (resource.parentId!=0)?"<a href='javascript:void(0)' class='btn btn-sm btn-danger resource_delete' >删除</a>":"";
					
					var detailLink = "<a href='#show_resource_modal' data-target='#show_resource_modal' data-toggle='modal' class='btn btn-sm btn-success resource_detail' >详细</a>";
					var treeGridClass = (resource.parentId==0) ? "treegrid-"+resource.id : "treegrid-"+resource.id+' '+"treegrid-parent-"+resource.parentId;
					var type = (resource.type=="menu")?"菜单":"按钮";
					var content = "<tr>" +
								"<td style='text-align:left;'>"+resource.name+"</td>" +
								"<td style='display:none;'>"+resource.id+"</td>" +
								"<td style='display:none;'>"+resource.parentIds+"</td>" +
								"<td>"+type+"</td>" +
								"<td>"+resource.url+"</td>" +
								"<td>"+resource.permission+"</td>" +
								"<td width='15%' style='text-align: left;'>" + detailLink + deleteLink + addChildrenLink +
								"</td>" + 
								"</tr>"
					allResourcesTbody.append(content);
					allResourcesTbody.children("tr:last").addClass(treeGridClass);
				});	
				initTreeGrid();
			}
			
			
		});
		
	}
	
	//点击"添加子节点按钮"，将父节点ID与名称带给modal
	$(document).on("click","#allResources .resource_add",function(e){
	
		$("#parentname_add_res").val($(this).closest("tr").children("td:eq(0)").text());
		$("#parentid_add_res").val($(this).closest("tr").children("td:eq(1)").text());
		$("#parentids_add_res").val($(this).closest("tr").children("td:eq(2)").text());
	});
	
	$(document).on("change","#type_add_res~ul",function(e){
		debugger;
		//$("#type_add_res").text()=="菜单"?$("#url_add_res").removeProp("readonly"):$("#url_add_res").prop("readonly","true");
	});
	
	//添加用户 - 提交到数据库
	$(document).on("click","#add_resource_btn",function(event){
		debugger;
		$("#add_resource_modal").modal("hide");
		
		var name = $("#childrenname_add_res").val();
		var type = ($("#type_add_res").text()=="菜单")?"menu":"button";
		var url = $("#url_add_res").val();
		var permission = $("#permission_add_res").val();
		var parentId = $("#parentid_add_res").val();
		var parentIds = $("#parentids_add_res").val()+"/"+parentId;
		
		
		var resource = new Resource(0,name,type,url,permission,parentId,parentIds);
		
		
		$.post("resource/add",resource,function(result){
			debugger;
			
			showResources();
				
		},"json");
		
	});
	
	$(document).on("click","#allResources .resource_delete",function(e){
		
		var id = $(this).closest("tr").children("td:eq(1)").text();
		$.post("resource/delete/"+id,"",function(result){
			
			showResources();
			
		},"json");		
		
	});
	
	
	$.each($("#show_resource_table tr"),function(n,tr){
		debugger;
		$(tr).children("td").eq(0).css("width","80px").css("background-color","#EDF3F4").css("text-align","right");
		$(tr).children("td").eq(1).css("padding-left","10px").css("padding-top","15px").css("text-align","left");
		
	});
	
	$(document).on("click","#allResources .resource_detail",function(event){
		var id = parseInt($(this).closest("tr").children("td").eq(1).text());
		$.post("resource/show/"+id,"",function(result){
			debugger;
			
			var type = (result.type=="menu"?"菜单":"按钮");
			var lis = $("#type_res_text_update ul").children("li");
			for(var i = 0;i<lis.length;i++)if(type==$(lis[i]).text()) $(lis[i]).children("input").prop("checked","true");
			
			$("#id_res_span_update").text(result.id);
			$("#name_res_span_update").text(result.name);
			$("#type_res_span_update").text(type);
			$("#url_res_span_update").text(result.url);
			$("#permission_res_span_update").text(result.permission);
			
			$("#id_res_text_update").val(result.id);
			$("#name_res_text_update").val(result.name);
			$("#type_res_text_update .btn").text(type);
			
			$("#url_res_text_update").val(result.url);
			$("#permission_res_text_update").val(result.permission);
			
			
		},"json")
		
	});
	
	$(document).on("click","#show_resource_table .sp",function(event){
		debugger;
		$("#show_resource_table .sp").hide();
		$("#show_resource_table .in").show();
		
	});
	
	//编辑用户更新信息,存储到数据库
	$("#resource_update_btn").on("click",function(event){
		debugger;
		reset();
		var id = parseInt($("#id_res_text_update").val());
		var name = $("#name_res_text_update").val();
		var type = ($("#type_res_text_update .btn").text()=="菜单")?"menu":"button";
		var url = $("#url_res_text_update").val();
		var permission = $("#permission_res_text_update").val();
		var resource = new Resource(id,name,type,url,permission);
		$.post("resource/update",resource,function(result){
		showResources();	
			
		},"json");
		
		
	});
	
	
	/**
	 * 编辑还原
	 */
	function reset()
	{
		$("#show_resource_modal").modal("hide");
		$("#show_resource_table .sp").show();
		$("#show_resource_table .in").hide();
	}
});