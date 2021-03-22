package com.gomes.daniel.ckn.layer.pesquisa.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mercado {


	@Id
	@EqualsAndHashCode.Include
	private long id;
	
	@Column
	private String nome;
	
//	@Column
//	@Enumerated(EnumType.STRING)
//	private Status status;

	
	public Mercado(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Mercado() {
		super();
	}

}
