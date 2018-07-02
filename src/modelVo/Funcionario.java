package modelVo;

public class Funcionario extends Usuario {
	
	private String cargo;
	
	public Funcionario(String login, String senha, String nomeCompleto, Endereco endereco, String cpf, String idade,
			String sexo, String tipoSanguineo, String email, String telefone, String caminho) {
		super(login, senha, nomeCompleto, endereco, cpf, idade, sexo, tipoSanguineo, email, telefone, caminho);
		// TODO Stub de construtor gerado automaticamente
	}
	
	public Funcionario(String login, String senha, String nomeCompleto, Endereco endereco, String cpf, String idade,
			String sexo, String tipoSanguineo, String email, String telefone) {
		super(login, senha, nomeCompleto, endereco, cpf, idade, sexo, tipoSanguineo, email, telefone);
		// TODO Stub de construtor gerado automaticamente
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
