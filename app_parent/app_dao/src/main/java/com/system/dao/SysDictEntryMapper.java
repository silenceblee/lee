package com.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.frame.common.Page;
import com.system.po.SysDictEntry;

public interface SysDictEntryMapper {
    /**
     * 通过主键删除数据 
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    int deleteByPrimaryKey(@Param("dictCode") String dictCode, @Param("dictType") String dictType);

    /**
     * 插入数据 
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    int insert(SysDictEntry record);

    /**
     * 选择性插入数�?
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    int insertSelective(SysDictEntry record);

    /**
     * 通过主键查询数据 
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    SysDictEntry selectByPrimaryKey(@Param("dictCode") String dictCode, @Param("dictType") String dictType);

    /**
     * 通过主键选择性更新数�?
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    int updateByPrimaryKeySelective(SysDictEntry record);

    /**
     * 通过主键更新数据 
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    int updateByPrimaryKey(SysDictEntry record);
    
    
    /**
     * 查询所有记录
     * @return
     */
    List<SysDictEntry> selectList(Page page);
}