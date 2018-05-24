package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Menu extends PanelGeral {

	private JButton btnCadastro, btnConsulta,btnCadastroFuncionario ,btnSair;
	
	public Menu() {
		super();
		setBorder(BorderFactory.createTitledBorder("Menu"));
		setForeground(Color.WHITE);
		setBackground(new Color(95,158,160));
	}
	
	@Override
	public void inicializar() {
		
		btnCadastro = new JButton("Cadastro Paciente");
		btnCadastroFuncionario = new JButton("Cadastro Funcionario");
		btnConsulta = new JButton("Consulta");
		btnSair = new JButton("Sair");

		add(btnCadastro);
		add(btnCadastroFuncionario);
		add(btnConsulta);
		add(btnSair);
		
	}

	//metodos de acesso
	public JButton getBtnCadastro() {
		return btnCadastro;
	}

	public JButton getBtnConsulta() {
		return btnConsulta;
	}

	public JButton getBtnSair() {
		return btnSair;
	}

	public JButton getBtnCadastroFuncionario() {
		return btnCadastroFuncionario;
	}

}
