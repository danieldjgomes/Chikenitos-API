package com.gomes.daniel.ckn.layer.mineracao.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gomes.daniel.ckn.layer.mineracao.Controller.MineracaoController;
import com.gomes.daniel.ckn.layer.mineracao.domain.infrastructure.MineracaoRepositoryImpl;
import com.gomes.daniel.ckn.layer.mineracao.domain.model.ClubeExtra;
import com.gomes.daniel.ckn.layer.mineracao.domain.model.DamianCenterLar;
import com.gomes.daniel.ckn.layer.mineracao.domain.model.Semar;
import com.gomes.daniel.ckn.layer.mineracao.domain.model.TendaAtacado;

@Component
public class MineracaoService {
	@Autowired
	MineracaoController mineracaoController;
	
	@Autowired
	MineracaoRepositoryImpl mineracaoRepositoryImpl;
	
	
	public void salvar() {
		
		System.out.println("Semar");
		mineracaoController.salvar(mineracaoRepositoryImpl.minerar(new Semar()));
		
		System.out.println("DamianCenterLar");
		mineracaoController.salvar(mineracaoRepositoryImpl.minerar(new DamianCenterLar()));
		
		System.out.println("TendaAtacado");
		mineracaoController.salvar(mineracaoRepositoryImpl.minerar(new TendaAtacado()));

		System.out.println("ClubeExtra");
		mineracaoController.salvar(mineracaoRepositoryImpl.minerar(new ClubeExtra()));
		
		System.out.println("Mineracao Realizada");
	}
	
}
	