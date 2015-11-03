package com.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.po.Country;
import com.app.service.ICountryService;


@Controller
@RequestMapping("/country")
public class CountryController {
	@Resource(name="countryService")
	private ICountryService countryService;
	
	@RequestMapping("/showCountry")
	public String toIndex(HttpServletRequest request,Model model){
		String code = request.getParameter("code");
		Country country = countryService.getById(code);
		model.addAttribute("country", country);
		return "showCountry";
	}
}
