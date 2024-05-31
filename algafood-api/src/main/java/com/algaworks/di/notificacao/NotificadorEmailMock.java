package com.algaworks.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.di.modelo.Cliente;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.NORMAL)
@Component
public class NotificadorEmailMock implements Notificador {
	
	@Autowired
	private NotificadorProperties notificadorProperties;

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.println("Host-dev: " + notificadorProperties.getHostServidor());
		System.out.println("Porta-dev: " + notificadorProperties.getPortaServidor());
		
		System.out.printf("MOCK: Notificando seria enviada para %s através do e-mail %s: %s\n",
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
