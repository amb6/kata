package com.bnp.kataAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class CostControllerTest {
	@Autowired
	MockMvc mockMvc;

	@Test
	public void costTestOk() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/cost").param("title", "title 1").param("title", "title 2"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
