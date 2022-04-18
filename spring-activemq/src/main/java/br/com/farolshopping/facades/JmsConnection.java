package br.com.farolshopping.facades;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import lombok.Data;

@Data
public class JmsConnection {
	InitialContext context;
	ConnectionFactory factory;
	Connection connection;
	
	public void abrir() throws JMSException, NamingException {
		this.context = new InitialContext();
		this.factory = (ConnectionFactory) this.context.lookup("ConnectionFactory");
		this.connection = factory.createConnection();
		connection.setClientID("estoque");
		connection.start();
	}
	
	public void fechar() throws NamingException, JMSException {
		this.connection.close();
		this.context.close();
	}
}
