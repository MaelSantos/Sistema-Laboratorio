package modelVo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(value = "ExameGeral")
public class ExameGeral {

	private String codigo;
	private String tipoExame;
	private String tipoDeColeta;
	private double valor;
	
	public ExameGeral(String tipoExame, String tipoDeColeta, double valor, String codigo) {
		this.codigo = codigo;
		this.tipoExame = tipoExame;
		this.tipoDeColeta = tipoDeColeta;
		this.valor = valor;
		
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof ExameGeral) {
			ExameGeral geral = (ExameGeral) obj;
			
			if(geral.getCodigo().equalsIgnoreCase(codigo) ||
					geral.getTipoExame().equalsIgnoreCase(tipoExame))
				return true;
		}
		
		if (obj instanceof String) {
			String string = (String) obj;
			
			if(codigo.equalsIgnoreCase(string) ||
					tipoExame.equalsIgnoreCase(string) )
				return true;
			
		}
		
		return super.equals(obj);
	}
	
}
