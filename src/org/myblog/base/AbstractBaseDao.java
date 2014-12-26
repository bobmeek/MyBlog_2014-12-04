package org.myblog.base;

import java.io.Serializable;
import java.util.List;

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
		
	}
	
	@Override
	public void delete(PK pk) 
	{
		
	}
	
	@Override
	public void update(T entity) 
	{
		
	}
	
	@Override
	public T login(T entity) 
	{
		return null;
	}
}