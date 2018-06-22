package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class ContasPagar extends PanelGeral {
		
	// componentes do Panel de Contas á pagar
    private JLabel descricao,fornecedor,planoDeConta,dataVencimento,centroLucro,gerarparcelaP,
    valorTotal,numParcelas,intervaloParcela;
    private JTextField descricaoT,fornecedorT;
    private JFormattedTextField dataVencimentoFT, valorTotalFT;
    private JComboBox<String> planoDeContaC,centroLucroC,gerarparcelaC,numParcelasC,intervaloParcelaC;
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
		    centroLucro= new JLabel("Centro de Custo Lucro: ");
		    gerarparcelaP= new JLabel("Gerar Parcerla por: ");
		    valorTotal= new JLabel("Valor Total: ");
		    numParcelas= new JLabel("Numero de Parcelas: ");
		    intervaloParcela= new JLabel("Intervalo entre as Parcelas: ");
		    
		    descricaoT= new JFormattedTextField();
		    fornecedorT= new JFormattedTextField();
		    dataVencimentoFT= new JFormattedTextField();
		    valorTotalFT= new JFormattedTextField();
		    try {
			    dataVencimentoFT.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
			  
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
	
		    gerarparcelaC= new JComboBox<String>();
		    
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
		    
		    add(descricaoT);
		    add(fornecedorT);
		    
		    add(planoDeConta);
		    add(centroLucro);
		    	    
		    add(planoDeContaC);
		    add(centroLucroC);
		    
		    add(dataVencimento);
		    add(gerarparcelaP);
		    
		    add(dataVencimentoFT);
		    add(gerarparcelaC);
		    
		    add(valorTotal);
		    add(numParcelas);
		    
		    add(valorTotalFT);
		    add(numParcelasC);
		    
		    add(intervaloParcela);
		    add(new JLabel(""));
		    add(intervaloParcelaC);
		   
		    add(lancar);
	}

}
