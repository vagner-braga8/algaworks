package com.algaworks.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.di.modelo.service.AtivacaoClienteService;

@Configuration
public class ServiceConfig {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public AtivacaoClienteService ativacaoClienteService() {
		return new AtivacaoClienteService();
	}
	
}
