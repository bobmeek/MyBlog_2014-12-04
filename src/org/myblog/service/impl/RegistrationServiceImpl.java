package org.myblog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myblog.base.AbstractBaseDao;
import org.myblog.model.RegistrationVO;
import org.myblog.service.facade.RegistrationService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl extends AbstractBaseDao<RegistrationVO, Integer> implements RegistrationService{
	
	public void deleteBatch(List<Integer> ids){
		String operate = ".deleteBatch";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("ids", ids);
		delete(maps, operate);
	}
}
