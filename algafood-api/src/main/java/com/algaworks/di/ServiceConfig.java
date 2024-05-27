package com.algaworks.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.di.modelo.notificacao.Notificador;
import com.algaworks.di.modelo.service.AtivacaoClienteService;

@Configuration
public class ServiceConfig {
	
	@Bean
	public AtivacaoClienteService ativacaoClienteService(Notificador notificador) {
		return new AtivacaoClienteService(notificador);
	}
	
}
