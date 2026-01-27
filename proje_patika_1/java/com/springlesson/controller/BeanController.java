package com.springlesson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlesson.bean.BeanConfig;

@Controller
public class BeanController {

	@Autowired
	BeanConfig beanConfig;
	
	@GetMapping("/bean/dto")
	@ResponseBody // html olmadan direk bir şekilde ekranda gösteme
	public String getBeanDto() {
		return beanConfig.beanDto() + ".";
	}
}
