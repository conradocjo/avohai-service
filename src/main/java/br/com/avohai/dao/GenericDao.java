package br.com.avohai.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Getter;

public class GenericDao<T> {

	
	/**
	 * Entity Manager provê um meio de interação com banco de dados.
	 * abaixo uso o lombok para implementação ficar mais limpa.
	 * */
	@Getter
	@PersistenceContext
	private EntityManager entityManager;

}
