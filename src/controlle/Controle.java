package controlle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			//salvar banco de dados 
		}
		
	}
	
}
