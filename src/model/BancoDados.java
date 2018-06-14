package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

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
		xStream.alias("Andamento", Andamento.class);
		
		//remover mesnagem de erro 
		XStream.setupDefaultSecurity(xStream);
		xStream.allowTypes(new Class[] {
				Paciente.class, 
				Funcionario.class, 
				Administrador.class, 
				Endereco.class, 
				MarcarExame.class, 
				ExameGeral.class,
				Andamento.class
		});		
		// clear out existing permissions and set own ones
		xStream.addPermission(NoTypePermission.NONE);
		//allow some basics
		xStream.addPermission(NullPermission.NULL);
		xStream.addPermission(PrimitiveTypePermission.PRIMITIVES);
		xStream.allowTypeHierarchy(Object.class);

		pacientes = (ArrayList<Paciente>) lerArquivo("pacientes.xml");
		examesMarcados = (ArrayList<MarcarExame>) lerArquivo("examesMarcados.xml");
		funcionarios = (ArrayList<Funcionario>) lerArquivo("funcionarios.xml");
		examesGerais = (ArrayList<ExameGeral>) lerArquivo("examesValor.xml");

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
		if (object instanceof Paciente) { //add paciente
			Paciente paciente = (Paciente) object;
			for(Paciente p : pacientes)
			{
				if(p.getCpf().equalsIgnoreCase(paciente.getCpf()))
				{
					return false;
				}						
			}
			pacientes.add(paciente);
			gravar(pacientes,"pacientes.xml");
			return true;
		}
		if (object instanceof Funcionario) { //add funcionario
			Funcionario funcionario = (Funcionario) object;
			for(Funcionario f : funcionarios)
			{
				if(f.getCpf().equalsIgnoreCase(funcionario.getCpf()))
				{
					return false;
				}						
			}
			funcionarios.add(funcionario);
			gravar(funcionarios, "funcionarios.xml");
			return true;

		}
		if (object instanceof ExameGeral) { //add exame
			ExameGeral exameGeral = (ExameGeral) object;
			for(ExameGeral eV : examesGerais)
			{
				if(eV.getTipoExame().equalsIgnoreCase(exameGeral.getTipoExame()))
				{
					return false;
				}						
			}
			examesGerais.add(exameGeral);
			gravar(examesGerais,"examesValor.xml");
			return true;
		}
		if (object instanceof MarcarExame) { //add exame
			MarcarExame marcarExame = (MarcarExame) object;

			examesMarcados.add(marcarExame);
			gravar(examesMarcados,"examesMarcados.xml");
			return true;
		}
		
		return false;
	}

	public void editarPaciente(Paciente paciente) {

		File file =  new File(getClass().getClassLoader().getResource("funcionarios.xml").getFile());
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
			File file = new File(getClass().getClassLoader().getResource(caminho).getFile());
			print = new PrintWriter(file);
			print.write(xml);
			print.flush();

		} catch (FileNotFoundException e) {
			System.err.println("Erro ao gravar: "+e.getMessage()+"Local: "+e.getLocalizedMessage());
			e.printStackTrace();
		}
		finally {
			print.close();			
		}
	}

	public ArrayList<? extends Object> lerArquivo(String caminho) { 

		FileReader ler=null;
		ArrayList<? extends Object> temp = null;
		try {
			ler = new FileReader(new File(getClass().getClassLoader().getResource(caminho).getFile()));

			temp =  (ArrayList<? extends Object>) xStream.fromXML(ler);
		} catch (Exception e) {
			System.err.println("Erro ao Ler: "+e.getMessage()+"Local: "+e.getLocalizedMessage());
		}

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

