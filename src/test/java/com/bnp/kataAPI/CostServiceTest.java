package com.bnp.kataAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bnp.kataAPI.service.CostService;

@SpringBootTest
public class CostServiceTest {

	@Autowired
	CostService costService;

	@Test
	void CostServiceTestNoSales() {
		List<String> list = new ArrayList<>();
		list.add("Clean Code");
		list.add("Clean Code");
		assertEquals(costService.basketCost(list), 100);
	}

	@Test
	void CostServiceTestFirstSales() {
		List<String> list = new ArrayList<>();
		list.add("Clean Code");
		list.add("The Clean Coder");
		assertEquals(costService.basketCost(list), 95);
	}
	@Test
	void CostServiceTestSecondSales() {
		List<String> list = new ArrayList<>();
		list.add("Clean Code");
		list.add("The Clean Coder");
		list.add("Clean Architecture");
		assertEquals(costService.basketCost(list), 135);
	}
	@Test
	void CostServiceTestFourthSales() {
		List<String> list = new ArrayList<>();
		list.add("Clean Code");
		list.add("The Clean Coder");
		list.add("Clean Architecture");
		list.add("Test Driven Development");
		assertEquals(costService.basketCost(list), 160);
	}
	@Test
	void CostServiceTestGoldSales() {
		List<String> list = new ArrayList<>();
		list.add("Clean Code");
		list.add("The Clean Coder");
		list.add("Clean Architecture");
		list.add("Test Driven Development");
		list.add("Working Effectively With Legacy Code");
		assertEquals(costService.basketCost(list), 187.5);
	}
}
