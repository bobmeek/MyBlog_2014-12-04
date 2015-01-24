/**  
 * @Title: Role.java
 * @Package org.myblog.model
 * @Description: TODO
 * @author bobmeek
 * @date Jan 21, 2015 2:45:06 PM
 * @version V1.0  
 */
package org.myblog.model;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: Role
 * @Description: 角色实体类
 * @author bobmeek
 * @date Jan 21, 2015 2:45:06 PM
 */
public class RoleVO implements Serializable
{
	/**
	  * @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String role;
	
	private String desc;
	
	private List<ResourceVO> listResource;

	public RoleVO()
	{
	}

	public RoleVO(Integer id, String role, String desc, List<ResourceVO> listResource)
	{
		this.id = id;
		this.role = role;
		this.desc = desc;
		this.listResource = listResource;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public List<ResourceVO> getListResource()
	{
		return listResource;
	}

	public void setListResource(List<ResourceVO> listResource)
	{
		this.listResource = listResource;
	}

	@Override
	public String toString()
	{
		return "RoleVO [id=" + id + ", role=" + role + ", desc=" + desc +", listResource=" + listResource + "]";
	}

	
	
	
	
	
	
}
