package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;

public class BuscaCozinhaMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext aaplicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CadastroCozinha cadastroCozinha = aaplicationContext.getBean(CadastroCozinha.class);

		Cozinha cozinha = cadastroCozinha.buscar(1L);
		
			System.out.println(cozinha.getNome());
		
	}

}