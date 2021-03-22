package com.gomes.daniel.ckn.layer.relatorio.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Mensal extends Relatorio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	long id;
	
	@Column
	double valor;
	
	public Mensal(long id, double valor, int mes, int ano) {
		super();
		this.id = id;
		this.valor = valor;
		this.mes = mes;
		this.ano = ano;
	}

	public Mensal() {
		super();
	}

	@Column
	int mes;
	
	@Column
	int ano;
	
	
}
