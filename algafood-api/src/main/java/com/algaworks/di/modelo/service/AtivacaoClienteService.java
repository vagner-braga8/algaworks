package com.algaworks.di.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.modelo.notificacao.Notificador;

@Component
public class AtivacaoClienteService {

	//1a forma de resolver problema de ambiguidade (lista de beans)
	@Autowired
	private List<Notificador> notificadores;
	
	public void ativar (Cliente cliente) {
		cliente.ativar(true);
		for(Notificador notificador: notificadores) {
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
		}
	}
}
