package br.com.avohai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avohai.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {
	
	
	
}
