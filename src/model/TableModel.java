package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import app.App;

public class TableModel extends AbstractTableModel {
	
	private String [] colunas={"NOME", "CPF", "SEXO"};;	
	private ArrayList<Paciente> paciente= new ArrayList<Paciente>();
	
	public TableModel() {
		
	    paciente=App.pacientesTest;		
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
			return paciente.get(linha).getNome();
		case 1:
			return paciente.get(linha).getCpf();
		case 2:
			return paciente.get(linha).getSexo();
		}
		return null;
	}
	
    public void addRow(Paciente p){
        this.paciente.add(p);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.paciente.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    public void pesquisa(String nomeCpf,ArrayList<Paciente> pacientes) {
    	paciente= new ArrayList<Paciente>();
    	
    	for(Paciente p:pacientes) {
    		if(p.getNome().equals(nomeCpf)||p.getCpf().equals(nomeCpf)) {
    			addRow(p);
    		}
    		
    	}
    	
    }
  

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}
	

}