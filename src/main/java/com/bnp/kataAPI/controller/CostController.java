package com.bnp.kataAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CostController {

	@GetMapping("/cost")
	public void cost() {
		return;
	}
}
