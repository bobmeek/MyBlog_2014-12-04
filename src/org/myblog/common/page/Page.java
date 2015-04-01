package org.myblog.common.page;

/**
 * 
 * @ClassName: Page
 * @Description: 分页工具类
 * @author XIAyuzheng521
 * @date 2013-11-17 下午5:41:12
 */
public class Page
{

	/**
	 * 总记录数
	 */
	private int totalCount;
	
	/**
	 * 总页数
	 */
	private int totalPage;
	
	/**
	 * 每页显示条数
	 */
	private int pageCount;
	
	/**
	 * 当前页
	 */
	private int currentPage;
	
	/**
	 * 起始点
	 */
	private int srartIndex;
	
	/**
	 * 是否有上一页
	 */
	private boolean hasPrePage;
	
	/**
	 * 是否有下一页
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
	 * <p>Description: 无参构造</p>
	 */
	public Page(){}
	
	/**
	 * <p>Title: </p>
	 * <p>Description: 每页显示条数,构造函数</p>
	 * @param pageCount
	 */
	public Page(int pageCount)
	{
		this.pageCount = pageCount;
	}

	
	

	/**
	 * <p>Title: </p>
	 * <p>Description: 该类构造函数</p>
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
