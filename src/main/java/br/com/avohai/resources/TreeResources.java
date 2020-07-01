package br.com.avohai.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tree")
public class TreeResources {

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public String testeConrado() {
		return "Tudo funcionando!";
	}
}
