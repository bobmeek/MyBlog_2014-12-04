package org.myblog.service.impl;

import java.net.URISyntaxException;
import java.util.List;

import org.myblog.common.BaseUtils;
import org.myblog.common.DataBaseUtil;
import org.myblog.dto.DataFile;
import org.myblog.service.facade.DataBackupService;
import org.springframework.stereotype.Service;

/**   
 * @desc   [ 网站数据操作 ]
 * @author [ bobmeek ]   
 * @time   [ 2015年3月14日 下午12:41:53 ] 
 *
 */
@Service
public class DataBackupServiceImpl implements DataBackupService {
	
	static{
		DataBaseUtil.loadProperties(BaseUtils.getClassesPath()+"data.properties");
	}
	
	@Override
	public boolean backup(String nextPath,String fileName) {
		
		try {
			return DataBaseUtil.backup(nextPath, fileName);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean recover(String nextPath,String fileName) {
		try {
			return DataBaseUtil.recover(nextPath, fileName);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean delete(String nextPath,String fileName) {
		try {
			return DataBaseUtil.delete(nextPath, fileName);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<DataFile> show(String nextPath) {
		try {
			return DataBaseUtil.show(nextPath);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
