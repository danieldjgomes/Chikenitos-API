package com.gomes.daniel.ckn.layer.relatorio.infrastructure;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gomes.daniel.ckn.layer.mineracao.domain.model.Pesquisa;
import com.gomes.daniel.ckn.layer.pesquisa.infrastructure.root.PesquisaRoot;
import com.gomes.daniel.ckn.layer.relatorio.domain.model.Diario;
import com.gomes.daniel.ckn.layer.relatorio.domain.model.Mensal;
import com.gomes.daniel.ckn.layer.relatorio.domain.model.Relatorio;
import com.gomes.daniel.ckn.layer.relatorio.domain.model.Semanal;
@Component
public class RelatorioInfrastructure {
	
	@Autowired
	PesquisaRoot pesquisaRoot;
	
	public List<Pesquisa> listar() {
		return pesquisaRoot.listar();
	}

	public Long maiorIdDiario(List<Diario> listaDiario) {
		
		List<Diario> diarios = listaDiario;
		Long maxId = 0L;
		for (Relatorio diario: diarios) {
			
			if(diario.getId()	> maxId) {
				maxId = diario.getId();
			}
			
		}
		return maxId;
	}
	
	
	public Long maiorIdSemanal(List<Semanal> listaSemanal) {
		List<Semanal> semanais = listaSemanal;
		Long maxId = 0L;
		for (Semanal semanal: semanais) {
			
			if(semanal.getId()	> maxId) {
				maxId = semanal.getId();
			}
		}
		return maxId;
	}
	
	public Long maiorIdMensal(List<Mensal> listaMensal) {
		List<Mensal> mensais = listaMensal;
		Long maxId = 0L;
		for (Mensal mensal: mensais) {
			
			if(mensal.getId()	> maxId) {
				maxId = mensal.getId();
			}
		}
		return maxId;
	}
	
	public int pegarSemana(Date date) {
		 Calendar cl = Calendar. getInstance();
	      cl.setTime(date);  
	      return cl.get(Calendar.WEEK_OF_YEAR);
	}
}
