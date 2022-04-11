package br.com.farolshopping.microservice.loja.contorller.dto;

import java.util.List;

public class CompraDto {
	private List<ItemDaCompraDto> itens;
	private EnderecoDto endereco;
	
	public List<ItemDaCompraDto> getItens() {
		return itens;
	}
	public EnderecoDto getEndereco() {
		return endereco;
	}
}