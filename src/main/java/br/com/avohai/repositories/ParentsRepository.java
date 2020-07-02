package br.com.avohai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avohai.model.Parent;

@Repository
public interface ParentsRepository extends JpaRepository<Parent, Long> {

}
