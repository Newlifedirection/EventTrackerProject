package com.skilldistillery.rides.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
	
	@GetMapping(path = "/")
	public String home() {
		return "index.html";
	}

}
