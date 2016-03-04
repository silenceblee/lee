package com.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.common.Page;
import com.system.dao.SysDictEntryMapper;
import com.system.dao.SysDictTypeMapper;
import com.system.po.SysDictEntry;
import com.system.po.SysDictType;

/**
 * 数据字典业务处理类
 * @author master
 *
 */
@Service
public class SysDictService {

	/**字典类型*/
	@Autowired
	private SysDictTypeMapper dictTypeDao;
	/**字典明细*/
	@Autowired
	private SysDictEntryMapper dictEntryDao;
	
	/**
	 * 查询数据字典类型
	 * @param page 查询条件
	 * @return
	 */
	public List<SysDictType> selectDictTypeList(Page page){
		return dictTypeDao.selectList(page);
	}
	
	/**
	 * 查询数据字典明细
	 * @param page 查询条件
	 * @return
	 */
	public List<SysDictEntry> selectDictEntryList(Page page){
		return dictEntryDao.selectList(page);
	}
	
	/**
	 * 字典类型新增
	 * @param dictType
	 * @return
	 * @throws Exception
	 */
	public int dictTypeAdd(SysDictType dictType) throws Exception{
		return dictTypeDao.insert(dictType);
	}
}
