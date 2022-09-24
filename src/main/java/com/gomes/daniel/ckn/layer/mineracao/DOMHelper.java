package com.gomes.daniel.ckn.layer.mineracao;

import com.gomes.daniel.ckn.layer.mineracao.domain.exception.ErroNaColetaException;
import com.gomes.daniel.ckn.layer.mineracao.domain.model.Pattern;
import com.gomes.daniel.ckn.layer.mineracao.domain.model.Site;
import com.gomes.daniel.ckn.layer.mineracao.domain.model.Mercado;
import com.gomes.daniel.ckn.layer.mineracao.domain.model.Pesquisa;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Date;

public class DOMHelper {

    public static Pesquisa searchSite(Site site) {

        Pattern classe = site.getPattern();
        Mercado mercado = site.getMercado();
        Document doc = null;
        try {
            doc = Jsoup.connect(site.getUrl()).timeout(20000).userAgent("Chrome").get();
        }
        catch (SocketTimeoutException e) {
            throw new ErroNaColetaException(
                    String.format("Ocorreu um erro na coleta dos dados no mercado"));
        }

        catch (IOException e) {
            e.printStackTrace();
        }

//        Double value = (Double) null;
//        Elements elements = null;
//        Element element = null;
//        String content = null;
//
//
//        elements = doc.select(classe);
//
//        if (elements != null) {
//            element = elements.first();
//        }
//
//        if (element != null) {
//            content = element.text();
//        }


//        if (content == null) {
//            System.out.println(doc.getElementsContainingOwnText("R$").first().text());
//            content = doc.getElementsContainingOwnText("R$").first().text();
//        }
//
//
//        try{
//            value = Double.valueOf(content
//                    .replaceAll("[^0-9]", "")
//            )/100;
//        }
//        catch (Exception nullException) {
//            System.out.println("Valor não encontrado!\n");
//        }

        return new Pesquisa(new Date(System.currentTimeMillis()),mercado,0.0);

    }

}
