package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import model.ClassXML;
import model.Exame;
import model.TableModelExameValor;

public class ConsultaExames extends PanelGeral {

	private JTable tblExames;
	private TableModel model;
	private JScrollPane scpExames;
	private JTabbedPane tbpExames;
	
	
	public ConsultaExames() {
		super();
		setLayout(new FlowLayout());
	}

	@Override
	public void inicializar() {
		
		model = new TableModel(ClassXML.examesTotais);
		tblExames = new JTable(model);
		scpExames = new JScrollPane(tblExames);
	
		
//		model.addRow(new Exame("Abimael", "000000", "Ta morto faz tempo", "embalsamento", "corpo todo", "morto"));
		tbpExames = new JTabbedPane();
		JPanel p = new JPanel();
		JPanel pEV=new JPanel();
		p.add(scpExames);
		pEV.add(new JScrollPane(new JTable(new TableModelExameValor())));
		tbpExames.add("Exames Disponiveis",pEV);
		tbpExames.add("Todos os Exames", p);
		tbpExames.setPreferredSize(new Dimension(550, getHeight()));
		add(tbpExames);

		for(int i = 0; i < model.getColumnCount(); i++)
			tblExames.getColumnModel().getColumn(i).setPreferredWidth(model.colunas[i].length());
		model.fireTableDataChanged();
	}

	public class TableModel extends AbstractTableModel {
		
		private String [] colunas;	
		private ArrayList<Exame> exames;

		public TableModel() {
			exames = new ArrayList<>();	
			colunas = new String[]{"Codigo", "Paciente", "Medico", "Exame", "Parecer", "Tipo De Amostra", "Estado"};		
		}
		
		public TableModel(ArrayList<Exame> exames) {
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
			Exame exame = exames.get(linha);
			
//			"Codigo", "Paciente", "Medico", "Exame", "Parecer", "Tipo De Amostra", "Estado"};
			switch(coluna) {
			case 0:
				return exame.getCPFPaciente();
			case 1:
				return exame.getNomeMedico();
//			case 2:
//				return exames.get(linha).getTipoExame();
			case 3:
				return exame.getParecer();
//			case 4:
//				return exames.get(linha).getTipoAmostra();
//			case 5:
//				return exames.get(linha).getEstado();
			}
			return null;
		}
		
		@Override  
		public void setValueAt(Object aValue, int linha, int coluna) {  
			Exame exame = exames.get(linha);

			Exame e = null;
			if (aValue instanceof Exame) {
				e = (Exame) aValue;
			}
			
//			"Codigo", "Paciente", "Medico", "Exame", "Parecer", "Tipo De Amostra", "Estado"};
			switch (coluna) 
			{
			case 0:  
				exame.setNCPFPaciente(e.getCPFPaciente());             
				case 1:  
					exame.setNomeMedico(e.getNomeMedico());
//				case 2:
//					exame.setTipoExame(e.getTipoExame());
				case 3:  
					exame.setParecer(e.getParecer());
//				case 4:
//					exame.setTipoAmostra(e.getTipoAmostra());
//				case 5:
//					exame.setEstado()(e.getEstado());
				default:  
					System.err.println("Índice da coluna inválido");
			}  
			fireTableCellUpdated(linha, coluna);  
		}      


		public void addRow(Exame e){
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

		public ArrayList<Exame> getExames() {
			return exames;
		}

		public void setExames(ArrayList<Exame> exames) {
			this.exames = exames;
		}

	}


}
