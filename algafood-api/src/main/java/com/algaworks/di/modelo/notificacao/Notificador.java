package com.algaworks.di.modelo.notificacao;

import com.algaworks.di.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);

}