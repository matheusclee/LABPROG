/*
 * Aluno 1: Matheus Clemente Pereira
 * Aluno 2: Carlos Vinicius
 * Aluno 3: Jeffiti Mucio
 */
package lab07;

public class Medicos extends Contribuinte{

	private double congressos;
	private int numPacientes;
	private double riquezaMedicos;
	private int numMedicos;
	
	/**
	 * Construtor da classe Medicos.
	 * @param nome Recebe uma String.
	 * @param cod Recebe uma String.
	 * @param valorCasa	Recebe um double, se maior que zero, medico tem casa.
	 * @param valorCarro Recebe um double, se maior que zero, medico tem carro.
	 * @param numPacientes Recebe um inteiro.
	 * @param desCongressos Recebe um double.
	 */
	public Medicos(String nome, String cod, double valorCasa, double valorCarro, int numPacientes, double desCongressos) {
		super(nome, cod, valorCasa, valorCarro);
		setNumPacientes(numPacientes);
		setDespesasCongressos(desCongressos);
		riquezaMedicos = this.riquezaGeral(riquezaMedicos);
		numMedicos++;
	}
	
	/**
	 * Metodo que adiciona o valor das despesas com congressos do professor.
	 * Retorna true se o valor for adicionado.
	 * @param valor Recebe um double.
	 * @return Retorna um boolean.
	 */
	public boolean setDespesasCongressos(double valor) {
		if(valor > 0){
			congressos = valor;
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna o valor das despesas com congressos do medico.
	 * 
	 * @return Retorna um double.
	 */
	public double getDespesasCongressos() {
		return congressos;
	}

	/**
	 * Retorna o numero de pacientes atendidos pelo medico.
	 * @return Return um inteiro.
	 */
	public int getNumPacientes() {
		return numPacientes;
	}

	/**
	 * Recebe o numero de pacientes do medico.
	 * Retorna true se o numero de pacientes for adicionado.
	 * @param numPacientes Recebe um inteiro.
	 * @return Retorna um boolean.
	 */
	public boolean setNumPacientes(int numPacientes) {
		if(numPacientes > 0){
			this.numPacientes = numPacientes;
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna o valor da tributacao do Medico.
	 * @return Retorna um double.
	 */
	public double tributacao() {
		return numPacientes*10;
	}
	
	/**
	 * Retorna o valor de descontos do medico.
	 * @return Retorna um double.
	 */
	public double descontos() {
		return congressos;
	}
	
	/**
	 * Metodo que faz analise se o sinal de riqueza do Medico é menor ou maior que o sinal médio de riqueza de sua classe.
	 * @return Retorna boolean
	 */
	public boolean sinalDeRiquezaExterior(){
		return this.mediaRiqueza(riquezaMedicos, numMedicos);
	}
}
