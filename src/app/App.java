package app;

import controlle.Controle;
import model.ClassXML;
import view.Cadastro;
import view.CadastroFuncionario;
import view.Consulta;
import view.DetalhesPaciente;
import view.Menu;
import view.Principal;

public class App {
	
	public static void main(String[] args) {
		
		Cadastro cadastro = new Cadastro();
		
		Consulta consulta = new Consulta();
		
		DetalhesPaciente detalhesPaciente =new DetalhesPaciente();
		
		CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();
		
		Menu menu = new Menu();
		
		Principal principal = new Principal("Sistema Laboratorio", menu, cadastro, consulta, detalhesPaciente, cadastroFuncionario);
		
		Controle controle = new Controle(principal, menu, cadastro,consulta,detalhesPaciente, cadastroFuncionario);
		
	}
	
}
