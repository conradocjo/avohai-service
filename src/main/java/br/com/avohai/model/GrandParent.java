package br.com.avohai.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.avohai.model.enumerators.PaternalMaternalEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "GrandParent")
public class GrandParent implements Serializable {

	private static final long serialVersionUID = 8926858711463154015L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grandfather")
	private List<Person> grandFather;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grandmother")
	private List<Person> grandMother;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "greatergrandfather")
	private List<Person> greaterGrandFather;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "greatergrandmother")
	private List<Person> greaterGrandMother;

	@Column(name = "paternalMaternal", length = 8)
	@Enumerated(EnumType.STRING)
	private PaternalMaternalEnum paternalMaternalEnum;

}
