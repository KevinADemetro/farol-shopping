package br.com.farolshopping.microservice.loja.service;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.farolshopping.microservice.loja.client.FornecedorClient;
import br.com.farolshopping.microservice.loja.contorller.dto.CompraDto;
import br.com.farolshopping.microservice.loja.contorller.dto.InfoFornecedorDto;
import br.com.farolshopping.microservice.loja.dto.InfoPedidoDto;
import br.com.farolshopping.microservice.loja.modelo.Compra;

@Service
public class CompraService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	public Compra realizarCompra(CompraDto compra) {
		
		final String estado = compra.getEndereco().getEstado();
		
		LOG.info("buscando informações de {}",estado);
		InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		LOG.info("realizando um pedido");
		InfoPedidoDto pedido = fornecedorClient.realizarPedido(compra.getItens());
		
		System.out.println(info.getEndereco());
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePrepararo(pedido.getTempoDePreparo());
		compraSalva.setEndereco(compra.getEndereco().toString());
		return compraSalva;
	}
}