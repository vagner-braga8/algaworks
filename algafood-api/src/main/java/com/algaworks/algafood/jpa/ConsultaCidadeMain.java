package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

public class ConsultaCidadeMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext aaplicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CidadeRepository cidades = aaplicationContext.getBean(CidadeRepository.class);

		List<Cidade> todasCidades = cidades.buscarTodas();
		
		for(Cidade cidade : todasCidades) {
			System.out.printf("%s - %s\n" ,cidade.getNome(),
			cidade.getEstado().getNome());
		}
		
	}

}
