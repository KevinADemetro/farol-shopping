
public class TesteContaComMinhaExcecao {
	public static void main(String[] args) {
		
		Conta c = new Conta();
		try {
			c.depositar();
			
		} catch (MinhaExcecao me) {
			System.out.println("trata");
		}
	}
}
