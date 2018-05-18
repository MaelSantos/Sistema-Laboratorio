package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ClassXML {
	
	public static ArrayList<Paciente> pacientes = lerArquivo();
	
	public ClassXML() {
	}
	public static void gravar(ArrayList<Paciente> pacientes) {
		
			XStream stream =  new XStream(new DomDriver());
			stream.alias("Paciente", Paciente.class);
			stream.alias("Endereco", Endereco.class);
			String xml = stream.toXML(pacientes);
			
			
			PrintWriter print = null;
			try {
				File file = new File("files/arquivo.xml");
				print = new PrintWriter(file);
				print.write(xml);
				print.flush();
				print.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Paciente> lerArquivo() { 
		XStream stream=null;
		FileReader ler=null;
		try {
			 ler = new FileReader("Arquivo/arquivo.xml");
			stream = new XStream(new DomDriver());
			stream.alias("Paciente", Paciente.class);
			stream.alias("Endereco", Endereco.class);
			
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (ArrayList<Paciente>) stream.fromXML(ler);
	}
}
