package br.com.farolshopping.factorys.abstracts;

import br.com.farolshopping.factorys.ConsumerFilaFactory;
import br.com.farolshopping.factorys.ConsumerTopicoFactory;
import br.com.farolshopping.factorys.enums.OpcaoJms;
import br.com.farolshopping.factorys.interfaces.IConsumerFactory;

public class AbstractFactoryConsumer {
	OpcaoJms tipoFactory;
	IConsumerFactory factory;
	
	public AbstractFactoryConsumer(OpcaoJms tipoFactory) {
		this.tipoFactory = tipoFactory;
	}
	public IConsumerFactory getFactory() {
		
		if (this.tipoFactory == OpcaoJms.FILA) {
			return new ConsumerFilaFactory();
		}else if(this.tipoFactory == OpcaoJms.TOPICO){
			return new ConsumerTopicoFactory();
		}
		
		return null;
	}
}