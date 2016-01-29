package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/country")
public class CountryController {
	/*@Resource(name="countryService")
	private ICountryService countryService;
	
	@RequestMapping("/showCountry")
	public String toIndex(HttpServletRequest request,Model model){
		String code = request.getParameter("code");
		Country country = countryService.getById(code);
		model.addAttribute("country", country);
		return "showCountry";
	}*/
}
