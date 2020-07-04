package br.com.avohai.model.dto;

import java.io.Serializable;

import br.com.avohai.model.User;
import br.com.avohai.model.enumerators.PaternalMaternalEnum;
import lombok.Data;

@Data
public class DadosDoUsuario implements Serializable {

	private static final long serialVersionUID = 7884151599663592506L;

	private String nomeUsuario;
	private String cpf;
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

	public static DadosDoUsuario preencherDadosDoUsuario(User user) {
		DadosDoUsuario dadosDoUsuario = new DadosDoUsuario();
		if (user == null) {

		} else {
			dadosDoUsuario.setNomeUsuario(user.getName());
			dadosDoUsuario.setCpf(user.getCpf());

			user.getGrandParents().forEach(grandParents -> {
				if (grandParents.getPaternalMaternalEnum().equals(PaternalMaternalEnum.PATERNAL)) {
					dadosDoUsuario.setPaternalGreaterGrandFatherName(grandParents.getGreaterGrandFatherName());
					dadosDoUsuario.setPaternalGreaterGrandMotherName(grandParents.getGreaterGrandMotherName());
					dadosDoUsuario.setPaternalGrandFatherName(grandParents.getGrandFatherName());
					dadosDoUsuario.setPaternalGrandMotherName(grandParents.getGrandMotherName());
				} else {
					dadosDoUsuario.setMaternalGreaterGrandFatherName(grandParents.getGreaterGrandFatherName());
					dadosDoUsuario.setMaternalGreaterGrandMotherName(grandParents.getGreaterGrandMotherName());
					dadosDoUsuario.setMaternalGrandFatherName(grandParents.getGrandFatherName());
					dadosDoUsuario.setMaternalGrandMotherName(grandParents.getGrandMotherName());
				}
			});

			dadosDoUsuario.setNomePai(user.getParent().getFather());
			dadosDoUsuario.setNomeMae(user.getParent().getMother());
		}
		return dadosDoUsuario;
	}

}
