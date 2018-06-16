package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ConsultaPacientes extends PanelGeral {
	
	private JTextField consultaT;
	private JButton consultaB,voltarTabelaCompleta;
	private JScrollPane scrollpane;
	private TableModel tabelaModel;
	private JTable tabela;
	private JButton detalhesButton;
	
	
	public ConsultaPacientes() {
		super();
		setBorder(BorderFactory.createTitledBorder("Consulta Pacientes"));
		setLayout(new BorderLayout());

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(10,10,10));
		
		p.add(consultaT);
		p.add(consultaB);
		p.add(detalhesButton);
		p.add(voltarTabelaCompleta);
		
		add(p,BorderLayout.NORTH);
		add(scrollpane, BorderLayout.CENTER);
	}

	@Override
	public void inicializar() {
	
		consultaT=new JTextField(20);		
		consultaB= new JButton("Pesquisa");	
		tabelaModel= new TableModel();	
		voltarTabelaCompleta=new JButton("Tabela Completa");
		tabela=new JTable(tabelaModel);
		tabela.setPreferredScrollableViewportSize(new Dimension(500, 400));
//		tabela.setBackground(new Color(176,224,230));
	
		scrollpane=new JScrollPane(tabela);
		
		detalhesButton=new JButton("Detalhes");
		
	}

	public JButton getDetalhesButton() {
		return detalhesButton;
	}

	public JTextField getConsultaT() {
		return consultaT;
	}

	public void setConsultaT(JTextField consultaT) {
		this.consultaT = consultaT;
	}

	public JButton getConsultaB() {
		return consultaB;
	}

	public void setConsultaB(JButton consultaB) {
		this.consultaB = consultaB;
	}

	public JScrollPane getScrollpane() {
		return scrollpane;
	}

	public void setScrollpane(JScrollPane scrollpane) {
		this.scrollpane = scrollpane;
	}


	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public TableModel getTabelaModel() {
		return tabelaModel;
	}

	public void setTabelaModel(TableModel tabelaModel) {
		this.tabelaModel = tabelaModel;
	}

	public void setDetalhesButton(JButton detalhesButton) {
		this.detalhesButton = detalhesButton;
	}

	public JButton getVoltarTabelaCompleta() {
		return voltarTabelaCompleta;
	}

	public void setVoltarTabelaCompleta(JButton voltarTabelaCompleta) {
		this.voltarTabelaCompleta = voltarTabelaCompleta;
	}
	
}
