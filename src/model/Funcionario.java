package model;

public class Funcionario extends Usuario {
	
	private String cargo;
	
	public Funcionario(String login, String senha, String nomeCompleto, Endereco endereco, String cpf, String idade,
			String sexo, String tipoSanguineo, String email, String telefone, String caminho) {
		super(login, senha, nomeCompleto, endereco, cpf, idade, sexo, tipoSanguineo, email, telefone, caminho);
		// TODO Stub de construtor gerado automaticamente
	}

}
