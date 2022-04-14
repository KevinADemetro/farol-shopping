package br.com.farolshopping.model;

import lombok.Data;

@Data
public class Endereco {
	
	private String logradouro;
	
	private String bairro;
	
	private String cidade;
	
	private String uf;
	
}
