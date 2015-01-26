package org.myblog.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.myblog.common.Pager;
import org.myblog.dao.IDao;
import org.springframework.stereotype.Service;


@Service
public class IDaoImpl<T, PK extends Serializable> extends SqlSessionDaoSupport implements IDao<T, Serializable>
{
	
	@Override
	public void save(T entity) 
	{
		System.out.println("IDaoImpl save method invoked - > entity: " + entity);
		getSqlSession().insert(entity.getClass().getName() + ".add", entity);
	}

	@Override
	public void delete(Class<T> entityClass, Serializable pk) 
	{
		System.out.println("IDaoImpl delete method invoked - > Class: " + entityClass + " - > pk" + pk);
		getSqlSession().delete(entityClass.getName() + ".delete", pk);
	}

	public void delete(Class<T> entityClass,Map<String,Object> maps,String operate)
	{
		getSqlSession().delete(entityClass.getName() + operate, maps);
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
		System.out.println("IDaoImpl update method invoked - > entity: " + entity);
		getSqlSession().update(entity.getClass().getName()+".loginByUserName", entity);
		return null;
	}

	
	public int login(Class<T> entityClass,Map<String,Object> maps,String operate)
	{
		int count = 0;
		
		count = getSqlSession().selectOne(entityClass.getName() + operate, maps);
		
		return count;
	}
	
	
	@Override
	public int isExist(Class<T> entityClass, Map<String, Object> maps, String operate)
	{
		int count = 0;
		
		count = getSqlSession().selectOne(entityClass.getName() + operate, maps);
		
		return count;
	}

	@Override
	public List<T> findAll(Class<T> entityClass) 
	{
		System.out.println("IDaoImpl findAll method invoked - > Class: " + entityClass);
		return getSqlSession().selectList(entityClass.getName() + ".findAll");
	}

	@Override
	public T findById(Class<T> entityClass,Serializable pk) 
	{
		System.out.println("IDaoImpl findById method invoked - > Class: " + entityClass + " - > pk" + pk);
		return getSqlSession().selectOne(entityClass.getName() + ".findById", pk);
	}

	@Override
	public T findByParam(Class<T> entityClass, Map<String, Object> maps, String operate)
	{
		return getSqlSession().selectOne(entityClass.getName() + operate, maps);
	}
	
	public List<T> findListByParam(Class<T> entityClass, Map<String, Object> maps, String operate)
	{
		return getSqlSession().selectList(entityClass.getName() + operate, maps);
	}
	
	public Pager<T> findByPage(Class<T> entityClass, int pageNo, int pageSize)
	{
		/*Pager<T> pager = new Pager<T>();
		
		Map<String, Object> maps = new HashMap<String, Object>();
		
		maps.put("pageNo", pageNo);
		maps.put("pageSize", pageSize);
		
		// 分页所需的页码信息、每页显示条数放置在Map集合中, 并通过myBatis提供的SqlSessionDaoSupport方法返回一个List集合
		List<T> pageList = getSqlSession().selectList(entityClass.getName() + ".findByPage", maps);
		
		// 得到分页所需的总数信息
		int totalNum = getSqlSession().selectOne(entityClass.getName() + ".findTotal");
		
		pager.setPageList(pageList);
		pager.setTotalNum(totalNum);
		
		// 分页所需的信息加载到Pager对象中, 并返回一个 pager对象
		return pager;*/
		
		// 重构以上的代码
		return findByPage(entityClass, pageNo, pageSize, null);
	}
	
	// 方法重载的findByPage（parameter key需要判别是哪个 '日志类型要用到分页' ->设计该方法的初衷）
	public Pager<T> findByPage(Class<T> entityClass, int pageNo, int pageSize, Object key)
	{
		Pager<T> pager = new Pager<T>();
		
		Map<String, Object> maps = new HashMap<String, Object>();
		
		maps.put("pageNo", pageNo);
		maps.put("pageSize", pageSize);
		
		if(key != null)
		{
			// key-parameter存在value时，就设置该值
			maps.put("category", key);
		}
		
		List<T> pageList = getSqlSession().selectList(entityClass.getName() + ".findByPage", maps);
		
		int totalNum = getTotalNum(entityClass, key);
		
		pager.setPageList(pageList);
		pager.setTotalNum(totalNum);
		
		return pager;
	}
	
	// 计算日志类型分页总数的 private method.（parameter key需要判别哪个日志类型所需的分页总数信息）
	private int getTotalNum(Class<T> entityClass, Object key)
	{
		int totalNum = 0;
		
		if(key != null)
		{
			// key-parameter存在value时，就将参数-key传值到给定的sql语句中（得到指定的日志类型分页总数）
			totalNum = getSqlSession().selectOne(entityClass.getName() + ".findTotal", key);
		}
		else
		{
			totalNum = getSqlSession().selectOne(entityClass.getName() + ".findTotal");
		}
		return totalNum;
	}


	// finByKey method. 其中参数Map对分页的信息进行了封装， operate指定了需要调用哪个sql语句（从业务层传值过来）
	public Pager<T> findByKey(Class<T> entityClass, Map<String, Object> maps, String operate) 
	{
		System.out.println("test maps data: " + maps);
		System.out.println("test operate: " + operate);
		
		Pager<T> pager = new Pager<T>();
		
		List<T> pageList = getSqlSession().selectList(entityClass.getName() + operate, maps);
		
		int totalNum = getTotalNum(entityClass, maps, operate);
		
		System.out.println("totalNum size: " + totalNum);
		
		pager.setPageList(pageList);
		pager.setTotalNum(totalNum);
		
		return pager;
	}
	
	// 多条件的查询（计算）
	private int getTotalNum(Class<T> entityClass, Map<String, Object> maps, String operate)
	{
		int totalNum = 0;
		
		totalNum = getSqlSession().selectOne(entityClass.getName() + operate + "Total", maps);
		
		return totalNum;
	}	
	
	
	
	
	public void save(Class<T> entityClass, Map<String, Object> maps, String operate)
	{
		getSqlSession().insert(entityClass.getName() + operate, maps);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}