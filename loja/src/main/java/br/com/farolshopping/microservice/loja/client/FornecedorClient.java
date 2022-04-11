package br.com.farolshopping.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.farolshopping.microservice.loja.contorller.dto.InfoFornecedorDto;
import br.com.farolshopping.microservice.loja.contorller.dto.ItemDaCompraDto;
import br.com.farolshopping.microservice.loja.dto.InfoPedidoDto;

@FeignClient("fornecedor")
public interface FornecedorClient {
	
	@RequestMapping("/info/{estado}")
	InfoFornecedorDto getInfoPorEstado(@PathVariable String estado);

	@PostMapping("/pedido")
	InfoPedidoDto realizarPedido(List<ItemDaCompraDto> itens);
}
