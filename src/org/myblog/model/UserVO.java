/**  
 * @Title: UsersVO.java
 * @Package org.myblog.model
 * @Description: TODO
 * @author bobmeek
 * @date Dec 24, 2014 7:43:47 PM
 * @version V1.0  
 */
package org.myblog.model;

import java.sql.Timestamp;

/**
 * @ClassName: UsersVO
 * @Description: 用户类
 * @author bobmeek
 * @date Dec 24, 2014 7:43:47 PM
 */
public class UserVO
{
	private Integer id;
	
	private String username;
	
	private String userpwd;
	
	private String mail;
	
	private String phone;
	
	private String sex;
	
	private Timestamp birthday;
	
	
	private Integer mailActive;
	
	public Integer getMailActive()
	{
		return mailActive;
	}
	
	public void setMailActive(Integer mailActive)
	{
		this.mailActive = mailActive;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getUserpwd()
	{
		return userpwd;
	}

	public void setUserpwd(String userpwd)
	{
		this.userpwd = userpwd;
	}

	public String getMail()
	{
		return mail;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public Timestamp getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Timestamp birthday)
	{
		this.birthday = birthday;
	}
	
	
	
	
	
	
	
	
	
	

}
