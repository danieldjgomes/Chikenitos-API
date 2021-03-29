package com.gomes.daniel.ckn.layer.mineracao.domain.infrastructure;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import com.gomes.daniel.ckn.layer.mineracao.domain.exception.ErroNaColetaException;
import com.gomes.daniel.ckn.layer.mineracao.domain.model.Site;
import com.gomes.daniel.ckn.layer.mineracao.domain.repository.MineracaoRepository;
import com.gomes.daniel.ckn.layer.pesquisa.domain.model.Mercado;
import com.gomes.daniel.ckn.layer.pesquisa.domain.model.Pesquisa;

@Component
public class MineracaoRepositoryImpl implements MineracaoRepository {

	public Pesquisa minerar(Site site) {
		
		String url = site.getUrl();
		String classe = site.getClasseCss();
		Mercado mercado = site.getMercado();
		Document doc = null;
		try {
			doc = Jsoup.connect(url).timeout(20000).userAgent("Chrome").get();
		} 
		catch (SocketTimeoutException e) {
			 throw new ErroNaColetaException(
			 String.format("Ocorreu um erro na coleta dos dados no mercado %s", site.getMercado().getNome()));
		 }
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String out = doc.select(classe)
				.first()
				.text(); 
		
		double a = Double.valueOf(out
				.replaceAll("[^0-9]", "")
				)/100;	


		System.out.println(a);
		
	
		
		return new Pesquisa(new Date(System.currentTimeMillis()),mercado,a);
		
	}

	
}
