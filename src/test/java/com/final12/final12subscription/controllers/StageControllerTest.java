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

import com.final12.final12subscription.services.StageService;
import com.final12.final12subscription.web.rest.StageController;

@RunWith(SpringRunner.class)
@WebMvcTest(StageController.class)
public class StageControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	StageService stageService;
	
	@Test
	public void findStages() throws Exception {
		mockMvc.perform(get("/api/v1/etapas")).andExpect(status().isOk());
	}
}
