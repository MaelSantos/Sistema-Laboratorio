package controlle;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import app.App;
import model.ClassXML;
import model.Paciente;
import model.Verificar;
import view.Cadastro;
import view.Consulta;
import view.Mensagem;
import view.Menu;
import view.Principal;

public class Controle implements ActionListener{

	private Principal principal;//jframe
	private Menu menu;//jpanel
	private Cadastro cadastro;//jpanel
	private Consulta consulta;//jpanel
	
	public Controle(Principal principal, Menu menu, Cadastro cadastro,Consulta consulta) {
		this.principal = principal;
		this.menu = menu;
		this.cadastro = cadastro;
		this.consulta= consulta;
		
	
		cadastro.getBtnAdd().addActionListener(this);
		consulta.getConsultaB().addActionListener(this);
		menu.getBtnCadastro().addActionListener(this);
		menu.getBtnConsulta().addActionListener(this);
		menu.getBtnSair().addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == cadastro.getBtnAdd())
		{
			System.out.println(Verificar.verificarCadastro(cadastro));
			if( (Verificar.verificarCadastro(cadastro)))
			{
				ClassXML.pacientes.add(new Paciente(
						cadastro.getTfdNome().getText().trim(),
						cadastro.getTfdCpf().getText().trim(), 
						cadastro.getTfdSexo().getText().trim()));
				ClassXML.gravar(ClassXML.pacientes);				
			}
			else
			{
				Mensagem.exibirMensagem("Preencha os dados nescessarios !!!");
			}
		}
		
		if(e.getSource() == menu.getBtnCadastro())
		{ 
			
			consulta.setVisible(false);
			cadastro.setVisible(true);
			
		}
		if(e.getSource() == menu.getBtnConsulta())
		{
			cadastro.setVisible(false);
			consulta.setVisible(true);
		}
		
		if(e.getSource() == consulta.getConsultaB())
		{
			System.out.println("esta entrando");
			if(!consulta.getConsultaT().getText().trim().equals("")) {
				consulta.getTabelaModel().pesquisa(consulta.getConsultaT().getText(), App.pacientesTest);
					    
			}else {
				Mensagem.exibirMensagem("Insira o Nome ou Cpf do Paciente");
			}
		}
		
		if(e.getSource() == menu.getBtnSair())
		{
			System.exit(0);
		}
	}
	
}
