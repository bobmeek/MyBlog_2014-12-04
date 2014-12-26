package org.myblog.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.myblog.dao.IDao;
import org.springframework.stereotype.Service;

@Service
public class IDaoImpl<T, PK extends Serializable> extends SqlSessionDaoSupport implements IDao<T, Serializable>
{
	@Override
	public List<T> findAll(Class<T> entityClass) 
	{
		System.out.println("IDaoImpl findAll method invoked - > Class: " + entityClass);
		return getSqlSession().selectList(entityClass.getName() + ".findAll");
	}

	@Override
	public T findById(Serializable pk) 
	{
		return null;
	}

	@Override
	public void save(T entity) 
	{
	}

	@Override
	public void delete(Serializable pk) 
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