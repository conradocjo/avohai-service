package br.com.avohai.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avohai.model.dto.DadosDoUsuario;
import br.com.avohai.repositories.UsersRepository;
import br.com.avohai.services.TreeService;
import lombok.Getter;

@RestController
@RequestMapping("/user")
public class UserResources {

	@Autowired
	@Getter
	private UsersRepository usersRepository;

	@Autowired
	@Getter
	private TreeService treeService;

	@GetMapping(value = "/buscaUsuarioPeloCpf/{cpf}")
	public ResponseEntity<DadosDoUsuario> buscaUsuarioPeloCpf(@PathVariable String cpf) {
		return ResponseEntity.status(HttpStatus.OK).body(this.treeService.buscarUsuarioCompletoPorCpf(cpf));
	}

	@GetMapping(value = "/verificaSeUsuarioExiste/{cpf}")
	public ResponseEntity<Boolean> verificaSeUsuarioExiste(@PathVariable String cpf) {
		return ResponseEntity.status(HttpStatus.OK).body(this.usersRepository.findUserByCpf(cpf) != null);
	}

}
