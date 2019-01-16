package com.netintech.xfquartz.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * 基础dao封装一些简单的方法
 * @author 
 *
 */
public interface BaseDao<T>{
	/**  
     * 插入一个实体  
     * @param entity  
     */  
	int insert(T entity) ; 
      
    /**  
     * 根据实体主键删除一个实体  
     * @param primaryKey  
     */  
    void deleteById(Serializable id);  
    
    /**
     * 通过实体删除
     * @param entity
     */
    void deleteByEntity(T entity);
    
    /**
     * 通过map删除
     * @param params
     */
    void deleteByMap(Map<String, Object> params);


    /**
     * 通过id进行修改
     * @param id
     */
    void updateById(T entity);


    /**
     * 根据参数查询
     * @param clz
     * @param params
     * @return
     */
    public List<T> listByMap(Map<String, Object> params);


    /**
     * 查询所有实体,根据实体属性值为判断条件查询所有实体，
     * @param entity
     * @return
     */
    List<T> listByEntity(T entity);


    /**
     * 根据主键获取一个实体
     * @param id
     * @return
     */
    T getById(Serializable id);

    /**
     * 通过map查询
     * @param params
     * @return
     */
    T getByMap(Map<String, Object> params);
    
    /**
     * 通过对象查询
     * @param entity
     * @return
     */
    T getByEntity(T entity);
    
    
    /**
     * 批量新增
     * @param list
     */
    public void insertBatch(List<T> list);
    
    /**
     * 批量修改
     * @param list
     */
    public void updateBatch(List<T> list);

}
