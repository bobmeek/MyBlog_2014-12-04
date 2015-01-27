/**  
 * @Title: ResourceImpl.java
 * @Package org.myblog.service.impl
 * @Description: TODO
 * @author bobmeek
 * @date Jan 23, 2015 9:17:55 PM
 * @version V1.0  
 */
package org.myblog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myblog.base.AbstractBaseDao;
import org.myblog.model.ResourceVO;
import org.myblog.service.facade.ResourceService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ResourceImpl
 * @Description: TODO
 * @author bobmeek
 * @date Jan 23, 2015 9:17:55 PM
 */
@Service
public class ResourceServiceImpl extends AbstractBaseDao<ResourceVO, Integer> implements ResourceService
{

	@Override
	public List<ResourceVO> findResources()
	{
		
		return null;
	}
	
	public List<ResourceVO> findByName(String username)
	{
		String operate = ".findByName";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("username", username);
		return findListByParam(maps, operate);
		
	}
	
	public void deleteRoleRelation(int id)
	{
		String operate = ".deleteRoleRelation";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("id", id);
		delete(maps, operate);
	}

}
