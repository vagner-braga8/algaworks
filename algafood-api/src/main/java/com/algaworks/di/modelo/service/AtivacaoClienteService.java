package com.algaworks.di.modelo.service;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.modelo.notificacao.Notificador;

public class AtivacaoClienteService {
	
	private Notificador notificador;
	
	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
	}

	public void ativar (Cliente cliente) {
		cliente.ativar(true);
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
}
