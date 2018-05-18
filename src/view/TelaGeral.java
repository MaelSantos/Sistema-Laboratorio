package view;

import java.awt.FlowLayout;
import javax.swing.JFrame;

public abstract class TelaGeral extends JFrame {

	public static final int LARGURA = 500;
	public static final int ALTURA = 500;
	
	public TelaGeral(String titulo) {
		
		super(titulo);
		
//		inicializar();
		
		setSize(LARGURA, ALTURA);
		
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(null);
		
		setVisible(true);
		
	}
	
	public abstract void inicializar(); 
	
}
