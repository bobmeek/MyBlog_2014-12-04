package org.myblog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.myblog.base.AbstractBaseDao;
import org.myblog.model.TagVO;
import org.myblog.service.facade.TagService;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends AbstractBaseDao<TagVO, Integer> implements TagService 
{
	@Override
	public void addTag(TagVO tag) 
	{
		save(tag);
	}

	@Override
	public List<TagVO> findById2(Integer id) 
	{
		return findListById(id);
	}

	@Override
	public List<TagVO> searchTags(String keyword) 
	{
		String operate = ".searchTagByTagName";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tag_name", keyword);
		
		return findByParam1(map, operate);
	}

	@Override
	public void bulk_delete(List<Integer> id) 
	{
		bulk_delte(id);
	}

	@Override
	public void bulk_delete2(List<Integer> id) 
	{
		bulk_delte2(id);
	}
}