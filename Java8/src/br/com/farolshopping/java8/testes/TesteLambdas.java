package br.com.farolshopping.java8.testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TesteLambdas {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("teste 1");
		palavras.add("teste dois");
		palavras.add("dfssghgsdfsdf");
		palavras.add("fd");
		
		
		palavras.sort((s1, s2) -> {
		    return Integer.compare(s1.length(), s2.length()); 
		});
		
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		palavras.sort(Comparator.comparing(String::length));
		
		Consumer<String> impressor = System.out::println;
		
		palavras.forEach(impressor);
		palavras.forEach(System.out::println);
		System.out.println("-----------------");
		
		palavras.stream()
			.filter(s -> s.length() > 7)
			.forEach(System.out::println);
		
		System.out.println("-----------------");

		palavras.stream()
		.filter(s -> s.length() > 89)
		.findAny()
		.ifPresent(System.out::println);
		
		System.out.println("-----------------");

		List<String> lista = palavras.stream()
			.filter(s -> s.length() > 7)
			.collect(Collectors.toList());
		
		lista.forEach(System.out::println);
		
	}
}
