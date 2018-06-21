package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Caixa extends PanelGeral {
	
	private JButton contas_a_pagarB,contas_a_receberB;
	private JPanel contas_a_pagar,contas_a_receber;
	
	// componentes do Panel de Contas á pagar
    private JLabel descricao,fornecedor,planoDeConta,dataVencimento,centroLucro,gerarparcelaP,
    valorTotal,numParcelas,intervaloParcela;
    private JTextField descricaoT,fornecedorT;
    private JFormattedTextField dataVencimentoFT, valorTotalFT,numParcelasFT,intervaloParcelaFT;
    private JComboBox<String> planoDeContaC,centroLucroC,gerarparcelaC;
    
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
		    
		    descricaoT,
		    fornecedorT;
		    private JFormattedTextField dataVencimentoFT, valorTotalFT,numParcelasFT,intervaloParcelaFT;
		    private JComboBox<String> planoDeContaC,centroLucroC,gerarparcelaC;
		
	}

}
