package com.algaworks.di.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.di.event.ClienteAtivacaoEvent;

@Component
public class EmissaoNotaFiscalService { //Listener
	
	@EventListener
	public void clienteAtivadoListener(ClienteAtivacaoEvent event) {
		System.out.println("Emitindo nota fiscal para cliente " + event.getCliente().getNome());
	}
	
}
