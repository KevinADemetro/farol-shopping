public class Conta {
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total;
	
	public Conta() {}
	public Conta(int agencia, int numero) {
		total++;
		System.out.println("total de contas: "+total);
		this.agencia = agencia;
		this.numero = numero;
	}
	
	public void depositar(double valor) {
        if(valor>0){
            saldo += valor;
        }
	}

	public void sacar(double valor) {
        if(valor > 0 && saldo >= valor){
            saldo -= valor;
        }
	}

	public boolean transferir(double valor, Conta destino) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			destino.depositar(valor);
			return true;
		}
		return false;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		if(numero <=0) {
			System.out.println("n�o pode valor menor ou igual a zero");
			return;
		}
		this.numero = numero;
	}
	
 	public int getAgencia() {
		return agencia;
	}
 	
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("o n�mero da agencia n�o pode ser menor ou igual que zero");
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