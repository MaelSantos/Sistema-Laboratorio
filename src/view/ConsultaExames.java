package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import model.BancoDados;
import model.ExameGeral;
import model.MarcarExame;

public class ConsultaExames extends PanelGeral {

	private JTable tblExames, tblDisponiveis;
	private TableModel model;
	private JScrollPane scpExames;
	private TableModelExameGeral examesDisponiveis;
	private JTabbedPane tbpExames;
	ArrayList<ExameGeral> exames;
	
	private JPanel disponiveis, total;
	
	public ConsultaExames() {
		super();
		setLayout(new BorderLayout());
		add(tbpExames,BorderLayout.CENTER);
		exames = BancoDados.getInstance().getExamesGerais();
	}

	@Override
	public void inicializar() {
		model = new TableModel(BancoDados.getInstance().getExamesMarcados());
		tblExames = new JTable(model);
		examesDisponiveis=new TableModelExameGeral();
		tblDisponiveis = new JTable(examesDisponiveis);
		scpExames = new JScrollPane(tblExames);
	
		tbpExames = new JTabbedPane();
		total = new JPanel();
		disponiveis = new JPanel();
		total.setLayout(new BorderLayout());
		disponiveis.setLayout(new BorderLayout());
		
		
		total.add(scpExames,BorderLayout.CENTER);
		disponiveis.add(new JScrollPane(tblDisponiveis),BorderLayout.CENTER);
		tbpExames.add("Exames Disponiveis",disponiveis);
		tbpExames.add("Todos os Exames", total);

		tbpExames.setPreferredSize(new Dimension(550, getHeight()));

		for(int i = 0; i < model.getColumnCount(); i++)
			tblExames.getColumnModel().getColumn(i).setPreferredWidth(model.colunas[i].length());
		model.fireTableDataChanged();
	}

	public class TableModel extends AbstractTableModel {
		
		private String [] colunas;	
		private ArrayList<MarcarExame> exames;

		public TableModel() {
			exames = new ArrayList<>();	
			colunas = new String[]{"Codigo", "Paciente", "Medico", "Exame", "Parecer", "Tipo De Amostra", "Estado"};		
		}
		
		public TableModel(ArrayList<MarcarExame> exames) {
			this.exames = exames;		
			colunas = new String[]{"Codigo", "Paciente", "Medico", "Exame", "Parecer", "Tipo De Amostra", "Estado"};
		}

	    @Override
	    public String getColumnName(int column) {
	    	// TODO Auto-generated method stub
	    	return colunas[column];
	    }
		@Override
		public int getColumnCount() {
			
			return colunas.length;
		}
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return exames.size();
		}

		@Override
		public Object getValueAt(int linha, int coluna) {
			MarcarExame exame = exames.get(linha);
			
//			"Codigo", "Paciente", "Medico", "Exame", "Parecer", "Tipo De Coleta", "Estado"};
			switch(coluna) {
			case 0:
				return exame.getExame().getCodigo();
			case 1:
				return exame.getCpfPaciente();
			case 2:
				return exame.getNomeMedico();
			case 3:
				return exame.getExame().getTipoExame();
			case 4:
				return exame.getParecer();
			case 5:
				return exame.getExame().getTipoDeColeta();
			case 6:
				return exame.getStatus();
			}
			return null;
		}
		
		@Override  
		public void setValueAt(Object aValue, int linha, int coluna) {  
			MarcarExame exame = exames.get(linha);

			MarcarExame e = null;
			if (aValue instanceof MarcarExame) {
				e = (MarcarExame) aValue;
			}
			
//			"Codigo", "Paciente", "Medico", "Exame", "Parecer", "Tipo De Coleta", "Estado"};
			switch (coluna) 
			{
			case 0:  
				exame.getExame().setCodigo((e.getExame().getCodigo()));
			case 1:  
				exame.setCpfPaciente(e.getCpfPaciente());
			case 2:  
				exame.setNomeMedico(e.getNomeMedico());
			case 3:
				exame.getExame().setTipoExame(e.getExame().getTipoExame());
			case 4:  
				exame.setParecer(e.getParecer());
			case 5:
				exame.getExame().setTipoDeColeta(e.getExame().getTipoDeColeta());
			case 6:
				exame.setStatus(e.getStatus());
			default:  
				System.err.println("Índice da coluna inválido");
			}  
			fireTableCellUpdated(linha, coluna);  
		}      


		public void addRow(MarcarExame e){
			this.exames.add(e);
			this.fireTableDataChanged();
			fireTableStructureChanged();
		}

		public void removeRow(int linha){
			this.exames.remove(linha);
			this.fireTableRowsDeleted(linha, linha);
		}
//		public void pesquisa(String nomeCpf,ArrayList<Exame> exames) {
//
//			exames=new ArrayList<>();
//
//			exames = new ArrayList<>();
//
//			for(Exame e : exames) {
//				if(e.getCodigo().toLowerCase().contains(nomeCpf.toLowerCase())) {
//					addRow(e);
//				}
//			}
//			this.fireTableDataChanged();
//
//			fireTableStructureChanged();
//			System.gc();
//		}
		public void voltaTabelaCompleta() {
//			exames=ClassXML.pacientes;
			this.fireTableDataChanged();
		}


		public String[] getColunas() {
			return colunas;
		}

		public void setColunas(String[] colunas) {
			this.colunas = colunas;
		}

		public ArrayList<MarcarExame> getExames() {
			return exames;
		}

		public void setExames(ArrayList<MarcarExame> exames) {
			this.exames = exames;
		}

	}

	public JTable getTblExames() {
		return tblExames;
	}

	public TableModel getModel() {
		return model;
	}

	public JScrollPane getScpExames() {
		return scpExames;
	}

	public JTabbedPane getTbpExames() {
		return tbpExames;
	}

	public JPanel getDisponiveis() {
		return disponiveis;
	}

	public JPanel getTotal() {
		return total;
	}

	public JTable getTblDisponiveis() {
		return tblDisponiveis;
	}

	public void setTblDisponiveis(JTable tblDisponiveis) {
		this.tblDisponiveis = tblDisponiveis;
	}

	public ArrayList<ExameGeral> getExames() {
		return exames;
	}

	public void setExames(ArrayList<ExameGeral> exames) {
		this.exames = exames;
	}

	public TableModelExameGeral getExamesDisponiveis() {
		return examesDisponiveis;
	}
	
	
	
}
