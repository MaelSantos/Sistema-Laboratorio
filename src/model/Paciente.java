package model;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(value = "Paciente") 
public class Paciente extends Usuario{

	private ArrayList<Exame>exames;
	
	public Paciente(String nomeCompleto, String cpf, String idade, String sexo, String tipoSanguineo, String email,
			String telefone, Endereco endereco) {
		
//		(login, senha, nomeCompleto, endereco, cpf, idade, sexo, tipoSanguineo, email, telefone)
		super(nomeCompleto,cpf,nomeCompleto,endereco,cpf,idade,sexo,tipoSanguineo,email,telefone,"");
		exames = new ArrayList<>();

	}

	public ArrayList<Exame> getExames() {
		return exames;
	}

	public void setExames(ArrayList<Exame> exames) {
		this.exames = exames;
	}
	
		
}
