package com.final12.final12subscription.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.final12.final12subscription.services.SubscriptionService;
import com.final12.final12subscription.services.dto.EmissionDTO;

@RestController
@RequestMapping(value="/api")
public class EmissionController {
	
	@Autowired
	private SubscriptionService subscritionService;

	@GetMapping(value = "/v1/emissoes")
	public ResponseEntity<Page<EmissionDTO>> findPage(
			@RequestParam(value="fundo", defaultValue="") String fundo,
			@RequestParam(value="etapa", defaultValue="1") Long etapa,
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="fundo") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) throws Exception {
		
		return ResponseEntity.ok().body(subscritionService.findAll(fundo, etapa, page, linesPerPage, orderBy, direction));
	}
}
