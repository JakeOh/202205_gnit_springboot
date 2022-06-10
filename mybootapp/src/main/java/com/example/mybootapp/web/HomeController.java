package com.example.mybootapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		log.info("index() 호출...");
		return "index";
	}
	
	@GetMapping("/save")
	public String save() {
		log.info("save() GET 호출...");
		return "post_save";
	}
	
}
