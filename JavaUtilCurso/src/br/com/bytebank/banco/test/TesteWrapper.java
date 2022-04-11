package br.com.bytebank.banco.test;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapper {
		
	public static void main(String[] args) {
		
		 int[] idades = new int[5];
		 String[] nomes = new String[5];
		 
		 int idade = 29;
		 
		 Integer idadeRef = Integer.valueOf(29);
		 int valor = idadeRef.intValue();
		 
		 String s = args[0];
		 
		 Integer numero = Integer.valueOf(s);
//		 System.out.println(numero);
		 
		 List<Integer> numeros = new ArrayList<Integer>();
		 numeros.add(29);
		 
		 System.out.println(Integer.MAX_VALUE);
		 System.out.println(Integer.MIN_VALUE);
		 Integer i = Integer.valueOf(2147483647+1);
		 
		 System.out.println(i);
		 
	}
	
}
