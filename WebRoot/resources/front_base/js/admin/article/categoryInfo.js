$(function(){
	
	function Category(id,name,type,status,orders){
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
		this.orders = orders;
	}
	//单击左边树显示栏目管理
	$(document).on("click","#categoryInfo",function(e){
		show();
	});
	
	//设置列表元素可拖动排序
	$("#allCategory tbody").sortable({
		axis: "y",
		cursor: "move",
		//helper可得到拖动的对象
		helper:function(e,ele){
			var original = ele.children();
			//克隆对象
			var helper = ele.clone();
			helper.children().each(function(i){
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
			$('#allCategory tbody tr').each(function(i){
				debugger;
				$(this).children().eq(4).text(i+1);
			});
			//当拖拽排序后,立即将所有的导航顺序更新,所以遍历更新.
			$('#allCategory tbody tr').each(function(i){
				var id = parseInt($($(this).children().get(0)).text());
				var name = $($(this).children().get(1)).text();
				var type = parseInt($($(this).children().get(2)).text());
				var status = $($(this).children().get(3)).text()=='停用'?0:1;
				var orders = parseInt($($(this).children().get(4)).text());
				var category = new Category(id,name,type,status,orders);
				update(category);
			});
		}
	});
	
	/**
	 * 显示栏目信息
	 */
	function show(){
		
		$.post('category/show','',function(result){
			
			$("#allCategory tbody").html("");
			$.each(result,function(n,category){
				var status = category.status==0?'停用':'启用';
				var content = "<tr>" +
				"<td style='display:;'>"+category.id+"</td>" +
				"<td>"+category.name+"</td>" +
				"<td>"+category.type+"</td>" +
				"<td><button type='button' class='btn btn-info status_category_btn'>"+status+"</button></td>" +
				"<td style='display: ;'>"+category.orders+"</td>" +
				"<td width='10%' style='vertical-align: middle;'>" +
				"<a href='#detail_category_modal' data-target='#detail_category_modal' data-toggle='modal' class='btn btn-sm btn-success detail'>详细</a>" +
				"<a  id='delete_category_modal' class='btn btn-sm btn-danger delete'>删除</a>" +
				"</td>" +
				"</tr>";
				$("#allCategory tbody").append(content);
			});
		},'json');
	}
	
	//修改导航状态:启用?未启用
	$(document).on('click','.status_category_btn',function(e){
		debugger;
		var status = $(this).text()=='停用'?1:0;
		var id = parseInt($($(this).closest('tr').children().get(0)).text());
		var name = $($(this).closest('tr').children().get(1)).text();
		var type = parseInt($($(this).closest('tr').children().get(2)).text());
		var orders = parseInt($($(this).closest('tr').children().get(4)).text());
		var category = new Category(id,name,type,status,orders);
		update(category);
	});
	
	//添加
	$(document).on('click','#add_category_btn',function(e){
		debugger;
		$("#add_category_modal").modal("hide");
		var name = $('#categoryname_text_add').val();
		var category = new Category(1,name, 1, 1, 1);
		add(category);
	});
	
	
	//删除
	$(document).on('click','#delete_category_modal',function(e){
		debugger;
		var id = $($(this).closest('tr').children().get(0)).text();
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