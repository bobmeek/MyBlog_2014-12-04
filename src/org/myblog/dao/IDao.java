package org.myblog.dao;

import java.io.Serializable;
import java.util.List;

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
}