package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public abstract class PanelGeral extends JPanel {

	public PanelGeral() {
		
		setLayout(new GridLayout(16, 2, 0, 3));

		inicializar();
		
		
		setSize(TelaGeral.LARGURA, TelaGeral.ALTURA);
		
		setVisible(false);
		
	}
	
	public abstract void inicializar();
	
	
}
