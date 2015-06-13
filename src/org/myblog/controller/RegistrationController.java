package org.myblog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.myblog.common.Pager;
import org.myblog.common.SortListUtil;
import org.myblog.common.page.Page;
import org.myblog.common.page.PageUtil;
import org.myblog.model.RegistrationVO;
import org.myblog.service.facade.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/registration/")
public class RegistrationController {

	@Resource(name="registrationServiceImpl")
	private RegistrationService registrationService;
	
	
	
	@RequestMapping(value="/save/")
	@ResponseBody
	public int save(RegistrationVO registration){
		registrationService.save(registration);
		return 1;
	}
	
	@RequestMapping(value="/update/")
	@ResponseBody
	public int update(RegistrationVO registration){
		registrationService.update(registration);
		return 1;
	}
	
	@RequestMapping(value="/delete/{id}/")
	@ResponseBody
	public int delete(@PathVariable int id){
		registrationService.delete(id);
		return 1;
	}
	
	@RequestMapping(value="/delete/idArr",produces=("application/json"))
	@ResponseBody
	public int deleteUserBatch(@RequestBody int[] idArr)
	{
		List<Integer> ids = new ArrayList<Integer>();
		for (int i : idArr){
			ids.add(i);
		}
		registrationService.deleteBatch(ids);
		return 1;
	}
	
	
	@RequestMapping(value="/show/")
	@ResponseBody
	public List<RegistrationVO> show(){
		List<RegistrationVO> registrations = registrationService.findAll();
		return registrations;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/show/{currentPage}")
	@ResponseBody
	public ModelMap showByPager(@PathVariable int currentPage,ModelMap modelMap){
		int pageCount = 5;
		int totalCount = registrationService.getTotalNum();
		Page page = PageUtil.createPage(pageCount, currentPage, totalCount);
		int totalPage = page.getTotalPage();
		currentPage = page.getCurrentPage();
		int startIndex = page.getSrartIndex();
		boolean hasPrePage = page.isHasPrePage();
		boolean hasNextPage = page.isHasNextPage();
		Pager<RegistrationVO> pagers = registrationService.findByPage(startIndex, pageCount);
		//List<RegistrationVO> registrations = (List<RegistrationVO>) SortListUtil.sort(pagers.getPageList(),"id",SortListUtil.DESC);
		List<RegistrationVO> registrations = pagers.getPageList();
		modelMap.addAttribute("registrations",registrations);
		modelMap.addAttribute("totalCount",totalCount);
		modelMap.addAttribute("totalPage",totalPage);
		modelMap.addAttribute("currentPage",currentPage);
		modelMap.addAttribute("hasPrePage",hasPrePage);
		modelMap.addAttribute("hasNextPage",hasNextPage);
		return modelMap;
	}
	
	
}
