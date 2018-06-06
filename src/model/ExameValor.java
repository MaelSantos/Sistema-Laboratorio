package model;

public class ExameValor {
	
	private String nome;
	private String tipoDeColeta;
	private double valor;
	
	public ExameValor(String nome, String tipoDeColeta, double valor) {
		this.nome = nome;
		this.tipoDeColeta = tipoDeColeta;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoDeColeta() {
		return tipoDeColeta;
	}

	public void setTipoDeColeta(String tipoDeColeta) {
		this.tipoDeColeta = tipoDeColeta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
