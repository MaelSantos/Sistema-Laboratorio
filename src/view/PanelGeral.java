package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public abstract class PanelGeral extends JPanel {

	public PanelGeral() {
		
		inicializar();
		
		setLayout(new GridLayout(17, 2));
		
		setSize(TelaGeral.LARGURA, TelaGeral.ALTURA);
		
		setVisible(false);
		
	}
	
	public abstract void inicializar();
	
	
}
