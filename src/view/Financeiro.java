package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;

import model.Funcionario;

public class Financeiro extends PanelGeral{

	private JTabbedPane tbpFinaceiro;
	private DespesasView despesas;
	
	public Financeiro() {
		super();
		
		setBorder(BorderFactory.createTitledBorder("Financeiro"));
		
	}
	
	@Override
	public void inicializar() {
		
		tbpFinaceiro = new JTabbedPane();
		despesas = new DespesasView();
		
		tbpFinaceiro.add("Despesas", despesas);
		
		setLayout(new BorderLayout());
		add(tbpFinaceiro, BorderLayout.CENTER);
		
	}

	public JTabbedPane getTbpFinaceiro() {
		return tbpFinaceiro;
	}

	public DespesasView getDespesas() {
		return despesas;
	}

	
	
	

}
