/*
 * Aluno 1: Matheus Clemente Pereira
 * Aluno 2: Adenou Dantas
 * Aluno 3: Jeffiti Mucio
 * Aluno 4: Carlos Vinicius - Professor autorizou por e-mail incluir um 4º membro.
 * 
 */

package objetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Produto {

	private String nome;
	private List<NotaNaMosca> notas = new ArrayList();
	
	/**
	 * Metodo que incrementa o nome do produto.
	 * 
	 * @param nome 
	 * 		Recebe uma String.
	 */
	public void setNome(String nome){
		this.nome = nome;
	}
	
	/**
	 * Metodo que retorna o nome do produto.
	 * 
	 * @return
	 * 		Retorna uma String.
	 */
	public String getNome(){
		return this.nome;
	}
	
	/**
	 * Metodo que adiciona uma avaliaçao ao produto.
	 * @param nota
	 * 		Recebe um inteiro.
	 * @param comentario
	 * 		Recebe uma String.
	 * @param data
	 * 		Recebe um objeto do tipo data.
	 * @throws Exception 
	 * 		Retorna uma Exception caso houve algum parametro invalido.
	 */
	public void adicionaNota(int nota, String comentario, Date data) throws Exception{
		NotaNaMosca avaliacao = new NotaNaMosca();
		avaliacao.setNota(nota);
		avaliacao.setComentario(comentario);
		avaliacao.setData(data);
		
		notas.add(avaliacao);
	}
	
	public void imprimirSimples(){
		
	}
	
	public String toString(){
		
		return nome;
		
	}

}
