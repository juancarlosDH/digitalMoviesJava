package com.dh.jc.Primero.JC1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index()
	{	
		return "main";
	}
	
	@GetMapping("/test")
	public String test(Model model)
	{
		model.addAttribute("name", "JC");
		return "test";
	}
	
}
