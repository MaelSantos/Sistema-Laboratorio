package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

import view.Mensagem;

@SuppressWarnings("unchecked")
public class BancoDados {

	private static BancoDados dados;
	
	private ArrayList<Paciente> pacientes;
	private ArrayList<Funcionario> funcionarios;
	private ArrayList<ExameGeral> examesGerais;
	private ArrayList<MarcarExame> examesMarcados;
	private XStream xStream;

	private BancoDados() {
		
		xStream= new XStream(new Dom4JDriver());
		xStream.alias("Paciente", Paciente.class);
		xStream.alias("Funcionario", Funcionario.class);
		xStream.alias("Administrador", Administrador.class);
		xStream.alias("Endereco", Endereco.class);
		xStream.alias("ExameMarcado", MarcarExame.class);
		xStream.alias("ExameGeral", ExameGeral.class);
		
		pacientes = (ArrayList<Paciente>) lerArquivo("files/pacientes.xml");
		examesMarcados = (ArrayList<MarcarExame>) lerArquivo("files/examesMarcados.xml");
		funcionarios = (ArrayList<Funcionario>) lerArquivo("files/funcionarios.xml");
		examesGerais = (ArrayList<ExameGeral>) lerArquivo("files/examesValor.xml");
	}
	
	public static BancoDados getInstance()
	{
		if(dados == null)
			dados = new BancoDados();
		return dados;
	}
	
	public boolean addDado(Object object)
	{
		boolean add = true;
		if (object instanceof Paciente) {
			 Paciente paciente = (Paciente) object;
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
				 gravar(pacientes,"files/pacientes.xml");
				 return true;
			 }
		}
		if (object instanceof Funcionario) {
			Funcionario funcionario = (Funcionario) object;
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
				gravar(funcionarios, "files/funcionarios.xml");
				return true;
			}
		}
		if (object instanceof ExameGeral) {
			ExameGeral exameGeral = (ExameGeral) object;
			for(ExameGeral eV : examesGerais)
			{
				if(eV.getTipoExame().equalsIgnoreCase(exameGeral.getTipoExame()))
				{
					add = false;
				}						
			}
			if(add)
			{
				examesGerais.add(exameGeral);
				gravar(examesGerais,"files/examesValor.xml");
				return true;
			}
		}
		
		return false;
	}
	
public void editarPaciente(Paciente paciente) {
		
		File file =  new File("files/funcionarios.xml");
		int indice = 0;
		for(int i = 0; i < pacientes.size(); i++) {
			if(paciente.getCpf().equals(pacientes.get(i).getCpf())) {
				indice = i;
				break;
			}
		}
		
		pacientes.remove(indice);
		pacientes.add(indice, paciente);

		xStream.processAnnotations(Paciente.class);

		String text =  xStream.toXML(pacientes);

		PrintWriter writer;

		try {
			writer = new PrintWriter(file);
			writer.write(text);
			writer.flush();
			writer.close();
		}catch (FileNotFoundException e) {

		}	
	}

public void editarExame(ExameGeral exame) {
	
	File file =  new File("files/examesValor.xml");
	int indice = 0;
	for(int i = 0; i < pacientes.size(); i++) {
		if(exame.getCodigo().equals(examesGerais.get(i).getCodigo())) {
			indice = i;
			break;
		}
	}
	
	examesGerais.remove(indice);
	examesGerais.add(indice, exame);

	xStream.processAnnotations(ExameGeral.class);

	String text =  xStream.toXML(examesGerais);

	PrintWriter writer;

	try {
		writer = new PrintWriter(file);
		writer.write(text);
		writer.flush();
		writer.close();
	}catch (FileNotFoundException e) {

	}	
}
	public void excluirExame(ExameGeral exameGeral) {
		File file =  new File("files/examesValor.xml");
			this.examesGerais.remove(exameGeral);
			xStream.processAnnotations(ExameGeral.class);

			String text =  xStream.toXML(examesGerais);

			PrintWriter writer;

			try {
				writer = new PrintWriter(file);
				writer.write(text);
				writer.flush();
				writer.close();
			}catch (FileNotFoundException e) {
			
			}	
			
	}
	
	public void gravar(ArrayList<? extends Object> dados, String caminho) {

		String xml = xStream.toXML(dados);

		PrintWriter print = null;
		try {
			File file = new File(caminho);
			print = new PrintWriter(file);
			print.write(xml);
			print.flush();
			print.close();

		} catch (FileNotFoundException e) {
			System.err.println("Erro ao gravar: "+e.getMessage()+"Local: "+e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public ArrayList<? extends Object> lerArquivo(String caminho) { 

		FileReader ler=null;
		File file = new File(caminho);
		try {
			ler = new FileReader(caminho);
			
			if(!(file.exists()))
				file.createNewFile();
	
		} catch (Exception e) {
			System.err.println("Erro ao Ler: "+e.getMessage()+"Local: "+e.getLocalizedMessage());
		}
		
		ArrayList<? extends Object> temp =  (ArrayList<? extends Object>) xStream.fromXML(ler);
			
		return temp;
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public ArrayList<ExameGeral> getExamesGerais() {
		return examesGerais;
	}

	public ArrayList<MarcarExame> getExamesMarcados() {
		return examesMarcados;
	}
}

