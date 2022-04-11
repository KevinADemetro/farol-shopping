package br.com.farolshopping.testes;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeEEncoding {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String s = "C";
		System.out.println(s.codePointAt(0));
		
		Charset charset = Charset.defaultCharset();
//		System.out.println(charset.displayName());
		
		byte[] bytes = s.getBytes();
		System.out.println(bytes.length + ", UTF-16");
		String sNovo = new String(bytes);
		System.out.println(sNovo);
		
		bytes = s.getBytes();
		System.out.println(bytes.length + ", US_ASCII");
		sNovo = new String(bytes);
		System.out.println(sNovo);
	}
}
