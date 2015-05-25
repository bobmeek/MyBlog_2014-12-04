$(function() {
	
	function Article(){}
	function Menu(){}
	//获取选中栏目id
	var selectedMenuId = 1;
	
	
	toolbar = [ 'title', 'bold', 'italic', 'underline', 'color', '|', 'ol',
			'ul', 'blockquote', 'code', '|', 'link', 'image', '|', 'indent',
			'outdent' ];
	var editor = new Simditor({
		textarea : $('#editor'),
		placeholder : '这里输入内容...',
		pasteImage : true,
		toolbar : toolbar, // 工具栏
		defaultImage : '', // 编辑器插入图片时使用的默认图片
		upload : {
			url : 'article/upload/img', // 文件上传的接口地址
			params : {articleName:$('#saveArticleTitle').val()}, // 键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
			fileKey : 'fileDataFileName', // 服务器端获取文件数据的参数名
			connectionCount : 3,
			leaveConfirm : '正在上传文件'
		},
		markdown : true,
	});
	
	showCategory();
	//单击左边树显示栏目管理
	$(document).on("click","#publishArticle",function(e){
		operateAfterHandler();
		showCategory(null);
	});
	
	/**显示所有分类**/
	function showCategory(currentNode){
		$.post('article/show/category','',function(result){
			$.each(result,function(n,menu){
				var zNodes = [];
				if(null!=result){
					$.each(result,function(n,menu){
						var id = menu.id;
						var parentId = menu.parentId;
						var name = menu.name;
						var type = menu.type;
						var status = menu.status;
						var menu = new Menu();
						menu.id=id;menu.name=name;menu.parentId=parentId;menu.checked=status==1;menu.type=type;menu.font='"font-weight":bold';
						zNodes.push(menu);
					});
					initMenuTree(zNodes,currentNode);
				}
			});
			
		},'json');
	}
	
	
	$(document).on('click','#saveArticle',save);
	$(document).on('click','#updateArticle',update);
	$(document).on('click','#saveArticleMenu',function(e){
		debugger;
		var article = JSON.parse(sessionStorage.getItem('updateArticle'));
		var selectMenuId = null!=article?article.menu.id:1; 
		currentNode = treeObj.getNodeByParam("id",selectMenuId,null);
				
		showCategory(currentNode);
		$('#articleMenuTree').toggle('fast');
	});
	

	/**保存文章**/
	function save(e){
		debugger;
		articleOperate = 'save';
		var article = new Article();
		article.author = $('#currentUser').text();
		article.title = $('#saveArticleTitle').val();
		article.content = editor.getValue();
		article.menuId = selectedMenuId;
		
		var time = + new Date;
		article.releaseDate = Time(time, "%y-%M-%d %h:%m:%s"); // xxxx-xx-xx xx:xx:xx
		$.post('article/save',article,function(result){
			operateAfterHandler();
			showCategory(null);
			alert('发布文章成功!');
		},'json');
		
	}
	
	/**更新文章**/
	function update(e){
		debugger;
		var article = new Article();
		article.id = JSON.parse(sessionStorage.getItem('updateArticle')).id;
		article.author = $('#currentUser').text();
		article.title = $('#saveArticleTitle').val();
		article.content = editor.getValue();
		article.menuId = selectedMenuId;
		var time = + new Date;
		article.releaseDate = Time(time, "%y-%M-%d %h:%m:%s"); // xxxx-xx-xx xx:xx:xx
		$.post('article/update',article,function(result){
			operateAfterHandler();
			showCategory(null);
			alert('更新文章成功!');
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
                beforeClick: function(event,treeId, treeNode) {
                    //alert("before click");
					
                },
                onClick:function(event,treeId,treeNode){
                	debugger;
                	treeNode.id==1?alert('发布栏目不能为'+treeNode.name+'请重新选择发布栏目'):$('#saveArticleMenu').val(treeNode.name);
                	selectedMenuId = treeNode.id;
                }
                	
                
            }
        };
        
		var t = $("#articleMenuTree");
        $.fn.zTree.init(t, setting, zNodes);
        treeObj = $.fn.zTree.getZTreeObj("articleMenuTree");
        var allNodes = treeObj.getNodes();
		var cNodes = treeObj.getCheckedNodes();
		currentNode = currentNode==null?allNodes[0]:currentNode;
		if(cNodes.length>0){
			treeObj.selectNode(currentNode);
			//默认展开选中节点下的子节点
			//前台直接添加子节点
			//treeObj.expandNode(currentNode, true, true, true);
			//显示对应的子菜单
		}
		
	}
	
	
	
	
	
	
	
	
	/**保存或者更新操作之后的处理,如清空文本框,改变按钮等等**/
	function operateAfterHandler(){
		if(sessionStorage.getItem('articleOperate')=='update'){
			sessionStorage.removeItem('articleOperate');
			var article = JSON.parse(sessionStorage.getItem('updateArticle'));
			debugger;
			$('#publishArticleBreadcrumb').text('更新文章');
			$('#saveArticle').hide();
			$('#updateArticle').show();
			$('#saveArticleTitle').val(article.title);
			$('#saveArticleMenu').val(article.menu.name);
			selectedMenuId = article.menuId;
			editor.setValue(article.content);
		}else{
			$('#publishArticleBreadcrumb').text('发布文章');
			$('#saveArticle').show();
			$('#updateArticle').hide();
			$('#saveArticleTitle').val('');
			$('#saveArticleMenu').val('');
			editor.setValue('');
		}
	}
	
	
});
