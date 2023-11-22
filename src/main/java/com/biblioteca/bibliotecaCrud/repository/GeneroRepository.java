package com.biblioteca.bibliotecaCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.bibliotecaCrud.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {
	
}
