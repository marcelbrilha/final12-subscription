package com.final12.final12subscription.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.final12.final12subscription.entities.Stage;
import com.final12.final12subscription.entities.Subscription;
import com.final12.final12subscription.exceptions.ObjectNotFoundException;
import com.final12.final12subscription.repositories.SubscriptionRepository;
import com.final12.final12subscription.services.dto.EmissionDTO;
import com.final12.final12subscription.services.dto.SubscriptionDTO;
import com.final12.final12subscription.services.dto.SubscriptionNewDTO;
import com.final12.final12subscription.services.dto.SubscriptionUpdateDTO;
import com.final12.final12subscription.services.impl.SubscriptionServiceImpl;

@RunWith(SpringRunner.class)
public class SubscriptionServiceTest {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@MockBean
	SubscriptionRepository subscriptionRepository;
	
	@MockBean
	StageService stageService;
	
	@MockBean
	ModelMapper modelMapper;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@TestConfiguration
	static class SubscriptionServiceTestConfiguration {
		
		@Bean
		public SubscriptionService osService() {
			return new SubscriptionServiceImpl();
		}
		
	}
	
	@Test
	public void removeSubscription() throws Exception {
		Subscription subscription = new Subscription();
		Mockito.when(subscriptionRepository.findById(1L)).thenReturn(Optional.of(subscription));
		subscriptionService.delete(1L);
	}
	
	@Test
	public void createSubscription() throws Exception {
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
		
		Subscription subscriptionRequest = new Subscription();
		Subscription subscriptionResponse = new Subscription();
		subscriptionResponse.setFundo("BCFF11");
		
		Mockito.when(modelMapper.map(subscriptionNewDTO, Subscription.class)).thenReturn(subscriptionRequest);
		Mockito.when(stageService.findById(subscriptionNewDTO.getEtapa())).thenReturn(new Stage());
		Mockito.when(subscriptionRepository.save(subscriptionRequest)).thenReturn(subscriptionResponse);
		
		Subscription response = subscriptionService.create(subscriptionNewDTO);
		Assert.assertEquals(response.getFundo(), "BCFF11");
	}
	
	@Test
	public void findSubscriptionByIdThrowObjectNotFoundException() throws Exception {
		Mockito.when(subscriptionRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
		exception.expect(ObjectNotFoundException.class);
		exception.expectMessage("Subscrição não encontrada! Id: 1");
		subscriptionService.findById(1L);
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
		
		Subscription subscriptionRequest = new Subscription();
		Subscription subscriptionResponse = new Subscription();
		subscriptionResponse.setFundo("BCFF11");
		
		Mockito.when(subscriptionRepository.findById(1L)).thenReturn(Optional.of(new Subscription()));
		Mockito.when(modelMapper.map(subscriptionUpdateDTO, Subscription.class)).thenReturn(subscriptionRequest);
		Mockito.when(stageService.findById(subscriptionUpdateDTO.getEtapa())).thenReturn(new Stage());
		Mockito.when(subscriptionRepository.save(subscriptionRequest)).thenReturn(subscriptionResponse);
		
		Subscription response = subscriptionService.update(1L, subscriptionUpdateDTO);
		Assert.assertEquals(response.getFundo(), "BCFF11");
	}
	
	@Test
	public void searchSubscription() throws Exception {
		List<Subscription> subscriptions = new ArrayList<>();
		Stage stage = new Stage();
		Subscription subscription = new Subscription();
		subscription.setFundo("BCFF11");
		subscription.setEtapa(stage);
		subscriptions.add(subscription);
		
		PageRequest pageRequest = PageRequest.of(1, 5, Direction.valueOf("ASC"), "fundo");
		Page<Subscription> pageSubscripion = new PageImpl<Subscription>(subscriptions);
		
		Mockito.when(subscriptionRepository.findAll(pageRequest)).thenReturn(pageSubscripion);
		
		Page<SubscriptionDTO> response = subscriptionService.search(null, 1, 5, "fundo", "ASC");
		Assert.assertEquals(response.getNumberOfElements(), 1);
	}
	
	@Test
	public void searchSubscriptionByFund() throws Exception {
		List<Subscription> subscriptions = new ArrayList<>();
		Stage stage = new Stage();
		Subscription subscription = new Subscription();
		subscription.setFundo("BCFF11");
		subscription.setEtapa(stage);
		subscriptions.add(subscription);
		
		PageRequest pageRequest = PageRequest.of(1, 5, Direction.valueOf("ASC"), "fundo");
		Page<Subscription> pageSubscripion = new PageImpl<Subscription>(subscriptions);
		
		Mockito.when(subscriptionRepository.findByFundo("BCFF11", pageRequest)).thenReturn(pageSubscripion);
		
		Page<SubscriptionDTO> response = subscriptionService.search("BCFF11", 1, 5, "fundo", "ASC");
		Assert.assertEquals(response.getNumberOfElements(), 1);
	}
	
	@Test
	public void findEmission() throws Exception {
		List<Subscription> subscriptions = new ArrayList<>();
		Stage stage = new Stage();
		Subscription subscription = new Subscription();
		subscription.setFundo("BCFF11");
		subscription.setEtapa(stage);
		subscriptions.add(subscription);
		
		PageRequest pageRequest = PageRequest.of(1, 5, Direction.valueOf("ASC"), "fundo");
		Page<Subscription> pageSubscripion = new PageImpl<Subscription>(subscriptions);
		
		Mockito.when(stageService.findById(1L)).thenReturn(stage);
		Mockito.when(subscriptionRepository.findByEtapa(stage, pageRequest)).thenReturn(pageSubscripion);
		
		Page<EmissionDTO> response = subscriptionService.findAll(null, 1L, 1, 5, "fundo", "ASC");
		Assert.assertEquals(response.getNumberOfElements(), 1);
	}
	
	@Test
	public void findEmissionByFund() throws Exception {
		List<Subscription> subscriptions = new ArrayList<>();
		Stage stage = new Stage();
		Subscription subscription = new Subscription();
		subscription.setFundo("BCFF11");
		subscription.setEtapa(stage);
		subscriptions.add(subscription);
		
		PageRequest pageRequest = PageRequest.of(1, 5, Direction.valueOf("ASC"), "fundo");
		Page<Subscription> pageSubscripion = new PageImpl<Subscription>(subscriptions);
		
		Mockito.when(stageService.findById(1L)).thenReturn(stage);
		Mockito.when(subscriptionRepository.findByFundoAndEtapa("BCFF11", stage, pageRequest)).thenReturn(pageSubscripion);
		
		Page<EmissionDTO> response = subscriptionService.findAll("BCFF11", 1L, 1, 5, "fundo", "ASC");
		Assert.assertEquals(response.getNumberOfElements(), 1);
	}
}
