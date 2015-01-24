/**  
 * @Title: ResourceController.java
 * @Package org.myblog.controller
 * @Description: TODO
 * @author bobmeek
 * @date Jan 23, 2015 9:14:17 PM
 * @version V1.0  
 */
package org.myblog.controller;

import java.util.List;

import javax.annotation.Resource;

import org.myblog.model.ResourceVO;
import org.myblog.service.facade.ResourceServcie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: ResourceController
 * @Description: TODO
 * @author bobmeek
 * @date Jan 23, 2015 9:14:17 PM
 */
@Controller
@RequestMapping(value="/resource/")
public class ResourceController
{
	@Resource(name="resourceServiceImpl")
	private ResourceServcie resourceServcie;
	
	@RequestMapping(value="show/allResources",produces="application/json;charset=utf-8")
	@ResponseBody
	public List<ResourceVO> showResources()
	{
		List<ResourceVO> resources = resourceServcie.findAll();
		
		
		
		return resources;
	}
}
