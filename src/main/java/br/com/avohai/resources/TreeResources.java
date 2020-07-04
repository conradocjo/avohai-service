package br.com.avohai.resources;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avohai.model.dto.DadosDoUsuario;

@RestController
@RequestMapping("/tree")
public class TreeResources {

	@GetMapping(value = "/teste")
	public String testeConrado() {
		return "Tudo funcionando!";
	}

	@PostMapping
	public boolean salvarDadosDoUsuario(@Valid @RequestBody DadosDoUsuario dadosDoUsuario) {
		System.out.println(dadosDoUsuario);
		return true;
	}

}
