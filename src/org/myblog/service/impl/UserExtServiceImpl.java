/**  
 * @Title: UserExtServiceImpl.java
 * @Package org.myblog.service.impl
 * @Description: TODO
 * @author bobmeek
 * @date Jan 10, 2015 6:42:03 PM
 * @version V1.0  
 */
package org.myblog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myblog.base.AbstractBaseDao;
import org.myblog.model.UserExtVO;
import org.myblog.service.facade.UserExtService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserExtServiceImpl
 * @Description: TODO
 * @author bobmeek
 * @date Jan 10, 2015 6:42:03 PM
 */
@Service
public class UserExtServiceImpl extends AbstractBaseDao<UserExtVO, Integer> implements UserExtService
{

	
	public UserExtVO findExtById(Integer id)
	{
		String operate = ".findExtById";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("id", id);
		return findByParam(maps, operate);
		
	}
	
	public void deleteBatch(List<Integer> ids)
	{
		String operate = ".deleteBatch";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("ids", ids);
		delete(maps, operate);
	}

}
