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
import javax.ws.rs.PathParam;

import org.myblog.model.ResourceVO;
import org.myblog.model.RoleVO;
import org.myblog.service.facade.ResourceService;
import org.myblog.service.facade.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
	 private ResourceService resourceService;
	 
	 
	 @RequestMapping(value="/delete/{roleId}",produces="application/json;charset=utf-8")
	 @ResponseBody
	 public void deleteRole(@PathVariable int roleId)
	 {
		 roleService.deleteUserRelation(roleId);
		 roleService.deleteResourceRelation(roleId);
		 roleService.delete(roleId);
	 }
	 
	 @RequestMapping(value="/add",produces="application/json;charset=utf-8")
	 @ResponseBody
	 public void addRole(RoleVO role)
	 {
		 roleService.save(role);
	 }
	 
	 @RequestMapping(value = "/update",produces="application/json;charset=utf-8")
	 @ResponseBody
	 public void update(RoleVO role){
		 
		 roleService.update(role);
	 }
	 
	 
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
		 List<ResourceVO> resources = resourceService.findAll();
		 model.addAttribute("roles",roles);
		 model.addAttribute("resources",resources);
		 return model;
	 }
	 
	 
	 
	 @RequestMapping(value="/show/{id}",produces=("application/json;charset=utf-8"))
	 @ResponseBody
	 public RoleVO  showRoleById()
	 {
		 
		 return null;
	 }
	 
	 
	 
	 
	 
}
