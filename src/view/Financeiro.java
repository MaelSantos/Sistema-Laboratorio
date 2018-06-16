package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;

import model.Funcionario;

public class Financeiro extends PanelGeral{

	private JTabbedPane tbpFinaceiro;
	private Despesas despesas;
	
	public Financeiro() {
		super();
		
		setBorder(BorderFactory.createTitledBorder("Financeiro"));
		
	}
	
	@Override
	public void inicializar() {
		
		tbpFinaceiro = new JTabbedPane();
		despesas = new Despesas();
		
		tbpFinaceiro.add("Despesas", despesas);
		
		setLayout(new BorderLayout());
		add(tbpFinaceiro, BorderLayout.CENTER);
		
	}

	public JTabbedPane getTbpFinaceiro() {
		return tbpFinaceiro;
	}

	public Despesas getDespesas() {
		return despesas;
	}

	
	
	

}
