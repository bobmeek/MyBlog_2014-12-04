/**  
 * @Title: IArticleDaoImpls.java
 * @Package org.myblog.dao.impls
 * @Description: TODO
 * @author bobmeek
 * @date Dec 18, 2014 11:41:26 AM
 * @version V1.0  
 */
package org.myblog.dao.impls;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.myblog.dao.facade.IArticleDao;
import org.myblog.model.ArticleVO;
import org.myblog.model.CategoryVO;

/**
 * @ClassName: IArticleDaoImpls
 * @Description: TODO
 * @author bobmeek
 * @date Dec 18, 2014 11:41:26 AM
 */
public class ArticleDaoImpls extends SqlSessionDaoSupport implements IArticleDao
{

	@Override
	public List<ArticleVO> list()
	{
		List<ArticleVO> list = this.getSqlSession().selectList("org.myblog.dao.facade.IArticleDao.getAllArticles");
		return list;
	}

	@Override
	public void insert(ArticleVO a)
	{
		
	}

	@Override
	public void update(ArticleVO a)
	{
		
	}

	@Override
	public void deleteById(ArticleVO a)
	{
		
	}

}
