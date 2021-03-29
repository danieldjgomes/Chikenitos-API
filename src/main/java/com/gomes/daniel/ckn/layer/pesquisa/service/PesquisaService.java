package com.gomes.daniel.ckn.layer.pesquisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gomes.daniel.ckn.layer.pesquisa.domain.exception.EntidadeNãoEncontradaException;
import com.gomes.daniel.ckn.layer.pesquisa.domain.model.Pesquisa;
import com.gomes.daniel.ckn.layer.pesquisa.domain.repository.PesquisaRepository;

@Service
public class PesquisaService {
	
	@Autowired
	PesquisaRepository pesquisaRepository;
	
	
	public Pesquisa salvar(Pesquisa pesquisa) {
		return pesquisaRepository.salvar(pesquisa);
	}
	
	public void remover(long id){
		try{
			pesquisaRepository.remover(id);
		}
		catch(EmptyResultDataAccessException e) {
			
			throw new EntidadeNãoEncontradaException(
					String.format("Não existe um cadastro de cozinha com o código %d", id));	
		
	}
	
	}

}
