package com.final12.final12subscription.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.final12.final12subscription.entities.Subscription;
import com.final12.final12subscription.services.SubscriptionService;
import com.final12.final12subscription.services.dto.SubscriptionNewDTO;
import com.final12.final12subscription.services.dto.SubscriptionUpdateDTO;
import com.final12.final12subscription.web.rest.SubscriptionController;

@RunWith(SpringRunner.class)
@WebMvcTest(SubscriptionController.class)
public class SubscriptionControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	SubscriptionService subscritionService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Before
	public void setup() throws Exception {
		Subscription subscription = new Subscription();
		subscription.setId(1L);
		SubscriptionNewDTO subscriptionNewDTO = getSubscriptionNewDTO();
		
		Mockito.when(subscritionService.create(subscriptionNewDTO)).thenReturn(subscription);
	}

	@Test
	public void findSubscriptionById() throws Exception {
		mockMvc.perform(get("/api/v1/subscricoes/1")).andExpect(status().isOk());
	}
	
	@Test
	public void findSubscription() throws Exception {
		mockMvc.perform(get("/api/v1/subscricoes")).andExpect(status().isOk());
	}
	
	@Test
	public void deleteSubscription() throws Exception {
		mockMvc.perform(delete("/api/v1/subscricoes/1")).andExpect(status().isNoContent());
	}
	
	@Test
	public void createSubscription() throws Exception {
		SubscriptionNewDTO subscriptionNewDTO = getSubscriptionNewDTO();
		
		mockMvc.perform(post("/api/v1/subscricoes").contentType("application/json")
				.content(objectMapper.writeValueAsString(subscriptionNewDTO))).andExpect(status().isCreated());
	}
	
	@Test
	public void updateSubscription() throws Exception {
		SubscriptionUpdateDTO subscriptionUpdateDTO = new SubscriptionUpdateDTO();
		subscriptionUpdateDTO.setCoordenadorLider("Itaú");
		subscriptionUpdateDTO.setDataBase(LocalDate.now());
		subscriptionUpdateDTO.setEmissao("10ª");
		subscriptionUpdateDTO.setEtapa(1L);
		subscriptionUpdateDTO.setFundo("BCFF11");
		subscriptionUpdateDTO.setPeriodoNegociacaoAte(LocalDate.now());
		subscriptionUpdateDTO.setPeriodoNegociacaoDe(LocalDate.now());
		subscriptionUpdateDTO.setPeriodoPreferenciaAte(LocalDate.now());
		subscriptionUpdateDTO.setPeriodoPreferenciaDe(LocalDate.now());
		subscriptionUpdateDTO.setPeriodoPublicoAte(LocalDate.now());
		subscriptionUpdateDTO.setPeriodoPublicoDe(LocalDate.now());
		subscriptionUpdateDTO.setPeriodoSobrasAte(LocalDate.now());
		subscriptionUpdateDTO.setPeriodoSobrasDe(LocalDate.now());
		subscriptionUpdateDTO.setPreco(90.0);
		subscriptionUpdateDTO.setProporcaoPreferencia(50.2);
		subscriptionUpdateDTO.setProporcaoSobras(78.1);
		subscriptionUpdateDTO.setTaxa(1.50);
		
		mockMvc.perform(put("/api/v1/subscricoes/1").contentType("application/json")
				.content(objectMapper.writeValueAsString(subscriptionUpdateDTO))).andExpect(status().isOk());
	}
	
	private SubscriptionNewDTO getSubscriptionNewDTO() {
		SubscriptionNewDTO subscriptionNewDTO = new SubscriptionNewDTO();
		subscriptionNewDTO.setCoordenadorLider("Itaú");
		subscriptionNewDTO.setDataBase(LocalDate.now());
		subscriptionNewDTO.setEmissao("10ª");
		subscriptionNewDTO.setEtapa(1L);
		subscriptionNewDTO.setFundo("BCFF11");
		subscriptionNewDTO.setPeriodoNegociacaoAte(LocalDate.now());
		subscriptionNewDTO.setPeriodoNegociacaoDe(LocalDate.now());
		subscriptionNewDTO.setPeriodoPreferenciaAte(LocalDate.now());
		subscriptionNewDTO.setPeriodoPreferenciaDe(LocalDate.now());
		subscriptionNewDTO.setPeriodoPublicoAte(LocalDate.now());
		subscriptionNewDTO.setPeriodoPublicoDe(LocalDate.now());
		subscriptionNewDTO.setPeriodoSobrasAte(LocalDate.now());
		subscriptionNewDTO.setPeriodoSobrasDe(LocalDate.now());
		subscriptionNewDTO.setPreco(90.0);
		subscriptionNewDTO.setProporcaoPreferencia(50.2);
		subscriptionNewDTO.setProporcaoSobras(78.1);
		subscriptionNewDTO.setTaxa(1.50);
		
		return subscriptionNewDTO;
	}

}
