package br.com.avohai.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.avohai.model.enumerators.PaternalMaternalEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "GrandParent")
public class GrandParent extends BaseModel implements Serializable {

	private static final long serialVersionUID = 8926858711463154015L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "greaterGrandFatherName", nullable = false)
	private String greaterGrandFatherName;

	@Column(name = "greaterGrandMotherName", nullable = false)
	private String greaterGrandMotherName;

	@Column(name = "grandFatherName", nullable = false)
	private String grandFatherName;

	@Column(name = "grandMotherName", nullable = false)
	private String grandMotherName;

	@Column(name = "paternalMaternal", length = 8)
	@Enumerated(EnumType.STRING)
	private PaternalMaternalEnum paternalMaternalEnum;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public GrandParent(String greaterGrandFatherName, String greaterGrandMotherName, String grandFatherName,
			String grandMotherName, PaternalMaternalEnum paternalMaternalEnum) {
		this.greaterGrandFatherName = greaterGrandFatherName;
		this.greaterGrandMotherName = greaterGrandMotherName;
		this.grandFatherName = grandFatherName;
		this.grandMotherName = grandMotherName;
		this.paternalMaternalEnum = paternalMaternalEnum;
	}

	public GrandParent() {

	}

}
