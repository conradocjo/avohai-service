package br.com.avohai.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "father", nullable = false)
	private String father;

	@Column(name = "mother", nullable = false)
	private String mother;

	public Parent() {

	}

	public Parent(String father, String mother) {
		this.father = father;
		this.mother = mother;
	}

}
