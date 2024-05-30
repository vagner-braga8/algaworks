package com.algaworks.di.event;

import com.algaworks.di.modelo.Cliente;

public class ClienteAtivacaoEvent {

	private Cliente cliente;

	public ClienteAtivacaoEvent(Cliente cliente) {
		super();
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
