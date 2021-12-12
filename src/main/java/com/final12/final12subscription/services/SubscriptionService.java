package com.final12.final12subscription.services;

import org.springframework.data.domain.Page;

import com.final12.final12subscription.entities.Subscription;
import com.final12.final12subscription.services.dto.EmissionDTO;
import com.final12.final12subscription.services.dto.SubscriptionDTO;
import com.final12.final12subscription.services.dto.SubscriptionNewDTO;
import com.final12.final12subscription.services.dto.SubscriptionUpdateDTO;

public interface SubscriptionService {

	Subscription create(SubscriptionNewDTO subscriptionNewDTO) throws Exception;
	
	Subscription findById(Long id) throws Exception;
	
	void delete(Long id) throws Exception;
	
	Subscription update(Long id, SubscriptionUpdateDTO subscriptionUpdateDTO) throws Exception;
	
	Page<SubscriptionDTO> search(String fundo, Integer page, Integer linesPerPage, String orderBy, String direction);
	
	Page<EmissionDTO> findAll(String fundo, Long etapa, Integer page, Integer linesPerPage, String orderBy, String direction) throws Exception;
}
