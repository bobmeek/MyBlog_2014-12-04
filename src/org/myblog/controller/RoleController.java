/**  
 * @Title: RoleController.java
 * @Package org.myblog.controller
 * @Description: TODO
 * @author bobmeek
 * @date Jan 22, 2015 4:37:19 PM
 * @version V1.0  
 */
package org.myblog.controller;

import java.util.List;

import javax.annotation.Resource;

import org.myblog.model.ResourceVO;
import org.myblog.model.RoleVO;
import org.myblog.service.facade.ResourceServcie;
import org.myblog.service.facade.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @ClassName: RoleController
 * @Description: TODO
 * @author bobmeek
 * @date Jan 22, 2015 4:37:19 PM
 */
@Controller
@RequestMapping(value="/role/")
public class RoleController
{
	 @Resource(name = "roleServiceImpl")
	 private RoleService roleService; 
	 @Resource(name = "resourceServiceImpl")
	 private ResourceServcie resourceServcie;
	 
	 
	 /**添加与资源的关系**/
	 @RequestMapping(value = "/add/resourceRelation",produces="application/json;charset=utf-8")
	 @ResponseBody
	 public void addResourceRelation(int roleId,int resourceId)
	 {
		 roleService.addResourceRelation(roleId, resourceId);
	 }
	 
	 /**删除与资源的关系**/
	 @RequestMapping(value = "/delete/resourceRelation",produces="application/json;charset=utf-8")
	 @ResponseBody
	 public void deleteResourceRelation(int roleId,int resourceId)
	 {
		 roleService.deleteResourceRelation(roleId, resourceId);
	 }
	 
	 @RequestMapping(value="/show/allRoles",produces="application/json")
	 @ResponseBody
	 public ModelMap showAllRolesByPager(ModelMap model)
	 {
		 List<RoleVO> roles = roleService.findAll();
		 List<ResourceVO> resources = resourceServcie.findAll();
		 model.addAttribute("roles",roles);
		 model.addAttribute("resources",resources);
		 return model;
	 }
	 
	 
	 
	 @RequestMapping(value="show/{id}",produces=("application/json;charset=utf-8"))
	 @ResponseBody
	 public RoleVO  showRoleById()
	 {
		 
		 return null;
	 }
	 
	 
	 
	 
	 
	 
}
