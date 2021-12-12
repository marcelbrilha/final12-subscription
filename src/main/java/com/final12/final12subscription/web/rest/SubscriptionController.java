package com.final12.final12subscription.web.rest;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.final12.final12subscription.entities.Subscription;
import com.final12.final12subscription.services.SubscriptionService;
import com.final12.final12subscription.services.dto.SubscriptionDTO;
import com.final12.final12subscription.services.dto.SubscriptionNewDTO;
import com.final12.final12subscription.services.dto.SubscriptionUpdateDTO;

@RestController
@RequestMapping(value="/api")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService subscritionService;
	
	@GetMapping(value = "/v1/subscricoes/{id}")
	public ResponseEntity<Subscription> find(@PathVariable Long id) throws Exception {
		Subscription subscription = subscritionService.findById(id);
		return ResponseEntity.ok().body(subscription);
	}

	@PostMapping(value = "/v1/subscricoes")
	public ResponseEntity<Void> create(@Valid @RequestBody SubscriptionNewDTO subscriptionNewDTO) throws Exception {
		Subscription subscription = subscritionService.create(subscriptionNewDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(subscription.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/v1/subscricoes/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id) throws Exception  {
		subscritionService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/v1/subscricoes/{id}")
	public ResponseEntity<Subscription> update(@PathVariable Long id, @Valid @RequestBody SubscriptionUpdateDTO subscriptionUpdateDTO) throws Exception {
		Subscription subscription = subscritionService.update(id, subscriptionUpdateDTO);
		return ResponseEntity.ok().body(subscription);
	}
	
	@GetMapping(value = "/v1/subscricoes")
	public ResponseEntity<Page<SubscriptionDTO>> findPage(
			@RequestParam(value="fundo", defaultValue="") String fundo,
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="10") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="fundo") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		
		return ResponseEntity.ok().body(subscritionService.search(fundo, page, linesPerPage, orderBy, direction));
	}
	
}
