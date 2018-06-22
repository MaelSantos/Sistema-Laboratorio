package controlle;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import model.BancoDados;
import model.Endereco;
import model.ExameGeral;
import model.MarcarExame;
import model.Funcionario;
import model.Paciente;
import model.Usuario;
import model.Verificar;
import view.CadastroPacientes;
import view.CadastroExames;
import view.CadastroFuncionario;
import view.ConsultaPacientes;
import view.ContasPagar;
import view.ConsultaExames;
import view.DetalhesFuncionario;
import view.DetalhesPaciente;
import view.EditarExame;
import view.Financeiro;
import view.Login;
import view.Marcar;
import view.Mensagem;
import view.Menu;
import view.Perfil;
import view.Principal;

public class Controle extends MouseAdapter implements ActionListener {

	private Principal principal;// jframe
	private Menu menu;// jpanel
	private CadastroPacientes cadastro;// jpanel
	private ConsultaPacientes consulta;// jpanel
	private DetalhesPaciente detalhesPaciente;// jpanel
	private CadastroFuncionario cadastroFuncionario;// jpanel
	private DetalhesFuncionario detalhesFuncionario;// jpanel
	private Login login;// jpanel
	private Perfil perfil;
	private CadastroExames cadastroExames;
	private ConsultaExames consultaExames;
	private EditarExame editarExame;
	private Marcar marcar;
	private ContasPagar contasPagar;

	private Financeiro financeiro;
	public static String cpfPacientde;

	public Controle(Login login, Principal principal, Menu menu, CadastroPacientes cadastro, ConsultaPacientes consulta,
			DetalhesPaciente detalhesPaciente, CadastroFuncionario cadastroFuncionario,
			DetalhesFuncionario detalhesFuncionario, Perfil perfil, CadastroExames cadastroExames,
			ConsultaExames consultaExames, EditarExame editarExame, Marcar marcar,Financeiro financeiro,ContasPagar contasPagar) {
		
		this.principal = principal;
		this.menu = menu;
		this.cadastro = cadastro;
		this.consulta = consulta;
		this.detalhesPaciente = detalhesPaciente;
		this.cadastroFuncionario = cadastroFuncionario;
		this.detalhesFuncionario = detalhesFuncionario;
		this.login = login;
		this.perfil = perfil;
		this.cadastroExames = cadastroExames;
		this.consultaExames = consultaExames;
		this.editarExame = editarExame;
		this.marcar = marcar;
		this.financeiro = financeiro;
		this.contasPagar = contasPagar;
		
		cadastro.getBtnAdd().addActionListener(this);
		consulta.getConsultaB().addActionListener(this);
		consulta.getDetalhesButton().addActionListener(this);
		consulta.getVoltarTabelaCompleta().addActionListener(this);
		menu.getBtnCadastro().addActionListener(this);
		menu.getBtnCadastroFuncionario().addActionListener(this);
		menu.getBtnConsulta().addActionListener(this);
		menu.getBtnCadastrarExame().addActionListener(this);
		menu.getBtnConsultaExames().addActionListener(this);
		menu.getBtnMarcarExame().addActionListener(this);
		menu.getBtnFinanceiro().addActionListener(this);
		menu.getBtnContasPagar().addActionListener(this);
		detalhesPaciente.getBtnAdd().addActionListener(this);
		detalhesPaciente.getBntVoltar().addActionListener(this);
		detalhesFuncionario.getBtnVoltar().addActionListener(this);
		detalhesFuncionario.getBtnAdd().addActionListener(this);
		cadastroFuncionario.getBtnAdd().addActionListener(this);
		cadastroExames.getBtnSalvar().addActionListener(this);
		consultaExames.getPesquisaB().addActionListener(this);
		// login.getBntEntrar().addActionListener(this);
		// login.getBntSair().addActionListener(this);

		perfil.getBtnEditarDados().addActionListener(this);
		perfil.getBtnSair().addActionListener(this);

		login.getBntEntrar().addMouseListener(this);
		login.getBntSair().addMouseListener(this);

		// menu.getBtnDetalhesFuncionario().addActionListener(this);

		consultaExames.getTblDisponiveis().addMouseListener(this);
		editarExame.getBtnSalvar().addActionListener(this);

		marcar.getBtnAdd().addActionListener(this);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cadastro.getBtnAdd()) {
			if ((Verificar.verificarCadastro(cadastro))) {
				if (BancoDados.getInstance().addDado(new Paciente(cadastro.getTfdNome().getText().trim(),
						cadastro.getTfdCpf().getText().trim(), cadastro.getTfdNascimento().getText().trim(),
						cadastro.getCbxSexo().getSelectedItem().toString().trim(),
						cadastro.getCbxSangue().getSelectedItem().toString().trim(),
						cadastro.getTfdEmail().getText().trim(), cadastro.getTfdTelefone().getText().trim(),
						new Endereco(cadastro.getTfdRua().getText().trim(), cadastro.getTfdNumero().getText().trim(),
								cadastro.getTfdBairro().getText().trim(), cadastro.getTfdCidade().getText().trim(),
								cadastro.getCbxEstado().getSelectedItem().toString().trim(),
								cadastro.getTfdComplemento().getText().trim(), cadastro.getTfdCep().getText().trim()))))
					Mensagem.exibirMensagem("Adicionado com Sucesso");
				else
					Mensagem.exibirMensagem("Falha Ao Adicionar - Dados Podem Esta faltando ou Repetidos");
			} else {
				Mensagem.exibirMensagem("Preencha os dados nescessarios !!!");
			}
		}

