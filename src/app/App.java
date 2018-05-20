package app;

import controlle.Controle;
import view.Cadastro;
import view.Consulta;
import view.Menu;
import view.Principal;

public class App {
	
	public static void main(String[] args) {
		
		Cadastro cadastro = new Cadastro();
		
		Consulta consulta = new Consulta();

		Menu menu = new Menu();
		
		Principal principal = new Principal("Sistema Laboratorio", menu, cadastro,consulta);
		
		Controle controle = new Controle(principal, menu, cadastro,consulta);
		
	}
	
}
