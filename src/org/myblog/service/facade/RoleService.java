/**  
 * @Title: RoleService.java
 * @Package org.myblog.service.facade
 * @Description: TODO
 * @author bobmeek
 * @date Jan 21, 2015 6:12:11 PM
 * @version V1.0  
 */
package org.myblog.service.facade;

import java.util.List;
import java.util.Set;

import org.myblog.base.BaseDao;
import org.myblog.model.RoleVO;

/**
 * @ClassName: RoleService
 * @Description: TODO
 * @author bobmeek
 * @date Jan 21, 2015 6:12:11 PM
 */
public interface RoleService extends BaseDao<RoleVO,Integer>
{
	public List<RoleVO> findRoles();
	
	public List<RoleVO> findByName(String username);
	
	public void addResourceRelation(int roleId,int resourceId);
	
	public void deleteResourceRelation(int roleId,int resourceId);
	
	

}
