/**
 * 
 */
package org.myblog.controller;

import java.util.List;

import javax.annotation.Resource;

import org.myblog.common.SortListUtil;
import org.myblog.dto.DataFile;
import org.myblog.service.facade.DataBackupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author bobmeek
 *
 */
@Controller
@RequestMapping("/data/")
public class DataBackupController {
	
	@Resource(name="dataBackupServiceImpl")
	private DataBackupService dataBackupService;
	
	
	/**
	 * 
	 * @desc   [ 备份数据 ]
	 * @param  [ @param fileName 文件名称]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月14日 下午12:58:36 ] 
	 *
	 */
	@RequestMapping(value = "/backup")
	@ResponseBody
	public boolean backup(String fileName){
		return dataBackupService.backup("resources\\data_backup\\",fileName);
	}
	
	/**
	 * 
	 * @desc   [ 恢复数据 ]
	 * @param  [ @param fileName 文件名称]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月14日 下午10:21:28 ] 
	 *
	 */
	@RequestMapping(value = "/recover")
	@ResponseBody
	public boolean recover(String fileName){
		return dataBackupService.recover("resources\\data_backup\\",fileName);
	}
	
	/**
	 * 
	 * @desc   [ 删除某个数据文件 ]
	 * @param  [ @param fileName 文件名称]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月14日 下午10:23:11 ] 
	 *
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public boolean delete(String fileName){
		return dataBackupService.delete("resources\\data_backup\\",fileName);
	}
	
	/**
	 * 
	 * @desc   [ 显示所有数据文件 ]
	 * @param  [ @return ]
	 * @author [ bobmeek ]    
	 * @time   [ 2015年3月14日 下午10:23:25 ] 
	 *
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/show")
	@ResponseBody
	public List<DataFile> show(ModelMap modelMap){
		List<DataFile> list = dataBackupService.show("resources\\data_backup\\");
		//按照时间降序排序
		list = (List<DataFile>) SortListUtil.sort(list, "time", SortListUtil.DESC); 
		return list;
	}
}
