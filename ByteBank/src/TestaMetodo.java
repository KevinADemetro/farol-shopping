
public class TestaMetodo {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.saldo = 100;
		conta.depositar(50);
		System.out.println(conta.saldo);
		
		boolean conseguiuRetirar = conta.sacar(20);
		System.out.println(conta.saldo);
		System.out.println(conseguiuRetirar);
		
		Conta outraConta = new Conta();
		outraConta.depositar(1000);
		
		if (outraConta.transferir(300, conta)) {
			System.out.println("trasnfencia com sucesso");
		}else{
			System.out.println("faltou dinheiro");
		};
		System.out.println(outraConta.saldo);
		System.out.println(conta.saldo);
	}
}
