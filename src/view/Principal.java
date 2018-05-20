package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Principal extends TelaGeral{
	
	private JLabel titulo;
	private Cadastro cadastro;
	private Menu menu;
	private Consulta consulta;
	
	public Principal(String titulo, Menu menu, Cadastro cadastro,Consulta consulta) {
		super(titulo);
		
		this.cadastro = cadastro;
		this.menu = menu;
		this.consulta= consulta;
		inicializar();
	}

	@Override
	public void inicializar() {
		
		menu.setVisible(true);
		
		titulo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("nomeSistema.jpg")));
		
		add(titulo,BorderLayout.NORTH);
		add(menu,BorderLayout.WEST);
     	add(cadastro,BorderLayout.CENTER);
		add(consulta,BorderLayout.CENTER);
		
	}

	
	
}
