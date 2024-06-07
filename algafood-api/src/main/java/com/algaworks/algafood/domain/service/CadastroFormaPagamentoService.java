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
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Service
public class CadastroFormaPagamentoService {
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	 public List<FormaPagamento> buscarTodos() {
	        return formaPagamentoRepository.findAll();
	    }

	    public Optional<FormaPagamento> buscarPorId(Long id) {
	        return formaPagamentoRepository.findById(id);
	    }

	    public FormaPagamento salvar(FormaPagamento formaPagamento) {
	        return formaPagamentoRepository.save(formaPagamento);
	    }

	    public void remover(Long id) {
	        try {
	        	formaPagamentoRepository.deleteById(id);
	        } catch (EmptyResultDataAccessException e) {
	            throw new EntidadeNaoEncontradaException(
	                String.format("Não existe uma forma de pagamento com o código %d", id));
	        } catch (DataIntegrityViolationException e) {
	            throw new EntidadeEmUsoException(
	                String.format("Forma de pagamento de código %d não pode ser removida. Pois, está em uso.", id));
	        }
	    }
	    
	    public FormaPagamento atualizar(Long id, FormaPagamento formaPagamento) {
	        Optional<FormaPagamento> formaPagamentoAtual = formaPagamentoRepository.findById(id);
	        if (formaPagamentoAtual.isPresent()) {
	            BeanUtils.copyProperties(formaPagamento, formaPagamentoAtual.get(), "id");
	            return formaPagamentoRepository.save(formaPagamentoAtual.get());
	        } else {
	            throw new EntidadeNaoEncontradaException(
	                String.format("Não existe uma forma de pagamento com o código %d", id));
	        }
	    }
	
}
