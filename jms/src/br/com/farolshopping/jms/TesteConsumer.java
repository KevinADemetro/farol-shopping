package br.com.farolshopping.jms;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.naming.InitialContext;

public class TesteConsumer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		
		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		connection.start();
		new Scanner(System.in).nextLine();
		
		connection.close();
		context.close();
	}
}