package com.gomes.daniel.ckn.layer.mineracao.domain.repository;

import java.util.List;

import com.gomes.daniel.ckn.layer.mineracao.domain.model.Pesquisa;

public interface PesquisaRepository {
	
	List<Pesquisa> listar();
	Pesquisa buscar(long id);
	Pesquisa salvar(Pesquisa pesquisa);
	void remover(long id);

}
