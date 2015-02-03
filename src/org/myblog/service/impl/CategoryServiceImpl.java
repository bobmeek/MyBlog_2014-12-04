package org.myblog.service.impl;

import java.util.List;

import org.myblog.base.AbstractBaseDao;
import org.myblog.model.CategoryVO;
import org.myblog.service.facade.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends AbstractBaseDao<CategoryVO, Integer> implements CategoryService
{
	@Override
	public void addCategory(CategoryVO category) 
	{
		save(category);
	}

	@Override
	public void addCategory2(CategoryVO category, Integer pid) 
	{
		if(pid != null)
		{
			category.setParent_id(pid);
		}
		save(category);
	}

	@Override
	public List<CategoryVO> findArticleByCategoryId(int id) 
	{
		return findByIdList(id);
	}
}