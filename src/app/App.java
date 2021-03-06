package app;

import javax.swing.UIManager;

import controlle.Controle;
import modelVo.Usuario;
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
import view.MenuPaneContainer;
import view.Perfil;
import view.Principal;
import view.RelatoriosView;

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
		
//		Menu menu = new Menu();
		MenuPaneContainer menuPaneContainer = new MenuPaneContainer();
		
		ContasPagar contasPagar= new ContasPagar();
		ContasAReceber contasAReceber = new ContasAReceber();
		
		Perfil perfil = new Perfil(new Usuario("",""){}, "");
	
		RelatoriosView relatoriosView = new RelatoriosView();
		
		Principal principal = new Principal("Sistema Laboratorio", menuPaneContainer, cadastro, consulta, detalhesPaciente, cadastroFuncionario,
				detalhesFuncionario, perfil,cadastroExames,consultaExames, editarExame, marcar, financeiro,contasPagar, contasAReceber,
				editarExameMarcado, relatoriosView);
		
		Controle controle = new Controle(login,principal, menuPaneContainer, cadastro,consulta,detalhesPaciente
				, cadastroFuncionario,  detalhesFuncionario, perfil,cadastroExames,consultaExames, 
				editarExame, marcar, financeiro,contasPagar,contasAReceber, editarExameMarcado,relatoriosView );
	}
	
}
