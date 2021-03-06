package com.final12.final12subscription.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.final12.final12subscription.entities.Stage;
import com.final12.final12subscription.exceptions.ObjectNotFoundException;
import com.final12.final12subscription.repositories.StageRepository;
import com.final12.final12subscription.services.StageService;
import com.final12.final12subscription.services.dto.StageDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StageServiceImpl implements StageService {

	@Autowired
	private StageRepository repository;

	@Override
	public List<StageDTO> findAll() {
		log.info("Iniciando a pesquisa de todas as etapas");
		
		List<StageDTO> stagesDTO = new ArrayList<>();
		List<Stage> stages = repository.findAll();

		if (!stages.isEmpty()) {
			stagesDTO = stages.stream().map(stage -> new StageDTO(stage.getId(), stage.getDescricao()))
					.collect(Collectors.toList());
		}

		return stagesDTO;
	}

	@Override
	public Stage findById(Long id) throws Exception {
		log.info("Pesquisando por uma etapa: " + id);
		
		Optional<Stage> stage = repository.findById(id);
		
		return stage.orElseThrow(() -> new ObjectNotFoundException(
				"Etapa não encontrada! Id: " + id));
	}
	
}
