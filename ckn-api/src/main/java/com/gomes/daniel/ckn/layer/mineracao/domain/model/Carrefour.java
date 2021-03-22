package com.gomes.daniel.ckn.layer.mineracao.domain.model;

import com.gomes.daniel.ckn.layer.pesquisa.domain.model.Mercado;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Carrefour extends Site {
	
	private String url;
	private String classeCss;
	private Mercado mercado;
	
	public Carrefour() {
		this.url = "https://mercado.carrefour.com.br/nuggets-de-frango-tradicional-sadia-300g-4496914/p";
		this.classeCss = "span.vtex-product-price-1-x-currencyContainer";
		this.mercado = new Mercado(1l,"Carrefour");
	}
	
	

}
