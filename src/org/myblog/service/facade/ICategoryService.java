/**  
 * @Title: ICategoryService.java
 * @Package org.myblog.service.facade
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 9:46:53 PM
 * @version V1.0  
 */
package org.myblog.service.facade;

import java.util.List;

import org.myblog.model.CategoryVO;

/**
 * @ClassName: ICategoryService
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 9:46:53 PM
 */
public interface ICategoryService
{
	
	public List<CategoryVO> getAllCategories();
	
	
}
