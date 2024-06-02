package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class CidadeRepositoryImpl implements CidadeRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cidade> buscarTodas(){
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}
	
	@Override
	public Cidade buscarPorId(Long id) {
		return manager.find(Cidade.class, id);
	}
	
	@Transactional
	@Override
	public Cidade adicionar(Cidade cidade) {
		return manager.merge(cidade);
	}
	
	@Transactional
	@Override
	public void remover (Cidade cidade) {
		cidade = buscarPorId(cidade.getId());
		manager.remove(cidade);
	}
	
	
}
