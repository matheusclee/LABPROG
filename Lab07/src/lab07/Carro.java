/*
 * Aluno 1: Matheus Clemente Pereira
 * Aluno 2: Carlos Vinicius
 * Aluno 3: Jeffiti Mucio
 */
package lab07;

/**
 * Classe Carro.
 * 
 * @author Matheus Clemente/Carlos Vinicius
 *
 */
public class Carro {
	
	private double valor;
	
	/**
	 * Construtor da classe Carro.
	 * @param valor Recebe o valor do Carro.
	 */
	public Carro(double valor){
		setValor(valor);
	}
	
	/**
	 * Adiciona o valor do Carro.
	 * 
	 * @param valor Recebe um double como parametro.
	 */
	public void setValor(double valor){
		this.valor = valor;
	}
	
	/**
	 * Retorna o valor do Carro.
	 * 
	 * @return Retorna um double.
	 */
	public double getValor(){
		return this.valor;
	}
}
