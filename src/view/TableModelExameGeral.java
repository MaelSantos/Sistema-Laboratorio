package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.BancoDados;
import model.ExameGeral;

public class TableModelExameGeral extends AbstractTableModel{
	
	private String [] colunas;	
	private ArrayList<ExameGeral> exames= new ArrayList<ExameGeral>();

	public TableModelExameGeral() {
		exames = BancoDados.getInstance().getExamesGerais();//.getExamesValores();
		colunas = new String[]{"CODIGO","NOME DO EXAME", "TIPO DE COLETA", "PREÇO"};	
	}

    @Override
    public String getColumnName(int column) {
    	// TODO Auto-generated method stub
    	return colunas[column];
    }
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return exames.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		switch(coluna) {
		case 0:
			return exames.get(linha).getCodigo();
		case 1:
			return exames.get(linha).getTipoExame();
		case 2:
			return exames.get(linha).getTipoDeColeta();
		case 3:
			return exames.get(linha).getValor();
		
		}
		return null;
	}
	
	@Override  
	   public void setValueAt(Object aValue, int linha, int coluna) {  
		ExameGeral exame = exames.get(linha);
	 
	     switch (coluna) 
	     {
	     case 0:
	    	 exame.setCodigo(aValue.toString());
	     case 1:  
	    	 exame.setTipoExame(aValue.toString());         
	     case 2:  
	    	 exame.setTipoDeColeta(aValue.toString());
	     case 3:  
	    	 exame.setValor(Double.parseDouble(aValue.toString()));

	     default:  
	    	 System.err.println("Índice da coluna inválido");
	     }  
	     fireTableCellUpdated(linha, coluna);  
	     fireTableStructureChanged();
	    }      
	
	    public void atualizarTabela() {
	    	exames = BancoDados.getInstance().getExamesGerais();//.getExamesValores();
	    	fireTableStructureChanged();
	    }

	
        public void addRow(ExameGeral e){
	        this.exames.add(e);
	        this.fireTableDataChanged();
	        fireTableStructureChanged();
        }
    
	    public void removeRow(int linha){
	        this.exames.remove(linha);
	        this.fireTableRowsDeleted(linha, linha);
	    }

		public String[] getColunas() {
			return colunas;
		}

		public void setColunas(String[] colunas) {
			this.colunas = colunas;
		}

		public ArrayList<ExameGeral> getExames() {
			return exames;
		}

		public void setExames(ArrayList<ExameGeral> exames) {
			this.exames = exames;
		}
	    
		

}
