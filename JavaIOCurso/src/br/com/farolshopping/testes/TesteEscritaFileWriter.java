package br.com.farolshopping.testes;

import java.io.FileWriter;
import java.io.IOException;

public class TesteEscritaFileWriter {
	
	public static void main(String[] args) throws IOException{
		
//		OutputStream os = new FileOutputStream("arquivoDeTexto2.txt");
//		Writer osw = new OutputStreamWriter(os); 
//		BufferedWriter bw = new BufferedWriter(osw);
		
		FileWriter fw = new FileWriter("lorem2.txt");
		
		fw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
		fw.write(System.lineSeparator());
		fw.write("Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
		fw.close();
	}
}
