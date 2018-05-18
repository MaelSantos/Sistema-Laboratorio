package controlle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ClassXML;
import model.Paciente;
import model.Verificar;
import view.Cadastro;
import view.Principal;

public class Controle implements ActionListener{

	private Principal principal;//jframe
	private Cadastro cadastro;//jpanel
	
	public Controle(Principal principal, Cadastro cadastro) {
		this.principal = principal;
		this.cadastro = cadastro;
		
		cadastro.getBtnAdd().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == cadastro.getBtnAdd())
		{
			System.out.println(Verificar.verificarCadastro(cadastro));
			if( ! (Verificar.verificarCadastro(cadastro)))
			{
				ClassXML.pacientes.add(new Paciente(
						cadastro.getTfdNome().getText().trim(),
						cadastro.getTfdCpf().getText().trim(), 
						cadastro.getTfdSexo().getText().trim()));
				ClassXML.gravar(ClassXML.pacientes);				
			}
		}
		
	}
	
}
