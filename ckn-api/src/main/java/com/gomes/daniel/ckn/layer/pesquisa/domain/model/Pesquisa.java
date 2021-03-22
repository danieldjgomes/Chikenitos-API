package com.gomes.daniel.ckn.layer.pesquisa.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pesquisa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long id;
	
	@Column
	@NotNull
	private Date data;
	
	@ManyToOne
	@NotNull
	private Mercado mercado;
	
	@Column
	@NotNull
	private double valor;

	public Pesquisa(Date data, Mercado mercado, double valor) {
		super();
		this.data = data;
		this.mercado = mercado;
		this.valor = valor;
	}

	public Pesquisa() {
		super();
		
	}
	
	public boolean dateEquals(Date date) {
		if (this.data.getYear() 	== date.getYear() &&
			this.data.getMonth()	== date.getMonth()&&
			this.data.getDay()		== date.getDay()) {
			//System.out.println("true");
			return true;
		}
		else {
			//System.out.println("false");
			return false;
		}
	}

	
	
	
}
