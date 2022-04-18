package br.com.farolshopping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.farolshopping.factorys.abstracts.AbstractFactoryConsumer;
import br.com.farolshopping.factorys.abstracts.AbstractFactoryProducer;
import br.com.farolshopping.factorys.enums.OpcaoJms;
import br.com.farolshopping.factorys.interfaces.IConsumerFactory;
import br.com.farolshopping.factorys.interfaces.IProducerFactory;
import br.com.farolshopping.teste.ITesteConsumer;
import br.com.farolshopping.teste.ITesteProcucer;

@SpringBootApplication
public class ActiveMqApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ActiveMqApplication.class, args);
	}
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) throws Exception{
		return args -> {
			AbstractFactoryProducer abstractFactoryProducer;
			AbstractFactoryConsumer abstractfactoryConsumer;
			abstractFactoryProducer = new AbstractFactoryProducer(OpcaoJms.TOPICO);
			abstractfactoryConsumer = new AbstractFactoryConsumer(OpcaoJms.TOPICO);
			IProducerFactory producerFactory = abstractFactoryProducer.getFactory();
			IConsumerFactory consumerFactory = abstractfactoryConsumer.getFactory();
			ITesteConsumer consumer = consumerFactory.getConsumer();
			ITesteProcucer producer = producerFactory.getProducer();

			producer.testar();
			consumer.testar();

		};
	}
}