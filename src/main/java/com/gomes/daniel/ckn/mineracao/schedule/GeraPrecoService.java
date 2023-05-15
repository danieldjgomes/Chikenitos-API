package com.gomes.daniel.ckn.mineracao.schedule;

import com.gomes.daniel.ckn.mineracao.domain.ErroNaColetaException;
import com.gomes.daniel.ckn.mineracao.domain.model.Pesquisa;
import com.gomes.daniel.ckn.mineracao.domain.model.Site;
import com.gomes.daniel.ckn.mineracao.repository.GeraPrecoRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;

@Service
@RequiredArgsConstructor
public class GeraPrecoService {

    private final GeraPrecoRepository geraPrecoRepository;

    public void pesquisarPreco() {
        geraPrecoRepository.findSites().forEach(this::salvar);
    }

    private void salvar(Site s) {
        Pesquisa pesquisa;
        try {
            pesquisa = pesquisarPreco(s);
        } catch (ErroNaColetaException e) {
            throw new RuntimeException(e);
        }
        geraPrecoRepository.save(pesquisa);
    }


    public Pesquisa pesquisarPreco(Site site) throws ErroNaColetaException {

        String classe = site.getPattern().getClasseCSS();
        Document doc = null;
        try {
            String url = site.getPattern().getUrl();
            doc = Jsoup.connect(url).timeout(20000).userAgent("Chrome").get();
        } catch (SocketTimeoutException e) {
            throw new ErroNaColetaException("Ocorreu um erro na coleta dos dados no site " + site.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements elements;
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

        BigDecimal valor = new BigDecimal(content.replaceAll("[^0-9]", "")).movePointLeft(2);

        return Pesquisa.builder()
                .preco(valor)
                .idSite(site.getId())
                .build();

    }

}
