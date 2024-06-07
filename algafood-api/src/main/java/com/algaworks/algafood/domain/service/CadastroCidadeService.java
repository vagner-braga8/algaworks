package com.algaworks.algafood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;

	public List<Cidade> buscarTodas() {
		return cidadeRepository.findAll();
	}

	public Optional<Cidade> buscarPorId(Long id) {
		return cidadeRepository.findById(id);
	}

	public Cidade salvar(Cidade cidade) {

		Long estadoId = cidade.getEstado().getId();
		Optional<Estado> estado = estadoRepository.findById(estadoId);

		if (!estado.isPresent()) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com o código: %d", estadoId));
		}
		cidade.setEstado(estado.get());

		return cidadeRepository.save(cidade);
		
	}

	public void remover(Long id) {
	    try {
	        cidadeRepository.deleteById(id);
	    } catch (EmptyResultDataAccessException e) {
	        throw new EntidadeNaoEncontradaException(
	                String.format("Não existe um cadastro de cidade com o código %d", id));
	    } catch (DataIntegrityViolationException e) {
	        throw new EntidadeEmUsoException(
	                String.format("Cidade de código %d não pode ser removida. Pois, está em uso.", id));
	    }
	}


}
