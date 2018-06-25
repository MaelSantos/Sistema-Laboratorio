package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(value = "MarcarExame") 
public class MarcarExame{
	
	private ExameGeral exame;
	private String nomeMedico, cpfPaciente, nomePaciente, parecer;
	private Andamento status;
	private String codigo;
	
	public MarcarExame(ExameGeral exame, String nomeMedico, String cpfPaciente, String parecer, String codigo) {
		
		for(Paciente p : BancoDados.getInstance().getPacientes())
			if(p.getCpf().equalsIgnoreCase(cpfPaciente))
			{
				p.getExames().add(this);
				nomePaciente = p.getNomeCompleto();
				break;
			}
		this.codigo=codigo;
		this.exame = exame;
		this.nomeMedico = nomeMedico;
		this.cpfPaciente = cpfPaciente;
		this.parecer = parecer;
		this.status = Andamento.nao_realizado;
	}

	public ExameGeral getExame() {
		return exame;
	}

	public void setExame(ExameGeral exame) {
		this.exame = exame;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public Andamento getStatus() {
		return status;
	}

	public void setStatus(Andamento status) {
		this.status = status;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getCodigo() {
		// TODO Auto-generated method stub
		return codigo;
	}
}
