package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public abstract class PanelGeral extends JPanel {

	public PanelGeral() {
		
		setSize(TelaGeral.LARGURA, TelaGeral.ALTURA);

		setLayout(new GridLayout(16, 2, 0, 3));
		
		inicializar();
		
//		setBackground(new Color(95,158,160));
		
		setVisible(false);
		
	}
	
	public abstract void inicializar();
	
	
}
