package org.myblog.common.page;

/**
 * @ClassName: PageUtil
 * @Description: 处理分页相关计算
 * @author XIAyuzheng521
 * @date 2013-11-17 下午6:09:41
 */
public class PageUtil
{

	/**
	 * @author XIAyuzheng521
	 * @Title creatPage
	 * @Description: 创建分页
	 * @param @param page
	 * @param @param totalCount
	 * @param @return    设定文件
	 * @return Page    返回类型
	 * @throws
	 */
	public static Page creatPage(Page page,int totalCount)
	{
		return createPage(page.getPageCount(), page.getCurrentPage(), page.getTotalCount());
	}
	
	/**
	 * 
	 * @desc   [  ]
	 * @param  [ @param pageCount 每页显示的条数
	 * @param  [ @param currentPage 当前页
	 * @param  [ @param totalCount 总条数
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月26日 下午3:00:52 ] 
	 *
	 */
	public static Page createPage(int pageCount, int currentPage, int totalCount)
	{
		
		//获得每页显示条数
		pageCount = getPageCount(pageCount);
		
		//获取当前页
		currentPage = getCurrentPage(currentPage);
		
		//获得总页数
		int totalPage = getTotalPage(pageCount, totalCount);
		
		//从哪条开始
		int beginIndex = getBeginIndex(pageCount, currentPage);
		
		//是否有上一页
		boolean hasPrePage = getHasPrePage(currentPage);
		
		//是否有下一页
		boolean hasNextPage = getHasNextPage(currentPage, totalPage);
		
		return new Page(totalCount,totalPage,pageCount,currentPage,beginIndex, hasPrePage, hasNextPage);
		
		
	}
	
	/**
	 * @author XIAyuzheng521
	 * @Title getPageCount
	 * @Description: 每页显示条数
	 * @param @param pageCount
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public static int getPageCount(int pageCount)
	{
		return pageCount == 0 ? 10 : pageCount;
	}
	
	/**
	 * @author XIAyuzheng521
	 * @Title getCurrentPage
	 * @Description: 设置当前页
	 * @param @param currentPage
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public static int getCurrentPage(int currentPage)
	{
		return currentPage == 0 ? 1 : currentPage;
	}
	
	/**
	 * @author XIAyuzheng521
	 * @Title getBeginIndex
	 * @Description: 从第几条开始
	 * @param @param pageCount 每页显示条数
	 * @param @param currentPage 当前页
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public static int getBeginIndex(int pageCount,int currentPage)
	{
		return pageCount*(currentPage - 1);
	}
	
	/**
	 * @author XIAyuzheng521
	 * @Title getTotalPage
	 * @Description: 获得总页数
	 * @param @param pageCount 每页显示条数
	 * @param @param totalCount 总记录数
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public static int getTotalPage(int pageCount,int totalCount)
	{
		
		if(totalCount % pageCount == 0)
			return totalCount/pageCount;
		
		return (totalCount/pageCount)+1;
	}
	
	/**
	 * @author XIAyuzheng521
	 * @Title getHasPrePage
	 * @Description: 是否有上一页
	 * @param @param currentPage 当前页
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	public static boolean getHasPrePage(int currentPage)
	{
		return currentPage == 1 ? false : true;  
	}
	
	/**
	 * @author XIAyuzheng521
	 * @Title getHasNextPage
	 * @Description: 是否有下一页
	 * @param @param currentPage
	 * @param @param totalPage
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	public static boolean getHasNextPage(int currentPage,int totalPage)
	{
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}
}
