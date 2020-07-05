package br.com.avohai.services.impl;

import static br.com.avohai.model.dto.DadosDoUsuario.preencherDadosDoUsuario;
import static java.util.Objects.nonNull;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avohai.dao.GenericDao;
import br.com.avohai.model.GrandParent;
import br.com.avohai.model.Parent;
import br.com.avohai.model.User;
import br.com.avohai.model.dto.DadosDoUsuario;
import br.com.avohai.model.enumerators.PaternalMaternalEnum;
import br.com.avohai.repositories.GrandParentsRepository;
import br.com.avohai.repositories.ParentsRepository;
import br.com.avohai.repositories.UsersRepository;
import br.com.avohai.services.TreeService;
import lombok.Getter;

@Service
public class TreeServiceImpl extends GenericDao<User> implements TreeService {

	@Autowired
	@Getter
	private ParentsRepository parentsRepository;

	@Autowired
	@Getter
	private UsersRepository userRepository;

	@Autowired
	@Getter
	private GrandParentsRepository grandParentRepository;

	@Override
	public DadosDoUsuario buscarUsuarioCompletoPorCpf(String cpf) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT u FROM User u ");
		sql.append(" INNER JOIN u.parent parents ");
		sql.append(" INNER JOIN FETCH u.grandParents grandParents ");
		sql.append(" WHERE u.cpf = :parameterCpf ");

		TypedQuery<User> query = getEntityManager().createQuery(sql.toString(), User.class);
		query.setParameter("parameterCpf", cpf);

		User user = query.getSingleResult();

		return user != null ? preencherDadosDoUsuario(user) : new DadosDoUsuario();
	}

	@Override
	public boolean preparaDadosParaSeremGravados(DadosDoUsuario dadosDoUsuario) {
		boolean retorno = false;
		Date dataDoCadastro = new Date();

		GrandParent paternalGrandParent = new GrandParent(dadosDoUsuario.getPaternalGreaterGrandFatherName(),
				dadosDoUsuario.getPaternalGreaterGrandMotherName(), dadosDoUsuario.getPaternalGrandFatherName(),
				dadosDoUsuario.getPaternalGrandMotherName(), PaternalMaternalEnum.PATERNAL, dataDoCadastro);

		GrandParent maternalGrandParent = new GrandParent(dadosDoUsuario.getMaternalGreaterGrandFatherName(),
				dadosDoUsuario.getMaternalGreaterGrandMotherName(), dadosDoUsuario.getMaternalGrandFatherName(),
				dadosDoUsuario.getMaternalGrandMotherName(), PaternalMaternalEnum.MATERNAL, dataDoCadastro);

		Parent parent = new Parent(dadosDoUsuario.getNomePai(), dadosDoUsuario.getNomeMae(), dataDoCadastro);

		User user = new User(dadosDoUsuario.getNomeUsuario(), dadosDoUsuario.getCpf(), parent,
				Arrays.asList(paternalGrandParent, maternalGrandParent), dataDoCadastro);

		paternalGrandParent.setUser(user);
		maternalGrandParent.setUser(user);
		try {
			realizarPersistenciaDosDados(paternalGrandParent, maternalGrandParent, parent, user);
			retorno = true;
		} catch (Exception e) {
			retorno = false;
		}

		return retorno;
	}

	private void realizarPersistenciaDosDados(GrandParent paternalGrandParent, GrandParent maternalGrandParent,
			Parent parent, User user) throws Exception {
		try {
			User usuarioExistente = this.userRepository.findUserByCpf(user.getCpf());

			Parent parentExistente = this.parentsRepository.findParentByPartName(parent.getFather().concat("%"),
					parent.getMother().concat("%"));

			GrandParent paternalGrandParentExistente = this.grandParentRepository.findGrandParentByPartName(
					paternalGrandParent.getGrandFatherName().concat("%"),
					paternalGrandParent.getGrandMotherName().concat("%"), PaternalMaternalEnum.PATERNAL);

			GrandParent maternalGrandParentExistente = this.grandParentRepository.findGrandParentByPartName(
					maternalGrandParent.getGrandFatherName().concat("%"),
					maternalGrandParent.getGrandMotherName().concat("%"), PaternalMaternalEnum.MATERNAL);

			gravar(paternalGrandParent, maternalGrandParent, parent, user, usuarioExistente, parentExistente,
					paternalGrandParentExistente, maternalGrandParentExistente);

		} catch (Exception e) {
			throw new Exception();
		}
	}

	private void gravar(GrandParent paternalGrandParent, GrandParent maternalGrandParent, Parent parent, User user,
			User usuarioExistente, Parent parentExistente, GrandParent paternalGrandParentExistente,
			GrandParent maternalGrandParentExistente) {
		if (nonNull(parentExistente)) {
			parentsRepository.save(parentExistente);
		} else {
			parentsRepository.save(parent);
		}

		if (nonNull(usuarioExistente)) {
			user = userRepository.save(usuarioExistente);
		} else {
			user = userRepository.save(user);
		}

		if (nonNull(paternalGrandParentExistente) && nonNull(maternalGrandParentExistente)) {
			grandParentRepository
					.saveAll(Arrays.asList(paternalGrandParentExistente, maternalGrandParentExistente));
		} else {
			grandParentRepository.saveAll(Arrays.asList(maternalGrandParent, paternalGrandParent));
		}
	}

}
