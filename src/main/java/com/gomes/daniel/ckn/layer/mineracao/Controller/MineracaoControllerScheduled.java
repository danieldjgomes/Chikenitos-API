package com.gomes.daniel.ckn.layer.mineracao.Controller;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gomes.daniel.ckn.layer.mineracao.Service.MineracaoService;


@Component
@EnableScheduling
public class MineracaoControllerScheduled {
	
	@Autowired
	MineracaoService mineracaoService;

	@Scheduled(cron = "0 0 0 * * *") //Diario: 00:00
	public void alimentaPesquisas() {
		System.out.println("Pesquisa realizada: " + LocalDateTime.now());
		mineracaoService.salvar();	
	}
	
	
	
		

}

	
