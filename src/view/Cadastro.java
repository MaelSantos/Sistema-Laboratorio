package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Cadastro extends PanelGeral {

	//dados do paciente
	private JTextField tfdNome, tfdCpf, tfdIdade, tfdSangue, tfdSexo, tfdEmail, tfdTelefone;
	private JLabel lblNome, lblCpf, lblIdade, lblSangue, lblSexo, lblEmail, lblTelefone;
	//dados do endereco
	private JTextField tdfRua, tfdNumero, tfdBairro, tfdCidade, tfdEstado, tfdComplemento, tfdCep;
	private JLabel lblfRua, lblNumero, lblBairro, lblCidade, lblEstado, lblComplemento, lblCep;
	
	private JButton btnAdd;
	
	public Cadastro() {
		super();
		setBorder(BorderFactory.createTitledBorder("Cadastro"));
	}
	
	@Override
	public void inicializar() {

		//dados do paciente
		tfdNome = new JTextField(10); 
		tfdCpf = new JTextField(10); 
		tfdIdade = new JTextField(10); 
		tfdSangue = new JTextField(10); 
		tfdSexo = new JTextField(10); 
		tfdEmail = new JTextField(10); 
		tfdTelefone = new JTextField(10);
		
		lblNome = new JLabel("Nome:"); 
		lblCpf = new JLabel("CPF:"); 
		lblIdade = new JLabel("Idade:"); 
		lblSangue = new JLabel("Tipo Sanguínio:"); 
		lblSexo = new JLabel("Sexo:"); 
		lblEmail = new JLabel("Email:"); 
		lblTelefone = new JLabel("Telefone:");
		
		//dados do endereco
		tdfRua = new JTextField(10); 
		tfdNumero = new JTextField(10); 
		tfdBairro = new JTextField(10); 
		tfdCidade = new JTextField(10); 
		tfdEstado = new JTextField(10); 
		tfdComplemento = new JTextField(10); 
		tfdCep = new JTextField(10);
		
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
		add(tfdNome);
		
		add(lblCpf);
		add(tfdCpf);
		
		add(lblIdade);
		add(tfdIdade);
		
		add(lblSexo);
		add(tfdSexo);
		
		add(lblSangue);
		add(tfdSangue);
		
		add(lblEmail);
		add(tfdEmail);
		
		//dados de endereco
		add(lblTelefone);
		add(tfdTelefone);
		
		add(lblfRua);
		add(tdfRua);
		
		add(lblNumero);
		add(tfdNumero);
		
		add(lblBairro);
		add(tfdBairro);
		
		add(lblCidade);
		add(tfdCidade);
		
		add(lblEstado);
		add(tfdEstado);
		
		add(lblComplemento);
		add(tfdComplemento);
		
		add(lblCep);
		add(tfdCep);
		
		add(btnAdd);
		
	}


	//metodos de acesso
	public JTextField getTfdNome() {
		return tfdNome;
	}

	public void setTfdNome(JTextField tfdNome) {
		this.tfdNome = tfdNome;
	}
	
	public JTextField getTfdCpf() {
		return tfdCpf;
	}

	public void setTfdCpf(JTextField tfdCpf) {
		this.tfdCpf = tfdCpf;
	}


	public JTextField getTfdIdade() {
		return tfdIdade;
	}


	public void setTfdIdade(JTextField tfdIdade) {
		this.tfdIdade = tfdIdade;
	}


	public JTextField getTfdSangue() {
		return tfdSangue;
	}


	public void setTfdSangue(JTextField tfdSangue) {
		this.tfdSangue = tfdSangue;
	}


	public JTextField getTfdSexo() {
		return tfdSexo;
	}


	public void setTfdSexo(JTextField tfdSexo) {
		this.tfdSexo = tfdSexo;
	}


	public JTextField getTfdEmail() {
		return tfdEmail;
	}


	public void setTfdEmail(JTextField tfdEmail) {
		this.tfdEmail = tfdEmail;
	}


	public JTextField getTfdTelefone() {
		return tfdTelefone;
	}


	public void setTfdTelefone(JTextField tfdTelefone) {
		this.tfdTelefone = tfdTelefone;
	}


	public JLabel getLblNome() {
		return lblNome;
	}


	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}


	public JLabel getLblCpf() {
		return lblCpf;
	}


	public void setLblCpf(JLabel lblCpf) {
		this.lblCpf = lblCpf;
	}


	public JLabel getLblIdade() {
		return lblIdade;
	}


	public void setLblIdade(JLabel lblIdade) {
		this.lblIdade = lblIdade;
	}


	public JLabel getLblSangue() {
		return lblSangue;
	}


	public void setLblSangue(JLabel lblSangue) {
		this.lblSangue = lblSangue;
	}


	public JLabel getLblSexo() {
		return lblSexo;
	}


	public void setLblSexo(JLabel lblSexo) {
		this.lblSexo = lblSexo;
	}


	public JLabel getLblEmail() {
		return lblEmail;
	}


	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}


	public JLabel getLblTelefone() {
		return lblTelefone;
	}


	public void setLblTelefone(JLabel lblTelefone) {
		this.lblTelefone = lblTelefone;
	}


	public JTextField getTdfRua() {
		return tdfRua;
	}


	public void setTdfRua(JTextField tdfRua) {
		this.tdfRua = tdfRua;
	}


	public JTextField getTfdNumero() {
		return tfdNumero;
	}


	public void setTfdNumero(JTextField tfdNumero) {
		this.tfdNumero = tfdNumero;
	}


	public JTextField getTfdBairro() {
		return tfdBairro;
	}


	public void setTfdBairro(JTextField tfdBairro) {
		this.tfdBairro = tfdBairro;
	}


	public JTextField getTfdCidade() {
		return tfdCidade;
	}


	public void setTfdCidade(JTextField tfdCidade) {
		this.tfdCidade = tfdCidade;
	}


	public JTextField getTfdEstado() {
		return tfdEstado;
	}


	public void setTfdEstado(JTextField tfdEstado) {
		this.tfdEstado = tfdEstado;
	}


	public JTextField getTfdComplemento() {
		return tfdComplemento;
	}


	public void setTfdComplemento(JTextField tfdComplemento) {
		this.tfdComplemento = tfdComplemento;
	}


	public JTextField getTfdCep() {
		return tfdCep;
	}


	public void setTfdCep(JTextField tfdCep) {
		this.tfdCep = tfdCep;
	}


	public JLabel getLblfRua() {
		return lblfRua;
	}


	public void setLblfRua(JLabel lblfRua) {
		this.lblfRua = lblfRua;
	}


	public JLabel getLblNumero() {
		return lblNumero;
	}


	public void setLblNumero(JLabel lblNumero) {
		this.lblNumero = lblNumero;
	}


	public JLabel getLblBairro() {
		return lblBairro;
	}


	public void setLblBairro(JLabel lblBairro) {
		this.lblBairro = lblBairro;
	}


	public JLabel getLblCidade() {
		return lblCidade;
	}


	public void setLblCidade(JLabel lblCidade) {
		this.lblCidade = lblCidade;
	}


	public JLabel getLblEstado() {
		return lblEstado;
	}


	public void setLblEstado(JLabel lblEstado) {
		this.lblEstado = lblEstado;
	}


	public JLabel getLblComplemento() {
		return lblComplemento;
	}


	public void setLblComplemento(JLabel lblComplemento) {
		this.lblComplemento = lblComplemento;
	}


	public JLabel getLblCep() {
		return lblCep;
	}


	public void setLblCep(JLabel lblCep) {
		this.lblCep = lblCep;
	}


	public JButton getBtnAdd() {
		return btnAdd;
	}


	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

}
