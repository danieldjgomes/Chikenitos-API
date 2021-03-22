package com.gomes.daniel.ckn.layer.relatorio.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.gomes.daniel.ckn.layer.relatorio.domain.model.Diario;
import com.gomes.daniel.ckn.layer.relatorio.domain.model.Mensal;
import com.gomes.daniel.ckn.layer.relatorio.domain.model.Semanal;
import com.gomes.daniel.ckn.layer.relatorio.infrastructure.repository.RelatorioRepository;

@Component
public class RelatorioRepositoryImpl implements RelatorioRepository {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Diario> listarDiario() {
		return manager.createNativeQuery("select * from diario order by id desc limit 100 ", Diario.class).getResultList();
	}
	
	@Override
	@Transactional
	public Diario salvar(Diario diario) {
		System.out.println(diario.toString());
		return manager.merge(diario);
	}
	
	@Override
	@Transactional
	public void truncarDiario() {
		manager.createNativeQuery("truncate table diario").executeUpdate();
		
	}
	

	@Override
	public List<Semanal> listarSemanal() {
		return manager.createNativeQuery("select * from semanal order by id desc limit 52", Semanal.class).getResultList();
		
	}
	@Override
	@Transactional
	public Semanal salvar(Semanal semanal) {
		System.out.println(semanal.toString());
		return manager.merge(semanal);
	}
	
	@Override
	@Transactional
	public void truncarSemanal() {
		manager.createNativeQuery("truncate table semanal").executeUpdate();
		
	}
	

	@Override
	public List<Mensal> listarMensal() {
		return manager.createNativeQuery("select * from mensal order by id desc limit 36", Mensal.class).getResultList();
	}

	@Override
	@Transactional
	public Mensal salvar(Mensal mensal) {
		System.out.println(mensal.toString());
		return manager.merge(mensal);
	}
	
	@Override
	@Transactional
	public void truncarMensal() {
		manager.createNativeQuery("truncate table mensal").executeUpdate();
		
	}

	

}
