/**  
 * @Title: ResourceServcie.java
 * @Package org.myblog.service.facade
 * @Description: TODO
 * @author bobmeek
 * @date Jan 23, 2015 9:16:04 PM
 * @version V1.0  
 */
package org.myblog.service.facade;

import java.util.List;

import org.myblog.base.BaseDao;
import org.myblog.model.ResourceVO;
import org.myblog.model.RoleVO;

/**
 * @ClassName: ResourceServcie
 * @Description: TODO
 * @author bobmeek
 * @date Jan 23, 2015 9:16:04 PM
 */
public interface ResourceService extends BaseDao<ResourceVO,Integer>
{
	public List<ResourceVO> findResources(); 
	
	public List<ResourceVO> findByName(String username);
	
	public void deleteRoleRelation(int id);
}
