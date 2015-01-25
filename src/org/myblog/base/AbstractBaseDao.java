package org.myblog.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.myblog.common.GetEntityClassUtil;
import org.myblog.common.Pager;
import org.myblog.dao.IDao;


public abstract class AbstractBaseDao<T, PK extends Serializable> implements BaseDao<T, PK> 
{
	@SuppressWarnings("rawtypes")
	Class entityClass = GetEntityClassUtil.getEntityClass(getClass());
	
	@Resource
	private IDao<T, Serializable> idao;
	
	
	@Override
	public void save(T entity) 
	{
		idao.save(entity);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void delete(PK pk) 
	{
		System.out.println(entityClass.toString() + ", id = " + pk);
		idao.delete(entityClass, pk);
	}
	
	@SuppressWarnings("unchecked")
	public void delete(Map<String,Object> maps,String operate)
	{
		idao.delete(entityClass, maps, operate);
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
	
	
	@SuppressWarnings("unchecked")
	public T findByParam(Map<String, Object> maps, String operate)
	{
		return idao.findByParam(entityClass, maps, operate);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findListByParam(Map<String, Object> maps, String operate)
	{
		return idao.findListByParam(entityClass, maps, operate);
	}
	
	@SuppressWarnings("unchecked")
	public Pager<T> findByPage(int pageNo, int pageSize)
	{
		return idao.findByPage(entityClass, pageNo, pageSize);
	}
	
	@SuppressWarnings("unchecked")
	public Pager<T> findByPage(int pageNo, int pageSize, Object key)
	{
		return idao.findByPage(entityClass, pageNo, pageSize, key);
	}
	
	@SuppressWarnings("unchecked")
	public Pager<T> findByKey(Map<String, Object> maps,String operate)
	{
		return idao.findByKey(entityClass, maps, operate);
	}
	
	@SuppressWarnings("unchecked")
	public void save(Map<String, Object> maps, String operate)
	{
		idao.save(entityClass, maps, operate);
	}
	
}