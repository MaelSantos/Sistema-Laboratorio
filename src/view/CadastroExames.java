package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class CadastroExames extends PanelGeral {
	
	private JLabel labelcpfPaciente, labelNomeMedico, labelParecer, labelTipoExame,labelTipoAmostra;
	private JTextField  fieldNomeMedico, fieldTipoExame;
	private JFormattedTextField fieldcpfPaciente;
	private JScrollPane scrollPane;
	private JTextArea textAreaParecer;
	private JButton btnSalvar;
	private JComboBox<String> comboBoxTipoAmostra;
	
	
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
		labelParecer = new JLabel("Parecer:");
		labelTipoAmostra = new JLabel("Tipo de amostra:");
		labelTipoExame = new JLabel("Tipo de exame:");
		
		//TextField
		fieldNomeMedico = new JTextField();
		fieldcpfPaciente = new JFormattedTextField();
		
		fieldTipoExame = new JTextField();
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
		btnSalvar.setBackground(Color.GREEN);
		
		//Combo
		
		
		comboBoxTipoAmostra = new JComboBox<>();
		comboBoxTipoAmostra.addItem("Outro");
		comboBoxTipoAmostra.addItem("Sangue");
		comboBoxTipoAmostra.addItem("Urina");
		comboBoxTipoAmostra.addItem("Fezes");
		comboBoxTipoAmostra.addItem("Esperma");
		comboBoxTipoAmostra.addItem("Secreção Pleural");
		comboBoxTipoAmostra.addItem("Secreção Vaginal");
		
		
		
		
		add(labelcpfPaciente);
		add(fieldcpfPaciente);
		add(labelNomeMedico);
		add(fieldNomeMedico);
		add(labelTipoAmostra);
		add(comboBoxTipoAmostra);
		add(labelTipoExame);
		add(fieldTipoExame);
		add(labelParecer);
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
		return labelParecer;
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

	public JLabel getLabelTipoExame() {
		return labelTipoExame;
	}

	public JLabel getLabelTipoAmostra() {
		return labelTipoAmostra;
	}

	public JTextField getFieldTipoExame() {
		return fieldTipoExame;
	}


	public JComboBox<String> getComboBoxTipoAmostra() {
		return comboBoxTipoAmostra;
	}
	

	
	
}
