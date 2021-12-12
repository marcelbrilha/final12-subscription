package com.final12.final12subscription.services.dto;

import java.time.LocalDate;

import com.final12.final12subscription.entities.Subscription;

import lombok.Data;

@Data
public class EmissionDTO {

	private String fundo;
	private Double preco;
	private Double taxa;
	private LocalDate dataBase;
	private LocalDate periodoNegociacaoDe;
	private LocalDate periodoNegociacaoAte;
	private LocalDate periodoPreferenciaDe;
	private LocalDate periodoPreferenciaAte;
	private String etapa;
	private LocalDate periodoSobrasDe;
	private LocalDate periodoSobrasAte;
	private LocalDate periodoPublicoDe;
	private LocalDate periodoPublicoAte;
	private Double proporcaoPreferencia;
	private Double proporcaoSobras;
	private String coordenadorLider;
	
	public EmissionDTO(Subscription subscription) {
		fundo = subscription.getFundo();
		preco = subscription.getPreco();
		taxa = subscription.getTaxa();
		dataBase = subscription.getDataBase();
		periodoNegociacaoDe = subscription.getPeriodoNegociacaoDe();
		periodoNegociacaoAte = subscription.getPeriodoNegociacaoAte();
		periodoPreferenciaDe = subscription.getPeriodoPreferenciaDe();
		periodoPreferenciaAte = subscription.getPeriodoPreferenciaAte();
		etapa = subscription.getEtapa().getDescricao();
		periodoSobrasDe = subscription.getPeriodoSobrasDe();
		periodoSobrasAte = subscription.getPeriodoSobrasAte();
		periodoPublicoDe = subscription.getPeriodoPublicoDe();
		periodoPublicoAte = subscription.getPeriodoPublicoAte();
		proporcaoPreferencia = subscription.getProporcaoPreferencia();
		proporcaoSobras = subscription.getProporcaoSobras();
		coordenadorLider = subscription.getCoordenadorLider();
	}
}
