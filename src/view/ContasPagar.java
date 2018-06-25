package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class ContasPagar extends PanelGeral {
		
	// componentes do Panel de Contas á pagar
    private JLabel descricao,fornecedor,planoDeConta,dataVencimento,valorParcela,
    valorTotal,numParcelas,intervaloParcela,centroLucro;
    private JTextField tfdDescricao,tfdFornecedor,tfdValorParcela;
    private JFormattedTextField tfdDataVencimento, tfdValorTotal;
    private JComboBox<String> planoDeContaC,centroLucroC,numParcelasC,intervaloParcelaC;
    private JButton lancar;
    
    public ContasPagar() {
    	
    	setBorder(BorderFactory.createTitledBorder("Contas á Pagar"));
    }
	@Override
	public void inicializar() {
		
		    descricao= new JLabel("Descrição: ");
		    fornecedor= new JLabel("Fornecedor/Paciente: ");
		    planoDeConta= new JLabel("Plano de Conta: ");
		    dataVencimento= new JLabel("Data de Vencimento: ");
		    valorParcela= new JLabel("Valor da Parcela: ");
		    centroLucro= new JLabel("Centro de Custo Lucro: ");
		    valorTotal= new JLabel("Valor Total: ");
		    numParcelas= new JLabel("Numero de Parcelas: ");
		    intervaloParcela= new JLabel("Intervalo entre as Parcelas: ");
		    
		    tfdDescricao= new JFormattedTextField();
		    tfdFornecedor= new JFormattedTextField();
		    tfdValorParcela=new JFormattedTextField();
		    tfdDataVencimento= new JFormattedTextField();
		    tfdValorTotal= new JFormattedTextField();
		    try {
			    tfdDataVencimento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
			  
			} catch (Exception e) {
				// TODO: handle exception
			}

		    planoDeContaC= new JComboBox<String>();
		    planoDeContaC.addItem("Pacelado");
		    planoDeContaC.addItem("Á Vista");
		    
		    centroLucroC= new JComboBox<String>();
		    centroLucroC.addItem("50%");
		    centroLucroC.addItem("40%");
		    centroLucroC.addItem("30%");
		    centroLucroC.addItem("20%");
		    centroLucroC.addItem("10%");
	
		   
		    
		    numParcelasC= new JComboBox<String>();
		    numParcelasC.addItem("2");
		    numParcelasC.addItem("3");
		    numParcelasC.addItem("5");
		    numParcelasC.addItem("8");
		    numParcelasC.addItem("10");
		    numParcelasC.addItem("12");
		    
		    intervaloParcelaC= new JComboBox<String>();
		    intervaloParcelaC.addItem("30");
		    intervaloParcelaC.addItem("20");
		    intervaloParcelaC.addItem("15");
		    intervaloParcelaC.addItem("10");
		    
		    
		    
		    
		    lancar=new JButton("Lançar");
		    
		    add(descricao);
		    add(fornecedor);
		    
		    add(tfdDescricao);
		    add(tfdFornecedor);
		    
		    add(planoDeConta);
		    add(centroLucro);
		    	    
		    add(planoDeContaC);
		    add(centroLucroC);
		    
		    add(dataVencimento);
		    add(valorTotal);
		    
		    add(tfdDataVencimento);
		    add(tfdValorTotal);
		    
		    add(new JSeparator(JSeparator.HORIZONTAL));
			add(new JSeparator(JSeparator.HORIZONTAL));
			add(new JLabel("Plano de Conta Parcelado:"));
			add(new JLabel(""));
			
		    add(valorParcela);
		    add(numParcelas);
		    
		    add(tfdValorParcela);
		    add(numParcelasC);
		    
		    add(intervaloParcela);
		    add(new JLabel(""));
		    add(intervaloParcelaC);
		    
		    
		    add(new JLabel(""));
		    add(new JSeparator(JSeparator.HORIZONTAL));
			add(new JSeparator(JSeparator.HORIZONTAL));
			add(new JLabel(""));
		    add(lancar);
	}
	public JButton getLancar() {
		return lancar;
	}
	public JTextField getTfdFornecedor() {
		return tfdFornecedor;
	}
	public void setTfdFornecedor(JTextField tfdFornecedor) {
		this.tfdFornecedor = tfdFornecedor;
	}
	public JTextField getTfdDescricao() {
		return tfdDescricao;
	}
	public JTextField getTfdValorParcela() {
		return tfdValorParcela;
	}
	public JFormattedTextField getTfdDataVencimento() {
		return tfdDataVencimento;
	}
	public JFormattedTextField getTfdValorTotal() {
		return tfdValorTotal;
	}
	public JLabel getDescricao() {
		return descricao;
	}
	public JLabel getFornecedor() {
		return fornecedor;
	}
	public JLabel getPlanoDeConta() {
		return planoDeConta;
	}
	public JLabel getDataVencimento() {
		return dataVencimento;
	}
	public JLabel getValorParcela() {
		return valorParcela;
	}
	public JLabel getValorTotal() {
		return valorTotal;
	}
	public JLabel getNumParcelas() {
		return numParcelas;
	}
	public JLabel getIntervaloParcela() {
		return intervaloParcela;
	}
	public JLabel getCentroLucro() {
		return centroLucro;
	}
	public JComboBox<String> getPlanoDeContaC() {
		return planoDeContaC;
	}
	public JComboBox<String> getCentroLucroC() {
		return centroLucroC;
	}
	public JComboBox<String> getNumParcelasC() {
		return numParcelasC;
	}
	public JComboBox<String> getIntervaloParcelaC() {
		return intervaloParcelaC;
	}
	

}
