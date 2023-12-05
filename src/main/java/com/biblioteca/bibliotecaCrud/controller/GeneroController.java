package com.biblioteca.bibliotecaCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.bibliotecaCrud.model.Genero;
import com.biblioteca.bibliotecaCrud.service.GeneroService;

@Controller
@RequestMapping("/")
public class GeneroController {
	
	@Autowired
	private GeneroService generoService; 
	
    @GetMapping
    public String getAllGeneroPage(Model model) {
    	List<Genero> generos = generoService.listAll();
    	model.addAttribute("generos", generos);
        return "listarGenero";
    }
    
    @GetMapping("/genero/criar")
	public String getCreatePage(final Model model) {
    	model.addAttribute("genero", new Genero()); 
    	return "criarGenero";
    }
    
    @GetMapping("/genero/editar/{id}")
	public String getEditGeneroPage(@PathVariable("id") final int id, final Model model) {
    	model.addAttribute("genero", generoService.findById(id));
    	return "editarGenero";
    }
    
    @PostMapping("/genero/salvar")
    public String saveGenero(final Genero genero) {
    	generoService.updateGenero(genero);
    	return "redirect:/";
    }
    
    @GetMapping("/genero/deletar/{id}")
    public String deleteGenero(@PathVariable("id") final int id) {
    	generoService.deleteGenero(id);
    	return "redirect:/";
    }
	
}
