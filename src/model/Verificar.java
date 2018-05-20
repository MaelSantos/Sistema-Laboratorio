package model;

import view.Cadastro;

public class Verificar {

	public static boolean verificarCadastro(Cadastro cadastro)
	{
		if(cadastro.getTfdNome().getText().trim().equals("") || 
				cadastro.getTfdCpf().getText().trim().equals("") ||
				cadastro.getTfdSexo().getText().trim().equals("") ||
				cadastro.getTfdTelefone().getText().trim().equals("") ) 
			return false;
		
		return true;
	}
	
}
