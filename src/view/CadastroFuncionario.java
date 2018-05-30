package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class CadastroFuncionario extends Cadastro {

	private JTextField tfdCargo;
	private JLabel lblCargo;
	
	private JLabel lblSenha, lblConfirmar, lblLogin;
	private JTextField tfdLogin; 
	private JPasswordField tfdSenha, tfdConfirmar;
	
	private BufferedImage imagem;
	private JButton btnAddImagem,btnRemoveImage;
	private JLabel lblImagem;
	private JFileChooser fcsImagem;
	
	public CadastroFuncionario() {
		super();
		setBorder(BorderFactory.createTitledBorder("Cadastro De Funcionarios"));
		
	}
	
	@Override
	public void inicializar() {
		super.inicializar();
		
		Component[] comp = getComponents();
		for(Component co : comp)
			remove(co);
		
		System.gc();
		
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
		
		lblSenha = new JLabel("Senha:"); 
		lblConfirmar = new JLabel("Confirme Sua Senha:");
		lblLogin = new JLabel("Login:");
		tfdSenha = new JPasswordField(10);
		tfdConfirmar = new JPasswordField(10);
		tfdLogin = new JTextField(10);
		
		btnAdd.setText("Criar Conta");
		
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
				GridBagConstraints.REMAINDER, //gridy
				GridBagConstraints.RELATIVE, //gridwidth
				GridBagConstraints.REMAINDER, //gridheight
				0.1, //weightx
				1, //weighty
				GridBagConstraints.WEST, //anchor
				GridBagConstraints.NONE, //fill
				new Insets(0, 0, 0, 0), //insets
				0, //ipadx
				0); //ipady
		
		setLayout(new GridBagLayout());
		JPanel p = new JPanel();
		p.setSize(150, 600);
		p.setPreferredSize(new Dimension(150, 500));
		p.setMaximumSize(new Dimension(150, 500));
		p.setMinimumSize(new Dimension(150, 0));
		
		p.setLayout(new FlowLayout());
		p.setBorder(BorderFactory.createTitledBorder("Dados Conta"));
		p.setBackground(new Color(176,224,230));
		p.setVisible(true);
		
		c.gridheight = GridBagConstraints.REMAINDER;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.VERTICAL;

		p.add(lblImagem);
		p.add(btnAddImagem);
		p.add(btnRemoveImage);
		
		p.add(lblLogin);
		p.add(tfdLogin);
		
		p.add(lblSenha);
		p.add(tfdSenha);
		
		p.add(lblConfirmar);
		p.add(tfdConfirmar);
		
		p.add(btnAdd);
		
		add(p,c);
		
		JPanel t = new JPanel();
		t.setLayout(new GridLayout(17, 2));
		t.setBorder(BorderFactory.createTitledBorder("Dados Funcionario"));
		t.setBackground(new Color(176,224,230));
		
		c.weightx = 0.9;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.BOTH;
		t.add(lblCargo);
		t.add(tfdCargo);
		
		//dados do paciente
		t.add(lblNome);
		t.add(lblCpf);
		
		t.add(tfdNome);
		t.add(tfdCpf);
		
		t.add(lblNascimento);
		t.add(lblSexo);
		
		t.add(tfdNascimento);
		t.add(cbxSexo);
		
		t.add(lblSangue);
		t.add(lblEmail);
		
		t.add(cbxSangue);
		t.add(tfdEmail);
		
		t.add(new JSeparator(JSeparator.HORIZONTAL)).setSize(100, 100);
		t.add(new JSeparator(JSeparator.HORIZONTAL)).setSize(100, 100);
		
		//dados de endereco
		t.add(lblTelefone);
		t.add(lblfRua);
		
		t.add(tfdTelefone);
		t.add(tdfRua);
		
		t.add(lblNumero);
		t.add(lblBairro);
		
		t.add(tfdNumero);
		t.add(tfdBairro);
		
		t.add(lblCidade);
		t.add(lblEstado);
		
		t.add(tfdCidade);
		t.add(cbxEstado);
		
		t.add(lblComplemento);
		t.add(lblCep);
		
		t.add(tfdComplemento);
		t.add(tfdCep);
		
		add(t,c);
		
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

	public JLabel getLblCargo() {
		return lblCargo;
	}

	public JLabel getLblSenha() {
		return lblSenha;
	}

	public JLabel getLblConfirmar() {
		return lblConfirmar;
	}

	public JLabel getLblLogin() {
		return lblLogin;
	}

	public JPasswordField getTfdSenha() {
		return tfdSenha;
	}

	public JPasswordField getTfdConfirmar() {
		return tfdConfirmar;
	}

	public JTextField getTfdLogin() {
		return tfdLogin;
	}

	public JLabel getLblImagem() {
		return lblImagem;
	}

	
}
