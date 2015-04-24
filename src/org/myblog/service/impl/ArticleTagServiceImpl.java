package org.myblog.service.impl;

import java.util.List;

import org.myblog.base.AbstractBaseDao;
import org.myblog.model.ArticleTagVO;
import org.myblog.service.facade.ArticleTagService;
import org.springframework.stereotype.Service;

@Service
public class ArticleTagServiceImpl extends AbstractBaseDao<ArticleTagVO, Integer> implements ArticleTagService 
{
	@Override
	public void addArticleTag(ArticleTagVO articleTag) 
	{
		save(articleTag);
	}
}