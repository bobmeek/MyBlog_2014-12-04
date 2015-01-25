/**  
 * @Title: RoleServiceImpl.java
 * @Package org.myblog.service.impl
 * @Description: TODO
 * @author bobmeek
 * @date Jan 21, 2015 6:14:50 PM
 * @version V1.0  
 */
package org.myblog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.myblog.base.AbstractBaseDao;
import org.myblog.model.RoleVO;
import org.myblog.service.facade.RoleService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: RoleServiceImpl
 * @Description: TODO
 * @author bobmeek
 * @date Jan 21, 2015 6:14:50 PM
 */
@Service
public class RoleServiceImpl extends AbstractBaseDao<RoleVO, Integer> implements RoleService
{


	@Override
	public List<RoleVO> findRoles()
	{
		
		return null;
	}
	@Override
	public List<RoleVO> findByName(String username)
	{
		String operate =".findByName";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("username", username);
		return findListByParam(maps, operate);
	}
	
	public void addResourceRelation(int roleId,int resourceId)
	{
		String operate = ".addResourceRelation";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("roleId", roleId);
		maps.put("resourceId",resourceId);
		save(maps, operate);
	}
	
	public void deleteResourceRelation(int roleId,int resourceId)
	{
		String operate = ".deleteResourceRelation";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("roleId", roleId);
		maps.put("resourceId",resourceId);
		delete(maps, operate);
	}

}
