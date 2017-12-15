/*
 * Aluno 1: Matheus Clemente Pereira
 * Aluno 2: Carlos Vinicius
 */
package lab07;

public abstract class Rodoviarios extends Contribuinte{

	private double kmRodados;
	
	/**
	 * Construtor da classe Rodoviarios.
	 * @param nome Recebe uma String.
	 * @param cod Recebe uma String.
	 * @param valorCasa Recebe um double, se maior que zero, tem casa.
	 * @param valorCarro Recebe um double, se maior que zero, tem carro.
	 * @param kmRodados Recebe um double.
	 */
	public Rodoviarios(String nome, String cod, double valorCasa, double valorCarro, double kmRodados) {
		super(nome, cod, valorCasa, valorCarro);
		setKmRodados(kmRodados);
	}
	
	/**
	 * Adiciona o numero de quilometros rodados.
	 * Retorna true se o numero de quilometros for adicionado.
	 * @param num Recebe um double.
	 * @return Retorna um boolean.
	 */
	public boolean setKmRodados(double num){
		if(num > 0){
			kmRodados = num;
			return true;	
		}
		return false;
	}
	
	/**
	 * Retorna o numero de quilometros rodados.
	 * @return Retorna um double;
	 */
	public double getKmRodados(){
		return kmRodados;
	}
	
	/**
	 * Retorna o valor de descontos.
	 * @return Retorna um double.
	 */
	public double descontos(){
		return kmRodados*0.01;
	}
}
