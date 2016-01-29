package com.system.dao;

import com.system.po.SysDictType;
import com.system.po.SysDictTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictTypeMapper {
    /**
     * 通过Example条件查询数量 
     *
     * @mbggenerated 2016-01-29 11:30:51
     */
    int countByExample(SysDictTypeExample example);

    /**
     * 通过Example条件删除数据 
     *
     * @mbggenerated 2016-01-29 11:30:51
     */
    int deleteByExample(SysDictTypeExample example);

    /**
     * 通过主键删除数据 
     *
     * @mbggenerated 2016-01-29 11:30:51
     */
    int deleteByPrimaryKey(String dictType);

    /**
     * 插入数据 
     *
     * @mbggenerated 2016-01-29 11:30:51
     */
    int insert(SysDictType record);

    /**
     * 选择性插入数�?
     *
     * @mbggenerated 2016-01-29 11:30:51
     */
    int insertSelective(SysDictType record);

    /**
     * 通过Examply条件查询数据集合 
     *
     * @mbggenerated 2016-01-29 11:30:51
     */
    List<SysDictType> selectByExample(SysDictTypeExample example);

    /**
     * 通过主键查询数据 
     *
     * @mbggenerated 2016-01-29 11:30:51
     */
    SysDictType selectByPrimaryKey(String dictType);

    /**
     * 通过Example条件选择新更新数�?
     *
     * @mbggenerated 2016-01-29 11:30:51
     */
    int updateByExampleSelective(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);

    /**
     * 通过Example更新数据 
     *
     * @mbggenerated 2016-01-29 11:30:51
     */
    int updateByExample(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);

    /**
     * 通过主键选择性更新数�?
     *
     * @mbggenerated 2016-01-29 11:30:51
     */
    int updateByPrimaryKeySelective(SysDictType record);

    /**
     * 通过主键更新数据 
     *
     * @mbggenerated 2016-01-29 11:30:51
     */
    int updateByPrimaryKey(SysDictType record);
}