package com.gomes.daniel.ckn.layer.relatorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomes.daniel.ckn.layer.relatorio.domain.model.Diario;
import com.gomes.daniel.ckn.layer.relatorio.domain.model.Mensal;
import com.gomes.daniel.ckn.layer.relatorio.domain.model.Semanal;
import com.gomes.daniel.ckn.layer.relatorio.domain.repository.RelatorioRepositoryImpl;

@RestController
@CrossOrigin
@RequestMapping("/relatorios")
public class RelatorioController {
	
	
	@Autowired
	RelatorioRepositoryImpl relatorioRepositoryImpl;
	
	@GetMapping("/diario")
	public ResponseEntity<List<Diario>> listarDiario(){
			List<Diario> diarios = relatorioRepositoryImpl.listarDiario();
			
			if(diarios != null) {
				return ResponseEntity.ok(diarios);
			}
			
			else {
				return ResponseEntity.notFound().build();
			}
	}
			
			@GetMapping("/semanal")
			public ResponseEntity<List<Semanal>> listarSemanal(){
					List<Semanal> semamais = relatorioRepositoryImpl.listarSemanal();
					
					if(semamais != null) {
						return ResponseEntity.ok(semamais);
					}
					
					else {
						return ResponseEntity.notFound().build();
					}
			}
			
			
			@GetMapping("/mensal")
			public ResponseEntity<List<Mensal>> listarMensal(){
					List<Mensal> mensais = relatorioRepositoryImpl.listarMensal();
							
					if(mensais != null) {
						return ResponseEntity.ok(mensais);
					}
							
					else {
						return ResponseEntity.notFound().build();
					}
				
	}

}
