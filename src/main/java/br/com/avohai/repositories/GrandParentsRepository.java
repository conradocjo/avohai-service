package br.com.avohai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avohai.model.GrandParent;

public interface GrandParentsRepository extends JpaRepository<GrandParent, Long> {

}
