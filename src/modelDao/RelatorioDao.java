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

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("Dados", new Double(list.size()));
		
		JasperPrint print = JasperFillManager.fillReport(relatorio, parametros, new JRBeanCollectionDataSource(list));
//		JasperViewer.viewReport(print,false);
		
		JasperViewer jasperViewer = new JasperViewer(print, false);
		jasperViewer.setZoomRatio(0.75F);
		jasperViewer.setLocationRelativeTo(null);
		jasperViewer.show();		
		
	}

	
	public static void main(String[] args) {
		try
		{
//			RelatorioDao.getInstance().gerar(BancoDados.getInstance().getContasARecebers(), "Receitas.jrxml");		
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	
	}
	
}

