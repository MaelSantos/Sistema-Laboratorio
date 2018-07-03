package modelVo;

public class DespesasVo {

	private String discricao, fornecedor, plano, centro_custo, data;
	private String valor, valorParcela;
	private String numeros_parcela;
	private String intervalo_parcelas;
	
	public DespesasVo(String discricao, String fornecedor, String plano, String centro_custo, String data, String valor,
			String numeros_parcela, String intervalo_parcelas, String valorParcela) {
		this.discricao = discricao;
		this.fornecedor = fornecedor;
		this.plano = plano;
		this.centro_custo = centro_custo;
		this.data = data;
		this.valor = valor;
		this.numeros_parcela = numeros_parcela;
		this.intervalo_parcelas = intervalo_parcelas;
		this.valorParcela = valorParcela;
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getNumeros_parcela() {
		return numeros_parcela;
	}

	public void setNumeros_parcela(String numeros_parcela) {
		this.numeros_parcela = numeros_parcela;
	}

	public String getIntervalo_parcelas() {
		return intervalo_parcelas;
	}

	public void setIntervalo_parcelas(String intervalo_parcelas) {
		this.intervalo_parcelas = intervalo_parcelas;
	}

	public String getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(String valorParcela) {
		this.valorParcela = valorParcela;
	}
}
