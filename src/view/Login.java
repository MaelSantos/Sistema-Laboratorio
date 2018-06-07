package view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.BancoDados;
import model.Funcionario;
import model.Paciente;
import model.Usuario;

public class Login extends TelaGeral{
	
	JLabel imgFundo, loginLabel, senhaLabel;
	JTextField loginField;
	JPasswordField senhaField;
	JLabel bntEntrar, bntSair;
	
	public Login(String titulo) {
		super(titulo);
		setSize(700,500);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		inicializar();
	}
	
	@Override
	public void inicializar() {
		loginLabel = new JLabel("Login: ");
		loginLabel.setBounds(200,220,100,30);
		
		senhaLabel = new JLabel("Senha: ");
		senhaLabel.setBounds(200, 300, 100, 30);
		
		loginField = new JTextField();
		loginField.setBounds(200, 260, 300, 35);
		
		senhaField= new JPasswordField();
		senhaField.setBounds(200, 340, 300, 35);
		
		loginLabel.setFont(new Font("Futura Md Bt", Font.LAYOUT_LEFT_TO_RIGHT,15));
		senhaLabel.setFont(new Font("Futura Md Bt", Font.LAYOUT_LEFT_TO_RIGHT,15));
		loginField.setFont(new Font("Futura Md Bt", Font.BOLD,15));
		senhaField.setFont(new Font("Futura Md Bt", Font.BOLD,15));
		
		try {
			bntEntrar = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("entrar.png")));
			bntSair = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("sair.png")));
			imgFundo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("fundoLogin.jpg")));			
		} catch (Exception e) {
			System.out.println("Erro");
		}
		
		bntEntrar.setBounds(200, 400, 150, 30);		
		bntSair.setBounds(350, 400, 150, 30);
				
		add(loginLabel);
		add(loginField);
		add(senhaLabel);
		add(senhaField);
		add(bntEntrar);
		add(bntSair);		
		add(imgFundo);
		setVisible(true);
		
	}
	
	public Usuario verificarLogin(String login, char[] password) {
		String senha = String.copyValueOf(password);
		for (Funcionario funcionario : BancoDados.getInstance().getFuncionarios()) {
			if(funcionario.getLogin().equals(login)&&funcionario.getSenha().equals(senha)) {
				return funcionario;
			}
		}
		for (Paciente paciente : BancoDados.getInstance().getPacientes()) {
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

	public JLabel getBntEntrar() {
		return bntEntrar;
	}

	public JLabel getBntSair() {
		return bntSair;
	}

	
}
