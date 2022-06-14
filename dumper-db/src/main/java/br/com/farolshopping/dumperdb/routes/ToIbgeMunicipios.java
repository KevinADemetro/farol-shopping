package br.com.farolshopping.dumperdb.routes;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ToIbgeMunicipios extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:buscarMunicipios")
			.setHeader(Exchange.HTTP_METHOD, constant("GET"))
			.toD("https://servicodados.ibge.gov.br/api/v1/localidades/municipios")				
			.process(processarResultado())
		.end();
	}

	private Processor processarResultado() {
		return new Processor() {				
			@Override
			public void process(Exchange exchange) throws Exception {
				JSONObject response = capturarResposta(exchange);
				List<String> insertDeMunicipios = new ArrayList<String>();
				insertDeMunicipios = gerarArrayDeInsert(response);
				
				exchange.getMessage().setBody(response, JSONObject.class);
			}
		};
	}

	
	protected List<String> gerarArrayDeInsert(JSONObject response) {
		JSONArray lista = response.getJSONArray("lista");
		for(Object municipio : lista) {
			JSONObject jsonMunicipo = (JSONObject) municipio;
//			System.out.println(jsonMunicipo.getString("id"));
//			System.out.println(jsonMunicipo.getString("nome"));
			String id = jsonMunicipo.getString("id");
			String nome = jsonMunicipo.getString("nome");
			String uf = jsonMunicipo.getJSONObject("microrregiao").getJSONObject("mesorregiao")
					.getJSONObject("UF").getString("sigla");
			
			String insert = "INSERT INTO municipios (id, nome, uf) VALUES ("+id+")";
		}
		return null;
	}

	private JSONObject capturarResposta(Exchange exchange) {
		return new JSONObject("{lista: "+exchange
				.getMessage().getBody(String.class)+"}");
	}
}