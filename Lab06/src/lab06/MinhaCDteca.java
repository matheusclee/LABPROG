/* 
 * ALUNO 1: Matheus Clemente Pereira
 * ALUNO 2: Carlos Vinicius N Lira
 */


package lab06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe representada para representar uma biblioteca de CD's.
 * 
 * @version 1.0
 * @author Matheus Clemente/Carlos Vinicius
 *
 */

public class MinhaCDteca {

	private List<CD> armazenaCDs = new ArrayList();
	
	/**
	 * Método que irá adicionar na biblioteca um objeto do tipo CD.
	 * 	 
	 * @param disco Objeto que será armazenado na biblioteca de CD's.
	 */
	public void adicionaCD(CD disco){
		armazenaCDs.add(disco);
	}
	
	
	/**
	 * Método que irá adicionar todos os objetos de uma colecao na bibilioteca de CD's.
	 * 
	 * @param colecao Parametro que recebe uma colecao do tipo MinhaCDteca.
	 */
	public void adicionaCDs(MinhaCDteca colecao){
		for(int i = 0; i < colecao.numeroDeCDs(); i++){
			adicionaCD(colecao.getI(i));
		}
		
	}
	
	/**
	 * Método que irá remover um objeto da biblioteca.
	 * 
	 * @param disco Recebe um parametro do tipo CD.
	 * 
	 * @return Retorna o objeto removido ou retorna 'null' caso o objeto nao exista na biblioteca.
	 */
	public CD removeCD(String titulo){
		CD aux = pesquisaCD(titulo);
		if(aux == null){
			return null;
		}else{
			armazenaCDs.remove(aux);
			return aux;
		}
		
	}
	
	/**
	 * Remove uma coleção de CD's da biblioteca, mesmo que a biblioteca tenha apenas um elemento da coleção passada pelo parametro.
	 * 
	 * @param colecao Recebe uma colecao de CD's.
	 * @return Retorna True ou False.
	 */
	public boolean removeCDs(MinhaCDteca colecao){
		boolean status = false;
		for(int i = 0; i < colecao.numeroDeCDs(); i++){
			CD aux = colecao.getI(i);
			if(removeCD(colecao.getI(i).getTitulo()) == aux){
				status = true;
			}
		}
		return status;
	}
	
	/**
	 * Metodo para retornar um objeto em uma determinada posição da biblioteca.
	 * 
	 * @param i Recebe uma posicao do tipo inteiro.
	 * 
	 * @return Retorna o elemento que esta na posicao informada.
	 */
	public CD getI(int i){
		if(i < armazenaCDs.size()){
			return armazenaCDs.get(i);
		}
		
		return null;
	}
	
	/**
	 * Metodo para pesquisar se existe o objeto na biblioteca. 
	 * 
	 * @param titulo Recebe uma String como parametro.
	 * @return Retorna o CD pesquisado ou null caso nao exista. 
	 */
	public CD pesquisaCD(String titulo){
		for(int i = 0; i < numeroDeCDs(); i++){
			if(titulo == armazenaCDs.get(i).getTitulo()){
				return armazenaCDs.get(i);
			}
		}
		
		return null;
	}

	/**
	 * Metodo que retorna a quantidade de CD's armazenados na biblioteca.
	 * 
	 * @return Retorna um inteiro.
	 */
	public int numeroDeCDs() {
		if(armazenaCDs.isEmpty()){
			return 0;
		}
		return armazenaCDs.size();
	}
	
	/**
	 * Metodo que compara duas colecoes do tipo MinhaCDteca e são iguas se ambas tiverem os mesmos CD's.
	 * 
	 * @param colecao Recebe uma colecao de CD's.
	 * @return Retorna True ou False.
	 */
	public boolean equals(MinhaCDteca colecao){
		boolean status = false;
		if(colecao.numeroDeCDs() <= numeroDeCDs()){
			for(int i = 0; i < colecao.numeroDeCDs(); i++){
				if(pesquisaCD(colecao.getI(i).getTitulo()) == colecao.getI(i)){
					status = true;
				}else{
					status = false;
				}
			}
		}else{
			for(int i = 0; i < numeroDeCDs(); i++){
				if(colecao.pesquisaCD(getI(i).getTitulo()) == getI(i)){
					status = true;
				}else{
					status = false;
				}
			}
		}
		
		return status;
	}
	
	/**
	 * Retorna os dados dos CD's que estao na biblioteca.
	 */
	@Override
	public String toString(){
		StringBuilder info = new StringBuilder();
		for(int i = 0; i < numeroDeCDs(); i++){
			info.append("Titulo: " + getI(i).getTitulo() + " Artista: " + getI(i).getArtista() + "\n");
		}
		return info.toString();	
	}
}
