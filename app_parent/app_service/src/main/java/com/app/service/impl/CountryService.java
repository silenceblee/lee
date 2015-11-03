package com.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dao.ICountryDao;
import com.app.po.Country;
import com.app.service.ICountryService;

@Service("countryService")
public class CountryService implements ICountryService{

	@Resource  
	private ICountryDao countryDao;
	
	public Country getById(String id) {
		return countryDao.selectByPrimaryKey(id);
	}

}
