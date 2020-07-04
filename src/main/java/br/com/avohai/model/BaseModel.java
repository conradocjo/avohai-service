package br.com.avohai.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseModel {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataHoraGravacao", nullable = true)
	private Date dataHoraGravacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataHoraEdicao", nullable = true)
	private Date dataHoraEdicao;

}
