package br.com.farolshopping;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.farolshopping.model.Empresa;
import br.com.farolshopping.model.Endereco;

@SpringBootApplication
public class SpringCamelApplication {
	
	@Autowired
	private ProducerTemplate producerTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringCamelApplication.class, args);
	}
		
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			Empresa empresa = producerTemplate.requestBody("direct:buscarEmpresa", 
					"08258075000189", Empresa.class);
			String cep = empresa.getCep();
			cep = cep.replace(".", "");
			cep = cep.replace("-", "");
			Endereco endereco = producerTemplate.requestBody(
			"direct:buscarEndereco", cep, Endereco.class);
			empresa.setEndereco(endereco);
			System.out.println(empresa);
		};
	}
}
