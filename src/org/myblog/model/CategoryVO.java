/**  
 * @Title: CategoryVO.java
 * @Package org.myblog.model
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 9:35:40 PM
 * @version V1.0  
 */
package org.myblog.model;

import java.io.Serializable;

/**
 * @ClassName: CategoryVO
 * @Description: 栏目
 * @author bobmeek
 * @date Dec 4, 2014 9:35:40 PM
 */
public class CategoryVO implements Serializable
{
	
	/**
	  * @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private String desc;
	
	public CategoryVO()
	{
		super();
	}

	
	public CategoryVO(String name, String desc)
	{
		super();
		this.name = name;
		this.desc = desc;
	}





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