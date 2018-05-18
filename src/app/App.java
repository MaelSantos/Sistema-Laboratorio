package app;

import controlle.Controle;
import view.Cadastro;
import view.Principal;

public class App {

	public static void main(String[] args) {
				
		Cadastro cadastro = new Cadastro();

		Principal principal = new Principal("Sistema Laboratorio", cadastro);
		
		Controle controle = new Controle(principal, cadastro);
		
	}
	
}
