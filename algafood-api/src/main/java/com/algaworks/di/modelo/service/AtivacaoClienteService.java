package com.algaworks.di.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.modelo.notificacao.NivelUrgencia;
import com.algaworks.di.modelo.notificacao.Notificador;
import com.algaworks.di.modelo.notificacao.TipoDoNotificador;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//@Component
public class AtivacaoClienteService {
	
	@TipoDoNotificador(NivelUrgencia.NORMAL)
	@Autowired
	private Notificador notificador;
	
	//@PostConstruct  (Posteriormente foi utilizada em uma classe de config/gerenciamento de beans)
	public void init() {
		System.out.println("INIT");
	}
	
	//@PreDestroy (Posteriormente foi utilizada em uma classe de config/gerenciamento de beans)
	public void destroy() {
		System.out.println("DESTROY");
	}
	
	public void ativar (Cliente cliente) {
		cliente.ativar(true);
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
}
