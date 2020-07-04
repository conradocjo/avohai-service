package br.com.avohai.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.avohai.model.Parent;
import br.com.avohai.model.dto.DadosDoUsuario;
import br.com.avohai.repositories.ParentsRepository;
import br.com.avohai.repositories.PersonRepository;
import br.com.avohai.repositories.UsersRepository;
import br.com.avohai.services.TreeServices;
import lombok.Getter;

public class TreeService implements TreeServices {

	@Autowired
	@Getter
	private ParentsRepository parentsRepository;

	@Autowired
	@Getter
	private PersonRepository personRepository;

	@Autowired
	@Getter
	private UsersRepository userRepository;

//	@Override
//	public boolean preparaDadosParaSeremGravados(DadosDoUsuario dadosDoUsuario) {
//		Parent parents = new  
//	}
	
	

}
