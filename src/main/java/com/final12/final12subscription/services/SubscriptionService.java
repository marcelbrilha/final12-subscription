package com.final12.final12subscription.services;

import com.final12.final12subscription.entities.Subscription;
import com.final12.final12subscription.services.dto.SubscriptionNewDTO;
import com.final12.final12subscription.services.dto.SubscriptionUpdateDTO;

public interface SubscriptionService {

	Subscription create(SubscriptionNewDTO subscriptionNewDTO) throws Exception;
	
	Subscription findById(Long id) throws Exception;
	
	void delete(Long id) throws Exception;
	
	Subscription update(Long id, SubscriptionUpdateDTO subscriptionUpdateDTO) throws Exception;
}
