package br.com.avohai.model.enumerators;

import lombok.Getter;
import lombok.Setter;

public enum PaternalMaternalEnum {

	PATERNAL("Paternal"), 
	MATERNAL("Maternal");

	@Getter
	@Setter
	private String label;

	private PaternalMaternalEnum(String label) {
		this.setLabel(label);
	}
	
}
