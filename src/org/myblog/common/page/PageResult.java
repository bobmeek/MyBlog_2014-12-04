/**  
 * @Title: PageResult.java
 * @Package com.omnific.util.page
 * @Description: TODO
 * @author A18ccms A18ccms_gmail_com  
 * @date 2013-11-17 下午5:58:53
 * @version V1.0  
 */
package org.myblog.common.page;

import java.util.List;

/**
 * @ClassName: PageResult
 * @Description: 分页结果集(将分页结果打包,便于访问)
 * @author XIAyuzheng521
 * @date 2013-11-17 下午5:58:53
 */
public class PageResult
{
	
	/**
	 * 分页信息
	 */
	private Page page;
	
	/**
	 * 每页显示集合
	 */
	private List content;
	
	
	
	
	
	public Page getPage()
	{
		return page;
	}

	public void setPage(Page page)
	{
		this.page = page;
	}

	public List getContent()
	{
		return content;
	}

	public void setContent(List content)
	{
		this.content = content;
	}

	public PageResult(){}
	
	/**
	 * <p>Description:构造函数 </p>
	 * @param page 分页信息
	 * @param content 每页显示集合
	 */
	public PageResult(Page page,List content)
	{
		this.page = page;
		this.content = content;
	}
	
}
