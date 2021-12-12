package com.final12.final12subscription.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.final12.final12subscription.entities.Stage;
import com.final12.final12subscription.entities.Subscription;
import com.final12.final12subscription.exceptions.ObjectNotFoundException;
import com.final12.final12subscription.repositories.SubscriptionRepository;
import com.final12.final12subscription.services.StageService;
import com.final12.final12subscription.services.SubscriptionService;
import com.final12.final12subscription.services.dto.SubscriptionNewDTO;
import com.final12.final12subscription.services.dto.SubscriptionUpdateDTO;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private StageService stageService;
	
	@Override
	public Subscription create(SubscriptionNewDTO subscriptionNewDTO) throws Exception {
		Subscription subscription = this.modelMapper.map(subscriptionNewDTO, Subscription.class);
		Stage stage = stageService.findById(subscriptionNewDTO.getEtapa());
		subscription.setEtapa(stage);
		
		return subscriptionRepository.save(subscription);
	}

	@Override
	public Subscription findById(Long id) throws Exception {
		Optional<Subscription> subscription = subscriptionRepository.findById(id);
		
		return subscription.orElseThrow(() -> new ObjectNotFoundException(
				"Subscrição não encontrada! Id: " + id));
	}

	@Override
	public void delete(Long id) throws Exception {
		Subscription subscription = findById(id);
		subscriptionRepository.delete(subscription);
	}

	@Override
	public Subscription update(Long id, SubscriptionUpdateDTO subscriptionUpdateDTO) throws Exception {
		Subscription subscription = findById(id);
		Subscription subscriptionUpdate = this.modelMapper.map(subscriptionUpdateDTO, Subscription.class);
		Stage stage = stageService.findById(subscriptionUpdateDTO.getEtapa());
		
		subscriptionUpdate.setId(subscription.getId());
		subscriptionUpdate.setEtapa(stage);
		
		return subscriptionRepository.save(subscriptionUpdate);
	}

}
