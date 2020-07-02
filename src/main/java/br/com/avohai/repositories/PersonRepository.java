package br.com.avohai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avohai.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
