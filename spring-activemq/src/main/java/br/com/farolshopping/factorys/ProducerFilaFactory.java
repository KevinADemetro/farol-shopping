package br.com.farolshopping.factorys;

import br.com.farolshopping.factorys.interfaces.IProducerFactory;
import br.com.farolshopping.teste.ITesteProcucer;
import br.com.farolshopping.teste.fila.TesteProducerFila;

public class ProducerFilaFactory implements IProducerFactory{

	TesteProducerFila producer;
	
	public ProducerFilaFactory() {
		this.producer = new TesteProducerFila();
	}
	
	@Override
	public ITesteProcucer getProducer() {
		return this.producer;
	}
}
