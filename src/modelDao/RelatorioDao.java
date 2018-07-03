package modelDao;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelVo.DespesasVo;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioDao {

	private static RelatorioDao instance;

	private RelatorioDao() {
	}

	public static RelatorioDao getInstance() {
		if(instance == null)
			instance = new RelatorioDao();
		return instance;
	}

	@SuppressWarnings("deprecation")
	public void gerar(List<? extends Object> list, String layout) throws JRException ,ClassNotFoundException, NoSuchMethodException {
		//gerando o jasper design

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(layout);

		JasperDesign desenho = JRXmlLoader.load(inputStream);

		//compila o relatório
		JasperReport relatorio = JasperCompileManager.compileReport(desenho);

//		JasperPrint print = JasperFillManager.fillReport(relatorio, null, new JRBeanCollectionDataSource(list));
//
//		JasperViewer.viewReport(print,false);
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		for(int i = 0;i < list.size();i++)
			parametros.put(list.get(i).hashCode()+"", list.get(i));
			
//		parametros.put("nota", new Double(list.size()));
		JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, new JRBeanCollectionDataSource(list));
		JasperViewer.viewReport(impressao, false);
		
//		showReport(layout, parametros, list, true);
		
		
	}
	
	public void showReport(String report, Map params, 
			Collection collection, boolean showPrint){
		JasperPrint jasperPrint;
		JasperViewer jasperViewer;
		JRDataSource dataSource;
		if (collection != null){
			dataSource = new JRBeanCollectionDataSource(collection);
		}
		else{
			dataSource = null;
		}
		try{
			jasperPrint = JasperFillManager.fillReport("files/"+report, params, dataSource);
			if (showPrint){
				jasperViewer = new JasperViewer(jasperPrint, false);
				jasperViewer.setZoomRatio(0.75F);
				jasperViewer.setLocationRelativeTo(null);
				jasperViewer.show();
			}
			else{
				JasperPrintManager.printReport(jasperPrint, true);
			}
		}
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try
		{
			RelatorioDao.getInstance().gerar(BancoDados.getInstance().getDespesas(), "Despesas.jrxml");
//			RelatorioDao.getInstance().gerar(BancoDados.getInstance().getContasARecebers(), "Receitas.jrxml");
//			RelatorioDao.getInstance().gerar(BancoDados.getInstance().getPacientes(), "Clientes.jrxml");			
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	
	}
	
}

