package br.com.avohai.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avohai.model.dto.DadosDoUsuario;
import br.com.avohai.services.TreeService;
import lombok.Getter;

@RestController
@RequestMapping("/tree")
public class TreeResources {

	@Autowired
	@Getter
	private TreeService treeService;

	@PostMapping
	public ResponseEntity<Boolean> salvarDadosDoUsuario(@Valid @RequestBody DadosDoUsuario dadosDoUsuario) {
		return ResponseEntity.ok().body(this.treeService.preparaDadosParaSeremGravados(dadosDoUsuario));
	}
	
	@PutMapping
	public ResponseEntity<Boolean> atualizarDadosDoUsuario(@Valid @RequestBody DadosDoUsuario dadosDoUsuario) {
		return ResponseEntity.ok().body(this.treeService.preparaDadosParaSeremGravados(dadosDoUsuario));
	}

	@GetMapping(value = "/teste")
	public String testeConrado() {
		return "Tudo funcionando!";
	}

}
