package org.myblog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myblog.base.AbstractBaseDao;
import org.myblog.model.ArticleVO;
import org.myblog.service.facade.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends AbstractBaseDao<ArticleVO, Integer>  implements ArticleService
{
	@Override
	public List<ArticleVO> searchArticles(String keyword) 
	{
		String operate = ".searchArticleByTitle";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", keyword);
		
		return findByParam1(map, operate);
	}
	
	
	public List<ArticleVO> findListByMenuId(Integer menuId){
		String operate = ".findListByMenuId";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("menuId", menuId);
		return findListByParam(map, operate);
	}
	
	@Override
	public void bulk_delete(List<Integer> id) 
	{
		bulk_delte(id);
	}
	
	@Override
	public void bulk_delete2(List<Integer> id) 
	{
		bulk_delte2(id);
	}

	@Override
	public void addArticle(ArticleVO article) 
	{
		save(article);
	}
}