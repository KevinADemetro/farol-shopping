package br.com.farolshopping.model;

import java.time.LocalDate;

import br.com.farolshopping.enums.Situacao;
import lombok.Data;

@Data
public class Empresa {
	String nome;
	String telefone;
	Situacao situacao;
	Endereco endereco;
	String cep;
	LocalDate dataDeAbertura;
	String cnpj;
}