package org.myblog.common;

import java.util.List;

public class Pager<T> 
{
	private int totalNum; // 总数
	
	private List<T> pageList; // 每页显示的具体内容

	public int getTotalNum() 
	{
		return totalNum;
	}

	public void setTotalNum(int totalNum) 
	{
		this.totalNum = totalNum;
	}

	public List<T> getPageList()
	{
		return pageList;
	}

	public void setPageList(List<T> pageList) 
	{
		this.pageList = pageList;
	}
}