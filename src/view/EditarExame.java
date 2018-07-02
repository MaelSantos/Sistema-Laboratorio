package view;

import javax.swing.BorderFactory;

import modelVo.ExameGeral;
import modelVo.Paciente;

public class EditarExame extends CadastroExames{
	private ExameGeral exame;
	public EditarExame() {
		
		
		setBorder(BorderFactory.createTitledBorder("Editar"));
	}
	
	public void autoPreencher(ExameGeral exame) {
		this.exame=exame;
		getFieldTipoExame().setText(exame.getTipoExame());
		getFieldvalor().setText(String.valueOf(exame.getValor()));
		getComboBoxTipoAmostra().setSelectedItem(exame.getTipoDeColeta());
		
	}

	public ExameGeral getExame() {
		return exame;
	}

	public void setExame(ExameGeral exame) {
		this.exame = exame;
	}
	

}
