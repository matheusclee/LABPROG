/*
 * Aluno 1: Matheus Clemente Pereira
 * Aluno 2: Carlos Vinicius
 */
package lab07;

public class Taxista extends Rodoviarios {
	
	private int numPassageiros;
	private double riquezaTaxistas;
	private int numTaxistas;

	/**
	 * Construtor da classe Taxista.
	 * 
	 * @param nome Recebe uma String.
	 * @param cod Recebe uma String.
	 * @param valorCasa Recebe um double, se maior que zero, o taxista tem casa.
	 * @param valorCarro Recebe um double, se maior que zero, o taxista tem carro.
	 * @param kmRodados Recebe um double.
	 * @param passageiros Recebe um inteiro.
	 */
	public Taxista(String nome, String cod, double valorCasa, double valorCarro, double kmRodados, int passageiros) {
		super(nome, cod, valorCasa, valorCarro, kmRodados);
		setNumPassageiros(passageiros);
		riquezaTaxistas = this.riquezaGeral(riquezaTaxistas);
		numTaxistas++;
	}

	/**
	 * Retorna o valor da tributacao do taxista.
	 * @return Retorna um double.
	 */
	public double tributacao(){
		return numPassageiros*0.5;
	}
	
	/**
	 * Adiciona o numero de passageiros.
	 * 
	 * @param num Recebe um inteiro.
	 * @return Retorna um boolean.
	 */
	public boolean setNumPassageiros(int num){
		if(num > 0){
			numPassageiros = num;
			return true;
		}
		return false;
		
	}
	
	/**
	 * Retorna o numero de passageiros do taxista.
	 * 
	 * @return Retorna um inteiro.
	 */
	public int getNumPassageiros(){
		return numPassageiros;
	}
	
	/**
	 * Metodo que faz analise se o sinal de riqueza do Taxista é menor ou maior que o sinal médio de riqueza de sua classe.
	 * @return Retorna boolean
	 */
	public boolean sinalDeRiquezaExterior(){
		return this.mediaRiqueza(riquezaTaxistas, numTaxistas);
	}
}
