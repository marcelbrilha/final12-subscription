package com.final12.final12subscription.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.final12.final12subscription.services.StageService;
import com.final12.final12subscription.services.dto.StageDTO;

@RestController
@RequestMapping(value="/api")
public class StageController {

	@Autowired
	private StageService stageService;
	
	@GetMapping(value="/v1/etapas")
	public ResponseEntity<List<StageDTO>> findAll() {
		List<StageDTO> stages = stageService.findAll();
		return ResponseEntity.ok().body(stages);
	}
}
