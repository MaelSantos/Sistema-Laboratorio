package controlle;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

import modelBo.Verificar;
import modelDao.BancoDados;
import modelDao.RelatorioDao;
import modelVo.Andamento;
import modelVo.DespesasVo;
import modelVo.Endereco;
import modelVo.ExameGeral;
import modelVo.Funcionario;
import modelVo.MarcarExame;
import modelVo.Paciente;
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
import view.Mensagem;
import view.MenuPaneContainer;
import view.Perfil;
import view.Principal;
import view.RelatoriosView;

public class Controle extends MouseAdapter implements ActionListener, ItemListener {

	private Principal principal;// jframe
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
	private EditarExameMarcado editarExameMarcado;
	private Marcar marcar;
	private ContasPagar contasPagar;
	private ContasAReceber contasAReceber;
	private Financeiro financeiro;
	private MenuPaneContainer menuPaneContainer;
	private RelatoriosView relatorios;

	public static String cpfPacientde;

	public Controle(Login login, Principal principal, MenuPaneContainer menuPaneContainer, CadastroPacientes cadastro, ConsultaPacientes consulta,
			DetalhesPaciente detalhesPaciente, CadastroFuncionario cadastroFuncionario,
			DetalhesFuncionario detalhesFuncionario, Perfil perfil, CadastroExames cadastroExames,
			ConsultaExames consultaExames, EditarExame editarExame, Marcar marcar, Financeiro financeiro,
			ContasPagar contasPagar, ContasAReceber contasAReceber, EditarExameMarcado editarExameMarcado,
			RelatoriosView relatorios) {

		this.principal = principal;
		this.menuPaneContainer=menuPaneContainer;
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
		this.editarExameMarcado = editarExameMarcado;
		this.marcar = marcar;
		this.financeiro = financeiro;
		this.contasPagar = contasPagar;
		this.contasAReceber = contasAReceber;
		this.relatorios = relatorios;
		
		cadastro.getBtnAdd().addActionListener(this);
		consulta.getConsultaB().addActionListener(this);
		consulta.getDetalhesButton().addActionListener(this);
		consulta.getVoltarTabelaCompleta().addActionListener(this);
		menuPaneContainer.getBtnCadastro().addActionListener(this);
		menuPaneContainer.getBtnCadastroFuncionario().addActionListener(this);
		menuPaneContainer.getBtnConsulta().addActionListener(this);
		menuPaneContainer.getBtnCadastrarExame().addActionListener(this);
		menuPaneContainer.getBtnConsultaExames().addActionListener(this);
		menuPaneContainer.getBtnMarcarExame().addActionListener(this);
		menuPaneContainer.getBtnFinanceiro().addActionListener(this);
		menuPaneContainer.getBtnContasPagar().addActionListener(this);
		menuPaneContainer.getBtnContasAReceber().addActionListener(this);
		menuPaneContainer.getBtnRelatorios().addActionListener(this);
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
		consultaExames.getTblExames().addMouseListener(this);
		editarExame.getBtnSalvar().addActionListener(this);
		editarExameMarcado.getBtnAdd().addActionListener(this);
		marcar.getBtnAdd().addActionListener(this);

		contasAReceber.getBtnLancar().addActionListener(this);
		contasAReceber.getBtnLimpar().addActionListener(this);
		contasAReceber.getBtnBuscar().addActionListener(this);
		contasAReceber.getComboTipoDePagamento().addItemListener(this);

		contasPagar.getLancar().addActionListener(this);
		
		relatorios.getBtnEscolha().addActionListener(this);
		
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

		if (e.getSource() == menuPaneContainer.getBtnCadastro()) {
			mudarTela(cadastro);
		}
		if (e.getSource() == menuPaneContainer.getBtnConsulta()) {
			mudarTela(consulta);
		}

		if (e.getSource() == menuPaneContainer.getBtnCadastroFuncionario()) {

			mudarTela(cadastroFuncionario);
		}
		if (e.getSource() == menuPaneContainer.getBtnCadastrarExame()) {

			mudarTela(cadastroExames);
		}
		if (e.getSource() == menuPaneContainer.getBtnConsultaExames()) {

			mudarTela(consultaExames);
		}
		if (e.getSource() == menuPaneContainer.getBtnMarcarExame()) {
			mudarTela(marcar);
		}
		if (e.getSource() == menuPaneContainer.getBtnFinanceiro()) {
			mudarTela(financeiro);
		}
		if (e.getSource() == menuPaneContainer.getBtnContasPagar()) {
			mudarTela(contasPagar);
		}
		if (e.getSource() == menuPaneContainer.getBtnContasAReceber()) {
			mudarTela(contasAReceber);
		}
		if (e.getSource() == menuPaneContainer.getBtnRelatorios()) {
			mudarTela(relatorios);
		}
		if(e.getSource() == relatorios.getBtnEscolha())
		{
			try {
				
			if(relatorios.getJcbTipo().getSelectedIndex() == 0)
			{
				System.out.println("Despesas");
				RelatorioDao.getInstance().gerar(BancoDados.getInstance().getDespesas(), "Despesas.jrxml");
				
			}
			if(relatorios.getJcbTipo().getSelectedIndex() == 1)
			{
				System.out.println("Receitas");
				RelatorioDao.getInstance().gerar(BancoDados.getInstance().getContasARecebers(), "Receitas.jrxml");
			}
			if(relatorios.getJcbTipo().getSelectedIndex() == 2)
			{
				System.out.println("Clientes");
				RelatorioDao.getInstance().gerar(BancoDados.getInstance().getPacientes(), "Clientes.jrxml");
			}
			}
			catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
			
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
			String codigoAtual = contarCodigo(BancoDados.getInstance().getExamesGerais().size());
			
			try {
				ExameGeral exame = new ExameGeral(cadastroExames.getFieldTipoExame().getText().trim(), tipoAmostra,
						Double.parseDouble(cadastroExames.getFieldvalor().getText()), codigoAtual);
				cadastroExames.getFieldTipoExame().setText("");
				cadastroExames.getFieldvalor().setText("");

				BancoDados.getInstance().addDado(exame);

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
					String codigoAtual = contarCodigo(BancoDados.getInstance().getExamesMarcados().size());

					BancoDados.getInstance()
							.addDado(new MarcarExame(geral, marcar.getTfdNomeMedico().getText().trim(),
									marcar.getTfdCpfPaciente().getText().trim(),
									marcar.getTfdParecer().getText().trim(), codigoAtual));

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

		if (e.getSource() == contasAReceber.getBtnLimpar()) {
			contasAReceber.getTfReferencia().setText("");
			contasAReceber.getTfValor().setText("");
			contasAReceber.getFtfCpfCliente().setText("");
			contasAReceber.getFtfDataFluxo().setText("");
			contasAReceber.getFtfDataVencimento().setText("");
			contasAReceber.getTfNomeCliente().setText("");

		}

		if (e.getSource() == contasAReceber.getBtnLancar()) {
			try {
				if (Verificar.verificarContasAReceber(contasAReceber)) {
					String codigoAtual = contarCodigo(Integer.parseInt(BancoDados.getInstance().getContasARecebers()
							.get(BancoDados.getInstance().getContasARecebers().size() - 1).getCodigo()) + 1);

					modelVo.ReceitaVo contasAReceberModel;

					if (contasAReceber.getComboParcelas().isVisible()) {
						contasAReceberModel = new modelVo.ReceitaVo(contasAReceber.getFtfCpfCliente().getText(),
								contasAReceber.getFtfDataVencimento().getText(),
								contasAReceber.getFtfDataFluxo().getText(), codigoAtual,
								contasAReceber.getTfValor().getText(), contasAReceber.getTfReferencia().getText(),
								(String) contasAReceber.getComboTipoDePagamento().getSelectedItem(),
								(String) contasAReceber.getComboParcelas().getSelectedItem());
					} else {
						contasAReceberModel = new modelVo.ReceitaVo(contasAReceber.getFtfCpfCliente().getText(),
								contasAReceber.getFtfDataVencimento().getText(),
								contasAReceber.getFtfDataFluxo().getText(), codigoAtual,
								contasAReceber.getTfValor().getText(), contasAReceber.getTfReferencia().getText(),
								(String) contasAReceber.getComboTipoDePagamento().getSelectedItem());

					}

					BancoDados.getInstance().addDado(contasAReceberModel);

					contasAReceber.getTfReferencia().setText("");
					contasAReceber.getTfValor().setText("");
					contasAReceber.getFtfCpfCliente().setText("");
					contasAReceber.getFtfDataFluxo().setText("");
					contasAReceber.getFtfDataVencimento().setText("");
					contasAReceber.getTfNomeCliente().setText("");
					Mensagem.exibirMensagem("Conta inserida com sucesso!");
				} else {
					Mensagem.exibirMensagem("Campos obrigatórios não preenchidos");
				}
			} catch (Exception ex) {
				Mensagem.exibirMensagem(
						"Conta não pode ser inserida. Certifique-se de que tudo esteja preenchido corretamente.");
			}

		}
		if (e.getSource() == contasAReceber.getBtnBuscar()) {
			double valor = buscarDebito(contasAReceber.getFtfCpfCliente().getText());
			String nome = buscarPaciente(contasAReceber.getFtfCpfCliente().getText()).getNome();

			contasAReceber.getTfValor().setText(String.valueOf(valor));
			contasAReceber.getTfNomeCliente().setText(nome);

		}

		if (e.getSource() == contasPagar.getLancar()) {
			if (Verificar.verificarContasPagar(contasPagar)) {

				if (BancoDados.getInstance().addDado(new DespesasVo(contasPagar.getTfdDescricao().getText().trim(), // discrição
						contasPagar.getTfdFornecedor().getText().trim(), // fornecedor,
						contasPagar.getPlanoDeContaC().getSelectedItem().toString(), // plano,
						contasPagar.getCentroLucroC().getSelectedItem().toString(), // centro de custo
						contasPagar.getTfdDataVencimento().getText().trim(), // data,
						contasPagar.getTfdValorTotal().getText().trim(), // valor,
						contasPagar.getNumParcelasC().getSelectedItem().toString(), // numeros_parcela,
						contasPagar.getIntervaloParcelaC().getSelectedItem().toString().trim(), // intervalo_parcelas,
						contasPagar.getTfdValorParcela().getText().trim()))) // valorPacerla
					Mensagem.exibirMensagem("Despesa Adicionada Com Sucesso!!!");
				else
					Mensagem.exibirMensagem("Falha Ao Adicionar Despesa!!!");
			} else
				Mensagem.exibirMensagem("Informe Todos Os Dados!!!");

		}
		if (e.getSource() == editarExameMarcado.getBtnAdd()) {
			MarcarExame exame = new MarcarExame(
					BancoDados.getInstance().getExamesGerais()
							.get(editarExameMarcado.getComboBoxExamesGerais().getSelectedIndex()),
					editarExameMarcado.getTfdNomeMedico().getText().trim(),
					editarExameMarcado.getTfdCpfPaciente().getText().trim(),
					editarExameMarcado.getTfdParecer().getText().trim(), editarExameMarcado.getExame().getCodigo());

			exame.setStatus((Andamento) editarExameMarcado.getStatus().getSelectedItem());
			BancoDados.getInstance().editarExameMarcado(exame);
			mudarTela(consultaExames);
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
					menuPaneContainer.getBtnCadastro().setVisible(true);
					menuPaneContainer.getBtnCadastroFuncionario().setVisible(true);
					menuPaneContainer.getBtnCadastroFuncionario().setVisible(true);
					menuPaneContainer.getBtnCadastrarExame().setVisible(true);
					menuPaneContainer.getBtnMarcarExame().setVisible(true);
				} else {
					perfil.atualiarUsuario(usuario, "Cliente");
					menuPaneContainer.getBtnCadastro().setVisible(false);
					menuPaneContainer.getBtnCadastroFuncionario().setVisible(false);
					menuPaneContainer.getBtnCadastrarExame().setVisible(false);
					menuPaneContainer.getBtnMarcarExame().setVisible(false);

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

		if (e.getSource() == consultaExames.getTblExames()) {
			JPopupMenu menu = new JPopupMenu();
			JMenuItem editar = new JMenuItem("Editar");
			editar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					editarExameMarcado.autoPreencher(BancoDados.getInstance().getExamesMarcados()
							.get(consultaExames.getTblExames().getSelectedRow()));
					mudarTela(editarExameMarcado);

				}
			});
			JMenuItem excluir = new JMenuItem("Excluir");
			excluir.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					BancoDados.getInstance().excluirExameMarcado(BancoDados.getInstance().getExamesMarcados()
							.get(consultaExames.getTblExames().getSelectedRow()));
					consultaExames.getModel().atualizarTabela();
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
			menu.show(consultaExames.getTblExames(), e.getX(), e.getY());

		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (contasAReceber.getComboTipoDePagamento().getSelectedIndex() == 1) {
				contasAReceber.getLbParcelas().setVisible(true);
				contasAReceber.getComboParcelas().setVisible(true);
			} else if (contasAReceber.getComboTipoDePagamento().getSelectedIndex() == 0) {
				contasAReceber.getLbParcelas().setVisible(false);
				contasAReceber.getComboParcelas().setVisible(false);
			}

		}

	}

	public void mudarTela(JPanel panel) {
		for (Component c : principal.getContentPane().getComponents())
			if (c.equals(panel))
				c.setVisible(true);
			else if (!(c.equals(menuPaneContainer) || c.equals(perfil)))
				c.setVisible(false);

	}

	public Paciente buscarPaciente(String cpf) {

		for (Paciente paciente : BancoDados.getInstance().getPacientes()) {
			if (paciente.getCpf().equals(cpf)) {
				return paciente;
			}
		}
		return null;
	}

	public double buscarDebito(String cpf) {
		double soma = 0;

		for (int i = 0; i < BancoDados.getInstance().getExamesMarcados().size(); i++) {
			MarcarExame marcarExame = (MarcarExame) BancoDados.getInstance().getExamesMarcados().get(i);
			if (marcarExame.getCpfPaciente().equals(cpf)) {

				for (ExameGeral exameGeral : BancoDados.getInstance().getExamesGerais()) {
					if (exameGeral.getTipoExame().equals(marcarExame.getExame().getTipoExame())) {
						soma += exameGeral.getValor();
					}
				}
			}

		}

		return soma;
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
