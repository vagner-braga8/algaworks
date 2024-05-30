package com.algaworks.di.notificacao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.beans.factory.annotation.Qualifier;

@Retention(RetentionPolicy.RUNTIME) //Essa notificação será lida em tempo de execução
@Qualifier
public @interface TipoDoNotificador {
	
	NivelUrgencia value();
	
}
