package com.tz.shopping.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 实现常用方法的基础类接口
 * @author YT
 * T : 泛型  : 可代表所有的实体类对象，也就是表对象
 * @param <T>
 */
public interface BaseDao<T> {
	
	/**
	 * 保存 insert
	 */
	public Serializable save(T o);
	
	/**
	 * 删除delete 按id
	 */
	public void delete(Serializable id);
	
	/**
	 * 删除delete 按class
	 */
	public void delete(T o);
	
	/**
	 * 修改
	 */
	public void update(T o);
	
	/**
	 * saveOrUpdate
	 */
	public void saveOrUpdate(T o);
	
	/**
	 * 获取单个对象
	 */
	public T get(Serializable id);
	
	/**
	 * 获取数组
	 */
	public List<T> find(String hql);
	
	/**
	 * 获取数组
	 */
	public List<T> find(String hql, Map<String, Object> params);
	
	/**
	 * 获取数组分页
	 */
	public List<T> find(String hql, int page, int rows);
	
	/**
	 * 获取数组分页
	 */
	public List<T> find(String hql, Map<String, Object> params, int page, int rows);
	
	/**
	 * 获取记录数量
	 */
	public Integer count(String hql);
	
	/**
	 * 获取记录数量
	 */
	public Integer count(String hql, Integer id);
	
	/**
	 * 获取记录数量
	 */
	public Integer count(String hql, Map<String, Object> params);
	
	/**
	 * 一些特殊的DML，如特殊的修改
	 */
	public int executeHql(String hql);
	
	/**
	 * 一些特殊的DML，如特殊的修改
	 */
	public int executeHql(String hql, Map<String, Object> params);
	

}
