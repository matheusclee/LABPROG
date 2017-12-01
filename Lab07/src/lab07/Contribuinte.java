/*
 * Aluno 1: Matheus Clemente Pereira
 * Aluno 2: Carlos Vinicius
 */

package lab07;

import java.util.ArrayList;
import java.util.List;

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
	private List<Casa> casas = new ArrayList<Casa>();
	private List<Carro> carros = new ArrayList<Carro>();
	private List<String> codigos = new ArrayList<String>();
	
	/**
	 * Construtor da Classe AbstrataContribuinte.
	 * 
	 * @param nome Recebe o nome do contribuinte.
	 * @param cod Recebe o codigo do contribuinte.
	 * @param temCasa Recebe false ou true se o contribinte tiver Casa.
	 * @param temCarro Recebe false ou true se o contrbuinte river Carro.
	 * 
	 */
	public Contribuinte(String nome, String cod, double valorCasa, double valorCarro){
		setNome(nome);
		setCodContribuinte(cod);
		if(valorCasa > 0){
			setCasas(valorCasa);
		}
		if(valorCarro > 0){
			setCarros(valorCarro);
		}
		numDeContribuintes++;
	}
	
	/**
	 * Adiciona um carro ao contribuinte.
	 * 
	 * @param valor Recebe o valor do Carro.
	 */
	public void setCarros(double valor) {
		Carro carro = new Carro(valor);
		carros.add(carro);
	}

	/**
	 * Adiciona uma casa ao Contribuinte.
	 * 
	 * @param valor Recebe o valor do Carro.
	 */
	private void setCasas(double valor) {
		Casa casa = new Casa(valor);
		casas.add(casa);
	}
	
	/**
	 * Adiciona o nome do contribuinte.
	 * 
	 * @param nome Recebe uma String com o nome do Contribuinte.
	 */
	public void setNome(String nome){
		this.nome = nome;
	}
	
	/**
	 * Retorna o nome do contribuinte.
	 * 
	 * @return Retorna uma String.
	 */
	public String getNome(){
		return nome;
	}
	
	/**
	 * Retorna True caso o codigo informado esteja disponivel. Retorna False caso nao esteja disponivel.
	 * 
	 * @param cod Recebe uma String como codigo;
	 * @return Retorna um boolean.
	 */
	private boolean setCodContribuinte(String cod){
		if(!codigos.contains(cod)) {
			codContribuinte = cod;
			codigos.add(cod);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Retorna o codigo do contribuinte.
	 * 
	 * @return Retorna uma String.
	 */
	public String getCodContribuinte(){
		return codContribuinte;
	}
	
	/**
	 * Retorna a quantidade de contribuintes cadastrados.
	 * 
	 * @return Retorna um inteiro.
	 */
	public int getNumdeContribuintes(){
		return numDeContribuintes;
	}
	
	/**
	 * Retorna o valor total dos bens do contribuinte.
	 * 
	 * @return Retorna um double.
	 */
	public double valorAcumuladoBens(){
		double aux = 0;
		for(int i = 0; i < casas.size(); i++){
			aux+=casas.get(i).getValor();
		}
		
		for(int i = 0; i < carros.size(); i++){
			aux+=carros.get(i).getValor();
		}
		
		return aux;
	}
	
	protected double riquezaGeral(double riquezaProfissao) {
		return riquezaProfissao += this.valorAcumuladoBens();
	}
	
	protected boolean mediaRiqueza(double riquezaProfissao, int numProfissionais) {
		if(this.valorAcumuladoBens() < (riquezaProfissao/numProfissionais)*1.5) {
			return true;
		}
		return false;
	}
}
