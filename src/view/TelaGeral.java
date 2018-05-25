package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

public abstract class TelaGeral extends JFrame {

	public static final int LARGURA = 700;
	public static final int ALTURA = 600;
		
	public TelaGeral(String titulo) {
		
		super(titulo);
		
//		inicializar();
		
		setSize(LARGURA, ALTURA);
		
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setBackground(new Color(176,224,230));
		
		setVisible(false);
		
	}
	
	public abstract void inicializar(); 
	
	
}
