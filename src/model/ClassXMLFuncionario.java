package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ClassXMLFuncionario {
	
	public static ArrayList<Funcionario> funcionarios = lerArquivo();
	
	public static boolean addPaciente(Funcionario funcionario)
	{
		boolean add = true;
		for(Funcionario f : funcionarios)
		{
			if(f.getCpf().equalsIgnoreCase(funcionario.getCpf()))
			{
				add = false;
			}						
		}
		if(add)
		{
			funcionarios.add(funcionario);
			gravar(funcionarios);
			return true;
		}
		return false;
	}
	
	public static void editarFuncionario(Funcionario funcionario) {
		XStream stream = new XStream(new DomDriver());
		File file =  new File("files/arquivoFuncionario.xml");
		int indice = 0;
		for(int i = 0; i < funcionarios.size(); i++) {
			if(funcionario.getCpf().equals(funcionarios.get(i).getCpf())) {
				indice = i;
				
			}
		}
		
		
		funcionarios.remove(indice);
		funcionarios.add(indice, funcionario);
		
		
		stream.processAnnotations(Funcionario.class);
		
		String text =  stream.toXML(funcionarios);
		
		
		PrintWriter writer;
		
		try {
			writer = new PrintWriter(file);
			writer.write(text);
			writer.flush();
			writer.close();
		}catch (FileNotFoundException e) {
			
		}	
	}
	
	public static void gravar(ArrayList<Funcionario> funcionarios) {
		
			XStream stream =  new XStream(new DomDriver());
			stream.alias("Funcionario", Funcionario.class);
			stream.alias("Endereco", Endereco.class);
			String xml = stream.toXML(funcionarios);
			
			
			PrintWriter print = null;
			try {
				File file = new File("files/arquivoFuncionario.xml");
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
	public static ArrayList<Funcionario> lerArquivo() { 
		XStream stream=null;
		FileReader ler=null;
		try {
			 ler = new FileReader("files/arquivoFuncionario.xml");
			stream = new XStream(new DomDriver());
			stream.alias("Funcionario", Funcionario.class);
			stream.alias("Endereco", Endereco.class);
			
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (ArrayList<Funcionario>) stream.fromXML(ler);
	}
	
	
}
