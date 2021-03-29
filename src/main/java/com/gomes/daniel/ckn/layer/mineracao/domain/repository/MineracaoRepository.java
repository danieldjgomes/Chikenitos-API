package com.gomes.daniel.ckn.layer.mineracao.domain.repository;

import com.gomes.daniel.ckn.layer.mineracao.domain.model.Site;
import com.gomes.daniel.ckn.layer.pesquisa.domain.model.Pesquisa;

public interface MineracaoRepository {
	
	Pesquisa minerar(Site site);
}
