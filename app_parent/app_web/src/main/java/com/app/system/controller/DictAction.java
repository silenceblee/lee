package com.app.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.util.BaseAction;
import com.app.util.TableResponse;
import com.frame.common.Page;
import com.system.po.SysDictEntry;
import com.system.po.SysDictType;
import com.system.service.SysDictService;

/**
 * 数据字典
 * @author master
 *
 */
@Controller
@RequestMapping("/dict")
public class DictAction extends BaseAction{

	@Autowired
	private SysDictService sysDictService;
	
	/**
	 * 数据字典类型分页查询
	 * @param page 查询条件
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loadDictType")
	public TableResponse<SysDictType>  loadDictType(Page page){
		List<SysDictType> datas = sysDictService.selectDictTypeList(page);
		return toTableResponse(page, datas);
	}
	
	
	/**
	 * 数据字典明细分页查询
	 * @param page 查询条件
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loadDictEntry")
	public TableResponse<SysDictEntry>  loadDictEntry(Page page){
		List<SysDictEntry> datas = sysDictService.selectDictEntryList(page);
		return toTableResponse(page, datas);
	}
	
	@RequestMapping(value = "/dictTypeAdd")
	public void dictTypeAdd(SysDictType dictType){
		try {
			sysDictService.dictTypeAdd(dictType);
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg(e.getMessage());
		}
		
	}
}
