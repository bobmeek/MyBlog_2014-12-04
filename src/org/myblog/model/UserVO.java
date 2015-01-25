/**  
 * @Title: UsersVO.java
 * @Package org.myblog.model
 * @Description: TODO
 * @author bobmeek
 * @date Dec 24, 2014 7:43:47 PM
 * @version V1.0  
 */
package org.myblog.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.myblog.common.CustomDateSerializer;


/**
 * @ClassName: UsersVO
 * @Description: 用户类
 * @author bobmeek
 * @date Dec 24, 2014 7:43:47 PM
 */
public class UserVO implements Serializable
{
	/**
	  * @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String username;
	
	private String userpwd;
	
	private String salt;
	
	private String email;
	
	
	private Timestamp registerTime;
	
	private String registerIP;
	
	private Timestamp lastLoginTime;
	
	private String lastLoginIP;
	
	private Integer isDisabled;
	
	private Integer isEmailActive;
	
	private Integer uid;
	
	private List<RoleVO> listRole;
	
	

	public UserVO()
	{
		super();
	}



	public UserVO(Integer id, String username, String userpwd, String salt, String email, Timestamp registerTime, String registerIP, Timestamp lastLoginTime, String lastLoginIP, Integer isDisabled,
			Integer isEmailActive, Integer uid, List<RoleVO> listRole)
	{
		super();
		this.id = id;
		this.username = username;
		this.userpwd = userpwd;
		this.salt = salt;
		this.email = email;
		this.registerTime = registerTime;
		this.registerIP = registerIP;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIP = lastLoginIP;
		this.isDisabled = isDisabled;
		this.isEmailActive = isEmailActive;
		this.uid = uid;
		this.listRole = listRole;
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



	public String getSalt()
	{
		return salt;
	}



	public void setSalt(String salt)
	{
		this.salt = salt;
	}


	public String getCredentialsSalt() {
        return username + salt;
    }

	public String getEmail()
	{
		return email;
	}



	public void setEmail(String email)
	{
		this.email = email;
	}



	public Timestamp getRegisterTime()
	{
		return registerTime;
	}



	public void setRegisterTime(Timestamp registerTime)
	{
		this.registerTime = registerTime;
	}



	public String getRegisterIP()
	{
		return registerIP;
	}



	public void setRegisterIP(String registerIP)
	{
		this.registerIP = registerIP;
	}



	public Timestamp getLastLoginTime()
	{
		return lastLoginTime;
	}



	public void setLastLoginTime(Timestamp lastLoginTime)
	{
		this.lastLoginTime = lastLoginTime;
	}



	public String getLastLoginIP()
	{
		return lastLoginIP;
	}



	public void setLastLoginIP(String lastLoginIP)
	{
		this.lastLoginIP = lastLoginIP;
	}



	public Integer getIsDisabled()
	{
		return isDisabled;
	}



	public void setIsDisabled(Integer isDisabled)
	{
		this.isDisabled = isDisabled;
	}



	public Integer getIsEmailActive()
	{
		return isEmailActive;
	}



	public void setIsEmailActive(Integer isEmailActive)
	{
		this.isEmailActive = isEmailActive;
	}



	public Integer getUid()
	{
		return uid;
	}



	public void setUid(Integer uid)
	{
		this.uid = uid;
	}



	public List<RoleVO> getListRole()
	{
		return listRole;
	}



	public void setListRole(List<RoleVO> listRole)
	{
		this.listRole = listRole;
	}



	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}



	@Override
	public String toString()
	{
		return "UserVO [id=" + id + ", username=" + username + ", userpwd=" + userpwd + ", salt=" + salt + ", email=" + email + ", registerTime=" + registerTime + ", registerIP=" + registerIP
				+ ", lastLoginTime=" + lastLoginTime + ", lastLoginIP=" + lastLoginIP + ", isDisabled=" + isDisabled + ", isEmailActive=" + isEmailActive + ", uid=" + uid + ", listRole=" + listRole
				+ "]";
	}

	
	
	

}
