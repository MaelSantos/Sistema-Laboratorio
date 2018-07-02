package modelVo;

public class DespesasVo {

	private String discricao, fornecedor, plano, centro_custo, data;
	private double valor,valorPacerla;
	private int numeros_parcela;
	private int intervalo_parcelas;
	
	public DespesasVo(String discricao, String fornecedor, String plano, String centro_custo, String data, double valor,
			int numeros_parcela, int intervalo_parcelas, double valorPacerla) {
		this.discricao = discricao;
		this.fornecedor = fornecedor;
		this.plano = plano;
		this.centro_custo = centro_custo;
		this.data = data;
		this.valor = valor;
		this.numeros_parcela = numeros_parcela;
		this.intervalo_parcelas = intervalo_parcelas;
		this.valorPacerla = valorPacerla;
	}

	public String getDiscricao() {
		return discricao;
	}

	public void setDiscricao(String discricao) {
		this.discricao = discricao;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		plano = plano;
	}

	public String getCentro_custo() {
		return centro_custo;
	}

	public void setCentro_custo(String centro_custo) {
		this.centro_custo = centro_custo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getNumeros_parcela() {
		return numeros_parcela;
	}

	public void setNumeros_parcela(int numeros_parcela) {
		this.numeros_parcela = numeros_parcela;
	}

	public int getIntervalo_parcelas() {
		return intervalo_parcelas;
	}

	public void setIntervalo_parcelas(int intervalo_parcelas) {
		this.intervalo_parcelas = intervalo_parcelas;
	}

	public double getValorPacerla() {
		return valorPacerla;
	}

	public void setValorPacerla(double valorPacerla) {
		this.valorPacerla = valorPacerla;
	}
	

	
}
