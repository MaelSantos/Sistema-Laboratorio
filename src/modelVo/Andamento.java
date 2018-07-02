package modelVo;

public enum Andamento {

	nao_realizado("N�o Realizado"), em_andamento("Em Andamento"), concluido("Concluido");

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
