package org.myblog.service.facade;

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
	
}
