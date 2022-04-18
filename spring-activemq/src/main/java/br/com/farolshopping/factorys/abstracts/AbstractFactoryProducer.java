package br.com.farolshopping.factorys.abstracts;

import br.com.farolshopping.factorys.ProducerFilaFactory;
import br.com.farolshopping.factorys.ProducerTopicoFactory;
import br.com.farolshopping.factorys.enums.OpcaoJms;
import br.com.farolshopping.factorys.interfaces.IConsumerFactory;
import br.com.farolshopping.factorys.interfaces.IProducerFactory;

public class AbstractFactoryProducer {
	OpcaoJms tipoFactory;
	IConsumerFactory factory;
	
	public AbstractFactoryProducer(OpcaoJms tipoFactory) {
		this.tipoFactory = tipoFactory;
	}
	
	public IProducerFactory getFactory() {
		
		if (this.tipoFactory == OpcaoJms.FILA) {
			return new ProducerFilaFactory();
		}else if(this.tipoFactory == OpcaoJms.TOPICO){
			return new ProducerTopicoFactory();
		}
		return null;
	}
}