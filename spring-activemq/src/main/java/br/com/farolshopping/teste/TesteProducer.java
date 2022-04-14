package br.com.farolshopping.teste;

import java.util.Iterator;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

import org.springframework.stereotype.Component;

@Component
public class TesteProducer{
	
	public void testar() throws Exception {
		System.out.println("sdads");
		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination fila = (Destination)context.lookup("financeiro");
		
		MessageProducer producer = session.createProducer(fila);
		Message message = session.createTextMessage("<pedido><id>123</id></pedido>");
		
		for (int i = 0; i < 100; i++) {
			producer.send(message);
		}
		
		session.close();
		connection.close();
		context.close();
	}
}
