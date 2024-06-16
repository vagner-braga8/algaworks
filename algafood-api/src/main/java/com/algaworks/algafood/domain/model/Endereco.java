package com.algaworks.algafood.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable   //Parte de alguma outra entidade que a 'incorpora-la'
public class Endereco {
	
	/*
	 * O prefixo iniciando pelo nome da classe (endereco_) é uma boa prática para quando ela for
	 * incorporada por alguma entidade, houver distinção no nome das colunas.
	 */
	
	@Column(name="endereco_cep")
	private String cep;
	
	@Column(name="endereco_logradouro")
	private String logradouro;
	
	@Column(name="endereco_numero")
	private String numero;
	
	@Column(name="endereco_complemento")
	private String complemento;
	
	@Column(name="endereco_bairro")
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name="endereco_cidade_id")
	private Cidade cidade;
}
