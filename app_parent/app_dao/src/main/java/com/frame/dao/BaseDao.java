package com.frame.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * dao基础类
 * @author master
 *
 * @param <T> 实体类
 */
public class BaseDao<T> {

	//注入MyBatis模板类
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	//private Class entityCalss;
	
	public BaseDao() {
//		//通过反射方式获取子类dao对应的泛型实体类
//		Type genType = getClass().getGenericSuperclass();
//		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
//		entityCalss = (Class) params[0];
	}
	
    /**
     * 通过主键删除数据 
     *
     */
    public int deleteByPrimaryKey(String key){
    	return sessionTemplate.delete("deleteByPrimaryKey", key);
    }

    /**
     * 插入数据 
     *
     */
    public  int insert(T entity){
    	return sessionTemplate.insert("insert", entity);
    }

    /**
     * 选择性插入数据
     *
     */
    public int insertSelective(T entity){
    	return sessionTemplate.insert("insertSelective", entity);
    }

    /**
     * 通过主键查询数据 
     *
     */
    public T selectByPrimaryKey(String key){
    	return sessionTemplate.selectOne("selectByPrimaryKey", key);
    }

    /**
     * 通过主键选择性更新数据
     *
     */
    public int updateByPrimaryKeySelective(T entity){
    	return sessionTemplate.update("updateByPrimaryKeySelective", entity);
    }

    /**
     * 通过主键更新数据 
     *
     */
    public int updateByPrimaryKey(T entity){
    	return sessionTemplate.update("updateByPrimaryKey", entity);
    }

    /**
     * 集合查询
     * @param entity
     * @return
     */
    public List<T> selectList(T entity){
    	return sessionTemplate.selectList("selectList", entity);
    }
    
    /**
     * 分页查询
     * @param entity
     * @return
     */
    public List<T> selectListPage(T entity){
    	return sessionTemplate.selectList("selectList", entity);
    }
}
