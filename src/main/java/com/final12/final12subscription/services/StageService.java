package com.final12.final12subscription.services;

import java.util.List;

import com.final12.final12subscription.entities.Stage;
import com.final12.final12subscription.services.dto.StageDTO;

public interface StageService {

	List<StageDTO> findAll();
	
	Stage findById(Long id) throws Exception;
}
