package model;

public class Exame {
	private String nomeMedico, cpfPaciente, parecer;
	
	
	public Exame() {
		
	}


	public Exame(String nomeMedico, String parecer) {
		super();
		this.nomeMedico = nomeMedico;
		this.parecer = parecer;
		
	}
	
	
	public Exame(String nomeMedico, String cpfPaciente, String parecer) {
		super();
		this.nomeMedico = nomeMedico;
		this.cpfPaciente = cpfPaciente;
		this.parecer = parecer;
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
