package br.com.bytebank.banco.modelo;

import java.io.Serializable;

public abstract class Conta implements Serializable{
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total;
	
	public Conta(int agencia, int numero) {
		total++;
		this.agencia = agencia;
		this.numero = numero;
	}
	
	public abstract void depositar(double valor);

	public void sacar(double valor) throws SaldoInsuficienteException{

        if(this.saldo < valor) {
            throw new SaldoInsuficienteException("saldo " + this.saldo + " valor " + valor);
        } 

        this.saldo -= valor;       
}

	public void transferir(double valor, Conta destino) throws SaldoInsuficienteException{
	    this.sacar(valor);
	    destino.depositar(valor);
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		if(numero <=0) {
			System.out.println("não pode valor menor ou igual a zero");
			return;
		}
		this.numero = numero;
	}
	
 	public int getAgencia() {
		return agencia;
	}
 	
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("o número da agencia não pode ser menor ou igual que zero");
			return;
		}
		this.agencia = agencia;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public static int getTotal() {
		return total;
	}
}