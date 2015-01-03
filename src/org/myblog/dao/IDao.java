package org.myblog.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IDao<T, PK extends Serializable>  
{	
	// 查询全部（之所以要加上泛型Class,是因为要通过class取得类路径调用相应的处理方法）
	public List<T> findAll(Class<T> entityClass);
	
	// 根据主键进行查询操作
	public T findById(PK pk); 
	
	// 保存操作
	public void save(T entity); 
	
	// 删除操作通过主键
	public void delete(PK pk); 
	
	// 修改操作
	public void update(T entity); 
	
	// 登录
	public T login(T entity);
	
	
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
	
}