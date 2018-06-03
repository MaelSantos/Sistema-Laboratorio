package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class CadastroExames extends PanelGeral {
	
	private JLabel labelcpfPaciente, labelNomeMedico, LabelParecer;
	private JTextField  fieldNomeMedico;
	private JFormattedTextField fieldcpfPaciente;
	private JScrollPane scrollPane;
	private JTextArea textAreaParecer;
	private JButton btnSalvar;
	
	
	public CadastroExames() {
		
	}

	@Override
	public void inicializar() {
		setBorder(BorderFactory.createTitledBorder("Cadastro De Exames"));
		//setLayout(null);
		
		
		setLayout(new GridLayout(15, 1));
		//Label's
		labelNomeMedico =  new JLabel("Medico:");
		
		labelcpfPaciente = new JLabel("Paciente: Nome Paciente");
		LabelParecer = new JLabel("Parecer:");
		
		//TextField
		fieldNomeMedico = new JTextField(10);
		fieldcpfPaciente = new JFormattedTextField();
		try {
			fieldcpfPaciente.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//TextArea
		textAreaParecer = new JTextArea(80,80);
		textAreaParecer.setLineWrap(true);
		textAreaParecer.setPreferredSize(new Dimension(300,300));
		
		//Scroll
		scrollPane = new JScrollPane(textAreaParecer);
		
		//tbn
		btnSalvar = new JButton("Salvar Exame");
		
		
		
		
		add(labelcpfPaciente);
		add(fieldcpfPaciente);
		add(labelNomeMedico);
		add(fieldNomeMedico);
		add(LabelParecer);
		add(scrollPane);
		add(btnSalvar);
		
		
			
		
		
		
	}

	public JLabel getLabelcpfPaciente() {
		return labelcpfPaciente;
	}
	

	public JTextField getFieldcpfPaciente() {
		return fieldcpfPaciente;
	}

	public JLabel getLabelNomeMedico() {
		return labelNomeMedico;
	}

	public JLabel getLabelParecer() {
		return LabelParecer;
	}

	public JTextField getFieldNomeMedico() {
		return fieldNomeMedico;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTextArea getTextAreaParecer() {
		return textAreaParecer;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	
	
}
