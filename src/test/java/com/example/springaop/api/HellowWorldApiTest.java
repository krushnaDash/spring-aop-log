package com.example.springaop.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HellowWordApi.class) // This will only load the controller
public class HellowWorldApiTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testHello() throws Exception {
		MvcResult result = mockMvc.perform(get("/v1/hello/").contentType(MediaType.APPLICATION_JSON))

				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is2xxSuccessful())
				.andReturn();
		assertThat(result.getResponse().getContentAsString()).isEqualTo("Welcome to AOP logging");

	}
}
