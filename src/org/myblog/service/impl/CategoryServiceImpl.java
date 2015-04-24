package org.myblog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myblog.base.AbstractBaseDao;
import org.myblog.model.CategoryVO;
import org.myblog.model.UserVO;
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
			category.setParentId(pid);
		}
		save(category);
	}

	@Override
	public List<CategoryVO> findArticleByCategoryId(int id) 
	{
		return findListById(id);
	}
	
	public List<CategoryVO> findNavigate(Integer type){
		String operate = ".findByType";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("type", type);
		return findListByParam(maps, operate);
	}
	public Integer findMaxOrders(Integer type){
		String operate = ".findMaxOrders";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("type", type);
		return findMaxParam(maps, operate);
	}

}