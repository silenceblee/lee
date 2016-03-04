package com.app.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录
 * @author master
 *
 */
@Controller
@RequestMapping("/")
public class LoginAction {

	@RequestMapping("login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("loginForward")
	public String loginForward(){
		return "frame";
	}
}
