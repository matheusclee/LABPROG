/*
 * Aluno 1: Matheus Clemente Pereira
 * Aluno 2: Carlos Vinicius
 */

package lab07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe Abstrata Contribuinte.
 * 
 * @author Matheus Clemente/Carlos Vinicius
 *
 */
public abstract class Contribuinte {
	
	protected String nome;
	protected String codContribuinte;
	private int numDeContribuintes;
	protected int numDeCasas = 0;
	private double[] valoresCasas;
	protected int numDeCarros = 0;
	private List<Carro> carros = new ArrayList();
	private double[] valoresCarros;
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Contrutor da Classe AbstrataContribuinte.
	 * 
	 * @param nome Recebe o nome do contribuinte.
	 * @param cod Recebe o codigo do contribuinte.
	 * @param temCasa Recebe false ou true se o contribinte tiver Casa.
	 * @param temCarro Recebe false ou true se o contrbuinte river Carro.
	 * 
	 */
	public Contribuinte(String nome, String cod, boolean temCasa, boolean temCarro){
		setNome(nome);
		setCodContribuinte(cod);
		if(temCasa){
			setCasas();
		}
		if(temCarro){
			setCarros();
		}
		numDeContribuintes++;
	}
	
	public Contribuinte(String nome, String cod, double numCasas, double numCarros){
		setNome(nome);
		setCodContribuinte(cod);
		if(numCarros > 0){
			for(int i = 0; i < numCarros; i++){
				setCarros(valor);
			}
		}
	}
	
	private void setCarros(double valor) {
		Carro carro = new Carro(valor);
		carros.add(carro);
	}

	private void setCasas() {
		System.out.print("Qual o numero de Casas: ");
		numDeCasas = sc.nextInt();
		valoresCasas = new double[numDeCasas];
		for(int i = 0; i < numDeCasas; i++){
			System.out.print("Informe o valor da casa " + i+1 + ": ");
			valoresCasas[i] = sc.nextDouble();
		}
		
	}
	
	/**
	 * Adiciona o nome do contribuinte.
	 * 
	 * @param nome Recebe uma String com o nome do Contribuinte.
	 */
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	private void setCodContribuinte(String cod){
		codContribuinte = cod;
	}
	
	public String getCodContribuinte(){
		return codContribuinte;
	}
	
	private void setNumdeContribuintes(){
		
	}
	
	public double valorAcumuladoBens(){
		double aux = 0;
		for(int i = 0; i < numDeCasas; i++){
			aux+=valoresCasas[i];
		}
		for(int i = 0; i < numDeCarros; i++){
			aux+=valoresCarros[i];
		}
		
		return aux;
	}
}
