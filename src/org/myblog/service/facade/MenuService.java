package org.myblog.service.facade;

import java.util.List;

import org.myblog.base.BaseDao;
import org.myblog.model.MenuVO;

public interface MenuService extends BaseDao<MenuVO, Integer> {

	/**
	 * 
	 * @desc   [ 查出该父ID下所有的子菜单中orders字段的最大值 ]
	 * @param  [ @param parentId 父ID
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015-4-23 下午9:10:55 ] 
	 *
	 */
	public int findMaxOrders(int parentId);
	
	/**
	 * 
	 * @desc   [ 根据菜单名称查找出对应的对象 ]
	 * @param  [ @param name 菜单名称
	 * @param  [ @return MenuVO]
	 * @author [ bobmeek ]   
	 * @time   [ 2015-4-28 下午7:44:24 ] 
	 *
	 */
	public MenuVO findByName(String name);
	
	/**
	 * 
	 * @desc   [ 根据父菜单ID找出相应的子菜单 ]
	 * @param  [ @param id 父菜单ID
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015-4-28 下午9:31:15 ] 
	 *
	 */
	public List<MenuVO> findListByParentId(int id);
}
