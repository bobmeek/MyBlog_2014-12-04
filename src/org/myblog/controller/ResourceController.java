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
import org.myblog.service.facade.ResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
	private ResourceService resourceService;
	
	@RequestMapping(value="/show/allResources",produces="application/json;charset=utf-8")
	@ResponseBody
	public List<ResourceVO> showResources()
	{
		List<ResourceVO> resources = resourceService.findAll();
		return resources;
	}
	
	@RequestMapping(value="/show/{id}",produces="application/json;charset=utf-8")
	@ResponseBody
	public ResourceVO showResource(@PathVariable int id)
	{
		ResourceVO resource = resourceService.findById(id);
		return resource;
	}
	
	@RequestMapping(value = "add",produces="application/json;charset=utf-8")
	@ResponseBody
	public void addChildrenResource(ResourceVO resource)
	{
		resourceService.save(resource);
		
	}
	
	@RequestMapping(value = "update",produces="application/json;charset=utf-8")
	@ResponseBody
	public void updateResource(ResourceVO resource)
	{
		resourceService.update(resource);
	}
	
	
	@RequestMapping(value="/delete/{id}",produces=("application/json"))
	@ResponseBody
	public void deleteResource(@PathVariable int id)
	{
		
		resourceService.deleteRoleRelation(id);
		resourceService.delete(id);
		
	}
	
	
	
}
