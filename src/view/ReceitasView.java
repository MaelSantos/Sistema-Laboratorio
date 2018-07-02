package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import modelDao.BancoDados;
import modelVo.ReceitaVo;

public class ReceitasView extends PanelGeral{

	private JTable tblDespesas;
	private ModelGenerico model;
	private JScrollPane scpDespesas;

	public ReceitasView() {
		super();
	}

	@Override
	public void inicializar() {

		model = new ModelGenerico(BancoDados.getInstance().getContasARecebers(), new String[] {
				"CPF Paciente", "Vencimento", "Fluxo", "Codigo", "Valor", "Referencia", "Tipo Pagamento", "Parcelas" });
		tblDespesas = new JTable(model);
		scpDespesas = new JScrollPane(tblDespesas);
		
		setLayout(new BorderLayout());
		add(scpDespesas,BorderLayout.CENTER);
	}

	@SuppressWarnings("serial")
	public class ModelGenerico extends AbstractTableModel {

		private String [] colunas;	
		private ArrayList<ReceitaVo> entidades;

		public ModelGenerico(ArrayList<ReceitaVo> entidades, String... colunas) {

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

//			cpfPaciente, dataVencimento, dataFluxo, codigo, valor, referencia, tipoPagamento, qtdParcelas;
			
			switch(coluna) {
			case 0:
				return entidades.get(linha).getCpfPaciente();
			case 1:
				return entidades.get(linha).getDataVencimento();
			case 2:
				return entidades.get(linha).getDataFluxo();
			case 3:
				return entidades.get(linha).getCodigo();
			case 4:
				return entidades.get(linha).getValor();
			case 5:
				return entidades.get(linha).getReferencia();
			case 6:
				return entidades.get(linha).getTipoPagamento();
			case 7:
				return entidades.get(linha).getQtdParcelas();
			}
			return null;
		}

		public void addRow(ReceitaVo p){
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

		
	}

}
