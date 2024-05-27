package com.algaworks.di;

import org.springframework.context.annotation.Bean;

import com.algaworks.di.modelo.notificacao.NotificadorEmail;
import com.algaworks.di.modelo.service.AtivacaoClienteService;

/*Classe para definição dos beans
 * Posteriormente , foi formada duas novas classes de configurações.
 * Usando assim, os dois métodos abaixo em cada nova classe para exemplo.*/

//@Configuration
public class AlgaConfig {
	
	/*
	 * Método reponsável por criar e instanciar um objeto do tipo 'NotificadorEmail'
	 * Por padrão o bean será nomeado como 'notificadorEmail', que é exatamente o 
	 * nome do método de definição do bean.
	 */
	@Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com.br");
		notificador.setCaixaAlta(true);
		return notificador;
	}
	
	/*
	 * Como o método notificadorEmail retorna uma instancia de 'NotificadorEmail' e
	 * está anotado com *bean. Na chamada do método 'AtivacaoClienteService' já vai
	 *  retornar um *bean gerenciado pelo Spring.
	 */
	@Bean
	public AtivacaoClienteService ativacaoClienteService() {
		return new AtivacaoClienteService(notificadorEmail());
	}
	
	
}
