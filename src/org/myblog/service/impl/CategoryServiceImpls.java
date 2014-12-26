/**  
 * @Title: CategoryServiceImpls.java
 * @Package org.myblog.service.impls
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 9:47:48 PM
 * @version V1.0  
 */
package org.myblog.service.impl;

import org.myblog.base.AbstractBaseDao;
import org.myblog.model.CategoryVO;
import org.myblog.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpls extends AbstractBaseDao<CategoryVO, Integer> implements CategoryService
{
	
}