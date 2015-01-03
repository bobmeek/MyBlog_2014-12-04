/**  
 * @Title: UserServiceImpl.java
 * @Package org.myblog.service.impl
 * @Description: TODO
 * @author bobmeek
 * @date Dec 27, 2014 3:54:53 PM
 * @version V1.0  
 */
package org.myblog.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.myblog.base.AbstractBaseDao;
import org.myblog.model.UserVO;
import org.myblog.service.facade.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @author bobmeek
 * @date Dec 27, 2014 3:54:53 PM
 */
@Service
public class UserServiceImpl extends AbstractBaseDao<UserVO, Integer> implements UserService
{

	public int nameIsExist(String name) 
	{
		String operate = ".nameIsExist";
		
		Map<String, Object> maps = new HashMap<String, Object>();
		
		// warning：Map中的username要和mapper中的username必须一致
		maps.put("username", name);
		
		return isExist(maps, operate);
	}

	
	public int mailIsExist(String mail) 
	{
		String operate = ".mailIsExist";
		
		Map<String, Object> maps = new HashMap<String, Object>();
		
		// warning：Map中的username要和mapper中的username必须一致
		maps.put("mail", mail);
		
		return isExist(maps, operate);
	}
	
	public void saveUser(UserVO user)
	{
		save(user); // 保存用户信息
	}
	
	public UserVO findByMail(String mail)
	{
		String operate = ".findByMail";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("mail", mail);
		return findByParam(maps, operate);
	}
	
}
