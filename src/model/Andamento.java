package model;

public enum Andamento {

	solicitado("Solicitado"), em_andamento("Em Andamento"), concluido("Concluido");

	private String nome;
	Andamento(String nome)
	{
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
