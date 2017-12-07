/*
 * Aluno 1: Matheus Clemente Pereira
 * Aluno 2: Carlos Vinicius
 * Aluno 3: Jeffiti Mucio
 */
package lab07;

import java.util.ArrayList;
import java.util.List;

public class Professores extends Contribuinte{

	private double SALARIO_MINIMO = 937;
	private double salario;
	private String entidade;
	private double materialDidatico;
	private double riquezaProfessores;
	private int numProfessores;
	
	/**
	 * Construtor da classe Professores.
	 * 
	 * @param nome Recebe uma String.
	 * @param cod Recebe uma String.
	 * @param valorCasa Recebe um Double, se maior que zero, o contribuinte tem Casa.
	 * @param valorCarro Recebe um Double, se maior que zero, o contribuinte tem Carro.
	 * @param salario Recebe um Double.
	 * @param materialDidatico Recebe um Double.
	 * @param entidade Recebe uma String, Entidade na qual o professor trabalha.
	 */
	public Professores(String nome, String cod, double valorCasa, double valorCarro, double salario, double materialDidatico, String entidade) {
		super(nome, cod, valorCasa, valorCarro);
		setSalario(salario);
		setMaterialDidatico(materialDidatico);
		setEntidade(entidade);
		riquezaProfessores = this.riquezaGeral(riquezaProfessores);
		numProfessores++;
	}

	/**
	 * Retorna a entidade na qual o professor trabalha.
	 * @return Retorna uma String.
	 */
	public String getEntidade() {
		return entidade;
	}

	/**
	 * Adiciona a Entidade na qual o professor trabalha.
	 * @param entidade Recebe uma String.
	 */
	public void setEntidade(String entidade) {
		this.entidade = entidade;
	}

	/**
	 * Retorna o valor do salário do professor.
	 * 
	 * @return REtorna um Double.
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Adiciona o valor do salário do professor. E retorna true caso o salário tenha sido adicionado.
	 * @param salario Recebe um double.
	 * @return Retorna um boolean.
	 */
	public boolean setSalario(double salario) {
		if(salario > 0){
			this.salario = salario;
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna o valor da tributacao do professor.
	 * @return Retorna um double.
	 */
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

	/**
	 * Retorna o valor de materiais gastos pelo professor.
	 * 
	 * @return Retorna um double.
	 */
	public double getMaterialDidatico() {
		return materialDidatico;
	}

	/**
	 * Adiciona o valor de despesas com materiais do professor.
	 * Retorna true caso o valor tenha sido adicionado.
	 * 
	 * @param materialDidatico Recebe um double.
	 * @return Retorna um boolean.
	 */
	public boolean setMaterialDidatico(double materialDidatico) {
		if(materialDidatico > 0){
			this.materialDidatico = materialDidatico;
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna o valor de descontos do professor.
	 * 
	 * @return Retorna um double.
	 */
	public double descontos() {
		return getMaterialDidatico();
	}
	
	/**
	 * Metodo que faz analise se o sinal de riqueza do professor é menor ou maior que o sinal médio de riqueza de sua classe.
	 * @return Retorna boolean
	 */
	public boolean sinalDeRiquezaExterior(){
		return this.mediaRiqueza(riquezaProfessores, numProfessores);
	}

}
