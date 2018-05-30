 package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Usuario;

public class Perfil extends JPanel {
	private JLabel labeltipo, labelft, labelNome;
	private JButton btnEditarDados,btnSair;
	private Usuario usuario;
	private String tipo;
	private BufferedImage imagem, fundo;
	
	public Perfil(Usuario usuario, String tipo) {
		//caminho = "C:\\Users\\Felipe\\Desktop\\img_teste.png";
		// setLayout(new FlowLayout());
		
		setSize(100, 90);
		setPreferredSize(new Dimension(100, 90));
		setMinimumSize(new Dimension(100, 90));
		//setLayout(new FlowLayout());
		
		this.usuario=usuario;
		this.tipo=tipo;

		labelft = new JLabel(new ImageIcon(usuario.getCaminho()));
		labelft = new JLabel("<html><center>Imagem Do Perfil");
		labelft.setBorder(BorderFactory.createEtchedBorder());
		labelft.setMaximumSize(new Dimension(90, 80));
		labelft.setPreferredSize(new Dimension(90, 80));
		labelft.setOpaque(true);
		labelft.setBackground(Color.BLACK);
		labelft.setForeground(Color.WHITE);
		
		if(usuario.getCaminho() != null)
		{
			try {
				imagem = ImageIO.read(getClass().getClassLoader().getResourceAsStream(usuario.getCaminho()));
				labelft.setIcon(new ImageIcon(imagem.getScaledInstance(90, 90, BufferedImage.SCALE_DEFAULT)));

			}
			catch (Exception e) {
				System.out.println("Erro!!!"+e.getMessage());
				e.printStackTrace();
			}
		}
		labeltipo =  new JLabel(tipo + ":");
		labelNome = new JLabel(usuario.getNome());
		btnEditarDados = new JButton(new ImageIcon(getClass().getClassLoader().getResource("editarConta.png")));
		btnSair = new JButton(new ImageIcon(getClass().getClassLoader().getResource("sairPerfil.png")));
		btnSair.setContentAreaFilled(false);
		btnEditarDados.setContentAreaFilled(false);
		try {
			fundo = ImageIO.read(getClass().getClassLoader().getResourceAsStream("nomeSistema.jpg"));
		} catch (IOException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
				
		
		
		add(btnEditarDados);
		add(btnSair);
		add(labeltipo);
		add(labelNome);
		add(labelft);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(fundo, 0, 0, getWidth(), getHeight(), null);
		
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

	public void atualiarUsuario(Usuario usuario, String tipo) {
		this.usuario = usuario;
		this.tipo = tipo;
		
		if(usuario.getCaminho() != null)
		{
			try {
				imagem = ImageIO.read(getClass().getClassLoader().getResourceAsStream(usuario.getCaminho()));
				labelft.setIcon(new ImageIcon(imagem.getScaledInstance(90, 90, BufferedImage.SCALE_DEFAULT)));

			}
			catch (Exception e) {
				System.out.println("Erro!!!"+e.getMessage());
				e.printStackTrace();
			}
		}

		
		labeltipo.setText(tipo + ":");
		labelNome.setText(usuario.getNome());
		
	}

	public JButton getBtnSair() {
		return btnSair;
	}

	public BufferedImage getImagem() {
		return imagem;
	}

	public BufferedImage getFundo() {
		return fundo;
	}

}
