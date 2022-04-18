package br.com.farolshopping.teste.fila;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.springframework.stereotype.Component;

import br.com.farolshopping.facades.JmsConnection;
import br.com.farolshopping.teste.ITesteProcucer;
import lombok.Cleanup;

@Component
public class TesteProducerFila implements ITesteProcucer{
	
	public void testar() throws Exception {
		
		@Cleanup(value = "fechar")
		JmsConnection conexao = new JmsConnection();
		conexao.abrir();
		
		Session session = conexao.getConnection().createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination fila = (Destination)conexao.getContext().lookup("financeiro");
		MessageProducer producer = session.createProducer(fila);
		
		for (int i = 0; i < 1000; i++) {
			Message message = session.createTextMessage("<pedido><id>"+i+"</id></pedido>");
			producer.send(message);
		}
		session.close();
	}
}
