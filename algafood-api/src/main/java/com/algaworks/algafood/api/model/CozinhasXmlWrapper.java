package com.algaworks.algafood.api.model;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import com.fasterxml.jackson.annotation.JsonRootName;

import io.micrometer.common.lang.NonNull;
import lombok.Data;

@Data
@JsonRootName("cozinhas") //Customizar o nome do domínimo apenas na requisição
public class CozinhasXmlWrapper {

	@NonNull
	private List<Cozinha> cozinhas;
	
	public CozinhasXmlWrapper(List<Cozinha> buscarTodas) {
	}
	
}
