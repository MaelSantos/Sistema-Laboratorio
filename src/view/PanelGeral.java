package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public abstract class PanelGeral extends JPanel {

	private BufferedImage fundo;
	
	public PanelGeral() {
		
		setSize(TelaGeral.LARGURA, TelaGeral.ALTURA);

		setLayout(new GridLayout(16, 2, 0, 3));
		
		inicializar();
		
		try {
		fundo = ImageIO.read(getClass().getClassLoader().getResourceAsStream("fundo.jpeg"));
	} catch (IOException e) {
		// TODO Bloco catch gerado automaticamente
		e.printStackTrace();
	}
		
		setVisible(false);

	}
	
	public abstract void inicializar();
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Stub de método gerado automaticamente
		super.paintComponent(g);
		Graphics2D graficos = (Graphics2D) g;
		
		graficos.drawImage(fundo, 0, 0, null);
//		graficos.drawImage(fundo, 0, 0,getWidth(),getHeight(), null);
				
		try {
			repaint();
			Thread.sleep(50);
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
}
