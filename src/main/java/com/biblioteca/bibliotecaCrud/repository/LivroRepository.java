package com.biblioteca.bibliotecaCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.bibliotecaCrud.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
	
}
