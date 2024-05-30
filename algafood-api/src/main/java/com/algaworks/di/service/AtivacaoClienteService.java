package com.algaworks.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.algaworks.di.event.ClienteAtivacaoEvent;
import com.algaworks.di.modelo.Cliente;

@Component
public class AtivacaoClienteService {
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	public void ativar (Cliente cliente) {
		cliente.ativar(true);                                             //Quando o cliente for ativado..
		eventPublisher.publishEvent(new ClienteAtivacaoEvent(cliente));
	}
	/*
	 * Primeira vantagem é o baixo acoplamento (retirando o notificador..);
	 * Alta coesão(assumir responsabilidade de outra classe, retirando a 
	 * responsabilidade de saber que precisa notificar e sim saber que 
	 * precisa apenas publicar um evento. Mas, saber o que vai acontecer,
	 * essa classe não sabe.
	 */
}
