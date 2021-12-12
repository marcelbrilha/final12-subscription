package com.final12.final12subscription.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.final12.final12subscription.entities.Stage;
import com.final12.final12subscription.entities.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

	Page<Subscription> findByFundo(String fundo, Pageable pageRequest);
	
	Page<Subscription> findByFundoAndEtapa(String fundo, Stage etapa, Pageable pageRequest);
	
	Page<Subscription> findByEtapa(Stage etapa, Pageable pageRequest);
}
