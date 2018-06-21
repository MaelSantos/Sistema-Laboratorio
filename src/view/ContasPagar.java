package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContasPagar extends PanelGeral {
		
	// componentes do Panel de Contas á pagar
    private JLabel descricao,fornecedor,planoDeConta,dataVencimento,centroLucro,gerarparcelaP,
    valorTotal,numParcelas,intervaloParcela;
    private JTextField descricaoT,fornecedorT;
    private JFormattedTextField dataVencimentoFT, valorTotalFT,numParcelasFT,intervaloParcelaFT;
    private JComboBox<String> planoDeContaC,centroLucroC,gerarparcelaC;
    
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
		    numParcelasFT= new JFormattedTextField();
		    intervaloParcelaFT= new JFormattedTextField();
		    
		    planoDeContaC= new JComboBox<String>();
		    centroLucroC= new JComboBox<String>();
		    gerarparcelaC= new JComboBox<String>();
		    
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
		    add(numParcelasFT);
		    
		    add(intervaloParcela);
		    add(intervaloParcelaFT);
		    
		
	}

}
