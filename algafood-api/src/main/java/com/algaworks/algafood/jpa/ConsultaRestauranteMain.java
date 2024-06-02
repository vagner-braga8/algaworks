package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext aaplicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restaurantes = aaplicationContext.getBean(RestauranteRepository.class);

		List<Restaurante> todosRestaurantes = restaurantes.buscarTodos();
		
		for(Restaurante restaurante : todosRestaurantes) {
			System.out.printf("%s - %f - %s\n" ,restaurante.getNome(),
					restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
		}
		
	}

}
