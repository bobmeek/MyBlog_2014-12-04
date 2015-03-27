package org.myblog.controller;

import java.util.List;

import javax.annotation.Resource;

import org.myblog.model.SiteInfoVO;
import org.myblog.service.facade.SiteInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @desc   [ 站点信息控制层 ]
 * @author [ bobmeek ]   
 * @time   [ 2015年3月24日 下午5:28:48 ] 
 *
 */
@Controller
@RequestMapping(value="/siteinfo/")
public class SiteInfoController {
	@Resource(name="siteInfoServiceImpl")
	private SiteInfoService siteInfoService;
	
	
	@RequestMapping(value = "/show")
	@ResponseBody
	public SiteInfoVO showSiteInfo(){
		SiteInfoVO siteInfo = siteInfoService.findAll().get(0);
		return siteInfo;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public void updateSiteInfo(SiteInfoVO siteInfo){
		siteInfoService.update(siteInfo);
	}
	
}
