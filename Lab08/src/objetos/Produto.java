/*
 * Aluno 1: Matheus Clemente Pereira
 * Aluno 2: Jeffiti Mucio
 * Aluno 3: Carlos Vinicius
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
	
	/**
	 * Metodo que imprime as avaliaçoes no modo Estrategia Simples.
	 */
	public void imprimirEstrategiaSimples(){
		if(notas.size() > 1){
			notaMedia(notas.size());
			
			int menorNota = -1;
			int maiorNota = -1;
			for(int i = 0; i < notas.size(); i++){
				if(notas.get(i).getNota()>notas.get(i+1).getNota()){
					maiorNota = i;
				}
				if(notas.get(i).getNota() < notas.get(i+1).getNota()){
					menorNota = i;
				}
			}
			System.out.print(notas.get(maiorNota).getData());
			System.out.println(notas.get(maiorNota).getComentario());
			System.out.print(notas.get(menorNota).getData());
			System.out.println(notas.get(menorNota).getComentario());
			
		}else{
			System.out.println("Nota Na Mosca: " + notas.get(0).getNota());
			System.out.print(notas.get(0).getData());
			System.out.println(notas.get(0).getComentario());
		}
		
	}
	
	/**
	 * Metodo que imprime as avaliacoes no modo Estrategia Sazonal.
	 */
	public void imprimirEstrategiaSazonal(){
		if(notas.size() > 1){
			notaMedia(notas.size());
			
			//ultimo comentario
			System.out.print(notas.get(notas.size()-1).getData());
			System.out.println(notas.get(notas.size()-1).getComentario());
			
			//penultimo comentario
			System.out.print(notas.get(notas.size()-2).getData());
			System.out.println(notas.get(notas.size()-2).getComentario());
		}else{
			System.out.println("Nota Na Mosca: " + notas.get(0).getNota());
			System.out.print(notas.get(0).getData());
			System.out.println(notas.get(0).getComentario());
		}
	}
	
	private void notaMedia(int numNotas){
		int media = 0;
		for(int i = 0; i < numNotas; i++){
			media += notas.get(i).getNota();
		}
		System.out.println("Nota Na Mosca: " + media/numNotas);
	}
	

}
