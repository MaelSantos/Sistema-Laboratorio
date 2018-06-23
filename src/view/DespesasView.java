package view;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import model.BancoDados;
import model.DespesasVo;

public class DespesasView extends PanelGeral{

	private JTable tblDespesas;
	private ModelGenerico model;

	public DespesasView() {
		super();
	}

	@Override
	public void inicializar() {

		model = new ModelGenerico(BancoDados.getInstance().getDespesas(), new String[] {
				"Discricao", "Fornecedor", "Plano", "Centro Custo", "Data",
				"Valor", "Nº de Parcelas","Valor Parcela","Intervalo Parcelas"});
		tblDespesas = new JTable(model);
		add(new JScrollPane(tblDespesas));
	}

	@SuppressWarnings("serial")
	public class ModelGenerico extends AbstractTableModel {

		private String [] colunas;	
		private ArrayList<DespesasVo> entidades;

		public ModelGenerico(ArrayList<DespesasVo> entidades, String... colunas) {

			this.entidades = entidades;		
			this.colunas = colunas;
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
			return entidades.size();
		}

		@Override
		public Object getValueAt(int linha, int coluna) {

//			"Discricao", "Fornecedor", "Plano", "Centro Custo", "Data",
//			"Valor", "Nº de Parcelas","Intervalo Parcelas"
			
			switch(coluna) {
			case 0:
				return entidades.get(linha).getDiscricao();
			case 1:
				return entidades.get(linha).getFornecedor();
			case 2:
				return entidades.get(linha).getPlano();
			case 3:
				return entidades.get(linha).getCentro_custo();
			case 4:
				return entidades.get(linha).getData();
			case 5:
				return entidades.get(linha).getValor();
			case 6:
				return entidades.get(linha).getNumeros_parcela();
			case 7:
				return entidades.get(linha).getIntervalo_parcelas();
			}
			return null;
		}

		public void addRow(DespesasVo p){
			this.entidades.add( p);			
			this.fireTableDataChanged();
			fireTableStructureChanged();
		}

		public void removeRow(int linha){
			this.entidades.remove(linha);
			this.fireTableRowsDeleted(linha, linha);
		}

		public String[] getColunas() {
			return colunas;
		}

		public void setColunas(String[] colunas) {
			this.colunas = colunas;
		}

		public ArrayList<DespesasVo> getEntidades() {
			return entidades;
		}

		public void setEntidades(ArrayList<DespesasVo> entidades) {
			this.entidades = entidades;
		}
	}


}
