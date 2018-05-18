package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public abstract class PanelGeral extends JPanel{

	public PanelGeral() {
		
		inicializar();
		
		setLayout(new GridLayout(14, 1));
		
		setSize(TelaGeral.LARGURA, TelaGeral.ALTURA);
		
		setVisible(false);
		
	}
	
	public abstract void inicializar();
	
}
