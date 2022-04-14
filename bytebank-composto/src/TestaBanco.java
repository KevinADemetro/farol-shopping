
public class TestaBanco {
	public static void main(String[] args) {
		
		Cliente paulo = new Cliente();
		paulo.nome = "Paulo Silveira";
		paulo.cpf= "123.123.123-12";
		paulo.profissao = "programador";
		
		Conta contaDoPaulo = new Conta();
		
		contaDoPaulo.depositar(100);
		contaDoPaulo.titular = paulo;
		System.out.println(contaDoPaulo.titular.nome);
	}
}
