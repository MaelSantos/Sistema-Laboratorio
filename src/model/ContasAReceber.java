package model;

public class ContasAReceber {
	private String cpfPaciente, dataVencimento, dataFluxo, codigo, valor, referencia, tipoPagamento, qtdParcelas;

	public ContasAReceber(String cpfPaciente, String dataVencimento, String dataFluxo, String codigo, String valor,
			String referencia, String tipoPagamento, String qtdParcelas) {
		super();
		this.cpfPaciente = cpfPaciente;
		this.dataVencimento = dataVencimento;
		this.dataFluxo = dataFluxo;
		this.codigo = codigo;
		this.valor = valor;
		this.referencia = referencia;
		this.tipoPagamento = tipoPagamento;
		this.qtdParcelas = qtdParcelas;
	}

	public ContasAReceber(String cpfPaciente, String dataVencimento, String dataFluxo, String codigo, String valor,
			String referencia, String tipoPagamento) {
		super();
		this.cpfPaciente = cpfPaciente;
		this.dataVencimento = dataVencimento;
		this.dataFluxo = dataFluxo;
		this.codigo = codigo;
		this.valor = valor;
		this.referencia = referencia;
		this.tipoPagamento = tipoPagamento;

	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getDataFluxo() {
		return dataFluxo;
	}

	public void setDataFluxo(String dataFluxo) {
		this.dataFluxo = dataFluxo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(String qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	
	@Override
	public String toString() {
		return cpfPaciente;
	}

}
