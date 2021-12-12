package com.final12.final12subscription.services.dto;

import com.final12.final12subscription.entities.Subscription;

import lombok.Data;

@Data
public class SubscriptionDTO {
	
	private Long id;
	private String fundo;
	private String emissao;
	private String etapa;
	
	public SubscriptionDTO(Subscription subscription) {
		id = subscription.getId();
		fundo = subscription.getFundo();
		emissao = subscription.getEmissao();
		etapa = subscription.getEtapa().getDescricao();
	}

}
