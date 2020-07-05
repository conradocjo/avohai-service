package br.com.avohai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.avohai.model.GrandParent;
import br.com.avohai.model.enumerators.PaternalMaternalEnum;

public interface GrandParentsRepository extends JpaRepository<GrandParent, Long> {

	@Query(nativeQuery = false, value = "SELECT gp FROM GrandParent gp WHERE gp.paternalMaternalEnum = :paternalMaternalEnum"
			+ " AND upper(grandFatherName) like upper (:grandFatherName) AND  upper(grandMotherName) like upper (:grandMotherName)")
	GrandParent findGrandParentByPartName(@Param("grandFatherName") String grandFatherName,
			@Param("grandMotherName") String grandMotherName,
			@Param("paternalMaternalEnum") PaternalMaternalEnum paternalMaternalEnum);

}
