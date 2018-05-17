package view;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public abstract class TelaGeral extends JFrame {

	public static final int LARGURA = 500;
	public static final int ALTURA = 500;
	
	public TelaGeral(String titulo) {
		
		super(titulo);
		
		inicializar();
		
		setSize(LARGURA, ALTURA);
		
		setLayout(new FlowLayout());
//		setLayout(new CardLayout(50, 10));
		
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		
	}
	
	public abstract void inicializar(); 
	
}
