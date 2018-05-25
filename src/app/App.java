package app;

import java.util.ArrayList;

import controlle.Controle;
import model.ClassXML;
import model.ClassXMLFuncionario;
import model.Endereco;
import model.Funcionario;
import view.Cadastro;
import view.CadastroFuncionario;
import view.Consulta;
import view.DetalhesPaciente;
import view.Login;
import view.Menu;
import view.Principal;

public class App {
	
	public static void main(String[] args) {
		
		Login login = new Login();
		
		Cadastro cadastro = new Cadastro();
		
		Consulta consulta = new Consulta();
		
		DetalhesPaciente detalhesPaciente =new DetalhesPaciente();
		
		CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();
		
		Menu menu = new Menu();
		
		Principal principal = new Principal("Sistema Laboratorio", menu, cadastro, consulta, detalhesPaciente, cadastroFuncionario);
		
		Controle controle = new Controle(login,principal, menu, cadastro,consulta,detalhesPaciente, cadastroFuncionario);
		
	}
	
}
