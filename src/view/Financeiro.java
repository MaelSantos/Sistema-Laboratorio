package view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;

public class Financeiro extends PanelGeral{

	private JTabbedPane tbpFinaceiro;
	private DespesasView despesas;
	private ReceitasView receitas;
	
	public Financeiro() {
		super();
		
		setBorder(BorderFactory.createTitledBorder("Financeiro"));
		
	}
	
	@Override
	public void inicializar() {
		
		tbpFinaceiro = new JTabbedPane();
		despesas = new DespesasView();
		
		receitas = new ReceitasView();
		
		tbpFinaceiro.add("Despesas", despesas);
		tbpFinaceiro.addTab("Receitas", receitas);
		
		setLayout(new BorderLayout());
		add(tbpFinaceiro, BorderLayout.CENTER);
		
	}

	public JTabbedPane getTbpFinaceiro() {
		return tbpFinaceiro;
	}

	public DespesasView getDespesas() {
		return despesas;
	}

	public ReceitasView getReceitas() {
		return receitas;
	}

}
