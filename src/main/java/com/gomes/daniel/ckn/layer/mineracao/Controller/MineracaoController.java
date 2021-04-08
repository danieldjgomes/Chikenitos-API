package com.gomes.daniel.ckn.layer.mineracao.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gomes.daniel.ckn.layer.pesquisa.domain.model.Pesquisa;
import com.gomes.daniel.ckn.layer.pesquisa.infrastructure.root.PesquisaRoot;


@Component
public class MineracaoController {
	
	
	@Autowired
	PesquisaRoot pesquisaRoot;
		
	public void salvar(Pesquisa pesquisa) {
		if (pesquisa != null){
			pesquisaRoot.salvar(pesquisa);
		}
		else {
			System.out.println("Erro na mineração\n");
		}
		
		//System.out.println(pesquisa.toString());
		
	}
		

}
