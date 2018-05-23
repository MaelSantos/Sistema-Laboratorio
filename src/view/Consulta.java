package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import model.TableModel;

public class Consulta extends PanelGeral {
	
	private JTextField consultaT;
	private JButton consultaB,voltarTabelaCompleta;
	private JScrollPane scrollpane;
	private TableModel tabelaModel;
	private JTable tabela;
	private JButton detalhesButton;
	
	
	public Consulta() {
		super();
		setBorder(BorderFactory.createTitledBorder("Consulta"));
		setLayout(new FlowLayout(0, 10, 10));	    
	}

	@Override
	public void inicializar() {
		
		
		
		consultaT=new JTextField(40);		
		consultaB= new JButton("Pesquisa");	
		tabelaModel= new TableModel();	
		voltarTabelaCompleta=new JButton("Tabela Completa");
		tabela=new JTable(tabelaModel);
		tabela.setPreferredScrollableViewportSize(new Dimension(500, 400));
		
	
		scrollpane=new JScrollPane(tabela);
		
		detalhesButton=new JButton("Detalhes");
		
		add(consultaT);
		add(consultaB);
		add(detalhesButton);
		add(voltarTabelaCompleta);
		add(scrollpane);
		
		
		
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
