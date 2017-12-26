/*
 * Aluno 1: Matheus Clemente Pereira
 * Aluno 2: Jeffiti Mucio
 * Aluno 3: Carlos Vinicius
 */

package interfaces;

import java.util.Date;

public interface naMosca {
	
	/**
	 * Metodo que adiciona uma nota ao produto, a nota deve ser um inteiro entre -2 e 2.
	 * 
	 * @param nota
	 * 		Recebe um inteiro entre -2 e 2.
	 * @throws Exception
	 * 		Retorna uma Exception se o parametro passado nao for valido.
	 */
	public void setNota(int nota) throws Exception; //nota deve ser -2, -1, 0, 1 ou 2.
	
	/**
	 * Metodo que adiciona um comentario ao produto, o mesmo deve ter no maximo 140 caracteres.
	 * @param comentario
	 * 		Recebe uma String.
	 * @throws Exception
	 * 		Retorna uma Exception se a parametro passado for invalido.
	 */
	public void setComentario(String comentario) throws Exception; //comentario deve ter no maximo 140 caracteres
	
	/**
	 * Metodo que adiciona uma data ao comentario.
	 * @param data
	 * 		Recebe um objeto do tipo data.
	 * @throws Exception
	 * 		Caso a data for inválida, retorna uma Exception.
	 */
	public void setData(Date data) throws Exception;//adiciona a data
	
	/**
	 * Metodo que retorna a nota do produto.
	 * @return
	 * 		Retorna um inteiro.
	 */
	public int getNota(); //retorna a nota 
	
	/**
	 * Metodo que retorna o comentario do produto.
	 * @return
	 * 		Retorna uma String.
	 */
	public String getComentario(); //retorna o comentario
	
	/**
	 * Metodo que retorna a data da avaliação.
	 * 
	 * @return
	 * 		Retorna um objeto do tipo Date.
	 */
	public Date getData();
	
	
}