package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import model.Paciente;

@SuppressWarnings("serial")
public class DetalhesPaciente extends Cadastro{
	
	private Paciente paciente;
	private JButton bntVoltar;
	public DetalhesPaciente() {
		setBorder(BorderFactory.createTitledBorder("Detalhes"));
		getBtnAdd().setText("Salvar");
		bntVoltar=new JButton("Voltar");
		add(bntVoltar);
		
	}
	
	public void autoPreencher(Paciente paciente) {
		this.paciente = paciente;
		getTfdNome().setText(paciente.getNome());
		getTfdCpf().setText(paciente.getCpf());
		getTfdNascimento().setText(paciente.getIdade());
		getCbxSexo().setSelectedItem(paciente.getSexo());
		getCbxSangue().setSelectedItem(paciente.getTipoSanguineo());
		getTfdEmail().setText(paciente.getEmail());
		
		getTfdRua().setText(paciente.getEndereco().getRua());
		getTfdBairro().setText(paciente.getEndereco().getBairro());
		getTfdCep().setText(paciente.getEndereco().getCep());
		getTfdCidade().setText(paciente.getEndereco().getCidade());
		getTfdComplemento().setText(paciente.getEndereco().getComplemento());
		getCbxEstado().setSelectedItem(paciente.getEndereco().getEstado());
		getTfdNumero().setText(paciente.getEndereco().getNumero());
		
	}

	public Paciente getPaciente() {
		return paciente;
	}
	public JButton getBntVoltar() {
		return bntVoltar;
	}
	
}
