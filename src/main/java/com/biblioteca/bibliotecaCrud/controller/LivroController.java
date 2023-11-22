package com.biblioteca.bibliotecaCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.bibliotecaCrud.model.Livro;
import com.biblioteca.bibliotecaCrud.service.GeneroService;
import com.biblioteca.bibliotecaCrud.service.LivroService;

@Controller
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroService livroService;
	
	@Autowired
	private GeneroService generoService; 
	
    @GetMapping
    public String getAllLivrosPage(Model model) {
    	List<Livro> livros = livroService.listAll();
    	model.addAttribute("livro", livros);
        return "listarLivros";
    }
    
    @GetMapping("/criar")
	public String getCreatePage(final Model model) {
    	model.addAttribute("livro", new Livro()); 
    	model.addAttribute("generos", generoService.listAll());
    	return "criarLivro";
    }
    
    @GetMapping("/editar/{id}")
	public String getEditLivroPage(@PathVariable("id") final int id, final Model model) {
    	model.addAttribute("livro", livroService.findById(id));
    	model.addAttribute("generos", generoService.listAll());
    	return "editarLivro";
    }
    
    @PostMapping("/salvar")
    public String saveLivro(final Livro livro) {
    	livro.setGenero(generoService.findById(livro.getGenero().getId()));
    	livroService.updateLivro(livro);
    	return "redirect:/livro";
    }
    
    @GetMapping("/deletar/{id}")
    public String deleteLivro(@PathVariable("id") final int id) {
    	livroService.deleteLivro(id);
    	return "redirect:/livro";
    }
    
}
