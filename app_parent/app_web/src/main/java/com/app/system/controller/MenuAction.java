package com.app.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 菜单
 * @author master
 *
 */
@Controller
public class MenuAction {
	
	@RequestMapping("/menu.do")
	public String forward(String path){
		return path;
	}
}
