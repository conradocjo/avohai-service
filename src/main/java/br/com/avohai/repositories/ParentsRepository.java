package br.com.avohai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.avohai.model.Parent;

@Repository
public interface ParentsRepository extends JpaRepository<Parent, Long> {

	@Query(nativeQuery = false, value = "SELECT p FROM Parent p WHERE upper(p.father) "
			+ "like upper(:fatherName) AND upper(p.mother) like (:motherName) ")
	Parent findParentByPartName(@Param("fatherName") String fatherName, @Param("motherName") String motherName);

}
