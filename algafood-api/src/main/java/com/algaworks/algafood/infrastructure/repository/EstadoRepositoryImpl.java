package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class EstadoRepositoryImpl implements EstadoRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Estado> buscarTodos(){
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}
	
	@Override
	public Estado buscarPorId(Long id) {
		return manager.find(Estado.class, id);
	}
	
	@Transactional
	@Override
	public Estado adicionar(Estado estado) {
		return manager.merge(estado);
	}
	
	@Transactional
	@Override
	public void remover (Estado estado) {
		estado = buscarPorId(estado.getId());
		manager.remove(estado);
	}
}
