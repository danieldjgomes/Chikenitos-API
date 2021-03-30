package com.gomes.daniel.ckn.layer.relatorio.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gomes.daniel.ckn.layer.relatorio.service.RelatorioService;

@Component
@EnableScheduling
public class RelatorioControllerScheduled {
	
	@Autowired
	RelatorioService relatorioService;
	
	
	@Scheduled(cron = "0 15 0 * * *") // Diario: 00:15
	public void GeraRelatorioDiario() {
		//relatorioService.truncarDiario();
		System.out.println("Relatorio Diario realizado: " + LocalDateTime.now());
		relatorioService.salvarDiario();
		
	}
	
	
	@Scheduled(cron = " 0 0 1 * * 6")	// Semanal: Sabado 01:00
	public void GeraRelatorioSemanal() {
		System.out.println("Relatorio Semanal realizado: " + LocalDateTime.now());
		relatorioService.salvarSemanal();
		//relatorioService.truncarSemanal();
	}
	
	@Scheduled(cron = "0 0  3 28 * *")	//Mensal: Dia 28 03:00
	public void GeraRelatorioMensal() {
		System.out.println("Relatorio mensal realizado: " + LocalDateTime.now());
		relatorioService.salvarMensal();
		//relatorioService.truncarMensal();
	}

}