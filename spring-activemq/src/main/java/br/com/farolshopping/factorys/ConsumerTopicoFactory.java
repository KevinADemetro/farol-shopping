package br.com.farolshopping.factorys;

import br.com.farolshopping.factorys.interfaces.IConsumerFactory;
import br.com.farolshopping.teste.ITesteConsumer;
import br.com.farolshopping.teste.topico.TesteConsumerTopico;
import br.com.farolshopping.teste.topico.TesteConsumerTopicoSelector;

public class ConsumerTopicoFactory implements IConsumerFactory{
	
	TesteConsumerTopico consumer;
	
	public ConsumerTopicoFactory() {
		this.consumer = new TesteConsumerTopico();
	}
	
	@Override
	public ITesteConsumer getConsumer() {
		return this.consumer;
	}
}