package br.com.farolshopping.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import br.com.farolshopping.model.Endereco;

@Component
public class RouteToViaCep extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:buscarEndereco")
			.process(prepararCorpoDaRequisicao())
			.setHeader(Exchange.HTTP_METHOD, constant("GET"))
			.toD("https://viacep.com.br/ws/${exchangeProperty[cep]}/json/")				
			.process(processarResultado())
		.end();
	}

	private Processor prepararCorpoDaRequisicao() {
		return new Processor() {					
			@Override
			public void process(Exchange exchange) throws Exception {
				String cep = exchange.getMessage().getBody(String.class);
				exchange.setProperty("cep", cep);
			}
		};
	}
	private Processor processarResultado() {
		return new Processor() {				
			@Override
			public void process(Exchange exchange) throws Exception {
				JSONObject response = capturarResposta(exchange);
				Endereco endereco = criarEndereco(response);
				
				exchange.getMessage().setBody(endereco, Endereco.class);
			}
		};
	}

	
	private JSONObject capturarResposta(Exchange exchange) {
		return new JSONObject(exchange
				.getMessage().getBody(String.class));
	}

	private Endereco criarEndereco(JSONObject response) {
		Endereco endereco = new Endereco();
		endereco.setCidade(response.getString("localidade"));
		endereco.setBairro(response.getString("bairro"));
		endereco.setLogradouro(response.getString("logradouro"));
		endereco.setUf(response.getString("uf"));
		return endereco;
	}
}