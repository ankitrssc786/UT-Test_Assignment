package com.pth.ci.test.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pth.ci.controller.DemoController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DemoController.class)
public class DemoTestController {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test_saveData() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/saveData")
				.accept(MediaType.APPLICATION_JSON).param("val", "200").contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());

		JSONAssert.assertEquals("CSV File written successfully all at a time", "200", String.valueOf(result.getResponse().getStatus()), true);
	}
}
