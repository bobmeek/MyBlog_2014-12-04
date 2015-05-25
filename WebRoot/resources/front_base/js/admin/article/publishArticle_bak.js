$(function() {
	
	function Article(){}
	
	
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
		showCategory();
	});
	
	/**显示所有分类**/
	function showCategory(){
		$.post('article/show/category','',function(result){
			
			if(sessionStorage.getItem('articleOperate')=='update'){
				sessionStorage.removeItem('articleOperate');
				var article = JSON.parse(sessionStorage.getItem('updateArticle'));
				debugger;
				$('#saveArticle').hide();
				$('#updateArticle').show();
				$('#saveArticleTitle').val(article.title);
				menuId = article.menuId;
				$("#"+menuId).prop('checked','checked');
				$('#showArticleCategoryBtn').html($('#menuLabel'+menuId).text()+'<span class="caret"></span>');
				editor.setValue(article.content);
			}else{
				$('#saveArticle').show();
				$('#updateArticle').hide();
				$('#saveArticleTitle').val('');
				$('#showArticleCategoryUL').html('');
				$('#showArticleCategoryBtn').html('默认'+'<span class="caret"></span>');
				editor.setValue('');
			}
			$.each(result,function(n,menu){
				var content=menu.id==1?'':'<li><input type="radio"  id="'+menu.id+'" name="NAME" value="VALUE" selected="selected"><label for="'+menu.id+'" id="menuLabel'+menu.id+'">'+menu.name+'</label></li>';
				$('#showArticleCategoryUL').append(content);
			});
			
		},'json');
	}
	
	
	$(document).on('click','#saveArticle',save);
	$(document).on('click','#updateArticle',update);

	//获取选中栏目id
	var menuId = 1;
	$(document).on('click','#showArticleCategoryUL li',function(e){
		debugger;
		menuId = parseInt($(this).children().get(0).id);
	});
	
	/**保存文章**/
	function save(e){
		debugger;
		articleOperate = 'save';
		var article = new Article();
		article.author = $('#currentUser').text();
		article.title = $('#saveArticleTitle').val();
		article.content = editor.getValue();
		article.menuId = menuId;
		
		var time = + new Date;
		article.releaseDate = Time(time, "%y-%M-%d %h:%m:%s"); // xxxx-xx-xx xx:xx:xx
		$.post('article/save',article,function(result){
			
			showCategory();
			editor.setValue('');
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
		article.menuId = menuId;
		var time = + new Date;
		article.releaseDate = Time(time, "%y-%M-%d %h:%m:%s"); // xxxx-xx-xx xx:xx:xx
		$.post('article/update',article,function(result){
			showCategory();
			editor.setValue('');
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
                beforeClick: function(treeId, treeNode) {
                    //alert("before click");
					
                },
                onClick:showChildsMenu,
                onCheck:zTreeOnCheck
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
	
});
