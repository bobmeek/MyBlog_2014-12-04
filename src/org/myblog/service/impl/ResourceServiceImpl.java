/**  
 * @Title: ResourceImpl.java
 * @Package org.myblog.service.impl
 * @Description: TODO
 * @author bobmeek
 * @date Jan 23, 2015 9:17:55 PM
 * @version V1.0  
 */
package org.myblog.service.impl;

import java.util.List;
import java.util.Map;

import org.myblog.base.AbstractBaseDao;
import org.myblog.common.Pager;
import org.myblog.model.ResourceVO;
import org.myblog.service.facade.ResourceServcie;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ResourceImpl
 * @Description: TODO
 * @author bobmeek
 * @date Jan 23, 2015 9:17:55 PM
 */
@Service
public class ResourceServiceImpl extends AbstractBaseDao<ResourceVO, Integer> implements ResourceServcie
{

	@Override
	public List<ResourceVO> findResources()
	{
		
		return null;
	}

}
