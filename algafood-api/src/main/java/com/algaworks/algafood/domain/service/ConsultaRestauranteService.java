package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class ConsultaRestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;

	public List<Restaurante> buscarTodos() {
		return restauranteRepository.buscarTodos();
	}
	
	public Restaurante buscarPorId(Long id) {
		return restauranteRepository.buscarPorId(id);
	}
	
}
