package app;

import java.util.ArrayList;

import controlle.Controle;
import model.ClassXML;
import model.Paciente;
import view.Cadastro;
import view.Consulta;
import view.Menu;
import view.Principal;

public class App {
	
	public static ArrayList<Paciente> pacientesTest=new ArrayList<Paciente>();
	
	public static void main(String[] args) {
		
		App.pacientesTest.add(new Paciente("Alex", "66666666", "Masculino"));
		App.pacientesTest.add(new Paciente("Mael", "66666666", "Desconhecido"));
		App.pacientesTest.add(new Paciente("Felipe01", "66666666", "Desconhecido"));
		App.pacientesTest.add(new Paciente("Felipe02", "66666666", "Desconhecido"));
		
		Cadastro cadastro = new Cadastro();
		Consulta consulta = new Consulta();

		Menu menu = new Menu();
		
		Principal principal = new Principal("Sistema Laboratorio", menu, cadastro,consulta);
		
		Controle controle = new Controle(principal, menu, cadastro,consulta);
		
	}
	
}
