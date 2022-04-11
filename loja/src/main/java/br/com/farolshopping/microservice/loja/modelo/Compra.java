package br.com.farolshopping.microservice.loja.modelo;

public class Compra {
	
	private Long pedidoId;
	private Integer tempoDePrepararo;
	private String endereco;
	
	public Long getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
	public Integer getTempoDePrepararo() {
		return tempoDePrepararo;
	}
	public void setTempoDePrepararo(Integer tempoDePrepararo) {
		this.tempoDePrepararo = tempoDePrepararo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}