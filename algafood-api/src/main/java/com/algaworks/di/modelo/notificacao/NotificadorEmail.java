package com.algaworks.di.modelo.notificacao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.algaworks.di.modelo.Cliente;

/*Quando houver mais de um bean desse tipo, com a anotação 'Primary' estamos afirmando que
tal bean será prioritário*/
@Primary
@Component
public class NotificadorEmail implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do e-mail %s: %s\n",
				cliente.getNome(), cliente.getEmail(),mensagem);
	}

}
