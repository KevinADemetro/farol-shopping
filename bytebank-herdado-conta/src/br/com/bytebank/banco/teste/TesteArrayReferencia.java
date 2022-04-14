package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayReferencia {
	
	public static void main(String[] args) {
		ContaCorrente[] contas = new ContaCorrente[5];
		ContaCorrente cc1 = new ContaCorrente(22,31);
		contas[0] = cc1;
		
		ContaCorrente cc2 = new ContaCorrente(231, 324);
		contas[1] = cc2;
		
		System.out.println(contas[1].getAgencia());
		
		 int[] refs = {1,2,3,4,5,6};
		 
		 System.out.println(refs[2]);
	}
}
