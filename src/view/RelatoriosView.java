package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class RelatoriosView extends PanelGeral{

	private JLabel lblTipo;
	private JComboBox<String> jcbTipo;
	private JButton btnEscolha; 
	
	public RelatoriosView() {
		super();
	}

	@Override
	public void inicializar() {
		
		jcbTipo = new JComboBox<>(new String[] {"Despesas", "Receitas", "Clientes"});
		btnEscolha = new JButton("Relatorio"); 
		
		add(jcbTipo);
		add(btnEscolha);
		
	}

	public JComboBox<String> getJcbTipo() {
		return jcbTipo;
	}

	public JButton getBtnEscolha() {
		return btnEscolha;
	}	
}
