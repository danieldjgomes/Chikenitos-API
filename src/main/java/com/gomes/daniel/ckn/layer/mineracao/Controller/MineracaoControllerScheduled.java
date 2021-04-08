package com.gomes.daniel.ckn.layer.mineracao.Controller;


import java.io.IOException;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gomes.daniel.ckn.layer.mineracao.Service.MineracaoService;
import com.gomes.daniel.ckn.layer.mineracao.domain.exception.ErroNaColetaException;


@Component
@EnableScheduling
public class MineracaoControllerScheduled {
	
	@Autowired
	MineracaoService mineracaoService;

	//@Scheduled(cron = "0 0 0 * * *") //Diario: 00:00
	@Scheduled(cron = "20 * * * * *") //Diario: 00:00
	public void alimentaPesquisas() {
		System.out.println("Pesquisa realizada: " + LocalDateTime.now());
		mineracaoService.salvar();	
	}
	
	
	//@Scheduled(cron = "20 * * * * *") //Diario: 00:00
	public void teste() {
		String url = "https://www.clubeextra.com.br/produto/344565/chicken-crispy-supreme-seara-300g";
		String classe = ".gallery-modalstyles__Price-sc-1ophit0-5 a";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).timeout(20000).userAgent("Chrome").get();
		} 
		catch (SocketTimeoutException e) {
			 throw new ErroNaColetaException(
			 String.format("Ocorreu um erro na coleta dos dados no mercado"));
		 }
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String out = null;
		Double value = 0.00;
		
		System.out.println(doc.getElementsContainingOwnText("R$").first().text());
		System.out.println(doc.select(classe));
		out = doc.select(classe).first().text();
			try{	
			value = Double.valueOf(out
					.replaceAll("[^0-9]", "")
					)/100;	
		}
		catch (Exception nullException) {
			System.out.println("Null encontrado\n");
		}
		

	}
}
	
