package view;

public class Principal extends TelaGeral{
	
	private Cadastro cadastro;
	
	public Principal(String titulo, Cadastro cadastro) {
		super(titulo);
		
		this.cadastro = cadastro;
		inicializar();
	}

	@Override
	public void inicializar() {
		
//		cadastro = new Cadastro();
		cadastro.setVisible(true);
		
		add(cadastro);
		
	}

	
	
}
