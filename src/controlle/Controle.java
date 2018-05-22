package controlle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ClassXML;
import model.Endereco;
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
			if( (Verificar.verificarCadastro(cadastro)))
			{
				if(ClassXML.addPaciente(new Paciente(
						cadastro.getTfdNome().getText().trim(), 
						cadastro.getTfdCpf().getText().trim(), 
						cadastro.getTfdNascimento().getText().trim(), 
						cadastro.getCbxSexo().getSelectedItem().toString().trim(), 
						cadastro.getCbxSangue().getSelectedItem().toString().trim(), 
						cadastro.getTfdEmail().getText().trim(), 
						cadastro.getTfdTelefone().getText().trim(), 				
						new Endereco(
								cadastro.getTfdRua().getText().trim(), 
								cadastro.getTfdNumero().getText().trim(), 
								cadastro.getTfdBairro().getText().trim(), 
								cadastro.getTfdCidade().getText().trim(), 
								cadastro.getCbxEstado().getSelectedItem().toString().trim(), 
								cadastro.getTfdComplemento().getText().trim(), 
								cadastro.getTfdCep().getText().trim()))))
				Mensagem.exibirMensagem("Adicionado com Sucesso");
				else
					Mensagem.exibirMensagem("Falha Ao Adicionar - Dados Podem Esta faltando ou Repetidos");
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
				consulta.getTabelaModel().pesquisa(consulta.getConsultaT().getText(), ClassXML.pacientes);
					    
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
