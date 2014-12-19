/**  
 * @Title: IArticleService.java
 * @Package org.myblog.service.facade
 * @Description: TODO
 * @author bobmeek
 * @date Dec 18, 2014 11:45:53 AM
 * @version V1.0  
 */
package org.myblog.service.facade;

import java.util.List;

import org.myblog.model.ArticleVO;

/**
 * @ClassName: IArticleService
 * @Description: TODO
 * @author bobmeek
 * @date Dec 18, 2014 11:45:53 AM
 */
public interface IArticleService
{
	public List<ArticleVO> getAllArticles();
}
