package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import app.App;

public class TableModel extends AbstractTableModel {
	
	private String [] colunas={"NOME", "CPF", "SEXO"};;	
	private ArrayList<Paciente> paciente= new ArrayList<Paciente>();
	
	public TableModel() {
		
	    paciente=ClassXML.pacientes;		
		colunas = new String[]{"NOME", "CPF", "SEXO"};		
	
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
		return paciente.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		switch(coluna) {
		case 0:
			return paciente.get(linha).getNomeCompleto();
		case 1:
			return paciente.get(linha).getCpf();
		case 2:
			return paciente.get(linha).getSexo();
		}
		return null;
	}
	
	@Override  
	   public void setValueAt(Object aValue, int linha, int coluna) {  
	     Paciente usuario = paciente.get(linha);
	 
	     switch (coluna) 
	     {
	     case 0:  
	    	 usuario.setNomeCompleto(aValue.toString());             
	     case 1:  
	    	 usuario.setCpf(aValue.toString());
	     case 2:  
	    	 usuario.setSexo(aValue.toString());

	     default:  
	    	 System.err.println("Índice da coluna inválido");
	     }  
	     fireTableCellUpdated(linha, coluna);  
	    }      

	
    public void addRow(Paciente p){
        this.paciente.add(p);
        this.fireTableDataChanged();
        fireTableStructureChanged();
    }
    
    public void removeRow(int linha){
        this.paciente.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    public void pesquisa(String nomeCpf,ArrayList<Paciente> pacientes) {
    	
    	paciente=new ArrayList<>();
    	
    	paciente = new ArrayList<>();
    	
    	for(Paciente p:pacientes) {
    		if(p.getNome().toLowerCase().contains(nomeCpf.toLowerCase())||p.getCpf().toLowerCase().contains(nomeCpf.toLowerCase())) {
    			addRow(p);
    		}
    	}
    	this.fireTableDataChanged();
    	
    	fireTableStructureChanged();
    	System.gc();
    }
    public void voltaTabelaCompleta() {
    	paciente=ClassXML.pacientes;
    	this.fireTableDataChanged();
    }
  

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	public ArrayList<Paciente> getPaciente() {
		return paciente;
	}

	public void setPaciente(ArrayList<Paciente> paciente) {
		this.paciente = paciente;
	}
	

}
