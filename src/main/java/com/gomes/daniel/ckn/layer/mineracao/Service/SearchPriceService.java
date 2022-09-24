package com.gomes.daniel.ckn.layer.mineracao.Service;


import com.gomes.daniel.ckn.layer.mineracao.DOMHelper;
import com.gomes.daniel.ckn.layer.mineracao.domain.repository.SearchPriceRepository;
import com.gomes.daniel.ckn.layer.mineracao.domain.model.Site;
import com.gomes.daniel.ckn.layer.mineracao.domain.model.Pesquisa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchPriceService {

    @Autowired
    private SearchPriceRepository searchPriceRepository;

    public void lookForPrice() {
        List<Site> sites = searchPriceRepository.getSites();
        sites.forEach(s -> {
                Pesquisa pesquisa = DOMHelper.searchSite(s);
                searchPriceRepository.save(pesquisa);
        });
    }
}
