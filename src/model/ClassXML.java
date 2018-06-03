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
	
	public static boolean addPaciente(Paciente paciente)
	{
		boolean add = true;
		for(Paciente p : pacientes)
		{
			if(p.getCpf().equalsIgnoreCase(paciente.getCpf()))
			{
				add = false;
			}						
		}
		if(add)
		{
			pacientes.add(paciente);
			gravar(pacientes);
			return true;
		}
		return false;
	}
	
	public static void editarPaciente(Paciente paciente) {
		XStream stream = new XStream(new DomDriver());
		File file =  new File("files/arquivo.xml");
		int indice = 0;
		for(int i = 0; i < pacientes.size(); i++) {
			if(paciente.getCpf().equals(pacientes.get(i).getCpf())) {
				indice = i;
				
			}
		}
		
		
		pacientes.remove(indice);
		pacientes.add(indice, paciente);
		
		
		stream.processAnnotations(Paciente.class);
		
		String text =  stream.toXML(pacientes);
		
		
		PrintWriter writer;
		
		try {
			writer = new PrintWriter(file);
			writer.write(text);
			writer.flush();
			writer.close();
		}catch (FileNotFoundException e) {
			
		}	
	}
	
	public static void gravar(ArrayList<Paciente> pacientes) {
		
			XStream stream =  new XStream(new DomDriver());
			stream.alias("Paciente", Paciente.class);
			stream.alias("Endereco", Endereco.class);
			stream.alias("Exame", Exame.class);
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
			 ler = new FileReader("files/arquivo.xml");
			stream = new XStream(new DomDriver());
			stream.alias("Paciente", Paciente.class);
			stream.alias("Endereco", Endereco.class);
			stream.alias("Exame", Exame.class);
			
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (ArrayList<Paciente>) stream.fromXML(ler);
	}
	
	
}
