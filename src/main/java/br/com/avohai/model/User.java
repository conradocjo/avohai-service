package br.com.avohai.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "User")
public class User extends BaseModel implements Serializable {

	private static final long serialVersionUID = -3220628448333591545L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "cpf", nullable = false, length = 14)
	private String cpf;

	@ManyToOne
	@JoinColumn(name = "parent")
	private Parent parent;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<GrandParent> grandParents;

	public User() {

	}

	public User(String name, String cpf, Parent parent, List<GrandParent> grandParents) {
		this.setName(name);
		this.cpf = cpf;
		this.grandParents = grandParents;
		this.parent = parent;
	}

}
