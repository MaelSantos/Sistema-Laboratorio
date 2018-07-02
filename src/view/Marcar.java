package view;

import java.awt.GridLayout;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.thoughtworks.xstream.mapper.CGLIBMapper.Marker;

import modelDao.BancoDados;
import modelVo.ExameGeral;

public class Marcar extends PanelGeral {

	private JTextField tfdNomeMedico, tfdParecer;
	private AutoTextField tfdCpfPaciente;
	private JLabel lblNomeMedico, lblCpfPaciente, lblParecer, lblExame;
	private JButton btnAdd;
	private JComboBox<String> comboBoxExamesGerais;
	
	public Marcar() {
		setLayout(new GridLayout(16, 2));
		setBorder(BorderFactory.createTitledBorder("Marcar Exame"));
	}

	@Override
	public void inicializar() {
		tfdNomeMedico = new JTextField(10); 
		tfdCpfPaciente = new AutoTextField(BancoDados.getInstance().getPacientes()
				,new AutoComboBox(BancoDados.getInstance().getPacientes()));
		
		tfdParecer = new JTextField(10); 
	
		
		lblNomeMedico = new JLabel("Medico");
		lblCpfPaciente = new JLabel("CPF Paciente");
		lblParecer = new JLabel("Parecer"); 
		lblExame = new JLabel("Exames");
		
		btnAdd = new JButton("Marcar Exame");
		
		comboBoxExamesGerais= new JComboBox<>();
		atualizarComboBoxExamesGerais();
		
		
		add(lblCpfPaciente);
		add(tfdCpfPaciente);
		
		add(lblNomeMedico);
		add(tfdNomeMedico);
		
		add(lblParecer);
		add(tfdParecer);
		
		add(lblExame);
		add(comboBoxExamesGerais);
		add(new JLabel(""));
		add(btnAdd);
	}

	public void atualizarComboBoxExamesGerais() {
		
		for(ExameGeral exame : BancoDados.getInstance().getExamesGerais()) {
			comboBoxExamesGerais.addItem(exame.getTipoExame());
		}
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

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JComboBox<String> getComboBoxExamesGerais() {
		return comboBoxExamesGerais;
	}
	
	
	

}
