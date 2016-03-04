package com.system.dao;

import java.util.List;

import com.frame.common.Page;
import com.system.po.SysDictType;

public interface SysDictTypeMapper {
    /**
     * 通过主键删除数据 
     *
     * @mbggenerated 2016-02-25 09:37:11
     */
    int deleteByPrimaryKey(String dictType);

    /**
     * 插入数据 
     *
     * @mbggenerated 2016-02-25 09:37:11
     */
    int insert(SysDictType record);

    /**
     * 选择性插入数�?
     *
     * @mbggenerated 2016-02-25 09:37:11
     */
    int insertSelective(SysDictType record);

    /**
     * 通过主键查询数据 
     *
     * @mbggenerated 2016-02-25 09:37:11
     */
    SysDictType selectByPrimaryKey(String dictType);

    /**
     * 通过主键选择性更新数�?
     *
     * @mbggenerated 2016-02-25 09:37:11
     */
    int updateByPrimaryKeySelective(SysDictType record);

    /**
     * 通过主键更新数据 
     *
     * @mbggenerated 2016-02-25 09:37:11
     */
    int updateByPrimaryKey(SysDictType record);
    
    /**
     * 查询所有记录
     * @return
     */
    List<SysDictType> selectList(Page page);
}