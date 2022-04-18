package br.com.farolshopping.teste.fila;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import org.springframework.stereotype.Component;

import br.com.farolshopping.facades.JmsConnection;
import br.com.farolshopping.teste.ITesteConsumer;
import lombok.Cleanup;

@Component
public class TesteConsumerFila implements ITesteConsumer{
	@SuppressWarnings("resource")
	public void testar() throws Exception {
		
		@Cleanup(value= "fechar")
		JmsConnection conexao = new JmsConnection();
		conexao.abrir();
		Session session = conexao.getConnection().createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination fila = (Destination)conexao.getContext().lookup("financeiro");
		
		MessageConsumer consumer = session.createConsumer(fila);
		consumer.setMessageListener(new MessageListener() {
			public void onMessage(Message message) {
				
				TextMessage textMessage = (TextMessage) message;
				try {
					System.out.println(textMessage.getText());
				} catch (JMSException e) {
					e.printStackTrace(); 
				}
			}
		});
		new Scanner(System.in).nextLine();
		session.close();
	}
}
