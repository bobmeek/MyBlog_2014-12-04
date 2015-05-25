$(function(){
	
	
   /** 角色分配：
	 * 1、得到所有角色。↑
	 * 2、遍历拼接成checkbox。↑
	 * 3、当点击的时候判断当前button中的值，如果与checkbox中的值有相同的，则将对应的checkbox高亮。↑
	 * 4、每添加一个用户默认分配一个注册用户角色。(触发器 	)。↑
	 * 5、设置完角色或者资源后，直接局部刷新，可将按钮放到一个固定的jsp页面中，引入;在jquery中加入shiro拦截。↑
	 * 6、权限拦截filterChainDefinitions配置，现在加上后，登录不了。↑
	 * 7、拦截Request method 'GET' not supported。↑
	 * 8、项目后台管理文件夹整理。
	 * 9、资源树取消问题。↑
	 * 
	 * bug：
	 * 1、编辑用户信息事件不触发。↑
	 * 
	 * 
	 * **/
	
	function Role(id,role,desc)
	{
		this.id = id;
		this.role = role;
		this.desc = desc;
	}
	function Resource(id,parentId,name,checked)
	{
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.checked = checked;
	}
	
	//初始化角色管理所有的资源
	var allResources;
	
	$(document).on('click','#usersRole',function(){
		showRoles();
	});
	
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
							"<td width='5%'><a href='#show_role_modal' data-target='#show_role_modal' data-toggle='modal' class='btn btn-sm btn-success role_detail' >详细</a></td>" +
							"<td width='10%' style='vertical-align: middle;'>" +
							"<a href='#' data-target='#' data-toggle='modal' class='btn btn-sm btn-warning role_setting_resource' >分配权限</a>" +
							"<a href='javascript:;' class='btn btn-sm btn-danger role_delete' >删除</a>" +
							"</td>" +
							"</tr>";
							
					
					$("#allRoles tbody").append(content);					
						
			});
			
		
		},"json");
	
	}
	
	
	//删除角色
	$(document).on("click","#allRoles .role_delete",function(e){
		
		var roleId =  $($(this).closest("tr").children("td")[0]).text();
		$.post("role/delete/"+roleId,"",function(result){
		
			showRoles();
			
		},"json");
		
	});
	
	//添加角色
	$(document).on("click","#add_role_btn",function(e){
		debugger;
		$("#add_role_modal").modal("hide");
		
		var $role = $("#role_add_role").val();
		var $desc = $("#desc_add_role").val();
		var role = new Role(0,$role,$desc);
		
		$.post("role/add",role,function(result){
			showRoles();
		},"json");
		
	});
	
	//修改角色信息
	$(document).on("click","#allRoles .role_detail",function(event){
		showRoleDetailCss();
		var id = parseInt($(this).closest("tr").children("td").eq(0).text());
		var role = $(this).closest("tr").children("td").eq(1).text();
		var desc = $(this).closest("tr").children("td").eq(2).text();
		$("#id_role_span_update").text(id);
		$("#role_role_span_update").text(role);
		$("#desc_role_span_update").text(desc);
		
		$("#id_role_text_update").val(id);
		$("#role_role_text_update").val(role);
		$("#desc_role_text_update").val(desc);
		
	});
	
	$(document).on('click','#show_role_table .sp',function(){
		showRoleText();
	});
	
	$(document).on('click','#update_role_btn',function(event){
		showRoleSpan();
		var $id = $('#id_role_text_update').val();
		var $role = $('#role_role_text_update').val();
		var $desc = $('#desc_role_text_update').val();
		var role = new Role($id,$role,$desc);
		$.post('role/update',role,function(result){
			showRoles();
		},'json');
	});
	
	/****
	 * 角色详细信息样式
	 * 将每个tr的第一个td变色，并且居右对齐。
	 */
	function showRoleDetailCss(){
		$.each($("#show_role_table tr"),function(n,tr){
			$(tr).children("td").eq(0).css({
				"width":"90px",
				"background-color":"#EDF3F4",
				"text-align":"right"
			});
			
			$(tr).children("td").eq(1).css({
				"padding-left":"10px",
				"padding-top":"15px",
				"text-align":"left"
			});
		});
	}
	$(document).on("click","#allRoles .role_setting_resource",function(){
		//对于同一对象绑定多个同一事件进行不同处理，执行完毕则轮询。
		$(".role_setting_resource").toggle(function(){
		
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
        
		debugger;
		showResourceTree($(this),zNodes);
			
		},function(){
			
			$("#resourceTree").fadeOut("fast");
		});
		
		//手动触发单击事件
		//$(".resourceTree").trigger("click");
	});
	
	
	function showResourceTree(currentBtn,zNodes)
	{
		var roleDetailObj = currentBtn;
        var roleDetailObjOffset = currentBtn.offset();
        $("#resourceTree").css({left:roleDetailObjOffset.left-120 + "px", top:roleDetailObjOffset.top + roleDetailObj.outerHeight() + "px"}).slideDown("fast");
		initResourceTree(currentBtn,zNodes);
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
	
	
	/**
	 * 编辑还原 - text隐藏,span显示
	 */
	function showRoleSpan(){
		$("#show_role_modal").modal("hide");
		$("#show_role_table .sp").show();
		$("#show_role_table .in").hide();
	}
	
	/**
	 * span隐藏，text显示
	 */
	function showRoleText(){
		$("#show_role_table .sp").hide();
		$("#show_role_table .in").show();
	}
	
		
		
});