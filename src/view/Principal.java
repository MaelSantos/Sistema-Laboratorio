package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Principal extends TelaGeral{
	
	private JLabel titulo;
	private Cadastro cadastro;
	private Menu menu;
	
	public Principal(String titulo, Menu menu, Cadastro cadastro) {
		super(titulo);
		
		this.cadastro = cadastro;
		this.menu = menu;
		inicializar();
	}

	@Override
	public void inicializar() {
		
		menu.setVisible(true);
		
		titulo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("nomeSistema.jpeg")));
		
		add(titulo,BorderLayout.NORTH);
		add(menu,BorderLayout.WEST);
		add(cadastro,BorderLayout.CENTER);
		
	}

	
	
}
