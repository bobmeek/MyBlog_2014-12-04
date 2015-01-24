package org.myblog.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.myblog.common.Pager;


public interface BaseDao<T, PK extends Serializable>  
{
	
	// 保存操作
	public void save(T entity); 
	
	// 删除操作通过主键
	public void delete(PK pk); 
	
	// 批量删除
	public void delete(Map<String,Object> maps,String operate);
	
	// 修改操作
	public void update(T entity); 
	
	// 查询全部
	public List<T> findAll();
	
	// 根据主键进行查询操作
	public T findById(PK pk); 
	
	// 一个带条件的分页
	public Pager<T> findByPage(int pageNo, int pageSize); 
		
	// 一个带条件的分页
	public Pager<T> findByPage(int pageNo, int pageSize, Object key); 
	
	// 多条件的查询分页
	public Pager<T> findByKey(Map<String, Object> maps, String operate);
	
	// 登录
	public T login(T entity); 
	
	//根据用户名/邮箱登录
	public int login(Map<String,Object> maps,String operate);
	
	// 判断某个值是否存在（parameter-Map, example：username, password ...）operate标识唯一的mapper
	// 返回值类型为int类型是想判断 'select count(*) table..., 返回的数据是0还是1 ?'
	public int isExist(Map<String, Object> maps, String operate);
	
	public void save(Map<String, Object> maps, String operate);
	
}
