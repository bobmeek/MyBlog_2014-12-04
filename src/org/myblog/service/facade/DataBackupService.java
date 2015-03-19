package org.myblog.service.facade;

import java.util.List;

import org.myblog.dto.DataFile;



/**
 * 
 * @desc   [  ]
 * @author [ bobmeek ]   
 * @time   [ 2015年3月14日 下午12:33:54 ] 
 *
 */
public interface DataBackupService {
	
	/**
	 * 
	 * @desc   [ 备份数据 ]
	 * @param  [ @param fileName 文件名称]
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月16日 下午6:37:27 ] 
	 *
	 */
	public boolean backup(String fileName);
	
	/**
	 * 
	 * @desc   [ 恢复数据 ]
	 * @param  [ @param fileName 文件名称 ]
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月16日 下午6:37:53 ] 
	 *
	 */
	public boolean recover(String fileName);
	
	/**
	 * 
	 * @desc   [ 删除数据文件 ]
	 * @param  [ @param fileName 文件名称 ]
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月16日 下午6:38:13 ] 
	 *
	 */
	public boolean delete(String fileName);
	
	/**
	 * 
	 * @desc   [ 显示数据文件 ]
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月16日 下午6:38:27 ] 
	 *
	 */
	public List<DataFile> show();
	 
}
