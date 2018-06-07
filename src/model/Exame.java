package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(value = "Exame") 
public class Exame {
	private String nomeMedico, cpfPaciente, parecer, tipoExame, tipoAmostra, status;
	
	public Exame() {
		
	}

	public Exame(String nomeMedico, String cpfPaciente, String parecer, String tipoExame, String tipoAmostra
			) {
		super();
		this.nomeMedico = nomeMedico;
		this.cpfPaciente = cpfPaciente;
		this.parecer = parecer;
		this.tipoExame = tipoExame;
		this.tipoAmostra = tipoAmostra;
		this.status = "Em Espera";
	}



	public String getNomeMedico() {
		return nomeMedico;
	}


	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}


	public String getCPFPaciente() {
		return cpfPaciente;
	}


	public void setNCPFPaciente(String nomePaciente) {
		this.cpfPaciente = nomePaciente;
	}


	public String getParecer() {
		return parecer;
	}


	public void setParecer(String parecer) {
		this.parecer = parecer;
	}
	
}
