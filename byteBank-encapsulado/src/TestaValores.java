
public class TestaValores {
	
	public static void main(String[] args) {
		
		System.out.println(Conta.getTotal());
		
		Conta conta = new Conta(1337, 26887);
		
//		conta.setAgencia(-50);
//		conta.setNumero(-80);
		
		Conta conta2 = new Conta(1337, 2345);
		Conta conta3 = new Conta(1658, 8871);

		System.out.println(Conta.getTotal());
		System.out.println(conta.getTotal());
		System.out.println(conta3.getTotal());
	}
}
