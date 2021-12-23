package com.final12.final12subscription.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.final12.final12subscription.services.SubscriptionService;
import com.final12.final12subscription.web.rest.EmissionController;

@RunWith(SpringRunner.class)
@WebMvcTest(EmissionController.class)
public class EmissionControllerTest {
	
	@Autowired
	MockMvc mockMvc;

	@MockBean
	SubscriptionService subscritionService;
	
	@Test
	public void findEmission() throws Exception {
		mockMvc.perform(get("/api/v1/emissoes")).andExpect(status().isOk());
	}

}
