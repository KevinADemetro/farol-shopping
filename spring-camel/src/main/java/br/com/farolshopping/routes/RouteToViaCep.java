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
			.id("prepararBody")
				.process(new Processor() {					
					@Override
					public void process(Exchange exchange) throws Exception {
						String cep = exchange.getMessage().getBody(String.class);
						exchange.setProperty("cep", cep);
					}
				})
				.setHeader(Exchange.HTTP_METHOD, constant("GET"))
				.toD("https://viacep.com.br/ws/${exchangeProperty[cep]}/json/")				
				.process(new Processor() {				
					@Override
					public void process(Exchange exchange) throws Exception {
						
						JSONObject response = new JSONObject(exchange
								.getMessage().getBody(String.class));
						
						Endereco endereco = new Endereco();
						endereco.setCidade(response.getString("localidade"));
						endereco.setBairro(response.getString("bairro"));
						endereco.setLogradouro(response.getString("logradouro"));
						endereco.setUf(response.getString("uf"));
						
						exchange.getMessage().setBody(endereco, Endereco.class);
						
					}
				})
	
		.end();
	}
	
}
