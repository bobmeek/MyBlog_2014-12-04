/**  
 * @Title: IArticleServiceImpls.java
 * @Package IArticleService
 * @Description: TODO
 * @author bobmeek
 * @date Dec 18, 2014 11:46:40 AM
 * @version V1.0  
 */
package org.myblog.service.impls;

import java.util.List;

import org.myblog.dao.facade.IArticleDao;
import org.myblog.model.ArticleVO;
import org.myblog.service.facade.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: IArticleServiceImpls
 * @Description: TODO
 * @author bobmeek
 * @date Dec 18, 2014 11:46:40 AM
 */
public class ArticleServiceImpls implements IArticleService
{
	@Autowired
	private IArticleDao articleDao;

	@Override
	public List<ArticleVO> getAllArticles()
	{
		List<ArticleVO> allArticleVOs =articleDao.list();
		return allArticleVOs;
	}
	
	
	public IArticleDao getArticleDao()
	{
		return articleDao;
	}
	public void setArticleDao(IArticleDao articleDao)
	{
		this.articleDao = articleDao;
	}
}
