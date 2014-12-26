/**  
 * @Title: UsersServiceImpls.java
 * @Package org.myblog.service.impls
 * @Description: TODO
 * @author bobmeek
 * @date Dec 24, 2014 7:55:00 PM
 * @version V1.0  
 */
package org.myblog.service.impls;

import java.util.List;

import org.myblog.dao.facade.IUsersDao;
import org.myblog.model.UsersVO;
import org.myblog.service.facade.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: UsersServiceImpls
 * @Description: TODO
 * @author bobmeek
 * @date Dec 24, 2014 7:55:00 PM
 */
public class UsersServiceImpls implements IUsersService
{

	@Autowired
	private IUsersDao usersDao;
	@Override
	public List<UsersVO> getAllUsers()
	{
		List<UsersVO> users = usersDao.list();
		return users;
	}

	@Override
	public void addUser(UsersVO u)
	{
		usersDao.insert(u);
	}
	
	
	
	
	
	
	public IUsersDao getUsersDao()
	{
		return usersDao;
	}
	public void setUsersDao(IUsersDao usersDao)
	{
		this.usersDao = usersDao;
	}
	
}
