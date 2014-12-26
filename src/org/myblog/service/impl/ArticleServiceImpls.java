/**  
 * @Title: IArticleServiceImpls.java
 * @Package IArticleService
 * @Description: TODO
 * @author bobmeek
 * @date Dec 18, 2014 11:46:40 AM
 * @version V1.0  
 */
package org.myblog.service.impl;

import org.myblog.base.AbstractBaseDao;
import org.myblog.model.ArticleVO;
import org.myblog.service.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpls extends AbstractBaseDao<ArticleVO, Integer>  implements ArticleService
{
	
}