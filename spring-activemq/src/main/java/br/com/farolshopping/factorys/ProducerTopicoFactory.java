package br.com.farolshopping.factorys;

import br.com.farolshopping.factorys.interfaces.IProducerFactory;
import br.com.farolshopping.teste.ITesteProcucer;
import br.com.farolshopping.teste.topico.TesteProducerTopico;

public class ProducerTopicoFactory implements IProducerFactory{
	TesteProducerTopico producer;
	
	public ProducerTopicoFactory() {
		this.producer = new TesteProducerTopico();
	}
	
	@Override
	public ITesteProcucer getProducer() {
		return this.producer;
	}
}