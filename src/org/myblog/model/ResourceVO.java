/**  
 * @Title: PermissionVO.java
 * @Package org.myblog.model
 * @Description: TODO
 * @author bobmeek
 * @date Jan 21, 2015 2:47:38 PM
 * @version V1.0  
 */
package org.myblog.model;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: PermissionVO
 * @Description: 权限实体类
 * @author bobmeek
 * @date Jan 21, 2015 2:47:38 PM
 */
public class ResourceVO implements Serializable
{

	/**
	  * @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer parentId;
	
	//方便后面排序:数据库SQL语句concat(parent_id,id)
	private String parentIds;
	
	private String name;
	
	private String permission;
	
	private String type;
	
	private String url;

	public ResourceVO()
	{
	}

	public ResourceVO(Integer id, Integer parentId, String parentIds, String name, String permission, String type, String url)
	{
		super();
		this.id = id;
		this.parentId = parentId;
		this.parentIds = parentIds;
		this.name = name;
		this.permission = permission;
		this.type = type;
		this.url = url;
	}

    public boolean isRootNode() {
        return parentId == 0;
    }

    public String makeSelfAsParentIds() {
        return getParentIds() + getId() + "/";
    }
    
    
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getParentId()
	{
		return parentId;
	}

	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}

	public String getParentIds()
	{
		return parentIds;
	}

	public void setParentIds(String parentIds)
	{
		this.parentIds = parentIds;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPermission()
	{
		return permission;
	}

	public void setPermission(String permission)
	{
		this.permission = permission;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	@Override
	public String toString()
	{
		return "PermissionVO [id=" + id + ", parentId=" + parentId + ", parentIds=" + parentIds + ", name=" + name + ", permission=" + permission + ", type=" + type + ", url=" + url + "]";
	}
	
	
	

}
