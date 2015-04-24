package org.myblog.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(PK pk) 
	{
		System.out.println(entityClass.toString() + ", id = " + pk);
		return idao.findById(entityClass, pk);
	}
	
	
	@SuppressWarnings("unchecked")
	public T findByParam(Map<String, Object> maps, String operate)
	{
		return idao.findByParam(entityClass, maps, operate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findListById(PK pk) 
	{
		System.out.println(entityClass.toString() + ", id = " + pk);
		return idao.findListById(entityClass, pk);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findListByParam(Map<String, Object> maps, String operate)
	{
		return idao.findListByParam(entityClass, maps, operate);
	}
	@SuppressWarnings("unchecked")
	public Integer findMaxId(){
		return idao.findMaxId(entityClass);
	}
	@SuppressWarnings("unchecked")
	public Integer findMaxParam(Map<String, Object> maps, String operate){
		return idao.findMaxParam(entityClass, maps, operate);
	}
	@SuppressWarnings("unchecked")
	public List<T> findByParam1(Map<String, Object> maps, String operate)
	{
		return idao.findByParam1(entityClass, maps, operate);
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
	public int getTotalNum()
	{
		return idao.getTotalNum(entityClass, null);
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
	
	@SuppressWarnings("unchecked")
	public void bulk_delte(List<Integer> id)
	{
		idao.bulk_delete(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public void bulk_delte2(List<Integer> id) 
	{
		idao.bulk_delete2(entityClass, id);
	}
	
}