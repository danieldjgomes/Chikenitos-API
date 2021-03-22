package com.gomes.daniel.ckn.layer.pesquisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gomes.daniel.ckn.layer.pesquisa.domain.exception.EntidadeNãoEncontradaException;
import com.gomes.daniel.ckn.layer.pesquisa.domain.model.Pesquisa;
import com.gomes.daniel.ckn.layer.pesquisa.infrastructure.root.PesquisaRoot;
import com.gomes.daniel.ckn.layer.relatorio.domain.model.Relatorio;

@RestController
@RequestMapping("/pesquisas")
public class PesquisaController {
	
	@Autowired
	PesquisaRoot pesquisaRoot;
	
	@GetMapping
	public ResponseEntity<List<Pesquisa>> listar(){
		List<Pesquisa> pesquisas = pesquisaRoot.listar();
		if (pesquisas != null)
			return ResponseEntity.ok(pesquisas);
		return ResponseEntity.notFound().build();
	}
	@GetMapping("/{pesquisaId}")
	public ResponseEntity<Pesquisa> buscar(@PathVariable long pesquisaId){
		Pesquisa pesquisa = pesquisaRoot.buscar(pesquisaId);
		if (pesquisa != null) {
			return ResponseEntity.ok(pesquisa);
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pesquisa salvar(@RequestBody Pesquisa pesquisa){
		return pesquisaRoot.salvar(pesquisa);
	}
	@DeleteMapping(("/{pesquisaId}"))
	public ResponseEntity<Pesquisa> remover(@PathVariable long pesquisaId) {
		try {
			pesquisaRoot.remover(pesquisaId);
		}
		catch(EntidadeNãoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	

}
