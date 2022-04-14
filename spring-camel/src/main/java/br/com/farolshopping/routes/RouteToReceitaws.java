package br.com.farolshopping.routes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import br.com.farolshopping.model.Empresa;

@Component
public class RouteToReceitaws extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:buscarEmpresa")
			.id("preparando corpo da requisição")
				.process(new Processor() {
					
					@Override
					public void process(Exchange exchange) throws Exception {
						String cnpj = exchange.getMessage().getBody(String.class);
						exchange.setProperty("cnpj", cnpj);
					}
				})
				.setHeader(Exchange.HTTP_METHOD, constant("GET"))
				.toD("https://receitaws.com.br/v1/cnpj/${exchangeProperty[cnpj]}")
				.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						JSONObject response = new JSONObject(exchange.getMessage()
								.getBody(String.class));
						Empresa empresa = new Empresa();
						empresa.setNome(response.getString("nome"));
						empresa.setTelefone(response.getString("telefone"));
						
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
						String date = response.getString("abertura");
						empresa.setDataDeAbertura(LocalDate.parse(date, formatter));
						empresa.setCnpj(response.getString("cnpj"));
						empresa.setCep(response.getString("cep"));
						exchange.getMessage().setBody(empresa, Empresa.class);
					}
				})
		.end();
			
	}

}
