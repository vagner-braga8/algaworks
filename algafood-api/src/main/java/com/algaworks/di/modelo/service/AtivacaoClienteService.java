package com.algaworks.di.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.modelo.notificacao.NivelUrgencia;
import com.algaworks.di.modelo.notificacao.Notificador;
import com.algaworks.di.modelo.notificacao.TipoDoNotificador;

@Component
public class AtivacaoClienteService {
	
	@TipoDoNotificador(NivelUrgencia.NORMAL)
	@Autowired
	private Notificador notificador;
	
	public void ativar (Cliente cliente) {
		cliente.ativar(true);
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
}
