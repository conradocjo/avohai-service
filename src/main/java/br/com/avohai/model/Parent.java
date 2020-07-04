package br.com.avohai.model;

import java.io.Serializable;

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
@Table(name = "Parent")
public class Parent extends BaseModel implements Serializable {

	private static final long serialVersionUID = 5784322308423497051L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "father")
	private Person father;

	@ManyToOne
	@JoinColumn(name = "mother")
	private Person mother;

	public Parent() {

	}

	public Parent(Person father, Person mother) {
		this.father = father;
		this.mother = mother;
	}

}
