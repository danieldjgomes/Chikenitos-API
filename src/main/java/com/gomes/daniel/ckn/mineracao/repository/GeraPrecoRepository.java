package com.gomes.daniel.ckn.mineracao.repository;

import com.gomes.daniel.ckn.mineracao.domain.model.Site;
import com.gomes.daniel.ckn.mineracao.domain.model.Pesquisa;

import java.util.List;

public interface GeraPrecoRepository {
    List<Site> findSites();
    void save(Pesquisa pesquisa);
}
