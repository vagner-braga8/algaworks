package com.algaworks.di.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.modelo.notificacao.Notificador;

@Component
public class AtivacaoClienteService {
	
	/*
	 * Exemplos de pontos de injeção de dependência:
	 *  via construtor - 1
	 *  via setter - 2 
	 *  via variável de instância - 3
	 */
	
	@Autowired
	private Notificador notificador; // 3 - ' add @Autowired'
	
	/* (1)
	 * @Autowired public AtivacaoClienteService(Notificador notificador) {
	 * this.notificador = notificador; }
	 */

	public void ativar (Cliente cliente) {
		cliente.ativar(true);
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
	
	//(2)
	/*
	 * @Autowired public void setNotificador(Notificador notificador) {
	 * this.notificador = notificador; } }
	 */
}
