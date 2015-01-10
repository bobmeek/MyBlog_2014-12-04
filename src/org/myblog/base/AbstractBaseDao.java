package org.myblog.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.myblog.common.GetEntityClassUtil;
import org.myblog.dao.IDao;

public abstract class AbstractBaseDao<T, PK extends Serializable> implements BaseDao<T, PK> 
{
	@SuppressWarnings("rawtypes")
	Class entityClass = GetEntityClassUtil.getEntityClass(getClass());
	
	@Resource
	private IDao<T, Serializable> idao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() 
	{
		return idao.findAll(entityClass);
	}
	
	@Override
	public T findById(PK pk) 
	{
		return null;
	}
	
	@Override
	public void save(T entity) 
	{
		idao.save(entity);
	}
	
	@Override
	public void delete(PK pk) 
	{
		
	}
	
	@Override
	public void update(T entity) 
	{
		idao.update(entity);
	}
	
	@Override
	public T login(T entity) 
	{
		return idao.login(entity);
	}
	
	@SuppressWarnings("unchecked")
	public int login(Map<String,Object> maps,String operate)
	{
		return idao.login(entityClass, maps, operate);
	}

	@SuppressWarnings("unchecked")
	public int isExist(Map<String, Object> maps, String operate)
	{
		return idao.isExist(entityClass, maps, operate);
	}
	
	@SuppressWarnings("unchecked")
	public T findByParam(Map<String, Object> maps, String operate)
	{
		return idao.findByParam(entityClass, maps, operate);
	}
	
}