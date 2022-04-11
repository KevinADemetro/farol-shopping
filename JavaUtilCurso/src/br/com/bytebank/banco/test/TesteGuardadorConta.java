package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorDeContas;

public class TesteGuardadorConta {
	public static void main(String[] args) {
		
		GuardadorDeContas guardador = new GuardadorDeContas();
		
		Conta cc = new ContaCorrente(22, 11);
		guardador.adicionar(cc);
		
		Conta cc2 = new ContaCorrente(11, 31);
		guardador.adicionar(cc2);
				
		Conta ref = guardador.getRefencia(0);
		System.out.println(ref.getNumero());
		
	}
}
