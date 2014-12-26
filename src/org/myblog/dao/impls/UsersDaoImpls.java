/**  
 * @Title: UsersDaoImpls.java
 * @Package org.myblog.dao.impls
 * @Description: TODO
 * @author bobmeek
 * @date Dec 24, 2014 7:50:52 PM
 * @version V1.0  
 */
package org.myblog.dao.impls;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.myblog.dao.facade.IUsersDao;
import org.myblog.model.UsersVO;

/**
 * @ClassName: UsersDaoImpls
 * @Description: TODO
 * @author bobmeek
 * @date Dec 24, 2014 7:50:52 PM
 */
public class UsersDaoImpls extends SqlSessionDaoSupport implements IUsersDao
{

	@Override
	public List<UsersVO> list()
	{
		
		return this.getSqlSession().selectList("org.myblog.dao.facade.IUsersDao.getUsersAll");
	}

	@Override
	public void insert(UsersVO u)
	{
		
		this.getSqlSession().insert("org.myblog.dao.facade.IUsersDao.addUser",u);
	}

	@Override
	public void update(UsersVO u)
	{
		
	}

	@Override
	public void deleteById(UsersVO u)
	{
		
	}
	
}
