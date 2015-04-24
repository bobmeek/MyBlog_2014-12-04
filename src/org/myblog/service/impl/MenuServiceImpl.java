package org.myblog.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.myblog.base.AbstractBaseDao;
import org.myblog.base.BaseDao;
import org.myblog.model.MenuVO;
import org.myblog.service.facade.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends AbstractBaseDao<MenuVO, Integer> implements MenuService{

	public int findMaxOrders(int parentId){
		String operate = ".findMaxOrders";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("parentId", parentId);
		return findMaxParam(maps, operate);
	}
	
}

