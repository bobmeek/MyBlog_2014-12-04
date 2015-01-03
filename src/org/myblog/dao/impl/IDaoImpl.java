package org.myblog.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
		System.out.println("IDaoImpl save method invoked - > entity: " + entity);
		getSqlSession().insert(entity.getClass().getName() + ".add", entity);
	}

	@Override
	public void delete(Serializable pk) 
	{
		
	}

	@Override
	public void update(T entity) 
	{
		System.out.println("IDaoImpl update method invoked - > entity: " + entity);
		getSqlSession().update(entity.getClass().getName()+".update", entity);
	}

	@Override
	public T login(T entity) 
	{
		return null;
	}

	@Override
	public int isExist(Class<T> entityClass, Map<String, Object> maps, String operate)
	{
		int count = 0;
		
		count = getSqlSession().selectOne(entityClass.getName() + operate, maps);
		
		return count;
	}

	@Override
	public T findByParam(Class<T> entityClass, Map<String, Object> maps, String operate)
	{
		return getSqlSession().selectOne(entityClass.getName() + operate, maps);
	}
}