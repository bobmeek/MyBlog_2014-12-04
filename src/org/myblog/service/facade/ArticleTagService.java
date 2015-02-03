package org.myblog.service.facade;

import org.myblog.base.BaseDao;
import org.myblog.model.ArticleTagVO;

public interface ArticleTagService extends BaseDao<ArticleTagVO, Integer>
{
	/**
	 * 保存文章标签对象
	 * @param articleTag
	 */
	public void addArticleTag(ArticleTagVO articleTag);
}