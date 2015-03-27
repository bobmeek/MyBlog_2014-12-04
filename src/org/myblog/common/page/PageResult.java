/**  
 * @Title: PageResult.java
 * @Package com.omnific.util.page
 * @Description: TODO
 * @author A18ccms A18ccms_gmail_com  
 * @date 2013-11-17 ����5:58:53
 * @version V1.0  
 */
package org.myblog.common.page;

import java.util.List;

/**
 * @ClassName: PageResult
 * @Description: ��ҳ�����(����ҳ������,���ڷ���)
 * @author XIAyuzheng521
 * @date 2013-11-17 ����5:58:53
 */
public class PageResult
{
	
	/**
	 * ��ҳ��Ϣ
	 */
	private Page page;
	
	/**
	 * ÿҳ��ʾ����
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
	 * <p>Description:���캯�� </p>
	 * @param page ��ҳ��Ϣ
	 * @param content ÿҳ��ʾ����
	 */
	public PageResult(Page page,List content)
	{
		this.page = page;
		this.content = content;
	}
	
}
