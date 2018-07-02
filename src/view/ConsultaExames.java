package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import controlle.Controle;
import modelDao.BancoDados;
import modelVo.ExameGeral;
import modelVo.MarcarExame;

public class ConsultaExames extends PanelGeral {

	private JTable tblExames, tblDisponiveis;
	private TableModel model;
	private JScrollPane scpExames;
	private TableModelExameGeral examesDisponiveis;
	private JTabbedPane tbpExames;
	ArrayList<ExameGeral> exames;
	private JTextField campoPesquisa;
	private JButton pesquisaB;
	private JComboBox<String> opcaoDePesquisa;
	private JPanel disponiveis, total;
	ArrayList<MarcarExame> marcarExames;
	

	public ConsultaExames() {
		super();
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Consulta Exames"));

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(10, 10, 10));

		p.add(campoPesquisa);
		p.add(opcaoDePesquisa);
		p.add(pesquisaB);

		add(p, BorderLayout.NORTH);
		add(tbpExames, BorderLayout.CENTER);
		exames = BancoDados.getInstance().getExamesGerais();
	}

	@Override
	public void inicializar() {
		model = new TableModel(BancoDados.getInstance().getExamesMarcados());
		tblExames = new JTable(model);
		examesDisponiveis = new TableModelExameGeral();
		tblDisponiveis = new JTable(examesDisponiveis);
		scpExames = new JScrollPane(tblExames);

		tbpExames = new JTabbedPane();
		total = new JPanel();
		disponiveis = new JPanel();
		total.setLayout(new BorderLayout());
		disponiveis.setLayout(new BorderLayout());

		total.add(scpExames, BorderLayout.CENTER);
		disponiveis.add(new JScrollPane(tblDisponiveis), BorderLayout.CENTER);
		tbpExames.add("Exames Disponiveis", disponiveis);
		tbpExames.add("Todos os Exames", total);

		tbpExames.setPreferredSize(new Dimension(550, getHeight()));

		pesquisaB = new JButton("Pesquisar");
		opcaoDePesquisa = new JComboBox<>();
		opcaoDePesquisa.addItem("Todos os Exames");
		opcaoDePesquisa.addItem("Não Realizado");
		opcaoDePesquisa.addItem("Em Andamento");
		opcaoDePesquisa.addItem("Concluido");
		campoPesquisa = new JTextField(20);

		for (int i = 0; i < model.getColumnCount(); i++)
			tblExames.getColumnModel().getColumn(i).setPreferredWidth(model.colunas[i].length());
		model.fireTableDataChanged();
	}

	public class TableModel extends AbstractTableModel {

		private String[] colunas;
		private ArrayList<MarcarExame> exames;

		public TableModel() {
			exames = new ArrayList<>();
			colunas = new String[] { "Codigo", "CPF", "Paciente", "Medico", "Exame", "Parecer", "Tipo De Amostra",
					"Estado" };
		}

		public TableModel(ArrayList<MarcarExame> exames) {
			this.exames = exames;
			colunas = new String[] { "Codigo", "CPF", "Paciente", "Medico", "Exame", "Parecer", "Tipo De Amostra",
					"Estado" };
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

			// "Codigo", "Paciente", "Medico", "Exame", "Parecer", "Tipo De Coleta",
			// "Estado"};
			switch (coluna) {
			case 0:
				return exame.getExame().getCodigo();
			case 1:
				return exame.getCpfPaciente();
			case 2:
				return exame.getNomePaciente();
			case 3:
				return exame.getNomeMedico();
			case 4:
				return exame.getExame().getTipoExame();
			case 5:
				return exame.getParecer();
			case 6:
				return exame.getExame().getTipoDeColeta();
			case 7:
				return exame.getStatus();
			}
			return null;
		}
		
		public void atualizarTabelaPaciente(String cpf) {
			marcarExames = new ArrayList<>();

			for (MarcarExame marcarExame : BancoDados.getInstance().getExamesMarcados()) {
				if (marcarExame.getCpfPaciente().equals(cpf)) {
					System.out.println("Entrou");
					marcarExames.add(marcarExame);
				}
			}

			exames = marcarExames;
			fireTableStructureChanged();
		}
		
		@Override
		public void setValueAt(Object aValue, int linha, int coluna) {
			MarcarExame exame = exames.get(linha);

			MarcarExame e = null;
			if (aValue instanceof MarcarExame) {
				e = (MarcarExame) aValue;
			}

			// "Codigo", "Paciente", "Medico", "Exame", "Parecer", "Tipo De Coleta",
			// "Estado"};
			switch (coluna) {
			case 0:
				exame.getExame().setCodigo((e.getExame().getCodigo()));
			case 1:
				exame.setCpfPaciente(e.getCpfPaciente());
			case 2:
				exame.setNomePaciente(e.getNomePaciente());
			case 3:
				exame.setNomeMedico(e.getNomeMedico());
			case 4:
				exame.getExame().setTipoExame(e.getExame().getTipoExame());
			case 5:
				exame.setParecer(e.getParecer());
			case 6:
				exame.getExame().setTipoDeColeta(e.getExame().getTipoDeColeta());
			case 7:
				exame.setStatus(e.getStatus());
			default:
				System.err.println("Índice da coluna inválido");
			}
			fireTableCellUpdated(linha, coluna);
		}

		public void addRow(MarcarExame e) {
			this.exames.add(e);
			this.fireTableDataChanged();
			fireTableStructureChanged();
		}

		public void removeRow(int linha) {
			this.exames.remove(linha);
			this.fireTableRowsDeleted(linha, linha);
		}

		public void pesquisa(String nomeCpfExame, String status, ArrayList<MarcarExame> examesEntrada) {

			exames = new ArrayList<>();

			if (status.equals("Todos os Exames") && getCampoPesquisa().getText().equals("")) {
				exames = examesEntrada;
			} else if (status.equals("Todos os Exames") && !getCampoPesquisa().getText().equals("")) {
				for (MarcarExame e : examesEntrada) {
					if (e.getCpfPaciente().toLowerCase().contains(nomeCpfExame.toLowerCase())
							|| e.getNomePaciente().toLowerCase().contains(nomeCpfExame.toLowerCase())
							|| e.getExame().getTipoExame().toLowerCase().contains(nomeCpfExame.toLowerCase())) {
						addRow(e);
					}
				}

			} else {
				for (MarcarExame e : examesEntrada) {
					if (e.getCpfPaciente().toLowerCase().contains(nomeCpfExame.toLowerCase())
							&& e.getStatus().toString().equals(status)
							|| e.getNomePaciente().toLowerCase().contains(nomeCpfExame.toLowerCase())
									&& e.getStatus().toString().equals(status)
							|| e.getExame().getTipoExame().toLowerCase().contains(nomeCpfExame.toLowerCase())
									&& e.getStatus().toString().equals(status)) {
						addRow(e);
					}
				}

			}

			this.fireTableDataChanged();

			fireTableStructureChanged();
			System.gc();
		}
		public void atualizarTabela() {
			marcarExames = BancoDados.getInstance().getExamesMarcados();
			this.fireTableDataChanged();
			fireTableStructureChanged();
		}

		public void voltaTabelaCompleta() {
			// exames=ClassXML.pacientes;
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

	public JTextField getCampoPesquisa() {
		return campoPesquisa;
	}

	public JButton getPesquisaB() {
		return pesquisaB;
	}

	public JComboBox<String> getOpcaoDePesquisa() {
		return opcaoDePesquisa;
	}

	public ArrayList<MarcarExame> getMarcarExames() {
		return marcarExames;
	}

	

	

}
