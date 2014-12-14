/**  
 * @Title: CategoryDaoImpls.java
 * @Package org.myblog.dao.impls
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 9:44:58 PM
 * @version V1.0  
 */
package org.myblog.dao.impls;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.myblog.dao.facade.ICategoryDao;
import org.myblog.model.CategoryVO;


/**
 * @ClassName: CategoryDaoImpls
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 9:44:58 PM
 */
public class CategoryDaoImpls extends SqlSessionDaoSupport implements ICategoryDao
{
	
	@Override
	public CategoryVO get(String id)
	{
		return null;
	}
	
	@Override
	public List<CategoryVO> list()
	{
		
		//引号里面的内容是CategoryMapper.xml文件中mapper定义的namespace
		List<CategoryVO> list = this.getSqlSession().selectList("org.myblog.dao.facade.ICategoryDao.getAllCategories");
		return list;
	}

	

	@Override
	public int insert(CategoryVO c)
	{
		return 0;
	}

	@Override
	public int update(CategoryVO c)
	{
		return 0;
	}

	@Override
	public int deleteById(String id)
	{
		return 0;
	}

}
