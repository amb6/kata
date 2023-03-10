package com.bnp.kataAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bnp.kataAPI.service.CostService;

@RestController
@RequestMapping("/api")
public class CostController {
	@Autowired
	CostService costService;

	@GetMapping("/cost")
	public float cost(@RequestParam List<String> title) {
		return costService.basketCost(title);
	}
}