		if (e.getSource() == cadastroFuncionario.getBtnAdd()) {
			if ((Verificar.verificarCadastro(cadastroFuncionario))) {
				if (cadastroFuncionario.getTfdSenha().getText().equals(cadastroFuncionario.getTfdConfirmar().getText())
						&& !cadastroFuncionario.getTfdSenha().getText().trim().equals("")) {
					if (BancoDados.getInstance()
							.addDado(new Funcionario(cadastroFuncionario.getTfdLogin().getText().trim(),
									cadastroFuncionario.getTfdSenha().getText().trim(),
									cadastroFuncionario.getTfdNome().getText().trim(),
									new Endereco(cadastroFuncionario.getTfdRua().getText().trim(),
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
				} else
					Mensagem.exibirMensagem("Senhar Repetidas");
			} else {
				Mensagem.exibirMensagem("Preencha os dados nescessarios !!!");
			}
		}

		if (e.getSource() == menu.getBtnCadastro()) {
			mudarTela(cadastro);
		}
		if (e.getSource() == menu.getBtnConsulta()) {
			mudarTela(consulta);
		}

		if (e.getSource() == menu.getBtnCadastroFuncionario()) {

			mudarTela(cadastroFuncionario);
		}
		if (e.getSource() == menu.getBtnCadastrarExame()) {

			mudarTela(cadastroExames);
		}
		if (e.getSource() == menu.getBtnConsultaExames()) {

			mudarTela(consultaExames);
		}
		if (e.getSource() == menu.getBtnMarcarExame()) {
			mudarTela(marcar);
		}
		if(e.getSource() == menu.getBtnFinanceiro())
		{
			mudarTela(financeiro);
		}
		if(e.getSource() == menu.getBtnContasPagar()) {
			mudarTela(contasPagar);
		}
		if (e.getSource() == consulta.getConsultaB()) {
			if (!consulta.getConsultaT().getText().trim().equals("")) {
				consulta.getTabelaModel().pesquisa(consulta.getConsultaT().getText(),
						BancoDados.getInstance().getPacientes());

			} else {
				consulta.getTabelaModel()
						.setPaciente((ArrayList<Paciente>) BancoDados.getInstance().lerArquivo("pacientes.xml"));
				Mensagem.exibirMensagem("Insira o Nome ou Cpf do Paciente");
			}
		}
		if (e.getSource() == consulta.getDetalhesButton()) {
			int select = consulta.getTabela().getSelectedRow();
			detalhesPaciente.autoPreencher(consulta.getTabelaModel().getPaciente().get(select));

			mudarTela(detalhesPaciente);
		}

		if (e.getSource() == consulta.getVoltarTabelaCompleta()) {
			consulta.getTabelaModel().voltaTabelaCompleta();

		}
		if (e.getSource() == detalhesPaciente.getBtnAdd()) {
			Paciente paciente = new Paciente(detalhesPaciente.getTfdNome().getText().trim(),
					detalhesPaciente.getTfdCpf().getText().trim(), detalhesPaciente.getTfdNascimento().getText().trim(),
					detalhesPaciente.getCbxSexo().getSelectedItem().toString().trim(),
					detalhesPaciente.getCbxSangue().getSelectedItem().toString().trim(),
					detalhesPaciente.getTfdEmail().getText().trim(), detalhesPaciente.getTfdTelefone().getText().trim(),
					new Endereco(detalhesPaciente.getTfdRua().getText().trim(),
							detalhesPaciente.getTfdNumero().getText().trim(),
							detalhesPaciente.getTfdBairro().getText().trim(),
							detalhesPaciente.getTfdCidade().getText().trim(),
							detalhesPaciente.getCbxEstado().getSelectedItem().toString().trim(),
							detalhesPaciente.getTfdComplemento().getText().trim(),
							detalhesPaciente.getTfdCep().getText().trim()));

			BancoDados.getInstance().editarPaciente(paciente);
		}

		if (e.getSource() == detalhesFuncionario.getBtnAdd()) {
			if (detalhesFuncionario.getTfdSenha().getText().equals(detalhesFuncionario.getTfdConfirmar().getText())
					&& !detalhesFuncionario.getTfdSenha().getText().trim().equals("")) {
				Funcionario funcionario = new Funcionario(detalhesFuncionario.getTfdLogin().getText().trim(),
						detalhesFuncionario.getTfdSenha().getText().trim(),
						detalhesFuncionario.getTfdNome().getText().trim(),
						new Endereco(detalhesFuncionario.getTfdRua().getText().trim(),
								detalhesFuncionario.getTfdRua().getText().trim(),
								detalhesFuncionario.getTfdBairro().getText(),
								detalhesFuncionario.getTfdCidade().getText().trim(),
								detalhesFuncionario.getCbxEstado().getSelectedItem().toString().trim(),
								detalhesFuncionario.getTfdComplemento().getText().trim(),
								detalhesFuncionario.getTfdCep().getText().trim()),

						detalhesFuncionario.getTfdCpf().getText(),
						detalhesFuncionario.getTfdNascimento().getText().trim(),
						detalhesFuncionario.getCbxSexo().toString(),
						detalhesFuncionario.getCbxSangue().toString().trim(),
						detalhesFuncionario.getTfdEmail().getText(),
						detalhesFuncionario.getTfdEmail().getText().trim());

				// Falta o editar funcionario
			} else
				Mensagem.exibirMensagem("Senhas Diferentes!!!");
		}

		if (e.getSource() == detalhesPaciente.getBntVoltar()) {

			mudarTela(consulta);
		}

		if (e.getSource() == detalhesFuncionario.getBtnVoltar()) {

			mudarTela(consulta);
		}

		if (e.getSource() == perfil.getBtnSair()) {
			principal.setVisible(false);
			login.getLoginField().setText(null);
			login.getSenhaField().setText(null);
			login.setVisible(true);
		}

		if (e.getSource() == perfil.getBtnEditarDados()) {

			if (login.verificarTipoUsuario(perfil.getUsuario())) {
				detalhesFuncionario.autoPreencher((Funcionario) perfil.getUsuario());
			} else {
				detalhesPaciente.autoPreencher((Paciente) perfil.getUsuario());
			}

			mudarTela(detalhesPaciente);
		}
		
		
		if (e.getSource() == cadastroExames.getBtnSalvar()) {
			String tipoAmostra = (String) cadastroExames.getComboBoxTipoAmostra().getSelectedItem();
			String codigoAtual = contarCodigo(Integer.parseInt(BancoDados.getInstance().getExamesGerais()
					.get(BancoDados.getInstance().getExamesGerais().size() - 1).getCodigo()) + 1);
			try {
				ExameGeral exame = new ExameGeral(cadastroExames.getFieldTipoExame().getText().trim(), tipoAmostra,
						Double.parseDouble(cadastroExames.getFieldvalor().getText()), codigoAtual);
				System.out.println(BancoDados.getInstance().addDado(exame));
				cadastroExames.getFieldTipoExame().setText("");
				cadastroExames.getFieldvalor().setText("");
				Mensagem.exibirMensagem("Exame salvo com sucesso.");
				consultaExames.getExamesDisponiveis().atualizarTabela();

			} catch (NumberFormatException exception) {
				Mensagem.exibirMensagem(
						"Certifique-se de que todos os campos estejam preenchidos corretamente. Erro:" + exception);
			}
		}
		if (e.getSource() == editarExame.getBtnSalvar()) {
			ExameGeral exameGeral = new ExameGeral(editarExame.getFieldTipoExame().getText().trim(),
					(String) editarExame.getComboBoxTipoAmostra().getSelectedItem(),
					Double.parseDouble(editarExame.getFieldvalor().getText().trim()),
					editarExame.getExame().getCodigo());

			BancoDados.getInstance().editarExame(exameGeral);
		}

		if (e.getSource() == marcar.getBtnAdd()) {
			if (Verificar.verificarMarcar(marcar)) {
				ExameGeral geral = null;
				String exameGeral = marcar.getComboBoxExamesGerais().getSelectedItem().toString();
				for (ExameGeral g : BancoDados.getInstance().getExamesGerais()) {
					if (g.equals(exameGeral)) {
						geral = g;
						break;
					}

				}
				if (geral != null) {
					BancoDados.getInstance().addDado(new MarcarExame(geral, marcar.getTfdNomeMedico().getText().trim(),
							marcar.getTfdCpfPaciente().getText().trim(), marcar.getTfdParecer().getText().trim()));

					Mensagem.exibirMensagem("Exame Marcado Com Sucesso!!!");
					marcar.getTfdNomeMedico().setText("");
					marcar.getTfdCpfPaciente().setText("");
					marcar.getTfdParecer().setText("");

					consultaExames.getModel().fireTableDataChanged();
				} else {
					Mensagem.exibirMensagem("Erro Ao Marcar Exame");
				}

			} else
				Mensagem.exibirMensagem("Preencha Todos os Campos");
		}
		if (e.getSource() == consultaExames.getPesquisaB()) {
			
			consultaExames.getModel().pesquisa(consultaExames.getCampoPesquisa().getText(),
					consultaExames.getOpcaoDePesquisa().getSelectedItem().toString(),
					BancoDados.getInstance().getExamesMarcados());
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == login.getBntEntrar()) {

			Usuario usuario = login.verificarLogin(login.getLoginField().getText(),
					login.getSenhaField().getPassword());
			if (usuario instanceof Paciente) {
				cpfPacientde = usuario.getCpf();
				consultaExames.getModel().atualizarTabelaPaciente(cpfPacientde);
			}
			if (usuario != null) {

				if (login.verificarTipoUsuario(usuario)) {

					perfil.atualiarUsuario(usuario, "Funcionario");
					menu.getBtnCadastro().setVisible(true);
					menu.getBtnCadastroFuncionario().setVisible(true);
					menu.getBtnCadastroFuncionario().setVisible(true);
					menu.getBtnCadastrarExame().setVisible(true);
					menu.getBtnMarcarExame().setVisible(true);
				} else {
					perfil.atualiarUsuario(usuario, "Cliente");
					menu.getBtnCadastro().setVisible(false);
					menu.getBtnCadastroFuncionario().setVisible(false);
					menu.getBtnCadastrarExame().setVisible(false);
					menu.getBtnMarcarExame().setVisible(false);
					
					
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

		if (e.getSource() == consultaExames.getTblDisponiveis()) {
			JPopupMenu menu = new JPopupMenu();
			JMenuItem editar = new JMenuItem("Editar");
			editar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					editarExame.autoPreencher(
							consultaExames.getExames().get(consultaExames.getTblDisponiveis().getSelectedRow()));
					mudarTela(editarExame);
					

				}
			});
			JMenuItem excluir = new JMenuItem("Excluir");
			excluir.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					BancoDados.getInstance().excluirExame(BancoDados.getInstance().getExamesGerais()
							.get(consultaExames.getTblDisponiveis().getSelectedRow()));

					// Excluir linha da tabela.

				}
			});

			JMenuItem cancelar = new JMenuItem("Cancelar");
			cancelar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					menu.setVisible(false);
				}
			});
			menu.add(editar);
			menu.add(excluir);
			menu.add(cancelar);
			menu.show(consultaExames.getTblDisponiveis(), e.getX(), e.getY());

		}
	}

	public void mudarTela(JPanel panel) {
		for (Component c : principal.getContentPane().getComponents())
			if (c.equals(panel))
				c.setVisible(true);
			else if (!(c.equals(menu) || c.equals(perfil)))
				c.setVisible(false);

	}
	public String contarCodigo(int codigoAtual) {
		String str = "";
		if (codigoAtual <= 9) {
			str = "00";
		} else if (codigoAtual >= 10) {
			str = "0";
		}
		return str + String.valueOf(codigoAtual);
	}
}
