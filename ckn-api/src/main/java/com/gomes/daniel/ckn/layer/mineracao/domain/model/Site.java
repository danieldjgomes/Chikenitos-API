package com.gomes.daniel.ckn.layer.mineracao.domain.model;

import com.gomes.daniel.ckn.layer.pesquisa.domain.model.Mercado;

import lombok.Data;

@Data
public class Site {
	
	private String url;
	private String classeCss;
	private Mercado mercado;
	

}
