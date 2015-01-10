package org.myblog.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T, PK extends Serializable>  
{
	// 查询全部
	public List<T> findAll();
	
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
	
	//根据用户名/邮箱登录
	public int login(Map<String,Object> maps,String operate);
	
	// 判断某个值是否存在（parameter-Map, example：username, password ...）operate标识唯一的mapper
	// 返回值类型为int类型是想判断 'select count(*) table..., 返回的数据是0还是1 ?'
	public int isExist(Map<String, Object> maps, String operate);
	
}
