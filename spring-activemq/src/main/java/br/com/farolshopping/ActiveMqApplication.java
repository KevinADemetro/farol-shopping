package br.com.farolshopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.farolshopping.teste.TesteConsumer;
import br.com.farolshopping.teste.TesteProducer;

@SpringBootApplication
public class ActiveMqApplication {

	@Autowired
	TesteConsumer testeConsumer;
	@Autowired
	TesteProducer testeProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(ActiveMqApplication.class, args);
	}
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) throws Exception{
		return args -> {
			System.out.println("asd");
			testeConsumer.testar();
			testeProducer.testar();
		};
	}
}
