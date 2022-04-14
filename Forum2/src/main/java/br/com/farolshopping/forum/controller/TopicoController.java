package br.com.farolshopping.forum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.farolshopping.forum.model.Topico;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	
	@GetMapping
	public List<Topico> listar(){
		return null;
	}
	
}
