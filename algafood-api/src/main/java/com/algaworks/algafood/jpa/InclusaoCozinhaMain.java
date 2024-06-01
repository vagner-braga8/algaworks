package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;

public class InclusaoCozinhaMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext aaplicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CadastroCozinha cadastroCozinha = aaplicationContext.getBean(CadastroCozinha.class);

		Cozinha c1 = new Cozinha();
		c1.setNome("Brasileira");
		
		Cozinha c2 = new Cozinha();
		c2.setNome("Italiana");
		
		cadastroCozinha.adicionar(c1);
		cadastroCozinha.adicionar(c2);
		
	}

}
