package com.algaworks.di.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.modelo.notificacao.Notificador;

@Component
public class AtivacaoClienteService {

	@Autowired(required = false)//Dependência opcional dentro de um Bean
	private Notificador notificador;
	
	public void ativar (Cliente cliente) {
		cliente.ativar(true);
		
		if(notificador != null) {
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
		}else {
			System.out.println("Não existe notificador. Mas, o cliente foi ativado.");
		}
	}
	
}
