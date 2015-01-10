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
import org.myblog.model.UserExtVO;
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

	
	public int emailIsExist(String email) 
	{
		String operate = ".emailIsExist";
		
		Map<String, Object> maps = new HashMap<String, Object>();
		
		// warning：Map中的username要和mapper中的username必须一致
		maps.put("email", email);
		
		return isExist(maps, operate);
	}
	
	public void saveUser(UserVO user)
	{
		save(user); // 保存用户信息
	}
	
	public UserVO findByMail(String email)
	{
		String operate = ".findByMail";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("email", email);
		return findByParam(maps, operate);
	}
	 
	
	public UserVO findByUsername(String username)
	{
		String operate = ".findByUsername";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("username", username);
		return findByParam(maps, operate);
	}
	
	
	public int nameLogin(String username,String userpwd)
	{
		String operate = ".nameLogin";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("username", username);
		maps.put("userpwd", userpwd);
		return login(maps,operate);
	}
	
	public int emailLogin(String email,String userpwd)
	{
		String operate = ".emailLogin";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("email", email);
		maps.put("userpwd", userpwd);
		return login(maps,operate);
	}
	
}
