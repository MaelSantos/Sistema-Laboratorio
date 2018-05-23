package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class Cadastro extends PanelGeral {

	//dados do paciente
	protected JFormattedTextField tfdNome, tfdCpf, tfdNascimento, tfdEmail, tfdTelefone, tfdCep;
	protected JLabel lblNome, lblCpf, lblNascimento, lblSangue, lblSexo, lblEmail, lblTelefone;
	//dados do endereco
	protected JTextField tdfRua, tfdNumero, tfdBairro, tfdCidade, tfdComplemento;
	protected JLabel lblfRua, lblNumero, lblBairro, lblCidade, lblEstado, lblComplemento, lblCep;
	
	protected JComboBox<String> cbxSangue, cbxSexo, cbxEstado;
	protected JButton btnAdd;
	
	public Cadastro() {
		super();
		setBorder(BorderFactory.createTitledBorder("Cadastro"));
	}
	
	@Override
	public void inicializar() {
		
		//dados do paciente
		tfdNome = new JFormattedTextField(); 
		tfdCpf = new JFormattedTextField(); 
		tfdNascimento = new JFormattedTextField(); 
		tfdEmail = new JFormattedTextField(); 
		tfdTelefone = new JFormattedTextField();
		tfdCep = new JFormattedTextField();
		
		try {
			tfdCpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
			tfdNascimento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
			tfdTelefone.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)# ####-####")));
			tfdCep.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
			
		} catch (ParseException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
		
		tfdNome.addKeyListener((new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";// lista de caracters que não devem ser aceitos
				if(caracteres.contains(e.getKeyChar()+"")){// se o character que gerou o evento estiver na lista
				e.consume();//aciona esse propriedade para eliminar a ação do evento
				tfdNome.setText(tfdNome.getText().substring(0,tfdNome.getText().length()));
				}
			}
			
		})); 
		
		cbxSangue = new JComboBox<>(new String[]{"O+","O-","A+","A-","B+","B-","AB+","AB-"}); 
		cbxSexo = new JComboBox<>(new String[] {"Masculino","Feminino"});
		
		lblNome = new JLabel("Nome:"); 
		lblCpf = new JLabel("CPF:"); 
		lblNascimento = new JLabel("Data De Nascimento:"); 
		lblSangue = new JLabel("Tipo Sanguínio:"); 
		lblSexo = new JLabel("Sexo:"); 
		lblEmail = new JLabel("Email:"); 
		lblTelefone = new JLabel("Telefone:");
		
		//dados do endereco
		tdfRua = new JTextField(10); 
		tfdNumero = new JTextField(10); 
		tfdBairro = new JTextField(10); 
		tfdCidade = new JTextField(10); 
		cbxEstado = new JComboBox<>(new String[] {"Acre – AC", "Alagoas – AL", "Amapá – AP", "Amazonas – AM", "Bahia – BA", "Ceará – CE", 
				"Distrito Federal – DF", "Espírito Santo – ES", "Goiás – GO", "Maranhão – MA", "Mato Grosso – MT", "Mato Grosso do Sul – MS", 
				"Minas Gerais – MG", "Pará – PA", "Paraíba – PB", "Paraná – PR", "Pernambuco – PE", "Piauí – PI", "Roraima – RR", "Rondônia – RO",
				"Rio de Janeiro – RJ","Rio Grande do Norte – RN", "Rio Grande do Sul – RS", "Santa Catarina – SC", "São Paulo – SP", "Sergipe – SE",
				"Tocantins – TO"});
		tfdComplemento = new JTextField(10); 
		
		lblfRua = new JLabel("Rua:");
		lblNumero = new JLabel("Numero:"); 
		lblBairro = new JLabel("Bairro:"); 
		lblCidade = new JLabel("Cidade:"); 
		lblEstado = new JLabel("Estado:"); 
		lblComplemento = new JLabel("Complemento:"); 
		lblCep = new JLabel("CEP:");
		
		btnAdd = new JButton("Add");
		
		//dados do paciente
		add(lblNome);
		add(lblCpf);
		
		add(tfdNome);
		add(tfdCpf);
		
		add(lblNascimento);
		add(lblSexo);
		
		add(tfdNascimento);
		add(cbxSexo);
		
		add(lblSangue);
		add(lblEmail);
		
		add(cbxSangue);
		add(tfdEmail);
		
		add(new JSeparator(JSeparator.HORIZONTAL));
		add(new JSeparator(JSeparator.HORIZONTAL));
		
		//dados de endereco
		add(lblTelefone);
		add(lblfRua);
		
		add(tfdTelefone);
		add(tdfRua);
		
		add(lblNumero);
		add(lblBairro);
		
		add(tfdNumero);
		add(tfdBairro);
		
		add(lblCidade);
		add(lblEstado);
		
		add(tfdCidade);
		add(cbxEstado);
		
		add(lblComplemento);
		add(lblCep);
		
		add(tfdComplemento);
		add(tfdCep);
		
		add(btnAdd);
		
	}

	/**
	 * @return o tfdNascimento
	 */
	public JFormattedTextField getTfdNome() {
		return tfdNome;
	}

	/**
	 * @return o tfdCpf
	 */
	public JFormattedTextField getTfdCpf() {
		return tfdCpf;
	}

	/**
	 * @return o tfdIdade
	 */
	public JFormattedTextField getTfdNascimento() {
		return tfdNascimento;
	}

	/**
	 * @return o tfdEmail
	 */
	public JFormattedTextField getTfdEmail() {
		return tfdEmail;
	}

	/**
	 * @return o tfdTelefone
	 */
	public JFormattedTextField getTfdTelefone() {
		return tfdTelefone;
	}

	/**
	 * @return o cbxSangue
	 */
	public JComboBox<String> getCbxSangue() {
		return cbxSangue;
	}

	/**
	 * @return o cbxSexo
	 */
	public JComboBox<String> getCbxSexo() {
		return cbxSexo;
	}

	/**
	 * @return o tdfRua
	 */
	public JTextField getTfdRua() {
		return tdfRua;
	}

	/**
	 * @return o tfdNumero
	 */
	public JTextField getTfdNumero() {
		return tfdNumero;
	}

	/**
	 * @return o tfdBairro
	 */
	public JTextField getTfdBairro() {
		return tfdBairro;
	}

	/**
	 * @return o tfdCidade
	 */
	public JTextField getTfdCidade() {
		return tfdCidade;
	}

	/**
	 * @return o tfdEstado
	 */
	public JComboBox<String> getCbxEstado() {
		return cbxEstado;
	}

	/**
	 * @return o tfdComplemento
	 */
	public JTextField getTfdComplemento() {
		return tfdComplemento;
	}

	/**
	 * @return o tfdCep
	 */
	public JTextField getTfdCep() {
		return tfdCep;
	}

	/**
	 * @return o btnAdd
	 */
	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public JLabel getLblCpf() {
		return lblCpf;
	}

	public JLabel getLblNascimento() {
		return lblNascimento;
	}

	public JLabel getLblSangue() {
		return lblSangue;
	}

	public JLabel getLblSexo() {
		return lblSexo;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public JLabel getLblTelefone() {
		return lblTelefone;
	}

	public JTextField getTdfRua() {
		return tdfRua;
	}

	public JLabel getLblfRua() {
		return lblfRua;
	}

	public JLabel getLblNumero() {
		return lblNumero;
	}

	public JLabel getLblBairro() {
		return lblBairro;
	}

	public JLabel getLblCidade() {
		return lblCidade;
	}

	public JLabel getLblEstado() {
		return lblEstado;
	}

	public JLabel getLblComplemento() {
		return lblComplemento;
	}

	public JLabel getLblCep() {
		return lblCep;
	}

	

}
