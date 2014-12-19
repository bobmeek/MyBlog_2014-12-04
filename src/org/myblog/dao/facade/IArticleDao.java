/**  
 * @Title: IArticleDao.java
 * @Package org.myblog.dao.facade
 * @Description: TODO
 * @author bobmeek
 * @date Dec 18, 2014 11:33:22 AM
 * @version V1.0  
 */
package org.myblog.dao.facade;

import java.util.List;

import org.myblog.model.ArticleVO;

/**
 * @ClassName: IArticleDao
 * @Description: TODO
 * @author bobmeek
 * @date Dec 18, 2014 11:33:22 AM
 */
public interface IArticleDao
{
	
	/**获取所有文章**/
	public List<ArticleVO> list();
	
	public void insert(ArticleVO a);
	public void update(ArticleVO a);
	public void deleteById(ArticleVO a);
	
}
