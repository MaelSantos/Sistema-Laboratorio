package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

public class MenuPaneContainer extends PanelGeral {
	
	private JXTaskPaneContainer taskpanecontainer;
	private JXTaskPane taskpaneCadastro,taskpaneConsulta,taskpaneFinanceiro,taskpaneMarcar,taskpaneCaixa, taskpaneRelatorio;
	private JButton btnCadastro, btnConsulta, btnCadastroFuncionario, btnCadastrarExame,
	btnConsultaExames, btnMarcarExame, btnFinanceiro,btnContasPagar, btnContasAReceber, btnRelatorios;
//	private BufferedImage fundo;
	
	@Override
	public void inicializar() {
		
		setLayout(new FlowLayout());
//		try {
//			fundo= ImageIO.read(getClass().getClassLoader().getResourceAsStream("fundo.jpeg"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		btnCadastro = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cadastrarPaciente.png")));
		btnCadastroFuncionario = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cadastrarFuncionario.png")));
		btnConsulta = new JButton(new ImageIcon(getClass().getClassLoader().getResource("consultarPaciente.png")));		
		btnCadastrarExame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cadastrarExame.png")));
		btnConsultaExames = new JButton(new ImageIcon(getClass().getClassLoader().getResource("consultarExame.png")));
		btnMarcarExame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("marcarExame.png")));
		btnFinanceiro = new JButton(new ImageIcon(getClass().getClassLoader().getResource("financeiro.png")));
		btnContasPagar =  new JButton(new ImageIcon(getClass().getClassLoader().getResource("contaspagar.png")));
		btnContasAReceber = new JButton(new ImageIcon(getClass().getClassLoader().getResource("contasReceber.png")));
		btnRelatorios = new JButton(new ImageIcon(getClass().getClassLoader().getResource("relatorios.png")));
		
		btnConsulta.setContentAreaFilled(false);
		btnConsulta.setBorderPainted(false);
		btnCadastroFuncionario.setContentAreaFilled(false);
		btnCadastroFuncionario.setBorderPainted(false);
		btnCadastro.setContentAreaFilled(false);
		btnCadastro.setBorderPainted(false);
		btnCadastrarExame.setContentAreaFilled(false);
		btnCadastrarExame.setBorderPainted(false);
		btnConsultaExames.setContentAreaFilled(false);
		btnConsultaExames.setBorderPainted(false);
		btnMarcarExame.setBorderPainted(false);
		btnMarcarExame.setContentAreaFilled(false);
		btnFinanceiro.setBorderPainted(false);
		btnFinanceiro.setContentAreaFilled(false);
		btnContasPagar.setBorderPainted(false);
		btnContasPagar.setContentAreaFilled(false);
		btnContasAReceber.setBorderPainted(false);
		btnContasAReceber.setContentAreaFilled(false);
		btnRelatorios.setBorderPainted(false);
		btnRelatorios.setContentAreaFilled(false);
		
		taskpanecontainer = new JXTaskPaneContainer();
		
		taskpaneCadastro= new JXTaskPane();
		taskpaneConsulta= new JXTaskPane();
		taskpaneFinanceiro= new JXTaskPane();
		taskpaneMarcar= new JXTaskPane();
		taskpaneCaixa= new JXTaskPane();
		taskpaneRelatorio = new JXTaskPane();
		
		taskpaneCadastro.setTitle("Cadastro");
		taskpaneConsulta.setTitle("Consulta");
		taskpaneFinanceiro.setTitle("Financeiro");
		taskpaneMarcar.setTitle("Marcar");
		taskpaneCaixa.setTitle("Caixa");
		taskpaneRelatorio.setTitle("Relatorios");
		
		taskpaneCadastro.setCollapsed(true);
		taskpaneConsulta.setCollapsed(true);
		taskpaneFinanceiro.setCollapsed(true);
		taskpaneMarcar.setCollapsed(true);
		taskpaneCaixa.setCollapsed(true);
		taskpaneRelatorio.setCollapsed(true);
		
		taskpaneCadastro.add(btnCadastroFuncionario);
		taskpaneCadastro.add(btnCadastro);
		taskpaneCadastro.add(btnCadastrarExame);
		
		taskpaneConsulta.add(btnConsultaExames);
		taskpaneConsulta.add(btnConsulta);
		
		taskpaneFinanceiro.add(btnFinanceiro);
		
		taskpaneMarcar.add(btnMarcarExame);
		
		taskpaneCaixa.add(btnContasPagar);
		taskpaneCaixa.add(btnContasAReceber);
		
		taskpaneRelatorio.add(btnRelatorios);
		
		taskpanecontainer.add(taskpaneCadastro);
		taskpanecontainer.add(taskpaneConsulta);
		taskpanecontainer.add(taskpaneMarcar);
		taskpanecontainer.add(taskpaneCaixa);
		taskpanecontainer.add(taskpaneFinanceiro);
		taskpanecontainer.add(taskpaneRelatorio);
		
		taskpanecontainer.setBackground(new Color(176,224,230));
		
		add(taskpanecontainer);
		
		setBorder(BorderFactory.createTitledBorder("Menu"));		
		setVisible(true);
		
	}
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		
//		g.drawImage(fundo, 0, 0, getWidth(), getHeight(), null);
//		
//	}
	public JXTaskPaneContainer getTaskpanecontainer() {
		return taskpanecontainer;
	}
	public JXTaskPane getTaskpaneCadastro() {
		return taskpaneCadastro;
	}
	public JXTaskPane getTaskpaneConsulta() {
		return taskpaneConsulta;
	}
	public JXTaskPane getTaskpaneFinanceiro() {
		return taskpaneFinanceiro;
	}
	public JXTaskPane getTaskpaneMarcar() {
		return taskpaneMarcar;
	}
	public JXTaskPane getTaskpaneCaixa() {
		return taskpaneCaixa;
	}
	public JButton getBtnCadastro() {
		return btnCadastro;
	}
	public JButton getBtnConsulta() {
		return btnConsulta;
	}
	public JButton getBtnCadastroFuncionario() {
		return btnCadastroFuncionario;
	}
	public JButton getBtnCadastrarExame() {
		return btnCadastrarExame;
	}
	public JButton getBtnConsultaExames() {
		return btnConsultaExames;
	}
	public JButton getBtnMarcarExame() {
		return btnMarcarExame;
	}
	public JButton getBtnFinanceiro() {
		return btnFinanceiro;
	}
	public JButton getBtnContasPagar() {
		return btnContasPagar;
	}
	public JButton getBtnContasAReceber() {
		return btnContasAReceber;
	}
//	public BufferedImage getFundo() {
//		return fundo;
//	}
	public JButton getBtnRelatorios() {
		return btnRelatorios;
	}
	
	

}
