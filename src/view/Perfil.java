package view;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Usuario;

public class Perfil extends JPanel {
	private JLabel labeltipo, labelft, labelNome;
	private JButton btnEditarDados;
	private Usuario usuario;
	private String tipo;
	public Perfil(Usuario usuario, String tipo) {
		//caminho = "C:\\Users\\Felipe\\Desktop\\img_teste.png";
		// setLayout(new FlowLayout());
		this.usuario=usuario;
		this.tipo=tipo;
		
		labelft = new JLabel(new ImageIcon(usuario.getCaminho()));
		
		labeltipo =  new JLabel(tipo + ":");
		labelNome = new JLabel(usuario.getNome());
		btnEditarDados = new JButton("Editar Dados");

		add(labeltipo);
		add(labelNome);
		add(labelft);
		add(btnEditarDados);

	}
	
	

	public Usuario getUsuario() {
		return usuario;
	}



	public String getTipo() {
		return tipo;
	}



	public JLabel getLabeltipo() {
		return labeltipo;
	}

	public JLabel getLabelft() {
		return labelft;
	}

	public JLabel getLabelNome() {
		return labelNome;
	}

	public JButton getBtnEditarDados() {
		return btnEditarDados;
	}

}
