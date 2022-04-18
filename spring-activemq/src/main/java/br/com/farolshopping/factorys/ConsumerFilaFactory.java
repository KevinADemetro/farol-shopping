package br.com.farolshopping.factorys;

import br.com.farolshopping.factorys.interfaces.IConsumerFactory;
import br.com.farolshopping.teste.ITesteConsumer;
import br.com.farolshopping.teste.fila.TesteConsumerFila;

public class ConsumerFilaFactory implements IConsumerFactory{
	
	TesteConsumerFila consumer;
	
	public ConsumerFilaFactory() {
		this.consumer = new TesteConsumerFila();
	}
	
	@Override
	public ITesteConsumer getConsumer() {
		return this.consumer;
	}
}