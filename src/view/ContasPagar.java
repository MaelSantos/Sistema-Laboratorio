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
    private JTextField descricaoT,fornecedorT,valorParcelaTF;
    private JFormattedTextField dataVencimentoFT, valorTotalFT;
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
		    
		    descricaoT= new JFormattedTextField();
		    fornecedorT= new JFormattedTextField();
		    valorParcelaTF=new JFormattedTextField();
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
		    add(valorTotal);
		    
		    add(dataVencimentoFT);
		    add(valorTotalFT);
		    
		    add(new JSeparator(JSeparator.HORIZONTAL));
			add(new JSeparator(JSeparator.HORIZONTAL));
			add(new JLabel("Plano de Conta Parcelado:"));
			add(new JLabel(""));
			
		    add(valorParcela);
		    add(numParcelas);
		    
		    add(valorParcelaTF);
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
	

}
