package lab07;

import java.util.ArrayList;
import java.util.List;

public class Professores extends Contribuinte{

	private double SALARIO_MINIMO = 937;
	private double salario;
	private String entidade;
	private double materialDidatico;
	private double sinalExteriorDeRiquezaGeral;
	private int numProfessores;
	private List<Professores> professores = new ArrayList<Professores>();
	
	public Professores(String nome, String cod, double valorCasa, double valorCarro, double salario, double materialDidatico, String entidade) {
		super(nome, cod, valorCasa, valorCarro);
		setSalario(salario);
		setMaterialDidatico(materialDidatico);
		setEntidade(entidade);
		setSinalExteriorDeRiquezaGeral();
		numProfessores++;
	}

	public String getEntidade() {
		return entidade;
	}

	public void setEntidade(String entidade) {
		this.entidade = entidade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double tributacao() {
		if(salario <= SALARIO_MINIMO) {
			return salario*0.05;
		}
		if(salario <= SALARIO_MINIMO*5) {
			return salario*0.1;
		}else {
			return salario*0.2;
		}
	}

	public double getMaterialDidatico() {
		return materialDidatico;
	}

	public void setMaterialDidatico(double materialDidatico) {
		this.materialDidatico = materialDidatico;
	}
	
	public double descontos() {
		return getMaterialDidatico();
	}
	
	private void addProfessor() {
		
	}
	
	private void setSinalExteriorDeRiquezaGeral() {
		sinalExteriorDeRiquezaGeral += this.valorAcumuladoBens();
	}
	
	private boolean sinalExteriorDeRiqueza() {
		if(this.valorAcumuladoBens() < (sinalExteriorDeRiquezaGeral/numProfessores)*1.5) {
			return true;
		}
		return false;
	}

}
