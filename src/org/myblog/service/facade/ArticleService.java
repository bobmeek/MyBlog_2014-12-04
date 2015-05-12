package org.myblog.service.facade;

import java.util.List;
import org.myblog.base.BaseDao;
import org.myblog.common.Pager;
import org.myblog.model.ArticleVO;

public interface ArticleService extends BaseDao<ArticleVO, Integer>
{
	/**
	 * 条件查询文章
	 */
	public List<ArticleVO> searchArticles(String keyword);
	
	/**根据某一菜单找对应的文章**/
	public List<ArticleVO> findListByMenuId(int menuId);
	
	/**根据某一菜单找对应文章并分页**/
	public Pager<ArticleVO> findPageByMenuId(int menuId,int startIndex,int pageCount);
	
	/**根据某一菜单找该菜单下文章的数据**/
	public int getTotalNumByMenuId(int menuId);
	
	
	
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