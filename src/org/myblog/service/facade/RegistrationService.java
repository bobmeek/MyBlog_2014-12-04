package org.myblog.service.facade;

import java.util.List;

import org.myblog.base.BaseDao;
import org.myblog.model.RegistrationVO;

public interface RegistrationService extends BaseDao<RegistrationVO, Integer>{
	
	/**批量删除**/
	public void deleteBatch(List<Integer> ids);
	
	/**
	 * 
	 * @desc   [ 检验该学生是否已报名 ]
	 * @param  [ @param idNumber 身份证号码
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015-6-11 下午9:32:06 ] 
	 *
	 */
	public int idNumberIsExist(String idNumber); 
	
}
