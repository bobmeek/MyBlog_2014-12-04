package org.myblog.service.facade;

import java.util.List;

import org.myblog.base.BaseDao;
import org.myblog.model.CategoryVO;

public interface CategoryService extends BaseDao<CategoryVO, Integer>
{
	/**
	 * 保存栏目对象
	 * @param category
	 */
	public void addCategory(CategoryVO category);
	
	/**
	 * 添加栏目
	 * pid为空表示父栏目，否则为子栏目
	 * @param category
	 * @param pid
	 */
	public void addCategory2(CategoryVO category, Integer pid);
	
	public List<CategoryVO> findArticleByCategoryId(int id);
}