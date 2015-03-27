package org.myblog.common.page;

/**
 * @ClassName: PageUtil
 * @Description: �����ҳ��ؼ���
 * @author XIAyuzheng521
 * @date 2013-11-17 ����6:09:41
 */
public class PageUtil
{

	/**
	 * @author XIAyuzheng521
	 * @Title creatPage
	 * @Description: ������ҳ
	 * @param @param page
	 * @param @param totalCount
	 * @param @return    �趨�ļ�
	 * @return Page    ��������
	 * @throws
	 */
	public static Page creatPage(Page page,int totalCount)
	{
		return createPage(page.getPageCount(), page.getCurrentPage(), page.getTotalCount());
	}
	
	/**
	 * 
	 * @desc   [  ]
	 * @param  [ @param pageCount ÿҳ��ʾ������
	 * @param  [ @param currentPage ��ǰҳ
	 * @param  [ @param totalCount ������
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015��3��26�� ����3:00:52 ] 
	 *
	 */
	public static Page createPage(int pageCount, int currentPage, int totalCount)
	{
		
		//���ÿҳ��ʾ����
		pageCount = getPageCount(pageCount);
		
		//��ȡ��ǰҳ
		currentPage = getCurrentPage(currentPage);
		
		//�����ҳ��
		int totalPage = getTotalPage(pageCount, totalCount);
		
		//��������ʼ
		int beginIndex = getBeginIndex(pageCount, currentPage);
		
		//�Ƿ�����һҳ
		boolean hasPrePage = getHasPrePage(currentPage);
		
		//�Ƿ�����һҳ
		boolean hasNextPage = getHasNextPage(currentPage, totalPage);
		
		return new Page(totalCount,totalPage,pageCount,currentPage,beginIndex, hasPrePage, hasNextPage);
		
		
	}
	
	/**
	 * @author XIAyuzheng521
	 * @Title getPageCount
	 * @Description: ÿҳ��ʾ����
	 * @param @param pageCount
	 * @param @return    �趨�ļ�
	 * @return int    ��������
	 * @throws
	 */
	public static int getPageCount(int pageCount)
	{
		return pageCount == 0 ? 10 : pageCount;
	}
	
	/**
	 * @author XIAyuzheng521
	 * @Title getCurrentPage
	 * @Description: ���õ�ǰҳ
	 * @param @param currentPage
	 * @param @return    �趨�ļ�
	 * @return int    ��������
	 * @throws
	 */
	public static int getCurrentPage(int currentPage)
	{
		return currentPage == 0 ? 1 : currentPage;
	}
	
	/**
	 * @author XIAyuzheng521
	 * @Title getBeginIndex
	 * @Description: �ӵڼ�����ʼ
	 * @param @param pageCount ÿҳ��ʾ����
	 * @param @param currentPage ��ǰҳ
	 * @param @return    �趨�ļ�
	 * @return int    ��������
	 * @throws
	 */
	public static int getBeginIndex(int pageCount,int currentPage)
	{
		return pageCount*(currentPage - 1);
	}
	
	/**
	 * @author XIAyuzheng521
	 * @Title getTotalPage
	 * @Description: �����ҳ��
	 * @param @param pageCount ÿҳ��ʾ����
	 * @param @param totalCount �ܼ�¼��
	 * @param @return    �趨�ļ�
	 * @return int    ��������
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
	 * @Description: �Ƿ�����һҳ
	 * @param @param currentPage ��ǰҳ
	 * @param @return    �趨�ļ�
	 * @return boolean    ��������
	 * @throws
	 */
	public static boolean getHasPrePage(int currentPage)
	{
		return currentPage == 1 ? false : true;  
	}
	
	/**
	 * @author XIAyuzheng521
	 * @Title getHasNextPage
	 * @Description: �Ƿ�����һҳ
	 * @param @param currentPage
	 * @param @param totalPage
	 * @param @return    �趨�ļ�
	 * @return boolean    ��������
	 * @throws
	 */
	public static boolean getHasNextPage(int currentPage,int totalPage)
	{
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}
}
