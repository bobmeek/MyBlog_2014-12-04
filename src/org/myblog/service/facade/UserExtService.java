/**  
 * @Title: UserExtService.java
 * @Package org.myblog.service.facade
 * @Description: TODO
 * @author bobmeek
 * @date Jan 10, 2015 6:40:28 PM
 * @version V1.0  
 */
package org.myblog.service.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myblog.base.BaseDao;
import org.myblog.model.UserExtVO;

/**
 * @ClassName: UserExtService
 * @Description: TODO
 * @author bobmeek
 * @date Jan 10, 2015 6:40:28 PM
 */

public interface UserExtService extends BaseDao<UserExtVO, Integer>
{
	/**根据ID查找该用户详细信息**/
	public UserExtVO findExtById(Integer id);
	
	 
	
	/**批量删除用户**/
	public void deleteBatch(List<Integer> ids);
}
