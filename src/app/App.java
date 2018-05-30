package app;

import javax.swing.UIManager;

import controlle.Controle;
import model.Usuario;
import view.Cadastro;
import view.CadastroFuncionario;
import view.Consulta;
import view.DetalhesFuncionario;
import view.DetalhesPaciente;
import view.Login;
import view.Menu;
import view.Perfil;
import view.Principal;

public class App {
	
	public static void main(String[] args) {
		
		String tema_padrao = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
        try {  
              UIManager.setLookAndFeel(tema_padrao);  
            } catch (Exception e) {  
        }
		
		Login login = new Login("Login");
		
		Cadastro cadastro = new Cadastro();
		
		Consulta consulta = new Consulta();
		
		DetalhesPaciente detalhesPaciente =new DetalhesPaciente();
		
		DetalhesFuncionario detalhesFuncionario =  new DetalhesFuncionario();
		
		CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();
		
		Menu menu = new Menu();
		
		Perfil perfil = new Perfil(new Usuario("",""){}, "");
	
		Principal principal = new Principal("Sistema Laboratorio", menu, cadastro, consulta, detalhesPaciente, cadastroFuncionario,
				detalhesFuncionario, perfil);
		
		Controle controle = new Controle(login,principal, menu, cadastro,consulta,detalhesPaciente, cadastroFuncionario,  detalhesFuncionario, perfil);
		
	}
	
}
