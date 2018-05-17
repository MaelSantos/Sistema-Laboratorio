package view;

public class Principal extends TelaGeral{
	
	private Cadastro cadastro;
	
	public Principal(String titulo) {
		super(titulo);
	}

	@Override
	public void inicializar() {
		
		cadastro = new Cadastro();
		cadastro.setVisible(true);
		
		add(cadastro);
		
	}

	
	
}
