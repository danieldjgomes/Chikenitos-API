package com.gomes.daniel.ckn.layer.pesquisa.infrastructure.root;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gomes.daniel.ckn.layer.pesquisa.domain.model.Pesquisa;
import com.gomes.daniel.ckn.layer.pesquisa.infrastructure.repository.PesquisaRepositoryImpl;
import com.gomes.daniel.ckn.layer.pesquisa.service.PesquisaService;

@Component
public class PesquisaRoot {
	
	@Autowired
	PesquisaRepositoryImpl pesquisaRepository;
	@Autowired
	PesquisaService pesquisaService;
	
	public List<Pesquisa> listar(){
		return pesquisaRepository.listar();
	}
	
	public Pesquisa buscar(long id) {
		return pesquisaRepository.buscar(id);
	}
	
	public Pesquisa salvar(Pesquisa pesquisa) {
		return pesquisaService.salvar(pesquisa);
	}
	
	public void remover(long id) {
		pesquisaService.remover(id);
	}
	

}
