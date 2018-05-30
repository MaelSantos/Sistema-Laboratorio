package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;


public class Menu extends PanelGeral {

	private JButton btnCadastro, btnConsulta, btnCadastroFuncionario;
	
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

		add(btnConsulta);
		add(btnCadastro);
		add(btnCadastroFuncionario);
		
	}

	//metodos de acesso
	public JButton getBtnCadastro() {
		return btnCadastro;
	}

	public JButton getBtnConsulta() {
		return btnConsulta;
	}

	public JButton getBtnCadastroFuncionario() {
		return btnCadastroFuncionario;
	}

}
