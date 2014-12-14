/**  
 * @Title: CategoryVO.java
 * @Package org.myblog.model
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 9:35:40 PM
 * @version V1.0  
 */
package org.myblog.model;

/**
 * @ClassName: CategoryVO
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 9:35:40 PM
 */
public class CategoryVO
{
	
	private int id;
	
	private String name;
	
	private String desc;

	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	
	
	
	
}