package br.com.farolshopping.microservice.loja.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.farolshopping.microservice.loja.contorller.dto.CompraDto;
import br.com.farolshopping.microservice.loja.modelo.Compra;
import br.com.farolshopping.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@PostMapping
	public Compra relaziarCompra(@RequestBody CompraDto compra) {
		return compraService.realizarCompra(compra);
	}
}