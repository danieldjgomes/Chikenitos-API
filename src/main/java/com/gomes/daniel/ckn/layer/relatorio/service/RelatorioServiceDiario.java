package com.gomes.daniel.ckn.layer.relatorio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomes.daniel.ckn.layer.mineracao.domain.model.Pesquisa;
import com.gomes.daniel.ckn.layer.relatorio.domain.model.Diario;
import com.gomes.daniel.ckn.layer.relatorio.domain.repository.RelatorioRepositoryImpl;
import com.gomes.daniel.ckn.layer.relatorio.infrastructure.RelatorioInfrastructure;

@Service
public class RelatorioServiceDiario {


	
	@Autowired
	RelatorioInfrastructure relatorioInfrastructure;
	
	@Autowired
	RelatorioRepositoryImpl relatorioRespositoryImpl;
	
	
	
	public void salvarDiario() {
 
		List<Pesquisa> pesquisas = relatorioInfrastructure.listar();
		
		//List<Diario> totalDiario = new ArrayList<Diario>();
		Long id = relatorioInfrastructure.maiorIdDiario(relatorioRespositoryImpl.listarDiario());
		
		double totalDia = 0;
		int qtdeValores = -1;
		Date data = null;
		
		for (Pesquisa pesquisa: pesquisas) {
			
			if (data == null) {
				data = pesquisa.getData();
			}
			
			if (pesquisa.dateEquals(data)) {
				totalDia += pesquisa.getValor();
				qtdeValores ++;
				//System.out.printf("Id: %d TotalDia: %f qtdeValores: %d  Data: %tD%n",id, totalDia, qtdeValores, data);
			}
			
			else {
				qtdeValores++;
				id++;
				
				//System.out.printf("Novo Diario: %d %f %tD%n \n",id, totalDia/qtdeValores, data);
				relatorioRespositoryImpl.salvar(new Diario(id,totalDia/qtdeValores,data));
				//totalDiario.add(new Diario(id, totalDia/qtdeValores, data));
				
				qtdeValores = 0;
				totalDia = pesquisa.getValor();
				data = pesquisa.getData();
			}

				
			}
				qtdeValores++;
				id++;
				//System.out.printf("Novo Diario: %d %f %tD%n \n",id, totalDia/qtdeValores, data);
				relatorioRespositoryImpl.salvar(new Diario(id,totalDia/qtdeValores,data));
			
			
	}
	
	public void truncarDiario() {
		relatorioRespositoryImpl.truncarDiario();
	}
}
