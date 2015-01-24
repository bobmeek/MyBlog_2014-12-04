$(function(){
	
	
	
	//初始化角色管理所有的资源
	var allResources;
	
	showRoles();
	function showRoles()
	{
		
		$.post("role/show/allRoles","",function(result){
			
			allResources = result.resources;
			
			$("#allRoles tbody").html("");
			$.each(result.roles,function(n,role){
				
				var resources = role.listResource;
				
				var resourceArr = [];
				$.each(resources,function(n,resource){
					resourceArr.push(resource.name);
				});
				
				var resourceStr = resourceArr.join(",");
				
				var content = "<tr>" +
							"<td style='display:none;'>"+role.id+"</td>" +
							"<td>"+role.role+"</td>" +
							"<td>"+role.desc+"</td>" +
							"<td>"+resourceStr+"</td>" +
							"<td width='5%' style='vertical-align: middle;'><a href='#show_role_modal' data-target='#show_role_modal' data-toggle='modal' class='btn btn-sm btn-success role_detail' >详细</a></td>" +
							"</tr>"
							
					
					$("#allRoles tbody").append(content);					
						
			});
			
		
		},"json");
	
	}
	
	
	function Resource(id,parentId,name,checked)
	{
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.checked = checked;
	}
	$(document).on("click","#allRoles .role_detail",function(event){
	
		
		var roleId =  $($(this).closest("tr").children("td")[0]).text();
		
		var resources = $($(this).closest("tr").children("td")[3]).text();
		
		var resourceArr = resources.split(",");
		
		var zNodes = [];
			
		$.each(allResources,function(n,res){
		
			var flag = false;
			var resource;
			for(var i = 0;i<resourceArr.length;i++)
			{
				if(res.name == resourceArr[i])
				{
					flag = true;
					resource = new Resource(res.id,res.parentId,res.name,true);
					break;
				}
			}
			if(!flag)
				resource = new Resource(res.id,res.parentId,res.name,false);
			zNodes.push(resource);
		});
        
		showResourceTree($(this),zNodes);

		
		
	});
	
	$(document).on("click","body",hideResourceTree);
	
	
	function showResourceTree(currentBtn,zNodes)
	{
		
		var roleDetailObj = currentBtn;
        var roleDetailObjOffset = currentBtn.offset();
        $("#resourceTree").css({left:roleDetailObjOffset.left-120 + "px", top:roleDetailObjOffset.top + roleDetailObj.outerHeight() + "px"}).slideDown("fast");
		initResourceTree(currentBtn,zNodes);
	}
	
	function hideResourceTree(e)
	{
		//定位问题
		debugger;
		if(!(e.target.text=="详细" || e.target.id=="resourceTree" ||$(event.target).parents("#resourceTree").length>0))
       		$("#resourceTree").fadeOut("fast");
		 
	} 
	
	
	/**加载资源树*/
	function initResourceTree(currentBtn,zNodes)
	{
        var setting = {
            check:{
              enable:true,
              autoCheckTrigger:true,
              chkboxType: { "Y": "", "N": "" }
            },
            view: {
                dblClickExpand: false,
                showLine: true,
                selectedMulti: false
            },
            data: {
                simpleData: {
                    enable:true,
                    idKey: "id",
                    pIdKey: "parentId",
                    rootPId: ""
                }
            },
            callback: {
                beforeClick: function(treeId, treeNode) {
                    alert("before click");
					
                },
                onCheck:function(event,treeId,treeNode)
                {
                	var roleId =  $(currentBtn.closest("tr").children("td")[0]).text();
                	
                	debugger;
                	if(treeNode.checked)
                	{
                		$.post("role/add/resourceRelation",{"roleId":roleId,"resourceId":treeNode.id},function(result){
                		
                		},"json");
                	}
                	else
                	{
                		$.post("role/delete/resourceRelation",{"roleId":roleId,"resourceId":treeNode.id},function(result){
                			
                		},"json");
                	}
                	var treeObj = $.fn.zTree.getZTreeObj("tree");
        			var cNodes = treeObj.getCheckedNodes();
        			var cNodeArr = [];
        			for(var i =0;i<cNodes.length;i++)
        			{
        				cNodeArr.push(cNodes[i].name);
        			}
        			$(currentBtn.closest("tr").children("td")[3]).html(cNodeArr.join(","));
                }
            }
        };
		
		var t = $("#tree");
        $.fn.zTree.init(t, setting, zNodes);
        var treeObj = $.fn.zTree.getZTreeObj("tree");
        var allNodes = treeObj.getNodes();
		var cNodes = treeObj.getCheckedNodes();
		if(cNodes.length>0) treeObj.selectNode(allNodes[0].children[0]);

	}
});