package org.myblog.service.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.myblog.base.BaseDao;
import org.myblog.model.CategoryVO;
import org.myblog.model.UserVO;
import org.springframework.ui.ModelMap;

public interface CategoryService extends BaseDao<CategoryVO, Integer>
{
	/**
	 * 保存栏目对象
	 * @param category
	 */
	public void addCategory(CategoryVO category);
	
	/**
	 * 添加栏目
	 * pid为空表示父栏目，否则为子栏目
	 * @param category
	 * @param pid
	 */
	public void addCategory2(CategoryVO category, Integer pid);
	
	public List<CategoryVO> findArticleByCategoryId(int id);
	
	/**
	 * 
	 * @desc   [ 查找导航栏目 ]
	 * @param  [ @param type 栏目类型
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月30日 下午9:48:52 ] 
	 *
	 */
	public List<CategoryVO> findNavigate(Integer type);
	
	/**
	 * 
	 * @desc   [ 获取最大Orders ]
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月31日 下午7:12:26 ] 
	 *
	 */
	public Integer findMaxOrders(Integer type);

	
	
}