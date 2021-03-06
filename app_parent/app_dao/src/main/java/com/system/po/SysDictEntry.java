package com.system.po;

import java.io.Serializable;

public class SysDictEntry implements Serializable {
    /**
     * 字典编码
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    private String dictCode;

    /**
     * 字典类型
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    private String dictType;

    /**
     * 字典名称
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    private String dictName;

    /**
     * 显示序号
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    private Integer dictOrder;

    /**
     * 备注
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_dict_entry
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    private static final long serialVersionUID = 1L;

    /**
     * 字典编码
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    public String getDictCode() {
        return dictCode;
    }

    /**
     * 字典编码
     *
     * @param dictCode java.lang.String
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    /**
     * 字典类型
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    public String getDictType() {
        return dictType;
    }

    /**
     * 字典类型
     *
     * @param dictType java.lang.String
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim();
    }

    /**
     * 字典名称
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    public String getDictName() {
        return dictName;
    }

    /**
     * 字典名称
     *
     * @param dictName java.lang.String
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    /**
     * 显示序号
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    public Integer getDictOrder() {
        return dictOrder;
    }

    /**
     * 显示序号
     *
     * @param dictOrder java.lang.Integer
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    public void setDictOrder(Integer dictOrder) {
        this.dictOrder = dictOrder;
    }

    /**
     * 备注
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     *
     * @param remark java.lang.String
     *
     * @mbggenerated 2016-03-03 14:18:35
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}