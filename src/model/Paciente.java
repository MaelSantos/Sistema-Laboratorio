package model;

public class Paciente {

	private String nome;
	private String cpf;
	private int idade;
	private String sexo;
	private String tipoSanguineo;
	private String email;
	private String telefone;
	private Endereco endereco;
	
	public Paciente(String nome, String cpf, String sexo) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
	}

	public Paciente(String nome, String cpf, int idade, String sexo, String tipoSanguineo, String email,
			String telefone, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
		this.tipoSanguineo = tipoSanguineo;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
		
}
