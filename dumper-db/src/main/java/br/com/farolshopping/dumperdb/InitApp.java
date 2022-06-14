package br.com.farolshopping.dumperdb;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class InitApp {

	@Autowired
	ProducerTemplate producerTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			String municipios = producerTemplate.requestBody(
					"direct:buscarMunicipios", "", String.class);
		};
		
	}

}
