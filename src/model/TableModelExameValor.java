package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModelExameValor extends AbstractTableModel{
	
	private String [] colunas={"NOME DO EXAME", "TIPO DE COLETA", "PREÇO"};	
	private ArrayList<ExameValor> exames= new ArrayList<ExameValor>();

	public TableModelExameValor() {
		exames= ExamesValorXML.getExamesValores();
		colunas=new String[]{"NOME DO EXAME", "TIPO DE COLETA", "PREÇO"};	
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
			return exames.get(linha).getNome();
		case 1:
			return exames.get(linha).getTipoDeColeta();
		case 2:
			return exames.get(linha).getValor();
		}
		return null;
	}
	
	@Override  
	   public void setValueAt(Object aValue, int linha, int coluna) {  
		ExameValor exame = exames.get(linha);
	 
	     switch (coluna) 
	     {
	     case 0:  
	    	 exame.setNome(aValue.toString());         
	     case 1:  
	    	 exame.setTipoDeColeta(aValue.toString());
	     case 2:  
	    	 exame.setValor(Double.parseDouble(aValue.toString()));

	     default:  
	    	 System.err.println("Índice da coluna inválido");
	     }  
	     fireTableCellUpdated(linha, coluna);  
	     fireTableStructureChanged();
	    }      

	
        public void addRow(ExameValor e){
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

		public ArrayList<ExameValor> getExames() {
			return exames;
		}

		public void setExames(ArrayList<ExameValor> exames) {
			this.exames = exames;
		}
	    
		

}
