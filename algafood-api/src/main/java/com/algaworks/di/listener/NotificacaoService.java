package com.algaworks.di.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.di.event.ClienteAtivacaoEvent;
import com.algaworks.di.notificacao.NivelUrgencia;
import com.algaworks.di.notificacao.Notificador;
import com.algaworks.di.notificacao.TipoDoNotificador;

@Component
public class NotificacaoService { //Listener
	
	@TipoDoNotificador(NivelUrgencia.NORMAL)
	@Autowired
	private Notificador notificador;
	
	@EventListener
	public void clienteAtivadoListener(ClienteAtivacaoEvent event) {
		notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
	}
	
}
