package org.myblog.service.facade;

import java.util.List;

import org.myblog.base.BaseDao;
import org.myblog.model.RegistrationVO;

public interface RegistrationService extends BaseDao<RegistrationVO, Integer>{
	
	/**批量删除**/
	public void deleteBatch(List<Integer> ids);
	
}
