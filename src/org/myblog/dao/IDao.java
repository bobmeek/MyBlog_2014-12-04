package org.myblog.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.myblog.common.Pager;


public interface IDao<T, PK extends Serializable>  
{	
	// 保存操作
	public void save(T entity); 
	
	// 修改操作
	public void update(T entity); 
	
	// 删除操作通过主键
	public void delete(Class<T> entityClass, PK pk);  
	
	// 传参删除
	public void delete(Class<T> entityClass,Map<String,Object> maps,String operate);
	
		
	// 查询全部（之所以要加上泛型Class,是因为要通过class取得类路径调用相应的处理方法）
	public List<T> findAll(Class<T> entityClass);
	
	// 根据主键进行查询操作
	public T findById(Class<T> entityClass,Serializable pk); 
	
	// 分页（pageNo：发往服务器端的页码信息, pageSize：每页显示的条数）
	public Pager<T> findByPage(Class<T> entityClass, int pageNo, int pageSize);
	
	// 一个带条件的分页
	public Pager<T> findByPage(Class<T> entityClass, int pageNo, int pageSize, Object key); 
	
	// 带多个条件的分页
	public Pager<T> findByKey(Class<T> entityClass, Map<String, Object> maps, String operate);
	
	// 登录
	public T login(T entity);
	
	//根据用户名/邮箱登录
	public int login(Class<T> entityClass,Map<String,Object> maps,String operate);
	
	/**
    * 判断某个值是否存在
    * @param entityClass
    * @param maps
    * @param operate
    * @return
    */
	public int isExist(Class<T> entityClass,Map<String, Object> maps,String operate);
	
	
	/**
	 * @Description 通过一个参数取到对应的对象  
	 * @author bobmeek
	 * @Title findByParam
	 * @param @param entityClass
	 * @param @param maps
	 * @param @param operate
	 * @param @return
	 * @return T    返回类型
	 */
	public T findByParam(Class<T> entityClass, Map<String, Object> maps, String operate);
	
	/**通过一个参数获取对应的集合**/
	public List<T> findListByParam(Class<T> entityClass, Map<String, Object> maps, String operate);
	
	/**存储关联表关系**/
	public void save(Class<T> entityClass, Map<String, Object> maps, String operate);
	
	/**删除关联表关系**/
	
}