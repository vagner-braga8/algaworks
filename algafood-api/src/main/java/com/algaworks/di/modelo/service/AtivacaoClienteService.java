package com.algaworks.di.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.modelo.notificacao.Notificador;

@Component
public class AtivacaoClienteService {
	
	@Qualifier("urgente")
	@Autowired
	private Notificador notificador;
	
	public void ativar (Cliente cliente) {
		cliente.ativar(true);
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
}
