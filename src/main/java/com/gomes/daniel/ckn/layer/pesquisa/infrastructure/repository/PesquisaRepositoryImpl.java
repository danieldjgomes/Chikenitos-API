package com.gomes.daniel.ckn.layer.pesquisa.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.gomes.daniel.ckn.layer.pesquisa.domain.model.Pesquisa;
import com.gomes.daniel.ckn.layer.pesquisa.domain.repository.PesquisaRepository;


@Component
public class PesquisaRepositoryImpl implements PesquisaRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Pesquisa> listar() {
		return manager.createQuery("from Pesquisa", Pesquisa.class).getResultList();
	}

	@Override
	public Pesquisa buscar(long id) {
		return manager.find(Pesquisa.class, id);
	}

	@Override
	@Transactional
	public Pesquisa salvar(Pesquisa pesquisa) {
		return manager.merge(pesquisa);
	}

	@Override
	@Transactional
	public void remover(long id) {
		Pesquisa pesquisa = buscar(id);
		
		if (pesquisa == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(pesquisa);
		
	}
	

}
