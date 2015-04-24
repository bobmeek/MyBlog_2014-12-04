$(function(){
	
	function Category(id,name,type,status,orders,parentId,parentIds){
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
		this.orders = orders;
		this.parentId = parentId;
		this.parentIds = parentIds;
	}
	
	
	//单击左边树显示栏目管理
	$(document).on("click","#categoryInfo",function(e){
		show();
	});
	
	
	/**
	 * 显示栏目信息
	 */
	function show(){
		
		$.post('category/show','',function(result){
			
			$("#allCategory tbody").html("");
			if(null!=result){
				result = JSON.parse(result);
				debugger;
				$.each(result,function(n,category){
					
				});
				
				
			}
			
		});
	}
	
	
	
	//添加一级菜单
	$(document).on('click','#add_category_btn',function(e){
		debugger;
		$("#add_category_modal").modal("hide");
		var $name = $('#categoryname_text_add').val();
		var category = new Category(1,$name, 1, 1, 1,0,'0/');
		add(category);
	});
	
	//点击"添加子菜单按钮"，将父节点ID与名称带给modal
	$(document).on('click','#allCategory .children_category_add',function(e){
		$("#parentname_add_category").val($(this).closest("tr").children("td:eq(0)").text());
		$("#parentid_add_category").val($(this).closest("tr").children("td:eq(1)").text());
		$("#parentids_add_category").val($(this).closest("tr").children("td:eq(6)").text());
	});
	//添加子菜单 - 提交到数据库
	$(document).on("click","#add_children_category_btn",function(event){
		debugger;
		$("#add_children_category_modal").modal("hide");
		var $name = $("#childrenname_add_category").val();
		var $parentId = $("#parentid_add_category").val();
		var $parentIds = $("#parentids_add_category").val();
		var category = new Category(1,$name,1,1,1,$parentId,$parentIds);
		add(category);
	});
	
	//删除
	$(document).on('click','#delete_category_modal',function(e){
		debugger;
		var id = $($(this).closest('tr').children().get(1)).text();
		remove(id);
	});
	
	/**
	 * 更新栏目信息
	 */
	function update(category){
		$.post('category/update',category,function(result){
			show();
		},'json');
	}
	 
	/**
	 * 添加栏目
	 */
	function add(category){
		$.post('category/add',category,function(result){
			show();
		},'json');
	}
	
	/**
	 * 删除栏目
	 */
	function remove(id){
		$.post('category/delete/'+id,'',function(result){
			show();
		},'json');
	}
	
});