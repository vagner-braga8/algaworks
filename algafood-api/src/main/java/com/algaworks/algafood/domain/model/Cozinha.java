package com.algaworks.algafood.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cozinha {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(nullable = false)
	private String nome;

	/*
	 * JsonIgnore : Não serialize a entidade 'Restaurante' quando for serializar a entidade 'Cozinha' 
	 * OneToMany : Uma cozinha para muitos restaurantes,
	 * mappedBy: "cozinha" : Que foi mapeado por cozinha,
	 * Onde? : List<Restaurante> , em Restaurante.
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "cozinha")
	private List<Restaurante> restaurantes = new ArrayList<>();
	
}
