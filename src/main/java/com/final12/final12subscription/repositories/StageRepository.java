package com.final12.final12subscription.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.final12.final12subscription.entities.Stage;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {

}
