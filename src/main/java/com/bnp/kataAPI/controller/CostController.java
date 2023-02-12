package com.bnp.kataAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CostController {

	@GetMapping("/cost")
	public String cost(@RequestParam List<String> title) {
		return title.get(0);
	}
}
