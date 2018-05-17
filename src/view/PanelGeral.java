package view;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public abstract class PanelGeral extends JPanel{

	public PanelGeral() {
		
		inicializar();
		
		setSize(TelaGeral.LARGURA, TelaGeral.ALTURA);
		
		setLayout(new FlowLayout(10, 10, 10));
		
		setVisible(false);
		
	}
	
	public abstract void inicializar();
	
}
