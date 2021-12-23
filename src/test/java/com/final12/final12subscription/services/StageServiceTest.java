package com.final12.final12subscription.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.final12.final12subscription.entities.Stage;
import com.final12.final12subscription.exceptions.ObjectNotFoundException;
import com.final12.final12subscription.repositories.StageRepository;
import com.final12.final12subscription.services.dto.StageDTO;
import com.final12.final12subscription.services.impl.StageServiceImpl;

@RunWith(SpringRunner.class)
public class StageServiceTest {
	
	@Autowired
	StageService stageService;
	
	@MockBean
	StageRepository stageRepository;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@TestConfiguration
	static class StageServiceTestConfiguration {
		
		@Bean
		public StageService osService() {
			return new StageServiceImpl();
		}
		
	}
	
	@Before
	public void setup() throws Exception {
		List<Stage> listStage = new ArrayList<>();
		Stage stage = new Stage();
		stage.setId(1L);
		stage.setDescricao("Andamento");
		listStage.add(stage);
		
		Mockito.when(stageRepository.findAll()).thenReturn(listStage);
		Mockito.when(stageRepository.findById(1L)).thenReturn(Optional.of(stage));
	}

	@Test
	public void findAllStage() throws Exception {
		List<StageDTO> response = stageService.findAll();
		Assert.assertEquals(response.get(0).getDescricao(), "Andamento");
	}
	
	@Test
	public void findStageById() throws Exception {
		Stage response = stageService.findById(1L);
		Assert.assertEquals(response.getDescricao(), "Andamento");
	}
	
	@Test
	public void findStageByIdThrowObjectNotFoundException() throws Exception {
		Mockito.when(stageRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
		exception.expect(ObjectNotFoundException.class);
		exception.expectMessage("Etapa não encontrada! Id: 1");
		stageService.findById(1L);
	}

}
