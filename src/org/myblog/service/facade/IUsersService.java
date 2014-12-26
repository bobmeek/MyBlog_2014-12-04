/**  
 * @Title: IUsersService.java
 * @Package org.myblog.service.facade
 * @Description: TODO
 * @author bobmeek
 * @date Dec 24, 2014 7:52:26 PM
 * @version V1.0  
 */
package org.myblog.service.facade;

import java.util.List;

import org.myblog.model.UsersVO;

/**
 * @ClassName: IUsersService
 * @Description: TODO
 * @author bobmeek
 * @date Dec 24, 2014 7:52:26 PM
 */
public interface IUsersService
{
	/**获取所有用户**/
	public List<UsersVO> getAllUsers();
	
	/**添加用户**/
	public void addUser(UsersVO u);
	

	
	
}
