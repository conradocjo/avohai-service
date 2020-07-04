package br.com.avohai.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Person")
public class Person extends BaseModel implements Serializable {

	private static final long serialVersionUID = 7884101404453275960L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "grandFather")
	private GrandParent grandFather;

	@ManyToOne
	@JoinColumn(name = "grandMother")
	private GrandParent grandMother;

	@ManyToOne
	@JoinColumn(name = "greaterGrandFather")
	private GrandParent greaterGrandFather;

	@ManyToOne
	@JoinColumn(name = "greaterGrandMother")
	private GrandParent greaterGrandMother;

	public Person() {

	}

	public Person(String name, GrandParent grandFather, GrandParent grandMother, GrandParent greaterGrandFather,
			GrandParent greaterGrandMother) {

	}
}
