
package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Usuario {

	private String login, senha;
	private String nomeCompleto, nome, sobrenome;
	private Endereco endereco;	
	private String cpf;
	private String idade;
	private String sexo;
	private String tipoSanguineo;
	private String email;
	private String telefone;
	
	private BufferedImage imagem;

	public Usuario(String login, String senha, String nomeCompleto, Endereco endereco, String cpf,
			String idade, String sexo, String tipoSanguineo, String email, String telefone, String caminho) {
		this.login = login;
		this.senha = senha;
		this.nomeCompleto = nomeCompleto;
		
		this.nome = nomeCompleto.split(" ")[0];
		this.sobrenome = nomeCompleto.split(" ")[1];
		
		this.endereco = endereco;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
		this.tipoSanguineo = tipoSanguineo;
		this.email = email;
		this.telefone = telefone;
		
		try {
			this.imagem = ImageIO.read(getClass().getClassLoader().getResourceAsStream(caminho));
		} catch (IOException e) {
			System.err.println("Erro ao carregar imagem!!!"+e.getMessage());
			e.printStackTrace();
		}
	}

	public Usuario(String login, String senha, String nomeCompleto, Endereco endereco, String cpf,
			String idade, String sexo, String tipoSanguineo, String email, String telefone) {
		this.login = login;
		this.senha = senha;
		this.nomeCompleto = nomeCompleto;
		
		this.nome = nomeCompleto.split(" ")[0];
		this.sobrenome = nomeCompleto.split(" ")[1];
		
		this.endereco = endereco;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
		this.tipoSanguineo = tipoSanguineo;
		this.email = email;
		this.telefone = telefone;
		
	}	
	
	public Usuario(String login, String senha, String caminho) {
		this.login = login;
		this.senha = senha;
		
		try {
			this.imagem = ImageIO.read(getClass().getClassLoader().getResourceAsStream(caminho));
		} catch (IOException e) {
			System.err.println("Erro ao carregar imagem!!!"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	//metodos de acesso
	public String getLogin() {
		return login;
	}
	
	public String getSenha() {
		return senha;
	}

	public BufferedImage getImagem() {
		return imagem;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public String getIdade() {
		return idade;
	}

	public String getSexo() {
		return sexo;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

}
