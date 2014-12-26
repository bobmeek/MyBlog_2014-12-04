/**  
 * @Title: IUsersDao.java
 * @Package org.myblog.dao.facade
 * @Description: TODO
 * @author bobmeek
 * @date Dec 24, 2014 7:49:47 PM
 * @version V1.0  
 */
package org.myblog.dao.facade;

import java.util.List;

import org.myblog.model.UsersVO;

/**
 * @ClassName: IUsersDao
 * @Description: TODO
 * @author bobmeek
 * @date Dec 24, 2014 7:49:47 PM
 */
public interface IUsersDao
{

	/**获取所有用户**/
	public List<UsersVO> list();
	
	public void insert(UsersVO u);
	public void update(UsersVO u);
	public void deleteById(UsersVO u);
	
	
	
	
}
