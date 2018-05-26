package model;

public class Paciente extends Usuario{

	//exames
	
	public Paciente(String nomeCompleto, String cpf, String idade, String sexo, String tipoSanguineo, String email,
			String telefone, Endereco endereco) {
		
//		(login, senha, nomeCompleto, endereco, cpf, idade, sexo, tipoSanguineo, email, telefone)
		super(nomeCompleto,cpf,nomeCompleto,endereco,cpf,idade,sexo,tipoSanguineo,email,telefone,"");

	}
		
}
