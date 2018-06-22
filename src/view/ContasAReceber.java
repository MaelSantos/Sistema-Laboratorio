package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class ContasAReceber extends PanelGeral {

	private JLabel lbDataFluxo, lbValor, lbCpfCliente, lbReferencia, lbDataVencimento, lbTipoPagamento, lbParcelas,
			lbNomeCliente;
	private JFormattedTextField ftfDataVencimento, ftfDataFluxo, ftfCpfCliente;
	private JTextField tfValor, tfReferencia, tfNomeCliente;
	private JComboBox<String> comboTipoDePagamento, comboParcelas;
	private JButton btnLancar, btnLimpar, btnBuscar;

	public ContasAReceber() {
		setBorder(BorderFactory.createTitledBorder("Contas á Receber"));
	}

	@Override
	public void inicializar() {

		// Label's
		lbCpfCliente = new JLabel("Cliente:");
		lbDataFluxo = new JLabel("Data do fluxo:");
		lbDataVencimento = new JLabel("Data de vencimento:");
		lbReferencia = new JLabel("Referência:");
		lbValor = new JLabel("Valor");
		lbTipoPagamento = new JLabel("Tipo de pagamento:");
		lbNomeCliente =  new JLabel("Nome");

		lbParcelas = new JLabel("Parcelas:");
		lbParcelas.setVisible(false);

		// JFORMATED
		ftfCpfCliente = new JFormattedTextField();
		ftfDataFluxo = new JFormattedTextField();
		ftfDataVencimento = new JFormattedTextField();

		try {
			ftfCpfCliente.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
			ftfDataFluxo.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
			ftfDataVencimento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));

		} catch (Exception e) {

		}

		// TEXTFILD
		tfReferencia = new JTextField();
		tfValor = new JTextField();
		tfValor.setEditable(false);
		tfNomeCliente = new JTextField();
		tfNomeCliente.setEditable(false);

		// COMBO
		comboParcelas = new JComboBox<>();

		comboParcelas.addItem("2");
		comboParcelas.addItem("4");
		comboParcelas.addItem("6");
		comboParcelas.addItem("8");
		comboParcelas.addItem("10");
		comboParcelas.addItem("12");
		comboParcelas.setVisible(false);

		comboTipoDePagamento = new JComboBox<>();

		comboTipoDePagamento.addItem("Á vista");
		comboTipoDePagamento.addItem("Á prazo");

		// BUTTON

		btnLancar = new JButton("LANCAR");
		btnLancar.setBackground(Color.GREEN);
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBackground(Color.red);

		add(lbCpfCliente);
		add(lbNomeCliente);
		
		add(ftfCpfCliente);
		add(tfNomeCliente);

		add(lbDataVencimento);
		add(lbDataFluxo);

		add(ftfDataVencimento);
		add(ftfDataFluxo);

		add(lbValor);
		add(lbReferencia);

		add(tfValor);
		add(tfReferencia);
		

		add(lbTipoPagamento);
		add(comboTipoDePagamento);

		add(lbParcelas);
		add(comboParcelas);

		add(btnLancar);
		add(btnLimpar);

	}

	public JFormattedTextField getFtfDataVencimento() {
		return ftfDataVencimento;
	}

	public JFormattedTextField getFtfDataFluxo() {
		return ftfDataFluxo;
	}

	public JFormattedTextField getFtfCpfCliente() {
		return ftfCpfCliente;
	}

	public JTextField getTfValor() {
		return tfValor;
	}

	public JTextField getTfReferencia() {
		return tfReferencia;
	}

	public JComboBox<String> getComboTipoDePagamento() {
		return comboTipoDePagamento;
	}

	public JComboBox<String> getComboParcelas() {
		return comboParcelas;
	}

	public JButton getBtnLancar() {
		return btnLancar;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public JLabel getLbParcelas() {
		return lbParcelas;
	}

	public void setLbParcelas(JLabel lbParcelas) {
		this.lbParcelas = lbParcelas;
	}

	public JTextField getTfNomeCliente() {
		return tfNomeCliente;
	}
	

}
