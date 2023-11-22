package com.biblioteca.bibliotecaCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.biblioteca.bibliotecaCrud.model.Genero;
import com.biblioteca.bibliotecaCrud.repository.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository generoRepository;
	
	public Genero findById(int id) {
		return generoRepository.findById(id).get();
	}
	
	public List<Genero> listAll() {
		return (List<Genero>) generoRepository.findAll(Sort.by("id"));
	}

	public void updateGenero(Genero genero) {
		generoRepository.save(genero);
	}

	public void deleteGenero(int id) {
		generoRepository.deleteById(id);
	}
	
}
