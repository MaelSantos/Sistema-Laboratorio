package view;

import java.awt.font.ImageGraphicAttribute;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.ClassXML;
import model.ClassXMLFuncionario;
import model.Funcionario;
import model.Paciente;

public class Login extends JFrame{
	JLabel imgFundo, loginLabel, senhaLabel;
	JTextField loginField;
	JPasswordField senhaField;
	JButton bntEntrar, bntSair;
	
	public Login() {
		setSize(600,500);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		loginLabel = new JLabel("Login: ");
		loginLabel.setBounds(170,220,100,30);
		
		senhaLabel = new JLabel("Senha: ");
		senhaLabel.setBounds(170, 300, 100, 30);
		
		loginField = new JTextField();
		loginField.setBounds(170, 260, 300, 30);
		
		senhaField= new JPasswordField();
		senhaField.setBounds(170, 340, 300, 30);
		
		bntEntrar = new JButton("Entrar");
		bntEntrar.setBounds(170, 400, 150, 30);
		
		bntSair = new JButton("Sair");
		bntSair.setBounds(320, 400, 150, 30);
				
		add(loginLabel);
		add(loginField);
		add(senhaLabel);
		add(senhaField);
		add(bntEntrar);
		add(bntSair);
		
		imgFundo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("fundoLogin.jpeg")));
		add(imgFundo);
		setVisible(true);
	}
	
	public boolean verificarLogin(String login, char[] password) {
		String senha = String.copyValueOf(password);
		for (Funcionario funcionario : ClassXMLFuncionario.funcionarios) {
			if(funcionario.getLogin().equals(login)&&funcionario.getSenha().equals(senha)) {
				return true;
			}
		}
		for (Paciente paciente : ClassXML.pacientes) {
			if(paciente.getLogin().equals(login)&&paciente.getSenha().equals(senha)) {
				return true;
			}
		}
		
		return false;
	}

	public JLabel getImgFundo() {
		return imgFundo;
	}

	public JLabel getLoginLabel() {
		return loginLabel;
	}

	public JLabel getSenhaLabel() {
		return senhaLabel;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JPasswordField getSenhaField() {
		return senhaField;
	}

	public JButton getBntEntrar() {
		return bntEntrar;
	}

	public JButton getBntSair() {
		return bntSair;
	}
	
	
}
