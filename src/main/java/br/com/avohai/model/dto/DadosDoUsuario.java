package br.com.avohai.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DadosDoUsuario implements Serializable {

	private static final long serialVersionUID = 7884151599663592506L;

	private String nomeUsuario;
	private String paternalGreaterGrandFatherName;
	private String maternalGreaterGrandFatherName;
	private String paternalGreaterGrandMotherName;
	private String maternalGreaterGrandMotherName;
	private String paternalGrandFatherName;
	private String maternalGrandFatherName;
	private String paternalGrandMotherName;
	private String maternalGrandMotherName;
	private String nomePai;
	private String nomeMae;
	
}
