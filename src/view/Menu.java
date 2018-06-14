package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Menu extends PanelGeral {

	private JButton btnCadastro, btnConsulta, btnCadastroFuncionario, btnCadastrarExame,
	btnConsultaExames, btnMarcarExame;
	
	public Menu() {
		super();
		setBorder(BorderFactory.createTitledBorder("Menu"));
		setForeground(Color.WHITE);
		setBackground(new Color(95,158,160));
	}
	
	@Override
	public void inicializar() {
		
		btnCadastro = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cadastrarPaciente.png")));
		btnCadastroFuncionario = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cadastrarFuncionario.png")));
		btnConsulta = new JButton(new ImageIcon(getClass().getClassLoader().getResource("consultarPaciente.png")));		
		btnCadastrarExame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cadastrarExame.png")));
		btnConsultaExames = new JButton(new ImageIcon(getClass().getClassLoader().getResource("consultarExame.png")));
		btnMarcarExame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("marcarExame.png")));
		
		btnConsulta.setContentAreaFilled(false);
		btnConsulta.setBorderPainted(false);
		btnCadastroFuncionario.setContentAreaFilled(false);
		btnCadastroFuncionario.setBorderPainted(false);
		btnCadastro.setContentAreaFilled(false);
		btnCadastro.setBorderPainted(false);
		btnCadastrarExame.setContentAreaFilled(false);
		btnCadastrarExame.setBorderPainted(false);
		btnConsultaExames.setContentAreaFilled(false);
		btnConsultaExames.setBorderPainted(false);
		btnMarcarExame.setBorderPainted(false);
		btnMarcarExame.setContentAreaFilled(false);
		
		add(btnConsulta);
		add(btnConsultaExames);
		add(btnMarcarExame);
		add(btnCadastro);
		add(btnCadastroFuncionario);
		add(btnCadastrarExame);
		
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

	public JButton getBtnCadastrarExame() {
		return btnCadastrarExame;
	}

	public JButton getBtnConsultaExames() {
		return btnConsultaExames;
	}

	public JButton getBtnMarcarExame() {
		return btnMarcarExame;
	}
	

}
