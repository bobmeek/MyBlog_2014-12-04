package org.myblog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.PathParam;

import org.myblog.common.SortListUtil;
import org.myblog.model.CategoryVO;
import org.myblog.model.MenuVO;
import org.myblog.service.facade.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/menu/")
public class MenuController {
	
	@Resource(name="menuServiceImpl")
	private MenuService menuService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/show")
	@ResponseBody
	public List<MenuVO> show(){
		List<MenuVO> menus = menuService.findAll();
		menus = (List<MenuVO>) SortListUtil.sort(menus, "orders");
		return menus;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/show/{id}")
	@ResponseBody
	public List<MenuVO> showChilds(@PathVariable Integer id){
		List<MenuVO> menus = menuService.findListById(id);
		menus = (List<MenuVO>) SortListUtil.sort(menus, "orders");
		return menus;
	}
	
	@RequestMapping(value = "/add/childs")
	@ResponseBody
	public void addChilds(MenuVO menu){
		//查出该父ID下所有的子菜单中orders字段的最大值 
		int maxOrders = menuService.findMaxOrders(menu.getParentId())+1;
		menu.setOrders(maxOrders);
		menu.setStatus(1);
		menuService.save(menu);
	}
	
	@RequestMapping(value="/update/childs",produces="application/json;charset=utf-8")
	@ResponseBody
	public void updateChilds(@RequestBody MenuVO[] menus){
		for (int i=0;i<menus.length; i++) {
			menuService.update(menus[i]);	
		}
	}
	@RequestMapping(value="/update/child",produces="application/json;charset=utf-8")
	@ResponseBody
	public void updateChilds(MenuVO menu){
		menuService.update(menu);	

	}
	
	@RequestMapping(value = "/delete/{id}")
	@ResponseBody
	public void deleteChilds(@PathVariable Integer id){
		menuService.delete(id);
	}
}
