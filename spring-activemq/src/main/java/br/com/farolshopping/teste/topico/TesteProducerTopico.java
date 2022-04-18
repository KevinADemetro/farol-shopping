package br.com.farolshopping.teste.topico;

import java.io.StringWriter;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.xml.bind.JAXB;

import org.springframework.stereotype.Component;

import br.com.farolshopping.facades.JmsConnection;
import br.com.farolshopping.modelo.Pedido;
import br.com.farolshopping.modelo.PedidoFactory;
import br.com.farolshopping.teste.ITesteProcucer;
import lombok.Cleanup;

@Component
public class TesteProducerTopico implements ITesteProcucer{
	
	public void testar() throws Exception {
		
		@Cleanup(value = "fechar")
		JmsConnection conexao = new JmsConnection();
		conexao.abrir();
		Session session = conexao.getConnection().createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination topico = (Destination)conexao.getContext().lookup("loja");
		
		MessageProducer producer = session.createProducer(topico);
		
		Pedido pedido = new PedidoFactory().geraPedidoComValores();
		StringWriter writer = new StringWriter();
		JAXB.marshal(pedido, writer);
		String xml = writer.toString();
		
		Message message = session.createTextMessage(xml);
		message.setBooleanProperty("ebook", false);
		producer.send(message);
		session.close();
	}
}