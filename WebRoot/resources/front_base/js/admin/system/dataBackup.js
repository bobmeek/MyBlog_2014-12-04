$(function(){
	
	$(document).on("click","#dataBackup",function(e){
		showDataFiles();
	});
	
	function showDataFiles(){
		$("#allDataFiles tbody").html("");
		$.post('data/show','',function(result){
			$.each(result,function(n,dataFile){
				var content = "<tr>" +
				"<td>"+dataFile.fileName+"</td>" +
				"<td>"+dataFile.time+"</td>" +
				"<td>"+dataFile.fileSize+"</td>" +
				"<td>" +
				"<a href='javascript:;'  class='btn btn-sm btn-success dataFileBtn_recover' >恢复</a>" +
				"<a href='javascript:;'  class='btn btn-sm btn-danger dataFileBtn_delete' >删除</a>" +
				"</td>" +
				"</tr>";
				$("#allDataFiles tbody").append(content);			
			});

		},'json');
	}
	
	//备份数据文件
	$(document).on('click','#dataFileLinkBackup',function(e){
		$fileName = $('#fileName').val() + '.sql';
		$.post('data/backup',{fileName:$fileName},function(result){
			showDataFiles();
		},'json');
	});
	
	//恢复数据文件
	$(document).on('click','.dataFileBtn_recover',function(e){
		$fileName = $($(this).closest('tr').children('td')[0]).text();
		$.post('data/recover',{fileName:$fileName},function(result){
			alert('恢复数据完成');
		},'json');
	});
	
	//删除数据文件
	$(document).on('click','.dataFileBtn_delete',function(e){
		$fileName = $($(this).closest('tr').children('td')[0]).text();
		$.post('data/delete',{fileName:$fileName},function(result){
			showDataFiles();
		},'json');
	});
	
	
});