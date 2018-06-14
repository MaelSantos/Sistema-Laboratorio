
package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

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
	private String caminho;
	
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
			this.caminho = nome+".jpg";
			copyFile(new File(caminho), new File("res/"+nome+caminho.toString().substring(caminho.toString().lastIndexOf("."), caminho.toString().length())));
			this.imagem = ImageIO.read(getClass().getClassLoader().getResourceAsStream(this.caminho));
			
		} catch (Exception e) {
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
	
	@SuppressWarnings("resource")
	public static void copyFile(File source, File destination) throws IOException {
        if (destination.exists())
            destination.delete();
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen())
                sourceChannel.close();
            if (destinationChannel != null && destinationChannel.isOpen())
                destinationChannel.close();
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

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	@Override
	public String toString() {
		return getCpf();
	}
	
}
