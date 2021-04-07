package com.gomes.daniel.ckn.layer.relatorio.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Diario extends Relatorio {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@EqualsAndHashCode.Include
		long id;
		
		@Column
		@JsonFormat(pattern = "yyyy/MM/dd")
		Date data;
		
		@Column
		double valor;
		
		public Diario(long id, double valor, Date data) {
		this.id = id;
		this.valor = valor;
		this.data = data;
	}

		public Diario() {
			super();
		}
		
}
