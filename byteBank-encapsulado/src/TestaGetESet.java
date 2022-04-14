
public class TestaGetESet {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setNumero(1337);
		
		System.out.println(conta.getNumero());
		
		Cliente paulo = new Cliente();
		
		paulo.setNome("Paulo Silveira");
		conta.setTitular(paulo);
		
		System.out.println(conta.getTitular().getNome());
		System.out.println(paulo.getNome());
		
		System.out.println(paulo);
		System.out.println(conta.getTitular());
		
		conta.getTitular().setProfissao("programador");
		
		System.out.println(paulo.getProfissao());
		
		Cliente titularDaConta = conta.getTitular();
		titularDaConta.setProfissao("programador");
		
		System.out.println(paulo == titularDaConta);
		
	}
}
