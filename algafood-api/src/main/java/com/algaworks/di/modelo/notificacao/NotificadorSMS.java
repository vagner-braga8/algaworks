package com.algaworks.di.modelo.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.di.modelo.Cliente;

@Qualifier("urgente") //Equivalente ao 'grau' de urgência por exemplo
@Component
public class NotificadorSMS implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através por SMS. Através do telefone %s: %s\n",
				cliente.getNome(), cliente.getTelefone(),mensagem);
	}

}
