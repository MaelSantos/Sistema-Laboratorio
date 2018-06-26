package model;

import view.CadastroPacientes;
import view.ContasAReceber;
import view.ContasPagar;
import view.Marcar;

public class Verificar {

	public static boolean verificarCadastro(CadastroPacientes cadastro)
	{
		if(cadastro.getTfdNome().getText().trim().equals("") || 
				cadastro.getTfdCpf().getText().trim().length() != 14 ||
				cadastro.getTfdNascimento().getText().trim().length() != 10 ||
				cadastro.getTfdTelefone().getText().trim().length() != 15 ||
				cadastro.getTfdRua().getText().trim().equals("") || 
				cadastro.getTfdNumero().getText().trim().equals("") ||
				cadastro.getTfdBairro().getText().trim().equals("") || 
				cadastro.getTfdCep().getText().trim().equals("") ||
				cadastro.getTfdCidade().getText().trim().equals(""))
			return false;
		
		return true;
	}
	
	public static boolean verificarMarcar(Marcar marcarExame)
	{
		if(marcarExame.getTfdCpfPaciente().getText().trim().equals("") ||
				marcarExame.getTfdNomeMedico().getText().trim().equals("")|| 
				marcarExame.getTfdParecer().getText().trim().equals("")) 
			return false;
		
		for(Paciente p : BancoDados.getInstance().getPacientes())
			if(p.getCpf().equalsIgnoreCase(marcarExame.getTfdCpfPaciente().getText().trim()))
				return true;
		
		return false;
	}

	public static boolean verificarContasPagar(ContasPagar pagar)
	{
		if(pagar.getTfdDataVencimento().getText().trim().equals("") || 
				pagar.getTfdDescricao().getText().trim().equals("") ||
				pagar.getTfdFornecedor().getText().trim().equals("") ||
				pagar.getTfdValorParcela().getText().trim().equals("") ||
				pagar.getTfdValorTotal().getText().trim().equals(""))
			return false;
		return true;
	}

	public static boolean verificarContasAReceber(ContasAReceber contasAReceber) {
		if(contasAReceber.getFtfCpfCliente().getText().equals("..-") || 
				contasAReceber.getFtfCpfCliente().getText().equals("999.999.999-99") ||
				contasAReceber.getFtfDataVencimento().getText().equals("//") || 
				contasAReceber.getTfReferencia().getText().equals("")) {
			return false;
		}
		return true;
		
	}
}
