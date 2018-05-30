package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Principal extends TelaGeral{
	
	private JLabel titulo;
	private Cadastro cadastro;
	private Menu menu;
	private Consulta consulta;
	private DetalhesPaciente detalhesPaciente;
	private CadastroFuncionario cadastroFuncionario;
	private DetalhesFuncionario detalhesFuncionario;
	private Perfil perfil;
	
	public Principal(String titulo, Menu menu, Cadastro cadastro,Consulta consulta, 
			DetalhesPaciente detalhesPaciente, CadastroFuncionario cadastroFuncionario, 
			DetalhesFuncionario detalhesFuncionario, Perfil perfil) {
		super(titulo);
		
		this.cadastro = cadastro;
		this.menu = menu;
		this.consulta= consulta;
		this.detalhesPaciente = detalhesPaciente;
		this.cadastroFuncionario = cadastroFuncionario;
		this.detalhesFuncionario = detalhesFuncionario;
		this.perfil = perfil;
		inicializar();
		setVisible(false);
	}

	@Override
	public void inicializar() {
		
		menu.setVisible(true);
		
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
		add(menu, cons);
		cons.fill = GridBagConstraints.BOTH;
		cons.anchor = GridBagConstraints.CENTER;
     	add(cadastro, cons);
     	add(consulta, cons);
     	add(detalhesPaciente,cons);
		add(cadastroFuncionario,cons);
		add(detalhesFuncionario,cons);
	}

}
