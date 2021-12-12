package com.final12.final12subscription.services.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SubscriptionUpdateDTO {
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String fundo;
	
	@NotNull(message="Preenchimento obrigatório")
	private Double preco;
	
	@NotNull(message="Preenchimento obrigatório")
	private Double taxa;
	
	@NotNull(message="Preenchimento obrigatório")
	private Double proporcaoPreferencia;
	
	@NotNull(message="Preenchimento obrigatório")
	private Double proporcaoSobras;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String coordenadorLider;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String emissao;
	
	@NotNull(message="Preenchimento obrigatório")
	private Long etapa;
	
	@NotNull(message="Preenchimento obrigatório")
	private LocalDate dataBase;
	
	@NotNull(message="Preenchimento obrigatório")
	private LocalDate periodoNegociacaoDe;
	
	@NotNull(message="Preenchimento obrigatório")
	private LocalDate periodoNegociacaoAte;
	
	@NotNull(message="Preenchimento obrigatório")
	private LocalDate periodoPreferenciaDe;
	
	@NotNull(message="Preenchimento obrigatório")
	private LocalDate periodoPreferenciaAte;
	
	@NotNull(message="Preenchimento obrigatório")
	private LocalDate periodoSobrasDe;
	
	@NotNull(message="Preenchimento obrigatório")
	private LocalDate periodoSobrasAte;
	
	@NotNull(message="Preenchimento obrigatório")
	private LocalDate periodoPublicoDe;
	
	@NotNull(message="Preenchimento obrigatório")
	private LocalDate periodoPublicoAte;

}
