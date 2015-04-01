/**  
 * @Title: Test.java
 * @Package com.omnific.util.page
 * @Description: TODO
 * @author XIAyuzheng521
 * @date 2013-11-17 ����7:43:41
 * @version V1.0  
 */
package org.myblog.common.page;


/**
 * @ClassName: Test
 * @Description: TODO
 * @author XIAyuzheng521
 * @date 2013-11-17 ����7:43:41
 */
public class Test
{
	public static void main(String[] args)
	{
		
		Page page = PageUtil.createPage(5,1, 30);
		
		System.out.println(page.isHasPrePage());
		
		
		
	}
}
