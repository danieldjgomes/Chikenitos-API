package com.gomes.daniel.ckn.layer.mineracao.domain.model;

import com.gomes.daniel.ckn.layer.pesquisa.domain.model.Mercado;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Semar extends Site {
	
	private String url;
	private String classeCss;
	private Mercado mercado;
	
	public Semar() {
		this.url = "https://drive.gruposemar.com.br/products/chikenitos-seara-300g-trad-un";
		this.classeCss = "h4.principal";
		this.mercado = new Mercado(1l,"Semar");
	}
	
	

}
