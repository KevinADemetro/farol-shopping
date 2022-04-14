
public class TesteValoresNegativos {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.depositar(100);
		System.out.println(conta.sacar(101));
		
		System.out.println(conta.getSaldo());
	}
}
