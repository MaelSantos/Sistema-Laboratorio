package modelDao;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioDao {

	public RelatorioDao() {
	}

//	public void gerar( List<? extends Object> list, String arquivo) throws JRException, ClassNotFoundException, Exception
//	{
//		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(arquivo);
//		
//		System.out.println(inputStream);
//		JasperReport report = JasperCompileManager.compileReport(inputStream);
//		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(list));
//		
//		JasperViewer.viewReport(print,false);
//	}

	public void gerar(List<? extends Object> list, String layout) throws JRException ,ClassNotFoundException,IOException {
		//gerando o jasper design
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(layout);
		
		System.out.println(inputStream);
		JasperDesign desenho = JRXmlLoader.load(inputStream);
		 
		System.out.println(desenho);
	
		//compila o relatório
		JasperReport relatorio = JasperCompileManager.compileReport( desenho );
		
		System.out.println(relatorio);

		JasperPrint print = JasperFillManager.fillReport(relatorio, null, new JRBeanCollectionDataSource(list));
		
		System.out.println(print);
		JasperViewer.viewReport(print,false);
		
		//implementação da interface JRDataSource para DataSource ResultSet
//		JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//		 
//		//executa o relatório
//		Map parametros = new HashMap();
//		parametros.put("nota", new Double(10));
//		JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//		 
//		//exibe o resultado
//		JasperViewer viewer = new JasperViewer( impressao , true );
//		viewer.show();
		}
	
	public static void main(String[] args) {
		try {
			new RelatorioDao().gerar(BancoDados.getInstance().getDespesas(), "Despesas.jrxml" );
		} catch (Exception e) {
//			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}