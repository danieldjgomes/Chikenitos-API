package com.gomes.daniel.ckn.layer.relatorio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService {
	
	@Autowired
	RelatorioServiceDiario serviceDiario;
	
	@Autowired
	RelatorioServiceSemanal serviceSemanal;
	
	@Autowired
	RelatorioServiceMensal serviceMensal;
	
	
	public void salvarDiario() {
		serviceDiario.salvarDiario();
	}
	
	public void truncarDiario() {
		serviceDiario.truncarDiario();
		
	}
	
	
	
	public void salvarSemanal() {
		serviceSemanal.salvarSemanal();
	}
	
	public void truncarSemanal() {
		serviceSemanal.truncarSemanal();
		
	}
	
		
	
	public void salvarMensal() {
		serviceMensal.salvarMensal();
	}
	
	public void truncarMensal() {
		serviceMensal.truncarMensal();
		
	}
	

}
