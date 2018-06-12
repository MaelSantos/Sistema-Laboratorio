package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Marcar extends PanelGeral {

	private JTextField tfdNomeMedico, tfdCpfPaciente, tfdParecer, tfdExame;
	private JLabel lblNomeMedico, lblCpfPaciente, lblParecer, lblExame;
	private JButton btnAdd;
	
	public Marcar() {
		setLayout(new GridLayout(10, 2));
	}

	@Override
	public void inicializar() {
		tfdNomeMedico = new JTextField(10); 
		tfdCpfPaciente = new JTextField(10);
		tfdParecer = new JTextField(10); 
		tfdExame = new JTextField(10);
		
		lblNomeMedico = new JLabel("Medico");
		lblCpfPaciente = new JLabel("CPF Paciente");
		lblParecer = new JLabel("Parecer"); 
		lblExame = new JLabel("Exames");
		
		btnAdd = new JButton("Marcar Exame");
		
		add(lblCpfPaciente);
		add(tfdCpfPaciente);
		
		add(lblNomeMedico);
		add(tfdNomeMedico);
		
		add(lblParecer);
		add(tfdParecer);
		
		add(lblExame);
		add(tfdExame);
		
		add(btnAdd);
	}

	public JTextField getTfdNomeMedico() {
		return tfdNomeMedico;
	}

	public JTextField getTfdCpfPaciente() {
		return tfdCpfPaciente;
	}

	public JTextField getTfdParecer() {
		return tfdParecer;
	}

	public JTextField getTfdExame() {
		return tfdExame;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

}
