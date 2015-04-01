package org.myblog.common.page;

/**
 * 
 * @ClassName: Page
 * @Description: ��ҳ������
 * @author XIAyuzheng521
 * @date 2013-11-17 ����5:41:12
 */
public class Page
{

	/**
	 * �ܼ�¼��
	 */
	private int totalCount;
	
	/**
	 * ��ҳ��
	 */
	private int totalPage;
	
	/**
	 * ÿҳ��ʾ����
	 */
	private int pageCount;
	
	/**
	 * ��ǰҳ
	 */
	private int currentPage;
	
	/**
	 * ��ʼ��
	 */
	private int srartIndex;
	
	/**
	 * �Ƿ�����һҳ
	 */
	private boolean hasPrePage;
	
	/**
	 * �Ƿ�����һҳ
	 */
	private boolean hasNextPage;

	public int getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}

	public int getTotalPage()
	{
		return totalPage;
	}

	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}

	public int getPageCount()
	{
		return pageCount;
	}

	public void setPageCount(int pageCount)
	{
		this.pageCount = pageCount;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getSrartIndex()
	{
		return srartIndex;
	}

	public void setSrartIndex(int srartIndex)
	{
		this.srartIndex = srartIndex;
	}


	public boolean isHasPrePage()
	{
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage)
	{
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage()
	{
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage)
	{
		this.hasNextPage = hasNextPage;
	}

	
	/**
	 * <p>Title: </p>
	 * <p>Description: �޲ι���</p>
	 */
	public Page(){}
	
	/**
	 * <p>Title: </p>
	 * <p>Description: ÿҳ��ʾ����,���캯��</p>
	 * @param pageCount
	 */
	public Page(int pageCount)
	{
		this.pageCount = pageCount;
	}

	
	

	/**
	 * <p>Title: </p>
	 * <p>Description: ���๹�캯��</p>
	 * @param totalCount
	 * @param totalPage
	 * @param pageCount
	 * @param currentPage
	 * @param srartIndex
	 * @param pageName
	 * @param pageHql
	 * @param hasPrePage
	 * @param hasNextPage
	 */
	public Page(int totalCount, int totalPage, int pageCount, int currentPage,int srartIndex,boolean hasPrePage, boolean hasNextPage)
	{
		super();
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.pageCount = pageCount;
		this.currentPage = currentPage;
		this.srartIndex = srartIndex;
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
	}	
	
	
	
	
	
	
	
	
}
