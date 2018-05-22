package model;

import view.Cadastro;

public class Verificar {

	public static boolean verificarCadastro(Cadastro cadastro)
	{
		if(cadastro.getTfdNome().getText().trim().equals("") || 
				cadastro.getTfdCpf().getText().trim().length() != 14 ||
				cadastro.getTfdNascimento().getText().trim().length() != 10 ||
				cadastro.getTfdTelefone().getText().trim().length() != 15 ||
				cadastro.getTfdRua().getText().trim().equals("") || 
				cadastro.getTfdNumero().getText().trim().equals("") ||
				cadastro.getTfdEstado().getText().trim().equals("") ||
				cadastro.getTfdBairro().getText().trim().equals("") || 
				cadastro.getTfdCep().getText().trim().equals("") ||
				cadastro.getTfdCidade().getText().trim().equals(""))
			return false;
		
		return true;
	}
	
}
