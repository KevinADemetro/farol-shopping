package br.com.farolshopping.testes;

import java.io.IOException;
import java.io.PrintStream;

public class TesteEscritaPrintStream {
	
	public static void main(String[] args) throws IOException{
		
		PrintStream ps = new PrintStream("lorem2.txt");
		
		ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
		ps.println();
		ps.println("Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
		
		ps.close();
		
	}
}
