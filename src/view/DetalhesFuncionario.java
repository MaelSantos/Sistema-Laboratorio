package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import modelVo.Funcionario;

public class DetalhesFuncionario extends CadastroFuncionario {

	private Funcionario funcionario;
	private JButton btnVoltar;

	public DetalhesFuncionario() {
		setBorder(BorderFactory.createTitledBorder("Detalhes"));
		getBtnAdd().setText("Salvar");
		btnVoltar = new JButton("Voltar");
		add(btnVoltar);

	}
	
	public void autoPreencher(Funcionario funcionario) {
		this.funcionario = funcionario;
		
		getTdfRua().setText(funcionario.getEndereco().getRua());
		getTfdBairro().setText(funcionario.getEndereco().getBairro());
		getTfdCep().setText(funcionario.getEndereco().getCep());
		getTfdCidade().setText(funcionario.getEndereco().getCidade());
		getTfdComplemento().setText(funcionario.getEndereco().getComplemento());
		getTfdNumero().setText(funcionario.getEndereco().getNumero());
		getCbxSexo().setSelectedItem(funcionario.getSexo());
		getCbxSangue().setSelectedItem(funcionario.getTipoSanguineo());
		
		getTfdCargo().setText(funcionario.getCargo());
		getTfdCpf().setText(funcionario.getCpf());
		getTfdEmail().setText(funcionario.getEmail());
		getTfdLogin().setText(funcionario.getLogin());
		getTfdNascimento().setText(funcionario.getIdade());
		getTfdNome().setText(funcionario.getNome());
		getTfdTelefone().setText(funcionario.getTelefone());
		
		

		
		
		
		
		
		//Ver os campos de senha.
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}
	
	

}