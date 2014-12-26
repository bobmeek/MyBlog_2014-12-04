package org.myblog.base;

import java.io.Serializable;
import java.util.List;

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
	
}
