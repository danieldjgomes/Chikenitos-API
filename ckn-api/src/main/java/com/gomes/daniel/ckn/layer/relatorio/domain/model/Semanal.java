package com.gomes.daniel.ckn.layer.relatorio.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Semanal extends Relatorio {
	
	@Id
	long id;
	
	@Column
	int semana;
	
	@Column
	double valor;

	@Column
	int ano;
	
	public Semanal(long id, double valor, int semana, int ano) {
		super();
		this.id = id;
		this.valor = valor;
		this.semana = semana;
		this.ano = ano;
	}

	public Semanal() {
		super();
	}

}
