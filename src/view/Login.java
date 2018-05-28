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
import model.Usuario;

public class Login extends JFrame{
	JLabel imgFundo, loginLabel, senhaLabel;
	JTextField loginField;
	JPasswordField senhaField;
	JButton bntEntrar, bntSair;
	
	public Login() {
		setSize(700,500);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		loginLabel = new JLabel("Login: ");
		loginLabel.setBounds(200,220,100,30);
		
		senhaLabel = new JLabel("Senha: ");
		senhaLabel.setBounds(200, 300, 100, 30);
		
		loginField = new JTextField();
		loginField.setBounds(200, 260, 300, 30);
		
		senhaField= new JPasswordField();
		senhaField.setBounds(200, 340, 300, 30);
		
		bntEntrar = new JButton("Entrar");
		bntEntrar.setBounds(200, 400, 150, 30);
		
		bntSair = new JButton("Sair");
		bntSair.setBounds(350, 400, 150, 30);
				
		add(loginLabel);
		add(loginField);
		add(senhaLabel);
		add(senhaField);
		add(bntEntrar);
		add(bntSair);
		
		imgFundo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("fundoLogin.jpg")));
		add(imgFundo);
		setVisible(true);
	}
	
	public Usuario verificarLogin(String login, char[] password) {
		String senha = String.copyValueOf(password);
		for (Funcionario funcionario : ClassXMLFuncionario.funcionarios) {
			if(funcionario.getLogin().equals(login)&&funcionario.getSenha().equals(senha)) {
				return funcionario;
			}
		}
		for (Paciente paciente : ClassXML.pacientes) {
			if(paciente.getLogin().equals(login)&&paciente.getSenha().equals(senha)) {
				return paciente;
			}
		}
		
		return null;
	}
	public boolean verificarTipoUsuario(Usuario usuario) {
		if(usuario instanceof Funcionario) {
			return true;
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
