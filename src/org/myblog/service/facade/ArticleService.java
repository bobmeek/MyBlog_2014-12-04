package org.myblog.service.facade;

import java.util.List;
import org.myblog.base.BaseDao;
import org.myblog.model.ArticleVO;

public interface ArticleService extends BaseDao<ArticleVO, Integer>
{
	/**
	 * 条件查询文章
	 */
	public List<ArticleVO> searchArticles(String keyword);
	
	public List<ArticleVO> findListByMenuId(Integer menuId);
	
	/**
	 * 批量删除文章
	 */
	public void bulk_delete(List<Integer> id);
	
	/**
	 * 批量删除文章标签
	 */
	public void bulk_delete2(List<Integer> id);
	
	/**
	 * 保存文章对象
	 */
	public void addArticle(ArticleVO article);
}