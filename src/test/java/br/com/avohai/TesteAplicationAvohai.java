package br.com.avohai;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.avohai.model.dto.DadosDoUsuario;
import br.com.avohai.services.impl.TreeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TesteAplicationAvohai {

	@InjectMocks
	private TreeServiceImpl treeService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Fiz apenas este teste utilizando Mockito e Junit, para validar a regra que
	 * verifica se é um novo registro ou Atualização, A finalidade deste processo é
	 * apenas certificar de que na hora de fazer o build o comportamento da gravação
	 * estará correto.
	 */
	@Test
	public void verificaSeRegistroEhNovo() {
		DadosDoUsuario dadosDoUsuario = mock(DadosDoUsuario.class);
		when(dadosDoUsuario.getIdUser()).thenReturn(null);
		assertTrue(treeService.verificaSeRegistroEhNovo(dadosDoUsuario));
		when(dadosDoUsuario.getIdUser()).thenReturn(1L);
		assertFalse(treeService.verificaSeRegistroEhNovo(dadosDoUsuario));
	}

}
