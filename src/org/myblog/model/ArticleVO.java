/**  
 * @Title: Article.java
 * @Package org.myblog.model
 * @Description: TODO
 * @author bobmeek
 * @date Dec 18, 2014 11:28:41 AM
 * @version V1.0  
 */
package org.myblog.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ClassName: Article
 * @Description: 文章
 * @author bobmeek
 * @date Dec 18, 2014 11:28:41 AM
 */
public class ArticleVO implements Serializable
{
	/**
	  * @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;

	private int id;
	
	private int categoryId;
	
	private String title;
	
	private String content;
	
	private String author;
	
	private Timestamp time;
	
	private int readCount;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	
	
	public int getCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
	}

	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	
	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public Timestamp getTime()
	{
		return time;
	}

	public void setTime(Timestamp time)
	{
		this.time = time;
	}

	public int getReadCount()
	{
		return readCount;
	}

	public void setReadCount(int readCount)
	{
		this.readCount = readCount;
	}
	
	
	
}
