/**  
 * @Title: ICategoryDao.java
 * @Package org.myblog.dao.facade
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 9:36:55 PM
 * @version V1.0  
 */
package org.myblog.dao.facade;

import java.util.List;

import org.myblog.model.CategoryVO;

/**
 * @ClassName: ICategoryDao
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 9:36:55 PM
 */
public interface ICategoryDao
{
	
	public CategoryVO get(String id);
	
	/**查询所有分类别**/
	public List<CategoryVO> list();
	
	public int insert(CategoryVO c);
	
	public int update(CategoryVO c);
	
	public int deleteById(String id);
	
	
}
