package model;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 * @author Magic
 *
 */
public class PTableModel extends AbstractTableModel {

	private ArrayList<? extends Object> dados;
	private ArrayList<String> nomesColuna;

	/**
	 * inicializa todos os componetes default
	 */
	public PTableModel() {
		super();
		dados = new ArrayList<Object>();

		nomesColuna = new ArrayList<>();
		for(int i = 0; i < 3; i++)
			nomesColuna.add("Coluna "+(i+1));
	}

	/**
	 * inicializa os dados do table
	 * colunas default
	 * @param dados
	 */
	public PTableModel(ArrayList<?> dados) {
		super();
		this.dados = dados;
		nomesColuna = new ArrayList<>();
		for(int i = 0; i < 3; i++)
			nomesColuna.add("Coluna "+(i+1));
	}

	/**
	 * 
	 * @param dados
	 * @param coluna
	 */
	public PTableModel(ArrayList<?> dados, String[] coluna) {
		super();
		this.dados = dados;
		this.nomesColuna = (ArrayList<String>) Arrays.asList(coluna);
	}
	/**
	 *
	 * @param dados
	 * @param coluna
	 */
	public PTableModel(ArrayList<?> dados, ArrayList<String> coluna) {
		super();
		this.dados = dados;
		this.nomesColuna = coluna;
	}

	/* (não-Javadoc)
	 * @see javax.swing.table.TableModel#addTableModelListener(javax.swing.event.TableModelListener)
	 */
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Stub de método gerado automaticamente
		super.addTableModelListener(arg0);
	}

	/* (não-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int dado) {
		// TODO Stub de método gerado automaticamente
		return dados.get(dado).getClass();
	}

	/* (não-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		// TODO Stub de método gerado automaticamente
		return nomesColuna.size();
	}

	/* (não-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int coluna) {
		// TODO Stub de método gerado automaticamente
		return nomesColuna.get(coluna);
	}

	/* (não-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		// TODO Stub de método gerado automaticamente
		return dados.size();
	}

	/* (não-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int linha, int coluna) {
		Object usuarioSelecionado = dados.get(linha);
		Object valueObject = null;
		switch(coluna){
		case 0: valueObject = usuarioSelecionado; break;
		default: System.err.println("Índice inválido para propriedade do bean Usuario.class");
		}

		return valueObject;
	}
	/* (não-Javadoc)
	 * @see javax.swing.table.TableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int linha, int coluna) {
		Object usuario = dados.get(linha);

		switch (coluna) 
		{
		case 0:  
			usuario = aValue;             
		default:  
			System.err.println("Índice da coluna inválido");
		}  

		fireTableCellUpdated(linha, coluna);  

	}
	
	public void compareTo(int coluna, Object valor)
	{
		System.out.println(valor.getClass().equals(getColumnClass(coluna)));	
	}
	
	public void ordem()
	{
		
	}

	/* (não-Javadoc)
	 * @see javax.swing.table.TableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Stub de método gerado automaticamente
		return false;
	}

	/* (não-Javadoc)
	 * @see javax.swing.table.TableModel#removeTableModelListener(javax.swing.event.TableModelListener)
	 */
	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Stub de método gerado automaticamente
		super.removeTableModelListener(arg0);
	}	
	/** 
	 * @param linha
	 * @return dado - expecificado 
	 */
	public Object getDado(int linha) {  
		return dados.get(linha);  
	}  

	/**
	 * adiciona um novo dado no table
	 * @param dado
	 */
	public void addDado(Object dado) {     

		@SuppressWarnings("unchecked")
		ArrayList<Object> temp = (ArrayList<Object>) dados;
		temp.add(dado);
		dados = temp;
		int ultimoIndice = getRowCount() - 1;  

		fireTableRowsInserted(ultimoIndice, ultimoIndice);  
	}  

	/**
	 * remove dado de acordo com o parametro expecificado
	 * @param linha
	 */
	public void removeDado(int linha) {  
		dados.remove(linha);  

		fireTableRowsDeleted(linha, linha);  
	}  

	/**
	 * adciona uma nova lista de dados aos ja existentes
	 * @param novosUsuarios
	 */
	@SuppressWarnings("unchecked")
	public void addListaDeUsuarios(ArrayList<Object> novosUsuarios) {  

		int tamanhoAntigo = getRowCount();
		dados = concatenarListas((ArrayList<Object>) dados, novosUsuarios);
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);  
	}  

	/**
	 * limpa todos os dados 
	 */
	public void limpar() {  
		dados.clear();    
		fireTableDataChanged();  
	}  
	/**
	 * @return true(se não houver nenhum dado) - false(se houver um ou mais dados)
	 */
	public boolean isEmpty() {  
		return dados.isEmpty();  
	}  

	/**
	 * @param primeiraLista
	 * @param segundaLista
	 * @return arrayList de dados(primeiraLista +segundaLista)
	 */
	private ArrayList<?> concatenarListas(ArrayList<Object> primeiraLista, ArrayList<Object> segundaLista) {

		ArrayList<Object> ret = new ArrayList<Object>();
		for (Object elementoLista : primeiraLista) {
			if (! (ret.contains(elementoLista))) {
				ret.add(elementoLista);
			}
		}
		for (Object elementoLista : segundaLista) {
			if (! (ret.contains(elementoLista))) {
				ret.add(elementoLista);
			}
		}
		return ret;
	}
	
	/**
	 * adciona uma nova coluna no table
	 * @param coluna
	 */
	public void addColuna(String coluna)
	{
		nomesColuna.add(coluna);
		fireTableStructureChanged();//notifica que houve uma modificação no table para atualizar
	}
	/**
	 * adciona novas colunas no table
	 * @param colunas
	 */
	public void addColuna(String[] colunas)
	{
		nomesColuna.addAll(Arrays.asList(colunas));
		fireTableStructureChanged();//notifica que houve uma modificação no table para atualizar
	}
	/**
	 * adciona novas colunas no table
	 * @param colunas
	 */
	public void addColuna(ArrayList<String> colunas)
	{
		nomesColuna.addAll(colunas);
		fireTableStructureChanged();//notifica que houve uma modificação no table para atualizar
	}
	/**
	 * remove coluna expecificada
	 * @param coluna
	 */
	public void removeColuna(int coluna)
	{
		nomesColuna.remove(coluna);
		fireTableStructureChanged();//notifica que houve uma modificação no table para atualizar
	}
	/**
	 * remove coluna expecificada
	 * @param coluna
	 */
	public void removeColuna(String coluna)
	{
		nomesColuna.remove(coluna);
		fireTableStructureChanged();//notifica que houve uma modificação no table para atualizar
	}
	/**
	 * modifica todas as colunas do table
	 * @param colunas
	 */
	public void setColunas(String[] colunas)
	{
		nomesColuna.clear();
		addColuna(colunas);
	}
	/**
	 * modifica todas as colunas do table
	 * @param colunas
	 */
	public void setColunas(ArrayList<String> colunas)
	{
		nomesColuna.clear();
		addColuna(colunas);
	}
	/**
	 * 
	 * @param coluna
	 */
	public void editarColuna(int coluna, String novaColuna)
	{
		nomesColuna.remove(coluna);
		nomesColuna.add(coluna, novaColuna);
		fireTableStructureChanged();//notifica que houve uma modificação no table para atualizar
	}
	
	
}