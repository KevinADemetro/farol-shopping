package br.com.bytebank.banco.test;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class ArrayListTeste {
	public static void main(String[] args) {
		
		ArrayList lista = new ArrayList();
		
		Conta cc1 = new ContaCorrente(31, 12);
		lista.add(cc1);
		
		Object cc2 = new ContaCorrente(313, 3213);
		
		lista.add(cc2);
		
		for(Object oRef : lista) {
			System.out.println(oRef);
		}
	}
}
