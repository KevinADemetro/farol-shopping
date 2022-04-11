package br.com.bytebank.banco.test;

import java.util.List;
import java.util.Vector;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteLinkedList {
	public static void main(String[] args) {
		
		List<Conta> lista = new Vector<>();
		
		ContaCorrente cc = new ContaCorrente(599, 872);
		ContaCorrente cc2 = new ContaCorrente(472, 246);
		
		lista.add(cc2);
		lista.add(cc);
		
		System.out.println(lista.contains(cc2));
	}
}
