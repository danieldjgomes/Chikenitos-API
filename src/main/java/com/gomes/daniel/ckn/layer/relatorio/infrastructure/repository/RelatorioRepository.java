package com.gomes.daniel.ckn.layer.relatorio.infrastructure.repository;

import java.util.List;

import com.gomes.daniel.ckn.layer.relatorio.domain.model.Diario;
import com.gomes.daniel.ckn.layer.relatorio.domain.model.Mensal;
import com.gomes.daniel.ckn.layer.relatorio.domain.model.Semanal;

public interface RelatorioRepository {
	
	
	List<Diario> listarDiario();
	Diario salvar(Diario diario);
	void truncarDiario();
	
	List<Semanal> listarSemanal();
	Semanal salvar(Semanal semanal);
	void truncarSemanal();
	
	List<Mensal> listarMensal();
	Mensal salvar(Mensal mensal);
	void truncarMensal();
	

}
