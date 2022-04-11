package br.com.farolshopping.testes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TesteSerialClasseCriada {

    public static void main(String[] args) throws IOException {

        String nome = "Nico Steppat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objeto.bin"));

    }

}
