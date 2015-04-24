$(function(){
	
	function Menu(){
	}
	
	//单击左边树显示栏目管理
	$(document).on("click","#indexMenu",function(e){
		showMenuTree(null);
	});
	
	
	/**
	 * 显示首页菜单导航
	 */
	function showMenuTree(currentNode){
		$.post('menu/show','',function(result){
			var zNodes = [];
			if(null!=result){
				$.each(result,function(n,menu){
					var id = menu.id;
					var parentId = menu.parentId;
					var name = menu.name;
					var status = menu.status;
					var menu = new Menu();
					menu.id=id;menu.name=name;menu.parentId=parentId;menu.checked=status==1;menu.font='"font-weight":bold';
					zNodes.push(menu);
				});
				initMenuTree(zNodes,currentNode);
			}
		},'json');
	}
	
	/**加载导航树*/
	var treeObj = null;
	function initMenuTree(zNodes,currentNode){
		
        var setting = {
            check:{
              enable:false
            },
            view: {
                dblClickExpand: false,
                showLine: true,
                selectedMulti: false,
                nameIsHTML: true
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
                    //alert("before click");
					
                },
                onClick:showChildsMenu,
                onCheck:zTreeOnCheck
            }
        };
        
		var t = $("#indexMenuTree");
        $.fn.zTree.init(t, setting, zNodes);
        treeObj = $.fn.zTree.getZTreeObj("indexMenuTree");
        var allNodes = treeObj.getNodes();
		var cNodes = treeObj.getCheckedNodes();
		currentNode = currentNode==null?allNodes[0]:currentNode;
		if(cNodes.length>0){
			treeObj.selectNode(currentNode);
			//默认展开选中节点下的子节点
			//前台直接添加子节点
			//treeObj.expandNode(currentNode, true, true, true);
			//显示对应的子菜单
			showChildsMenu(null,0, currentNode);
		}
		
	}
	
	//设置列表元素可拖动排序
	$("#allMenu tbody").sortable({
		axis: "y",
		cursor: "move",
		//helper可得到拖动的对象
		helper:function(e,ele){
			var original = ele.children();
			//克隆对象
			var helper = ele.clone();
			helper.children().each(function(i){
				//设置拖动起来后每一个td的宽度
				$(this).width(original.get(i).offsetWidth);
			});
			//设置拖动背景色
			helper.css({
				'background':'#999'
			});
			return helper;
		},
		//当顺序改变时触发
		update:function(e,ui){
			$('#allMenu tbody tr').each(function(i){
				//改变顺序
				$(this).children().eq(4).text(i+1);
			});
			//当拖拽排序后,立即将所有的导航顺序更新,所以遍历更新.
			var menus = []; 			//定义需要修改的菜单数组,因是拖动操作,所以需要遍历修改菜单组
			$('#allMenu tbody tr').each(function(i){
				debugger;
				var $id = parseInt($($(this).children().get(0)).text());
				var $name = $($(this).children().get(1)).text();
				var $status = $($(this).children().get(2)).text()=='停用'?0:1;
				var $parentId = $(this).prop('class').indexOf('parent')==-1 ? 0: parseInt($($($(this).prevAll('tr.treegrid-expanded').context).children().get(3)).text());
				var $orders = parseInt($($(this).children().get(4)).text());
				var menu = new Menu();
				menu.id=$id;menu.name=$name;menu.status=$status;menu.parentId=$parentId;menu.orders=$orders;
				menus.push(menu);
			}); 
			update(menus);
		}
	});
	
	/**显示子菜单**/
	var currentNode = null;
	var currentNodeId = 1;
	var currentNodeName = '';
	 
	function showChildsMenu(e,treeId,treeNode){
		debugger;
		currentNode = treeNode;
		currentNodeId = treeNode.id;
		currentNodeName = treeNode.name;
		$("#allMenu tbody").html("");
		$.post('menu/show/'+currentNodeId,'',function(result){
			if(null!=result){
				$.each(result,function(n,menu){
					var treeGridClass = (menu.parentId==0) ? "treegrid-"+menu.id : "treegrid-"+menu.id+' '+"treegrid-parent-"+menu.parentId;
					var status = menu.status==0?'停用':'启用';
					var content = "<tr>" +
					"<td style='display:none;'>"+menu.id+"</td>" +
					"<td>"+menu.name+"</td>" +
					"<td><button type='button' class='btn btn-info status_menu_btn'>"+status+"</button></td>" +
					"<td style='display: ;'>"+menu.parentId+"</td>" +
					"<td style='display: ;'>"+menu.orders+"</td>" +
					"<td width='15%' style='vertical-align: middle;'>" +
					"<a href='#detail_children_menu_modal' data-target='#detail_children_menu_modal' data-toggle='modal' class='btn btn-sm btn-success detail_children_menu'>详细</a>" +
					"<a  id='delete_menu_modal' class='btn btn-sm btn-danger delete'>删除</a>" +
					"</td>" +
					"</tr>";
					$("#allMenu tbody").append(content);
					$("#allMenu tbody").children("tr:last").addClass(treeGridClass);
				});
			}
		},'json');
	}
	
	function zTreeOnCheck(e,treeId,treeNode){
		/*var roleId = 0;
    	if(treeNode.checked){
    		$.post("menu/update",{"roleId":roleId,"resourceId":treeNode.id},function(result){
    		
    		},"json");
    	}
    	else{
    		$.post("menu/delete",{"roleId":roleId,"resourceId":treeNode.id},function(result){
    			
    		},"json");
    	}
    	var treeObj = $.fn.zTree.getZTreeObj("indexMenuTree");
		var cNodes = treeObj.getCheckedNodes();
		var cNodeArr = [];
		for(var i =0;i<cNodes.length;i++){
			cNodeArr.push(cNodes[i].name);
		}
		$(currentBtn.closest("tr").children("td")[3]).html(cNodeArr.join(","));*/
	}
	
	
	
	//修改导航状态:启用?未启用
	$(document).on('click','.status_menu_btn',function(e){
		debugger;
		var $status = $(this).text()=='停用'?1:0;
		var $id = parseInt($($(this).closest('tr').children().get(0)).text());
		var $name = $($(this).closest('tr').children().get(1)).text();
		var $parentId = $($(this).closest('tr').children().get(3)).text();
		var $orders = parseInt($($(this).closest('tr').children().get(4)).text());
		var menu = new Menu();
		menu.id=$id;menu.name=$name;menu.status=$status;menu.parentId=$parentId;menu.orders=$orders;
		update(menu);
		
	});
	
	$(document).on('click','.detail_children_menu',function(e){
		$("#name_detail_menu").val($($(this).closest('tr').children().get(1)).text());
		$("#id_detail_menu").val($($(this).closest('tr').children().get(0)).text());
		$("#status_detail_menu").val($($(this).closest('tr').children().get(2)).text());
		$("#parentid_detail_menu").val($($(this).closest('tr').children().get(3)).text());
		$("#orders_detail_menu").val($($(this).closest('tr').children().get(4)).text());
		
	});
	//修改菜单信息
	$(document).on('click','#detail_children_menu_btn',function(e){
		$("#detail_children_menu_modal").modal("hide");
		$id = $("#id_detail_menu").val();
		$name = $("#name_detail_menu").val();
		$status = $("#status_detail_menu").val()=='停用'?0:1;
		$parentId = $("#parentid_detail_menu").val();
		$orders = $("#orders_detail_menu").val();
		var menu = new Menu();
		menu.id=$id;menu.name=$name;menu.status=$status;menu.parentId=$parentId;menu.orders=$orders;
		update(menu);
	});
	
	
	//点击"添加子菜单按钮"，将父节点ID与名称带给modal
	$(document).on('click','.children_menu_add',function(e){
		$("#parentname_add_menu").val(currentNodeName);
		$("#parentid_add_menu").val(currentNodeId);
	});
	//添加子菜单 - 提交到数据库
	$(document).on("click","#add_children_menu_btn",function(event){
		debugger;
		$("#add_children_menu_modal").modal("hide");
		var $name = $("#childrenname_add_menu").val();
		var $parentId = $("#parentid_add_menu").val();
		var menu = new Menu();
		menu.name=$name;menu.parentId=$parentId;
		add(menu);
	});
	
	//删除
	$(document).on('click','#delete_menu_modal',function(e){
		debugger;
		var id = $($(this).closest('tr').children().get(0)).text();
		remove(id);
	});
	
	function add(menu){
		$.post("menu/add/childs",menu,function(result){
			showMenuTree(currentNode);
		},"json");
	}
	
	function update(menu){
		//若传过来的是一个菜单组,则执行
		if(menu.length>1){
			$.ajax({
			    url:"menu/update/childs" ,
			    type:"post" ,
			    data:JSON.stringify(menu),
			    dataType:"json",
			    contentType:"application/json",
			    success:function(result){
			    	showMenuTree(currentNode);
			    }
			});
		}else{ //若传过来的是一个菜单对象,则执行
			$.post("menu/update/child",menu,function(result){
				showMenuTree(currentNode);
			},"json");
		}
		
	}
	
	/**
	 * 删除菜单
	 */
	function remove(id){
		$.post('menu/delete/'+id,'',function(result){
			showMenuTree(currentNode);
		},'json');
	}
	
});