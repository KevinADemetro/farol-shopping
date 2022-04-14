
public class TesteReferencia {
	public static void main(String[] args) {
		
		Gerente g1 = new Gerente();
		Funcionario f1 = new Gerente();
		
		g1.setNome("Mario");
		g1.setSalario(10000);
		f1.setSalario(1000);
		String nome = g1.getNome();
		
		ControleBonificacao controleBonificacao = new ControleBonificacao();
		controleBonificacao.registrar(g1);
		controleBonificacao.registrar(f1);
		
		System.out.println(controleBonificacao.getSoma());
	}
}
