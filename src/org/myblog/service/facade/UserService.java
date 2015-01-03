/**  
 * @Title: UserService.java
 * @Package org.myblog.service.facade
 * @Description: TODO
 * @author bobmeek
 * @date Dec 27, 2014 3:52:58 PM
 * @version V1.0  
 */
package org.myblog.service.facade;

import org.myblog.base.BaseDao;
import org.myblog.model.UserVO;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @author bobmeek
 * @date Dec 27, 2014 3:52:58 PM
 */
public interface UserService extends BaseDao<UserVO, Integer>
{
	/**判断名字是否存在**/
	public int nameIsExist(String name);
	
	/**判断邮箱是否存在**/
	public int mailIsExist(String mail);
	
	/**添加用户**/
	public void saveUser(UserVO user);
	
	/**根据邮箱查找用户**/
	public UserVO findByMail(String mail);
}
