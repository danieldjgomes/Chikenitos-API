package com.gomes.daniel.ckn.layer.mineracao.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DamianCenterLar extends Site {
	
	private String url;
	private String classeCss;
	private Mercado mercado;
	
	public DamianCenterLar() {
		this.url = "https://www.tendaatacado.com.br/produto/chikenitos-tradicional-turma-da-monica-300g-1667";
		this.classeCss = "span.price-txt";		
		this.mercado = new Mercado(2l,"TendaAtacado");
	}
	
	

}
