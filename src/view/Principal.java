package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Principal extends TelaGeral{
	
	private JLabel titulo;
	private CadastroPacientes cadastro;
	private ConsultaPacientes consulta;
	private DetalhesPaciente detalhesPaciente;
	private CadastroFuncionario cadastroFuncionario;
	private DetalhesFuncionario detalhesFuncionario;
	private Perfil perfil;
	private CadastroExames cadastroExames;
	private ConsultaExames consultaExames;
	private EditarExame editarExame;
	private Marcar marcar;
	private Financeiro financeiro;
	private ContasPagar contasPagar;
	private ContasAReceber contasAReceber;
	private EditarExameMarcado editarExameMarcado;
	private MenuPaneContainer menuPaneContainer;
	private RelatoriosView relatorios;
	
//	 Menu menu
	public Principal(String titulo,MenuPaneContainer menuPaneContainer, CadastroPacientes cadastro,ConsultaPacientes consulta, 
			DetalhesPaciente detalhesPaciente, CadastroFuncionario cadastroFuncionario, 
			DetalhesFuncionario detalhesFuncionario, Perfil perfil, CadastroExames cadastroExames,
			ConsultaExames consultaExames, EditarExame editarExame, Marcar marcar, Financeiro financeiro,
			ContasPagar contasPaga, ContasAReceber contasAReceber, EditarExameMarcado editarExameMarcado,
			RelatoriosView relatorios) {
		super(titulo);
		
		this.cadastro = cadastro;
		this.menuPaneContainer = menuPaneContainer;
		this.consulta= consulta;
		this.detalhesPaciente = detalhesPaciente;
		this.cadastroFuncionario = cadastroFuncionario;
		this.detalhesFuncionario = detalhesFuncionario;
		this.perfil = perfil;
		this.cadastroExames = cadastroExames;
		this.consultaExames = consultaExames;
		this.editarExame=editarExame;
		this.editarExameMarcado = editarExameMarcado;
		this.marcar = marcar;
		this.financeiro = financeiro;
		this.contasPagar = contasPaga;
		this.contasAReceber = contasAReceber;
		this.relatorios = relatorios;
		
		inicializar();
		setVisible(false);
	}

	@Override
	public void inicializar() {
		
		menuPaneContainer.setVisible(true);
		
		titulo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("nomeSistema.jpg")));
	
		GridBagConstraints cons = new GridBagConstraints(
				GridBagConstraints.RELATIVE, //gridx
				GridBagConstraints.RELATIVE, //gridy
				GridBagConstraints.RELATIVE, //gridwidth
				GridBagConstraints.RELATIVE, //gridheight
				0.1, //weightx
				0.1, //weighty
				GridBagConstraints.CENTER, //anchor
				GridBagConstraints.HORIZONTAL, //fill
				new Insets(0, 0, 0, 0), //insets
				0, //ipadx
				0); //ipady
		
		setLayout(new GridBagLayout());
		
//		cons.anchor = GridBagConstraints.NORTHEAST;
//		cons.fill = GridBagConstraints.NONE;
		cons.gridwidth = GridBagConstraints.REMAINDER; //gridheight
		cons.anchor = GridBagConstraints.NORTHEAST;
//		cons.fill = GridBagConstraints.VERTICAL;
		add(perfil,cons);
//		add(titulo, cons);
		
		cons.gridheight = GridBagConstraints.REMAINDER;
		cons.weightx = 0;
		cons.weighty = 0.9;
		cons.gridwidth = GridBagConstraints.RELATIVE;
		cons.fill = GridBagConstraints.VERTICAL;
		cons.anchor = GridBagConstraints.WEST;
		add(menuPaneContainer, cons);
		cons.fill = GridBagConstraints.BOTH;
		cons.anchor = GridBagConstraints.CENTER;
     	add(cadastro, cons);
     	add(consulta, cons);
     	add(detalhesPaciente,cons);
		add(cadastroFuncionario,cons);
		add(detalhesFuncionario,cons);
		add(cadastroExames, cons);
		add(consultaExames, cons);
		add(editarExame, cons);
		add(marcar, cons);
		add(financeiro, cons);
		add(contasPagar,cons);
		add(contasAReceber,cons);
		add(editarExameMarcado,cons);
		add(relatorios,cons);
	}	
}
