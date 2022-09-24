package com.gomes.daniel.ckn.layer.mineracao.domain.repository;

import com.gomes.daniel.ckn.layer.mineracao.domain.model.Site;
import com.gomes.daniel.ckn.layer.mineracao.domain.model.Pesquisa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchPriceRepository {
    List<Site> getSites();
    void save(Pesquisa pesquisa);
}
