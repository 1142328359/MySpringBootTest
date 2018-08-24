package com.ytit.xyx.MySpringBootTest.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
	@RequestMapping(value="/{formName}")
	public String loginForm(String formName){
		// 动态跳转页面
		return formName; 
	}

}
