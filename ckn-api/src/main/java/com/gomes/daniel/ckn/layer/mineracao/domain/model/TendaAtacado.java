package com.gomes.daniel.ckn.layer.mineracao.domain.model;

import com.gomes.daniel.ckn.layer.pesquisa.domain.model.Mercado;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TendaAtacado extends Site {
	
	private String url;
	private String classeCss;
	private Mercado mercado;
	
	public TendaAtacado() {
		this.url = "https://damiancenterlar.com.br/loja/produto/chikenitos-seara-300g-tradicional-3542/";
		this.classeCss = "span.preco-final";		
		this.mercado = new Mercado(3l,"Damian CenterLar");
	}
	
	

}
