package br.com.bytebank.banco.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteClasseAnonimas {
	public static void main(String[] args) {
		
		List<Conta> lista = new ArrayList<Conta>();
		Conta cc1 = new ContaCorrente(142, 325);
		Conta cc2 = new ContaCorrente(230, 456);
		Conta cc3 = new ContaCorrente(0, 0);
		Conta cc4 = new ContaCorrente(681, 727);
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);
		
		int saldo = 50;
		
		for (Conta conta : lista) {
			saldo *= 2;
			conta.deposita(saldo);
			System.out.println(conta);
		}
		
		System.out.println("-------------------------");
		
		// Classe anonima que implementa comparator
		lista.sort(new Comparator<Conta> (){
			@Override
			public int compare(Conta c1, Conta c2) {
				return c1.getNumero() - c2.getNumero(); 
			}
		});
		

		// Inverte a ordem da classe
		Collections.reverse(lista);
		
		// Sort by compareTo da classe conta
		Collections.sort(lista);
		
		for (Conta conta : lista) {
			System.out.println(conta);
		}
		
	}
}