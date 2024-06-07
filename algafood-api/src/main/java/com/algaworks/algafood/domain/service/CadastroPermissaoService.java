package com.algaworks.algafood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

@Service
public class CadastroPermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;

	public List<Permissao> buscarTodos() {
		return permissaoRepository.findAll();
	}

	public Optional<Permissao> buscarPorId(Long id) {
		return permissaoRepository.findById(id);
	}

	public Permissao salvar(Permissao permissao) {
		return permissaoRepository.save(permissao);
	}

	public void remover(Long id) {
		try {
			permissaoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de permissão com o código %d", id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Permissão de código %d não pode ser removida. Pois, está em uso.", id));
		}
	}

	public Permissao atualizar(Long id, Permissao permissao) {
		Optional<Permissao> permissaoAtual = permissaoRepository.findById(id);
		if (permissaoAtual.isPresent()) {
			BeanUtils.copyProperties(permissao, permissaoAtual.get(), "id");
			return permissaoRepository.save(permissaoAtual.get());
		} else {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de permissão com o código %d", id));
		}
	}

}
