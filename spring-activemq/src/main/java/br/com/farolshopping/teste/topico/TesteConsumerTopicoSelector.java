package br.com.farolshopping.teste.topico;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.springframework.stereotype.Component;

import br.com.farolshopping.facades.JmsConnection;
import br.com.farolshopping.teste.ITesteConsumer;
import lombok.Cleanup;

@Component
public class TesteConsumerTopicoSelector implements ITesteConsumer{
	
	@SuppressWarnings("resource")
	public void testar() throws Exception {
		
		@Cleanup(value = "fechar")
		JmsConnection conexao = new JmsConnection();
		conexao.abrir();
		
		Session session = conexao.getConnection().createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topico = (Topic)conexao.getContext().lookup("loja");
		
		MessageConsumer consumer = session.createDurableSubscriber(topico, "assinatura", "ebook=false", false);
		
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
