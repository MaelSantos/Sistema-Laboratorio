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
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class CadastroExames extends PanelGeral {

	private JLabel  labelTipoExame, labelTipoAmostra,labelValor;

	private JButton btnSalvar;
	private JComboBox<String> comboBoxTipoAmostra;
	
	private JTextField fieldTipoExame, fieldvalor;
	

	public CadastroExames() {

	}

	@Override
	public void inicializar() {
		setBorder(BorderFactory.createTitledBorder("Cadastro De Exames"));
		// setLayout(null);

		setLayout(new GridLayout(15, 1));
		// Label's

		
		labelTipoAmostra = new JLabel("Tipo de amostra:");
		labelTipoExame = new JLabel("Tipo de exame:");
		labelValor = new JLabel("Valor");

		// TextField
	
		fieldvalor = new JTextField();
		fieldTipoExame = new JTextField();
		
		
		// tbn
		btnSalvar = new JButton("Salvar Exame");
		btnSalvar.setBackground(Color.GREEN);

		// Combo

		comboBoxTipoAmostra = new JComboBox<>();
		comboBoxTipoAmostra.addItem("Outro");
		comboBoxTipoAmostra.addItem("Sangue");
		comboBoxTipoAmostra.addItem("Urina");
		comboBoxTipoAmostra.addItem("Fezes");
		comboBoxTipoAmostra.addItem("Esperma");
		comboBoxTipoAmostra.addItem("Secreção Pleural");
		comboBoxTipoAmostra.addItem("Secreção Vaginal");
		
		
		
		

		
		add(labelTipoExame);
		add(fieldTipoExame);
		add(labelTipoAmostra);
		add(comboBoxTipoAmostra);
		add(labelValor);
		add(fieldvalor);
		
		
		add(new JSeparator());
		add(btnSalvar);

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

	public JComboBox<String> getComboBoxTipoAmostra() {
		return comboBoxTipoAmostra;
	}

	public JLabel getLabelValor() {
		return labelValor;
	}

	public JTextField getFieldTipoExame() {
		return fieldTipoExame;
	}

	public JTextField getFieldvalor() {
		return fieldvalor;
	}

	
	
	
}
