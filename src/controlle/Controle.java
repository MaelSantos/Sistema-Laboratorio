package controlle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import model.ClassXML;
import model.ClassXMLFuncionario;
import model.Endereco;
import model.Exame;
import model.Funcionario;
import model.Paciente;
import model.Usuario;
import model.Verificar;
import view.Cadastro;
import view.CadastroExames;
import view.CadastroFuncionario;
import view.Consulta;
import view.DetalhesFuncionario;
import view.DetalhesPaciente;
import view.Login;
import view.Mensagem;
import view.Menu;
import view.Perfil;
import view.Principal;

public class Controle extends MouseAdapter implements ActionListener{

	private Principal principal;//jframe
	private Menu menu;//jpanel
	private Cadastro cadastro;//jpanel
	private Consulta consulta;//jpanel
	private DetalhesPaciente detalhesPaciente;//jpanel
	private CadastroFuncionario cadastroFuncionario;//jpanel
	private DetalhesFuncionario detalhesFuncionario;//jpanel
	private Login login;//jpanel
	private Perfil perfil;
	private CadastroExames cadastroExames;

	public Controle(Login login,Principal principal, Menu menu, Cadastro cadastro,Consulta consulta, DetalhesPaciente detalhesPaciente,
			CadastroFuncionario cadastroFuncionario, DetalhesFuncionario detalhesFuncionario,Perfil perfil, CadastroExames cadastroExames) {
		this.principal = principal;
		this.menu = menu;
		this.cadastro = cadastro;
		this.consulta= consulta;
		this.detalhesPaciente=detalhesPaciente;
		this.cadastroFuncionario = cadastroFuncionario;
		this.detalhesFuncionario = detalhesFuncionario;
		this.login= login;
		this.perfil = perfil;
		this.cadastroExames = cadastroExames;

		cadastro.getBtnAdd().addActionListener(this);
		consulta.getConsultaB().addActionListener(this);
		consulta.getDetalhesButton().addActionListener(this);
		consulta.getVoltarTabelaCompleta().addActionListener(this);
		menu.getBtnCadastro().addActionListener(this);
		menu.getBtnCadastroFuncionario().addActionListener(this);
		menu.getBtnConsulta().addActionListener(this);
		menu.getBtnCadastrarExame().addActionListener(this);
		detalhesPaciente.getBtnAdd().addActionListener(this);
		detalhesPaciente.getBntVoltar().addActionListener(this);
		detalhesFuncionario.getBtnVoltar().addActionListener(this);
		detalhesFuncionario.getBtnAdd().addActionListener(this);
		cadastroFuncionario.getBtnAdd().addActionListener(this);
		cadastroExames.getBtnSalvar().addActionListener(this);
//		login.getBntEntrar().addActionListener(this);
//		login.getBntSair().addActionListener(this);
		
		
		
		perfil.getBtnEditarDados().addActionListener(this);
		perfil.getBtnSair().addActionListener(this);
		
		
		
		login.getBntEntrar().addMouseListener(this);
		login.getBntSair().addMouseListener(this);
		
		//menu.getBtnDetalhesFuncionario().addActionListener(this);
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

		if(e.getSource() == cadastroFuncionario.getBtnAdd())
		{
			if( (Verificar.verificarCadastro(cadastroFuncionario)))
			{
				if(detalhesFuncionario.getTfdSenha().getText()
						.equals(detalhesFuncionario.getTfdConfirmar().getText())
						&& !detalhesFuncionario.getTfdSenha().getText().trim().equals(""))
				{
				if(ClassXMLFuncionario.addFuncionario(new Funcionario(
						cadastroFuncionario.getTfdLogin().getText().trim(), 
						cadastroFuncionario.getTfdSenha().getText().trim(), 
						cadastroFuncionario.getTfdNome().getText().trim(),
						new Endereco(
								cadastroFuncionario.getTfdRua().getText().trim(), 
								cadastroFuncionario.getTfdNumero().getText().trim(), 
								cadastroFuncionario.getTfdBairro().getText().trim(), 
								cadastroFuncionario.getTfdCidade().getText().trim(), 
								cadastroFuncionario.getCbxEstado().getSelectedItem().toString().trim(), 
								cadastroFuncionario.getTfdComplemento().getText().trim(), 
								cadastroFuncionario.getTfdCep().getText().trim()),
						cadastroFuncionario.getTfdCpf().getText().trim(), 
						cadastroFuncionario.getTfdNascimento().getText().trim(), 
						cadastroFuncionario.getCbxSexo().getSelectedItem().toString().trim(), 
						cadastroFuncionario.getCbxSangue().getSelectedItem().toString().trim(), 
						cadastroFuncionario.getTfdEmail().getText().trim(), 
						cadastroFuncionario.getTfdTelefone().getText().trim(),
						cadastroFuncionario.getFcsImagem().getSelectedFile().getAbsolutePath())))
					Mensagem.exibirMensagem("Adicionado com Sucesso");
				else
					Mensagem.exibirMensagem("Falha Ao Adicionar - Dados Podem Esta faltando ou Repetidos");
				}
				else
					Mensagem.exibirMensagem("Senhar Repetidas");
			}
			else
			{
				Mensagem.exibirMensagem("Preencha os dados nescessarios !!!");
			}
		}


		if(e.getSource() == menu.getBtnCadastro())
		{ 

			consulta.setVisible(false);
			detalhesPaciente.setVisible(false);
			cadastroFuncionario.setVisible(false);
			cadastro.setVisible(true);

		}
		if(e.getSource() == menu.getBtnConsulta())
		{
			cadastro.setVisible(false);
			detalhesPaciente.setVisible(false);
			cadastroFuncionario.setVisible(false);
			consulta.setVisible(true);
		}

		if(e.getSource() == menu.getBtnCadastroFuncionario())
		{
			cadastro.setVisible(false);
			detalhesPaciente.setVisible(false);
			consulta.setVisible(false);
			cadastroFuncionario.setVisible(true);
		}
		if(e.getSource() == menu.getBtnCadastrarExame()) {
			cadastro.setVisible(false);
			detalhesPaciente.setVisible(false);
			consulta.setVisible(false);
			cadastroFuncionario.setVisible(false);
			cadastroExames.setVisible(true);
		}

		if(e.getSource() == consulta.getConsultaB())
		{
			if(!consulta.getConsultaT().getText().trim().equals("")) {
				consulta.getTabelaModel().pesquisa(consulta.getConsultaT().getText(), ClassXML.pacientes);

			}else {
				consulta.getTabelaModel().setPaciente(ClassXML.lerArquivo());
				Mensagem.exibirMensagem("Insira o Nome ou Cpf do Paciente");
			}
		}
		if (e.getSource()==consulta.getDetalhesButton()) {
			int select = consulta.getTabela().getSelectedRow();
			detalhesPaciente.autoPreencher(consulta.getTabelaModel().getPaciente().get(select));

			consulta.setVisible(false);
			detalhesPaciente.setVisible(true);
		}

		if(e.getSource() == consulta.getVoltarTabelaCompleta())
		{
			consulta.getTabelaModel().voltaTabelaCompleta();

		}
		if(e.getSource()==detalhesPaciente.getBtnAdd()) {
			Paciente paciente = new Paciente(
					detalhesPaciente.getTfdNome().getText().trim(), 
					detalhesPaciente.getTfdCpf().getText().trim(), 
					detalhesPaciente.getTfdNascimento().getText().trim(), 
					detalhesPaciente.getCbxSexo().getSelectedItem().toString().trim(), 
					detalhesPaciente.getCbxSangue().getSelectedItem().toString().trim(), 
					detalhesPaciente.getTfdEmail().getText().trim(), 
					detalhesPaciente.getTfdTelefone().getText().trim(), 				
					new Endereco(
							detalhesPaciente.getTfdRua().getText().trim(), 
							detalhesPaciente.getTfdNumero().getText().trim(), 
							detalhesPaciente.getTfdBairro().getText().trim(), 
							detalhesPaciente.getTfdCidade().getText().trim(), 
							detalhesPaciente.getCbxEstado().getSelectedItem().toString().trim(), 
							detalhesPaciente.getTfdComplemento().getText().trim(), 
							detalhesPaciente.getTfdCep().getText().trim()));

			ClassXML.editarPaciente(paciente);
		}

		if (e.getSource() == detalhesFuncionario.getBtnAdd()) {
			if(detalhesFuncionario.getTfdSenha().getText()
					.equals(detalhesFuncionario.getTfdConfirmar().getText())
					&& !detalhesFuncionario.getTfdSenha().getText().trim().equals(""))
			{
				Funcionario funcionario = new Funcionario(
						detalhesFuncionario.getTfdLogin().getText().trim(),
						detalhesFuncionario.getTfdSenha().getText().trim(),
						detalhesFuncionario.getTfdNome().getText().trim(),
						new Endereco(detalhesFuncionario.getTfdRua().getText().trim(),
								detalhesFuncionario.getTfdRua().getText().trim(),
								detalhesFuncionario.getTfdBairro().getText(),
								detalhesFuncionario.getTfdCidade().getText().trim(),
								detalhesFuncionario.getCbxEstado().getSelectedItem().toString().trim(),
								detalhesFuncionario.getTfdComplemento().getText().trim(),
								detalhesFuncionario.getTfdCep().getText().trim()),
						
						detalhesFuncionario.getTfdCpf().getText(), detalhesFuncionario.getTfdNascimento().getText().trim(),
						detalhesFuncionario.getCbxSexo().toString(), detalhesFuncionario.getCbxSangue().toString().trim(),
						detalhesFuncionario.getTfdEmail().getText(), detalhesFuncionario.getTfdEmail().getText().trim());
				
				// Falta o editar funcionario				
			}
			else
				Mensagem.exibirMensagem("Senhas Diferentes!!!");
		}

		if(e.getSource()==detalhesPaciente.getBntVoltar()) {
			detalhesPaciente.setVisible(false);
			consulta.setVisible(true);
		}

		if (e.getSource() == detalhesFuncionario.getBtnVoltar()) {
			detalhesFuncionario.setVisible(false);
			consulta.setVisible(true);
		}

		if(e.getSource() == perfil.getBtnSair())
		{
			principal.setVisible(false);
			login.getLoginField().setText(null);
			login.getSenhaField().setText(null);
			login.setVisible(true);
		}
		
		if (e.getSource()==perfil.getBtnEditarDados()) {
			cadastro.setVisible(false);
			cadastroFuncionario.setVisible(false);
			detalhesPaciente.setVisible(false);
			consulta.setVisible(false);
			
			if(login.verificarTipoUsuario(perfil.getUsuario())) {
				detalhesFuncionario.autoPreencher((Funcionario)perfil.getUsuario());
				detalhesFuncionario.setVisible(true);
			}else {
				detalhesPaciente.autoPreencher((Paciente)perfil.getUsuario());
				detalhesPaciente.setVisible(true);
			}
			

		}
		if(e.getSource() == cadastroExames.getBtnSalvar()) {
			
			Exame exame = new Exame(cadastroExames.getFieldNomeMedico().getText(),cadastroExames.getFieldcpfPaciente().getText(), cadastroExames.getTextAreaParecer().getText());
			ArrayList<Paciente> pacientes = ClassXML.lerArquivo();
			
			
			for (Paciente pacienteAtual : pacientes) {
				if(pacienteAtual.getCpf().equals(cadastroExames.getFieldcpfPaciente().getText())) {
					pacienteAtual.getExames().add(exame);
					ClassXML.editarPaciente(pacienteAtual);
				}
			}
			
			
			
			cadastroExames.getFieldcpfPaciente().setText("");
			cadastroExames.getFieldNomeMedico().setText("");
			cadastroExames.getTextAreaParecer().setText("");
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
        if (e.getSource() == login.getBntEntrar()) {
			
			Usuario usuario = login.verificarLogin(login.getLoginField().getText(),
					login.getSenhaField().getPassword());
			if (usuario != null) {
				
				if (login.verificarTipoUsuario(usuario)) {
					
					perfil.atualiarUsuario(usuario, "Funcionario");
					menu.getBtnCadastro().setVisible(true);
					menu.getBtnCadastroFuncionario().setVisible(true);
				} else {
					perfil.atualiarUsuario(usuario, "Cliente");
					menu.getBtnCadastro().setVisible(false);
					menu.getBtnCadastroFuncionario().setVisible(false);
				}
				perfil.getBtnEditarDados().addActionListener(this); 
				login.setVisible(false);
				principal.setVisible(true);
			} else {
				Mensagem.exibirMensagem("Login ou  Senha Incorretos !!!");
			}
		}
		if (e.getSource() == login.getBntSair()) {
			System.exit(0);

		}
		
	}

	

}
