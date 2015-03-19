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
	 * @param  [ @param nextPath 根目录下的子文件夹 - 比如:MyBlog_2014-12-04\WEB-INF 或者 MyBlog_2014-12-04\resources 等. ]
	 * @param  [ @param fileName 文件名称]
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月16日 下午6:37:27 ] 
	 *
	 */
	public boolean backup(String nextPath,String fileName);
	
	/**
	 * 
	 * @desc   [ 恢复数据 ]
	 * @param  [ @param nextPath 根目录下的子文件夹 - 比如:MyBlog_2014-12-04\WEB-INF 或者 MyBlog_2014-12-04\resources 等. ]
	 * @param  [ @param fileName 文件名称 ]
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月16日 下午6:37:53 ] 
	 *
	 */
	public boolean recover(String nextPath,String fileName);
	
	/**
	 * 
	 * @desc   [ 删除数据文件 ]
	 * @param  [ @param nextPath 根目录下的子文件夹 - 比如:MyBlog_2014-12-04\WEB-INF 或者 MyBlog_2014-12-04\resources 等. ]
	 * @param  [ @param fileName 文件名称 ]
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月16日 下午6:38:13 ] 
	 *
	 */
	public boolean delete(String nextPath,String fileName);
	
	/**
	 * 
	 * @desc   [ 显示数据文件 ]
	 * @param  [ @param nextPath 根目录下的子文件夹 - 比如:MyBlog_2014-12-04\WEB-INF 或者 MyBlog_2014-12-04\resources 等. ]
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月16日 下午6:38:27 ] 
	 *
	 */
	public List<DataFile> show(String nextPath);
	 
}
