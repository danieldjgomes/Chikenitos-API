package com.gomes.daniel.ckn.layer.mineracao.domain.infrastructure;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
			 String.format("Ocorreu um erro na coleta dos dados no mercado"));
		 }
		
		catch (IOException e) {
			e.printStackTrace();
		}
			
		Double value = (Double) null;
		Elements elements = null;
		Element element = null;
		String content = null;
		
		
		elements = doc.select(classe);
		
		if (elements != null) {
			element = elements.first();
		}
		
		if (element != null) {
			content = element.text();
		}
		
			
		if (content == null) {
			System.out.println(doc.getElementsContainingOwnText("R$").first().text());
			content = doc.getElementsContainingOwnText("R$").first().text();
			}
		
		
		try{	
			value = Double.valueOf(content
					.replaceAll("[^0-9]", "")
					)/100;	
		}
		catch (Exception nullException) {
			System.out.println("Null encontrado\n");
		}
		
		return new Pesquisa(new Date(System.currentTimeMillis()),mercado,value);
		
	}

	
}
