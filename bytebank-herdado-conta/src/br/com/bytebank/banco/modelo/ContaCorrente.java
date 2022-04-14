package br.com.bytebank.banco.modelo;

import java.io.Serializable;

public class ContaCorrente extends Conta implements Serializable{

	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}

	@Override
	public void sacar(double valor) throws SaldoInsuficienteException {
		double valorASacar = valor + 0.2;
		super.sacar(valorASacar);
	}

	@Override
	public void depositar(double valor) {
		super.saldo += valor;
	}
}
