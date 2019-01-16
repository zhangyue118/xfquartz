package com.netintech.xfquartz.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;


public abstract  class BaseServiceImpl<T> implements BaseService<T>{

    public abstract BaseDao<T> getBaseDao();  
    
    /**  
     * 插入一个实体  
     * @param entity  
     */  
	public int insert(T entity) {
		return this.getBaseDao().insert(entity);
	}
	
    /**  
     * 根据实体主键删除一个实体  
     * @param primaryKey  
     */  
	public void deleteById(Serializable id) {
		this.getBaseDao().deleteById(id);
	}
	
	
	/**
	 * 通过实体删除
	 */
	public void deleteByEntity(T entity) {
		this.getBaseDao().deleteByEntity(entity);		
	}

	/**
	 * 通过map删除
	 */
	public void deleteByMap(Map<String, Object> params) {
		this.getBaseDao().deleteByMap(params);
	}

	 
    /**
     * 通过id进行修改
     * @param id
     */
	public void updateById(T entity) {
         this.getBaseDao().updateById(entity);
	}
	
	 /**
     * 根据参数查询
     * @param clz
     * @param params
     * @return
     */
	public List<T> listByMap(Map<String, Object> params) {
		return this.getBaseDao().listByMap(params);
	}
	
	
	 /**  
     * 查询所有实体,根据实体属性值为判断条件查询所有实体，  
     * @param entity  
     * @return  
     */
	public List<T> listByEntity(T entity) {
		return this.getBaseDao().listByEntity(entity);
	}
	
	
	/**
     * 根据主键获取一个实体
     * @param id
     * @return
     */
	public T getById(Serializable id) {
		return this.getBaseDao().getById(id);
	}

	 /**
     * 通过map查询
     * @param params
     * @return
     */
	public T getByMap(Map<String, Object> params) {
		return this.getBaseDao().getByMap(params);
	}

	/**
     * 通过对象查询
     * @param entity
     * @return
     */
	public T getByEntity(T entity) {
		return this.getBaseDao().getByEntity(entity);
	}
	
	


	/**
	 * 批量新增
	 */
	 public void insertBatch(List<T> list) {
		 this.getBaseDao().insertBatch(list);
	}

	 /**
	  * 批量删除
	  */
	public void updateBatch(List<T> list) {
		 this.getBaseDao().updateBatch(list);
	}

	

	//判断空
	public boolean isEmpty(String str) {
		return (null == str) || (str.trim().length() <= 0);
	}

	public boolean isEmpty(Character cha) {
		return (null == cha) || cha.equals(' ');
	}

	public boolean isEmpty(Object obj) {
		return (null == obj);
	}

	public boolean isEmpty(Object[] objs) {
		return (null == objs) || (objs.length <= 0);
	}

	public boolean isEmpty(Collection<?> obj) {
		return (null == obj) || obj.isEmpty();
	}

	public boolean isEmpty(Set<?> set) {
		return (null == set) || set.isEmpty();
	}

	public boolean isEmpty(Serializable obj) {
		return null == obj;
	}

	public boolean isEmpty(Map<?, ?> map) {
		return (null == map) || map.isEmpty();
	}
}
