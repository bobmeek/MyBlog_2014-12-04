/**  
 * @Title: CategoryServiceImpls.java
 * @Package org.myblog.service.impls
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 9:47:48 PM
 * @version V1.0  
 */
package org.myblog.service.impls;

import java.util.List;

import org.myblog.dao.facade.ICategoryDao;
import org.myblog.model.CategoryVO;
import org.myblog.service.facade.ICategoryService;

/**
 * @ClassName: CategoryServiceImpls
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 9:47:48 PM
 */
public class CategoryServiceImpls implements ICategoryService
{

	private ICategoryDao categoryDao = null;
	
	
	@Override
	public List<CategoryVO> getAllCategories()
	{
		List<CategoryVO> allCategoryVOs = categoryDao.list();
		return allCategoryVOs;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/**=============================================注入==================================================**/
	
	/**
	 * @return the categoryDao
	 */
	public ICategoryDao getCategoryDao()
	{
		return categoryDao;
	}
	/**
	 * @param categoryDao the categoryDao to set
	 */
	public void setCategoryDao(ICategoryDao categoryDao)
	{
		this.categoryDao = categoryDao;
	}
}
