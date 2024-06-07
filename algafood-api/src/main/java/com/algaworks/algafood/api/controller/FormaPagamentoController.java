package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.service.CadastroFormaPagamentoService;

@RestController
@RequestMapping("/formaPagamentos")
public class FormaPagamentoController {

	@Autowired
	private CadastroFormaPagamentoService cadastrofiCadastroFormaPagamentoService;

	@GetMapping
	public List<FormaPagamento> listar() {
		return cadastrofiCadastroFormaPagamentoService.buscarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<FormaPagamento> buscarPorId(@PathVariable Long id) {
		Optional<FormaPagamento> formaPagamento = cadastrofiCadastroFormaPagamentoService.buscarPorId(id);
		if (formaPagamento.isPresent()) {
			return ResponseEntity.ok(formaPagamento.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody FormaPagamento formaPagamento) {
		try {
			formaPagamento = cadastrofiCadastroFormaPagamentoService.salvar(formaPagamento);

			return ResponseEntity.status(HttpStatus.CREATED).body(formaPagamento);

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<FormaPagamento> remover(@PathVariable Long id) {
		try {
			cadastrofiCadastroFormaPagamentoService.remover(id);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	   @PutMapping("/{id}")
	    public ResponseEntity<FormaPagamento> atualizar(@PathVariable Long id, @RequestBody FormaPagamento formaPagamento) {
	        try {
	        	FormaPagamento formaPagamentoAtualizada = cadastrofiCadastroFormaPagamentoService.atualizar(id, formaPagamento);
	            return ResponseEntity.ok(formaPagamentoAtualizada);
	        } catch (EntidadeNaoEncontradaException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }


}
