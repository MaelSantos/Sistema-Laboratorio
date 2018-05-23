package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroFuncionario extends Cadastro {

	private JTextField tfdCargo;
	private JLabel lblCargo;
	
	private BufferedImage imagem;
	private JButton btnAddImagem,btnRemoveImage;
	private JLabel lblImagem;
	private JFileChooser fcsImagem;
	
	public CadastroFuncionario() {
		super();
		setBorder(BorderFactory.createTitledBorder("Cadastro De Funcionarios"));
		setVisible(true);
	}
	
	@Override
	public void inicializar() {
		
		fcsImagem = new JFileChooser();
		btnAddImagem = new JButton("Adicionar Imagem");
		btnRemoveImage = new JButton("Remover Imagem");
		lblImagem = new JLabel("<html><center>Imagem Do Perfil");
		lblImagem.setBorder(BorderFactory.createEtchedBorder());
		lblImagem.setMaximumSize(new Dimension(100, 100));
		lblImagem.setPreferredSize(new Dimension(100, 100));
		lblImagem.setOpaque(true);
		lblImagem.setBackground(Color.BLACK);
		lblImagem.setForeground(Color.WHITE);
		
		tfdCargo = new JTextField(10);
		lblCargo = new JLabel("Cargo:");
		
		btnAddImagem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int escolha = fcsImagem.showOpenDialog(getParent());
				lblImagem.setIcon(new ImageIcon(fcsImagem.getSelectedFile().getPath()));
				File file = new File(fcsImagem.getSelectedFile().getAbsolutePath());
				try {
					imagem = ImageIO.read(file);
					lblImagem.setIcon(new ImageIcon(imagem.getScaledInstance(lblImagem.getWidth(),lblImagem.getHeight(), BufferedImage.SCALE_DEFAULT)));
				} catch (Exception e1) {
					System.err.println("Erro ao carregar imagem!!!"+e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		
		btnRemoveImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblImagem.setIcon(null);
				imagem = null;
				System.gc();
			}
		});
		
		GridBagConstraints c = new GridBagConstraints(
				GridBagConstraints.RELATIVE, //gridx
				GridBagConstraints.RELATIVE, //gridy
				GridBagConstraints.RELATIVE, //gridwidth
				GridBagConstraints.RELATIVE, //gridheight
				0.1, //weightx
				0.1, //weighty
				GridBagConstraints.WEST, //anchor
				GridBagConstraints.NONE, //fill
				new Insets(0, 0, 0, 0), //insets
				0, //ipadx
				0); //ipady
		
		setLayout(new GridBagLayout());
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(200, 200));
		p.setLayout(new FlowLayout());
		p.setBackground(Color.blue);
		p.add(lblImagem);
		p.add(btnAddImagem);
		p.add(btnRemoveImage);
		
		p.setVisible(true);
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.NONE;
		add(p,c);

		JPanel t = new JPanel();
		t.setPreferredSize(new Dimension(200, 200));
		t.setLayout(new GridLayout(20, 2));
		t.setBackground(Color.blue);
		
		c.anchor = GridBagConstraints.CENTER;
		t.add(lblCargo,c);
		t.add(tfdCargo,c);
		
		
//		super.inicializar();
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Teste");
		f.setSize(700, 500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.add(new CadastroFuncionario(), BorderLayout.CENTER);
		f.setVisible(true);
	}

	//metodos de acesso
	public JTextField getTfdCargo() {
		return tfdCargo;
	}

	public BufferedImage getImagem() {
		return imagem;
	}

	public JButton getBtnAddImagem() {
		return btnAddImagem;
	}

	public JButton getBtnRemoveImage() {
		return btnRemoveImage;
	}

	public JFileChooser getFcsImagem() {
		return fcsImagem;
	}

}
