package model;

public class Administrador extends Funcionario {

	public Administrador(String login, String senha, String nomeCompleto, Endereco endereco, String cpf, String idade,
			String sexo, String tipoSanguineo, String email, String telefone, String caminho) {
		super(login, senha, nomeCompleto, endereco, cpf, idade, sexo, tipoSanguineo, email, telefone, caminho);
		// TODO Stub de construtor gerado automaticamente
	}

	public Administrador(String login, String senha, String nomeCompleto, Endereco endereco, String cpf, String idade,
			String sexo, String tipoSanguineo, String email, String telefone) {
		super(login, senha, nomeCompleto, endereco, cpf, idade, sexo, tipoSanguineo, email, telefone);
		// TODO Stub de construtor gerado automaticamente
	}

}
