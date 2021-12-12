package com.final12.final12subscription.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_subscription")
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fundo;
	private Double preco;
	private Double taxa;
	private LocalDate dataBase;
	private Double proporcaoPreferencia;
	private Double proporcaoSobras;
	private String coordenadorLider;
	private String emissao;
	private LocalDate periodoNegociacaoDe;
	private LocalDate periodoNegociacaoAte;
	private LocalDate periodoPreferenciaDe;
	private LocalDate periodoPreferenciaAte;
	private LocalDate periodoSobrasDe;
	private LocalDate periodoSobrasAte;
	private LocalDate periodoPublicoDe;
	private LocalDate periodoPublicoAte;
	
	@ManyToOne
	@JoinColumn(name="etapa_id")
	private Stage etapa;
}
