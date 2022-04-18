package br.com.farolshopping.factorys.interfaces;

import br.com.farolshopping.teste.ITesteProcucer;

public interface IProducerFactory {
	public ITesteProcucer getProducer();
}