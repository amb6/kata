package com.bnp.kataAPI.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CostService {

	private final int UNIT_COST = 50;

	public float costWithSales(int n) {
		float z;
		z = Math.multiplyExact(n, UNIT_COST);
		switch (n) {
		case 2:
			return (z - (z * 5 / 100));
		case 3:
			return (z - (z * 10 / 100));
		case 4:
			return (z - (z * 20 / 100));
		case 5:
			return (z - (z * 25 / 100));

		default:
			return z;
		}
	}

	public float basketCost(List<String> titles) {
		float total = 0;
		if (!titles.isEmpty()) {
			// Get number of occurrence for each book
			// lets put the number of occurrence in a stored list
			List<Integer> storedBooksOccurrence = new ArrayList<>();

			storedBooksOccurrence
					.add(titles.stream().filter(c -> c.equals("Clean Code")).collect(Collectors.toList()).size());
			storedBooksOccurrence
					.add(titles.stream().filter(c -> c.equals("The Clean Coder")).collect(Collectors.toList()).size());
			storedBooksOccurrence.add(
					titles.stream().filter(c -> c.equals("Clean Architecture")).collect(Collectors.toList()).size());
			storedBooksOccurrence.add(titles.stream().filter(c -> c.equals("Test Driven Development"))
					.collect(Collectors.toList()).size());
			storedBooksOccurrence.add(titles.stream().filter(c -> c.equals("Working Effectively With Legacy Code"))
					.collect(Collectors.toList()).size());
			storedBooksOccurrence = storedBooksOccurrence.stream().sorted().collect(Collectors.toList());
			while (!storedBooksOccurrence.isEmpty()) {

				// remove the empty groups of book
				storedBooksOccurrence.removeIf(e -> e == 0);
				total = total + (storedBooksOccurrence.get(0) * costWithSales(storedBooksOccurrence.size()));
				int minValue = Collections.min(storedBooksOccurrence);
				for (int i = 0; i < storedBooksOccurrence.size(); i++) {
					int newValue = storedBooksOccurrence.get(i) - minValue;
					storedBooksOccurrence.set(i, newValue);

				}
				storedBooksOccurrence.removeIf(e -> e == 0);
			}
		}
		return total;

	}

}
