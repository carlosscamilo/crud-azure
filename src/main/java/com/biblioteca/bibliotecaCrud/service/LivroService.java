package com.biblioteca.bibliotecaCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.biblioteca.bibliotecaCrud.model.Livro;
import com.biblioteca.bibliotecaCrud.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public List<Livro> listAll() {
		return (List<Livro>) livroRepository.findAll(Sort.by("id"));
	}

	public Livro findById(final int id) {
		return livroRepository.findById(id).get();
	}	
	
	public Livro updateLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public void deleteLivro(final int id) {
		this.livroRepository.deleteById(id);
	}
}
