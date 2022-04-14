
public class Gerente extends Funcionario implements Autenticavel{

	private int senha;
	private AutenticacaoUtil util;
	
	public Gerente() {
		this.util = new AutenticacaoUtil();
	}
	
	@Override
	public void setSenha(int senha) {
		this.util.setSenha(senha);
	}

	@Override
	public boolean autenticar(int senha) {
		return this.util.autenticar(senha);
	}
	
	public double getBonificacao() {
		return super.getSalario();
	}
}
