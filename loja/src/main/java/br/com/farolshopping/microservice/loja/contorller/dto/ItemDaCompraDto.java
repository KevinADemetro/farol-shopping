package br.com.farolshopping.microservice.loja.contorller.dto;

public class ItemDaCompraDto {
	private Long id;
	private int quantidade;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}