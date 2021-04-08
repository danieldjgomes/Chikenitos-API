package com.gomes.daniel.ckn;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gomes.daniel.ckn.layer.mineracao.domain.exception.ErroNaColetaException;
import com.gomes.daniel.ckn.layer.pesquisa.domain.model.Mercado;

@SpringBootApplication
public class CknApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CknApiApplication.class, args);
		
		

}
}
