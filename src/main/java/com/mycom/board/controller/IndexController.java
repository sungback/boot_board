package com.mycom.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {
	@GetMapping("/")
	public String index() {
		// System.out.println("index 호출!");
		log.info("index 호출!");
		return "index";
	}
}
