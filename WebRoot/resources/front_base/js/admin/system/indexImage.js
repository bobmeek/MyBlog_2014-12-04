$(function(){
	
	function IndexImage(id,title,articleLink,imgPath,type,status,orders){
		this.id = id;
		this.title = title;
		this.articleLink = articleLink;
		this.imgPath = imgPath;
		this.type = type;
		this.status = status;
		this.orders = orders;
	}
	
	//单击左边树显示栏目管理
	$(document).on("click","#indexImage",function(e){
		show();
	});
	function show(){
		$.post('index/index-img/show','',function(result){
			debugger;
			$("#allIndexImage tbody").html('');
			$.each(result, function(i, indexImg){
				debugger;
				var status = indexImg.status==0?'停用':'启用';
				var type = indexImg.type==0?'站外链接':'站内链接';
				var jIndexImg = JSON.stringify(indexImg);
				var content = "<tr data-index-img="+jIndexImg+">" + "<td style='display: none'>" + indexImg.id + "</td>" 
				+ "<td>" + indexImg.title + "</td>" 
				+" <td><button type='button' class='btn btn-info status_index_img_btn'>"+status+"</button></td>"
				+ "<td>" + type  + "</td>" 
				+ "<td>"  
				+ "<a href='#add_index_img_modal' data-target='#add_index_img_modal' data-toggle='modal'  class='btn btn-success index_img_update'>详细</a>" 
				+ "<button type='button' id='delete_index_img_button' class='btn btn-danger delete'>删除</button>"
				+ "</td>"
				+ "</tr>";
				sessionStorage.setItem(indexImg.id,jIndexImg);
				$("#allIndexImage tbody").append(content);
			});	
			
		},'json');
		
	}
	
	
	/**添加**/
	$(document).on('click','#saveIndeximgBtn',save);
	
	function save(){
		debugger;
		var $title = $('#indexImgTitle').val();
		var $articleLink = $('#indexArticleLink').val();
		var $imgPath = $('#indexImageImg').attr('src');
		var $type = $('input[name="indexLinkType"]:checked').val();  
		var $status = $('input[name="indexImageStatus"]:checked').val();;
		var indexImg = new IndexImage(0,$title,$articleLink,$imgPath,$type,$status,0);
		$.post('index/index-img/save',indexImg,function(result){
			operateAfterHandler();
			show();
		},'json');
		
	}
	
	
	/**修改**/
	$(document).on('click','#updateIndeximgBtn',update);

	function update(e,indexImg){
		if(indexImg==null){
			var $title = $('#indexImgTitle').val();
			var $articleLink = $('#indexArticleLink').val();
			var $imgPath = $('#indexImageImg').attr('src');
			var $type = $('input[name="indexLinkType"]:checked').val();  
			var $status = $('input[name="indexImageStatus"]:checked').val();
			indexImg = new IndexImage(JSON.parse(sessionStorage.getItem('updateIndexImg')).id,$title,$articleLink,$imgPath,$type,$status,0);
		}
		$.post('index/index-img/update',indexImg,function(result){
			operateAfterHandler();
			show();
		},'json');
	}
	
	
	/**删除**/
	$(document).on('click','#delete_index_img_button',remove);
	
	function remove(){
		var $indexImg = $(this).closest('tr').data('index-img');
		var id = $indexImg.id;
		$.post('index/index-img/delete/'+id,"",function(result){
			operateAfterHandler();
			show();
		},'json');
	}
		
	
	/**弹出修改界面**/
	$(document).on('click','.index_img_update',function(e){
		debugger;
		$('#indexImgModalTitle').text('更新首页图片');
		$('#updateIndeximgBtn').show();
		$('#saveIndeximgBtn').hide();
		$('#indexImgHolder').hide();
		$('#indexImageImg').removeAttr("style");
		$('#indexImageImg').css({
			'max-width':'100%'
		});
		
		
		
		var $indexImg = $(this).closest('tr').data('index-img');
		var id = $indexImg.id;
		$('#indexImgTitle').val($indexImg.title);
		$('#indexArticleLink').val($indexImg.articleLink);
		$('#indexImageImg').attr('src',$indexImg.imgPath);
		$('input[name=indexLinkType][value='+$indexImg.type+']').prop('checked',true);
		$('input[name=indexImageStatus][value='+$indexImg.status+']').prop('checked',true);
		sessionStorage.setItem('updateIndexImg',JSON.stringify($indexImg));
	});
	
	//列表界面直接修改启用?停用状态
	$(document).on('click','.status_index_img_btn',function(e){
		debugger;
		var status = $(this).text()=='停用'?1:0;
		var $indexImg = $(this).closest('tr').data('index-img');
		$indexImg.status = status;
		update(e,$indexImg);
	});
	
	
	
	//点击上传头像按钮可选图片文件
//	$(document).on("click","#indexImgBtn",function(){
//		$("#propagandaImgFile").click();
//	});
	//点击头像本身可选图片文件
	$(document).on("click","#indexImageImgDIV",function(){
		$("#propagandaImgFile").click();
		
	});
	
	
	 $(document).on("change","#propagandaImgFile",function(){
		 	debugger;
	        var file = $("#propagandaImgFile").val();
	        //获取现在图片的路径，以便传到后台删除当前路径中的文件
	        var indexImgNameOld = $("#indexImageImg").attr("src");
	        
	        if(typeof(indexImgNameOld) != "undefined" && "" != indexImgNameOld)
	        	indexImgNameOld = indexImgNameOld.substring(indexImgNameOld.lastIndexOf("/")+1);
	        else
	        	indexImgNameOld = "";
	        
	        //判断上传的文件的格式是否正确  
	        var fileType = file.substring(file.lastIndexOf(".")+1).toLowerCase();  
	        if(fileType!="png"&&fileType!="jpg"&&fileType!="gif"){  
	            alert("上传文件格式错误");  
	            return;  
	        }  
	        else{  
	            var url = "index/propaganda-img/upload";  
	            $.ajaxFileUpload({  
	                url:url,
	                data:{"fileType":fileType,"indexImgNameOld":indexImgNameOld},
	                secureuri:false,  
	                fileElementId:"propagandaImgFile",        //file的id  
	                dataType:"text",                  //返回数据类型为文本  
	                success:function(data, status){        //服务器响应成功时的处理函数
			            //本例中设定上传文件完毕后,服务端会返回给前台[0`filepath]
	                	//0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)
			            if(data.substring(0, 1) == 0){     
			            	debugger;
			            	headPicNameNew = data.substring(2);
			                $("#indexImageImg").attr("src", headPicNameNew);
			                $('#indexImgHolder').hide();
			                $('#indexImageImg').removeAttr("style");
			        		$('#indexImageImg').css({
			        			'max-width':'100%'
			        		});
			            }else if(data ==1)
			            {
			            	alert("请选择文件后上传！");
			            }
			            else{
			                alert("失败！");
			            }
	        		},
			        error:function(data, status, e){ //服务器响应失败时的处理函数
			            alert("上传失败！");
			        }  
	            });  
	        }  
	    });
	 
	 
	 
	 /**点击关闭小图标触**/
	 $("#indexImgModalClose").on("click",function(){
		 operateAfterHandler();
		});
	 
	 /**保存或者更新操作之后的处理,如清空文本框,改变按钮等等**/
	 function operateAfterHandler(){
		 //模态框隐藏
		$("#add_index_img_modal").modal("hide");
		//更新按钮隐藏
		$('#updateIndeximgBtn').hide();
		//保存按钮显示
		$('#saveIndeximgBtn').show();
		//添加图片占位符显示
		$('#indexImgHolder').show();
		//修改模态框标题为添加
		$('#indexImgModalTitle').text('添加宣传图片');
		//修改图片大小
		$('#indexImageImg').css({
			'max-width':'100%',
			'margin-left':'30%'
		});
		//宣传图片标题清空
		$('#indexImgTitle').val('');
		//宣传图片对应文章链接清空
		$('#indexArticleLink').val('');
		//宣传图片路径清空
		$('#indexImageImg').attr('src','');
		//链接类型默认选择站内链接
		$('input[name=indexLinkType][value=1]').prop('checked',true);
		//启用状态默认显示启用
		$('input[name=indexImageStatus][value=1]').prop('checked',true);

	 }
	
});