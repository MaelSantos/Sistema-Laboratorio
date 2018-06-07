package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ExamesValorXML {
	
	private static ArrayList<ExameValor> examesValores=lerArquivo();
	
	public static boolean addExameValor(ExameValor exameValor)
	{
		
		boolean add = true;
		for(ExameValor eV : examesValores)
		{
			if(eV.getNome().equalsIgnoreCase(exameValor.getNome()))
			{
				add = false;
			}						
		}
		if(add)
		{
			examesValores.add(exameValor);
			gravar(examesValores);
			return true;
		}
		return false;
	}
	
	
	public static void gravar(ArrayList<ExameValor> examesValores) {
		
		XStream stream =  new XStream(new DomDriver());
		stream.alias("ExameValor", ExameValor.class);
		String xml = stream.toXML(examesValores);
		
		
		PrintWriter print = null;
		try {
			File file = new File("files/examesValor.xml");
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
	public static ArrayList<ExameValor> lerArquivo() { 
		XStream stream=null;
		FileReader ler=null;
		try {
			
			ler = new FileReader("files/examesValor.xml");
			stream = new XStream(new DomDriver());
			stream.alias("ExameValor", ExameValor.class);
			
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (ArrayList<ExameValor>) stream.fromXML(ler);
	}


	public static ArrayList<ExameValor> getExamesValores() {
		return examesValores;
	}
	
	

}
