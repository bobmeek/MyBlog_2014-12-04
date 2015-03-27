package org.myblog.test;

import java.util.List;

import org.myblog.model.SiteInfoVO;
import org.myblog.service.facade.SiteInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**   
 * @desc   [  ]
 * @author [ bobmeek ]   
 * @time   [ 2015年3月24日 下午5:37:02 ] 
 *
 */
public class SiteInfoT {
	private static ApplicationContext ctx;
	static
	{
	
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	
	public static void main(String[] args) {
		
		SiteInfoService siteInfoService = (SiteInfoService)ctx.getBean("siteInfoService");
		List<SiteInfoVO> list = siteInfoService.findAll();
		for (SiteInfoVO siteinfo : list) {
			System.out.println(siteinfo.getCopyright());
		}
	}
}
