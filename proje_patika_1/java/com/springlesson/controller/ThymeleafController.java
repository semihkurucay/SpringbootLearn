package com.springlesson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

@Controller
public class ThymeleafController {
	
	@GetMapping({"/", "index"})
	public String index() {
		return "index";
	}
	
	@GetMapping({"/getId/{id}", "/getId/"})
	public String getIdPathVarible(@PathVariable(name = "id", required = false) Long id, Model model) {
		if(id != null) {
			model.addAttribute("key_model", id);
		}else {
			model.addAttribute("key_model", "Id bulunamamaktadır");
		}
		
		return "getId";
	}
	
	//http://localhost:8080/getId?id=5&name=Hakk%C4%B1Bulut
	@GetMapping({"/getId"})
	public String getIdRequestParam(@RequestParam(name = "id", required = false, defaultValue = "-1") Long id,
									@RequestParam(name = "name") String name,
									Model model) {
		if(id != null) {
			if(id != -1) {
				model.addAttribute("key_model", "Id :" + id + " | Adı : " + name);
			}else {
				model.addAttribute("key_model", "default id : " + id);
			}
			
		}else {
			model.addAttribute("key_model", "Id bulunamamaktadır");
		}
		
		return "getId";
	}
	
	@GetMapping("/thymeleaf1") //url
	//@ResponseBody
	public String getThymeleaf() {
		return "thymeleaf1"; //döncek olan .html dosyası adı
	}
}
