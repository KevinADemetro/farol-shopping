
public class TesteFuncionario {
	public static void main(String[] args) {
		
		Gerente funcionario = new Gerente(); 
		funcionario.setNome("Kevin");
		funcionario.setCpf("123.123.123-12");
		funcionario.setSalario(3000.00);
		
		System.out.println(funcionario.getNome());
		System.out.println("bonificação "+ funcionario.getBonificacao());
	}
}
