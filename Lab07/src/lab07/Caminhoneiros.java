/*
 * Aluno 1: Matheus Clemente Pereira
 * Aluno 2: Carlos Vinicius
 * Aluno 3: Jeffiti Mucio
 */
package lab07;

public class Caminhoneiros extends Rodoviarios{
	
	private double toneladas;
	private int LIMITE = 10;
	private double riquezaCaminhoneiros;
	private int numCaminhoneiros;

	/**
	 * Contrutor da classe Caminhoneiro.
	 * @param nome Recebe uma String.
	 * @param cod Recebe uma String.
	 * @param valorCasa Receve um double, se maior que zero, o caminhoneiro tem casa.
	 * @param valorCarro Recebe um double, se maior que zero, o caminhoneiro tem Carro.
	 * @param kmRodados Recebe um double.
	 * @param numToneladas Recebe um double.
	 */
	public Caminhoneiros(String nome, String cod, double valorCasa, double valorCarro, double kmRodados, double numToneladas) {
		super(nome, cod, valorCasa, valorCarro, kmRodados);
		setToneladas(numToneladas);
		riquezaCaminhoneiros = riquezaGeral(riquezaCaminhoneiros);
		numCaminhoneiros++;
	}
	
	/**
	 * Adiciona o numero de quilometros rodados pelo caminhoneiro.
	 * Recebe um double.
	 * Retorna um true, caso o valor tenha sido adicionado.
	 * @param num Recebe um double.
	 * @return Retorna um boolean.
	 */
	public boolean setToneladas(double num){
		if(num > 0){
			toneladas = num;
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna o valor de quilometros rodados pelo caminhoneiro.
	 * 
	 * @return Retorna um double.
	 */
	public double getToneladas(){
		return toneladas;
	}
	
	/**
	 * Retorna o valor da tributacao do caminhoneiro.
	 * 
	 * @return Retorna um double.
	 */
	public double tributacao(){
		if(toneladas <= LIMITE){
			return 500;
		}else{
			return 500 + ((toneladas - LIMITE)*100);
		}
	}
	
	/**
	 * Metodo que faz analise se o sinal de riqueza do caminhoneiro é menor ou maior que o sinal médio de riqueza de sua classe.
	 * @return Retorna boolean
	 */
	public boolean sinalExteriorDeRiqueza(){
		return this.mediaRiqueza(riquezaCaminhoneiros, numCaminhoneiros);
	}

}
