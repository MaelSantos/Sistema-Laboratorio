package app;

import javax.swing.UIManager;

import controlle.Controle;
import model.BancoDados;
import model.ExameGeral;
import model.Usuario;
import view.CadastroPacientes;
import view.CadastroExames;
import view.CadastroFuncionario;
import view.ConsultaPacientes;
import view.ContasAReceber;
import view.ContasPagar;
import view.ConsultaExames;
import view.DetalhesFuncionario;
import view.DetalhesPaciente;
import view.EditarExame;
import view.EditarExameMarcado;
import view.Financeiro;
import view.Login;
import view.Marcar;
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
		
		CadastroPacientes cadastro = new CadastroPacientes();
		
		ConsultaPacientes consulta = new ConsultaPacientes();
		
		DetalhesPaciente detalhesPaciente =new DetalhesPaciente();
		
		CadastroExames cadastroExames = new CadastroExames();
		
		Marcar marcar = new Marcar();
		
		ConsultaExames consultaExames = new ConsultaExames();
		
		EditarExame editarExame = new EditarExame();
		
		EditarExameMarcado editarExameMarcado = new EditarExameMarcado();
		
		DetalhesFuncionario detalhesFuncionario =  new DetalhesFuncionario();
		
		CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();
	
		Financeiro financeiro = new Financeiro();
		
		Menu menu = new Menu();
		
		ContasPagar contasPagar= new ContasPagar();
		ContasAReceber contasAReceber = new ContasAReceber();
		
		Perfil perfil = new Perfil(new Usuario("",""){}, "");
	
		Principal principal = new Principal("Sistema Laboratorio", menu, cadastro, consulta, detalhesPaciente, cadastroFuncionario,
				detalhesFuncionario, perfil,cadastroExames,consultaExames, editarExame, marcar, financeiro,contasPagar, contasAReceber,
				editarExameMarcado);
		
		Controle controle = new Controle(login,principal, menu, cadastro,consulta,detalhesPaciente
				, cadastroFuncionario,  detalhesFuncionario, perfil,cadastroExames,consultaExames, 
				editarExame, marcar, financeiro,contasPagar,contasAReceber, editarExameMarcado );
	}
	
}
