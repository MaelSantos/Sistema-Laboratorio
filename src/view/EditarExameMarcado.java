package view;



import javax.swing.BorderFactory;
import javax.swing.JComboBox;

import modelVo.Andamento;
import modelVo.MarcarExame;

@SuppressWarnings("serial")
public class EditarExameMarcado extends Marcar{
	private MarcarExame exame;
	private JComboBox<Andamento> status;
	public EditarExameMarcado() {
		status = new JComboBox<>();
		status.addItem(Andamento.nao_realizado);
		status.addItem(Andamento.em_andamento);
		status.addItem(Andamento.concluido);
		remove(getBtnAdd());
		add(status);
		getBtnAdd().setText("Salvar");
		add(getBtnAdd());
		
		setBorder(BorderFactory.createTitledBorder("Editar"));
	}
	
	public void autoPreencher(MarcarExame exame) {
		this.exame=exame;
		getTfdCpfPaciente().setText(exame.getNomePaciente());
		getTfdCpfPaciente().setText(exame.getCpfPaciente());
		getTfdNomeMedico().setText(exame.getNomeMedico());
		getTfdParecer().setText(exame.getParecer());
		getComboBoxExamesGerais().setSelectedItem(exame.getExame());
		status.setSelectedItem(exame.getStatus());		
		
	}

	public MarcarExame getExame() {
		return exame;
	}

	public void setExame(MarcarExame exame) {
		this.exame = exame;
	}

	public JComboBox<Andamento> getStatus() {
		return status;
	}

	public void setStatus(JComboBox<Andamento> status) {
		this.status = status;
	}


	
	

}
