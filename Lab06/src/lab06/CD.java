/* 
 * ALUNO 1: Matheus Clemente Pereira
 * ALUNO 2: Carlos Vinicius N Lira
 * ALUNO 3: Jeffiti Mucio
 */

package lab06;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe representada para usar um CD
 * 
 * @version 1.0
 * @author Matheus Clemente/Carlos Vinicius
 *
 */
public class CD {
	
	private String artista;
	private String titulo;
	private String trilhaPrincipal;
	private int M;
	private List<String> faixas = new ArrayList();
	private final int VAZIO = 0;
	private final int NUM_FAIXAS_PADRAO = 10;
	
	/**
	 * Construtor de um CD
	 * @param titulo - Titulo do CD
	 * @param artista - Artista do CD
	 * @param num_faixas - Quantidade de musicas no CD
	 * @throws Exception - O numero de faixas nao pode ser menor que 1
	 */
	public CD(String titulo, String artista, int num_faixas) throws Exception {
		this.titulo = titulo;
		this.artista = artista;
		setM(num_faixas);
	}
	
	/**
	 * Construtor de um CD
	 * @param titulo - Titulo do CD
	 * @param artista - Artista do CD
	 */
	public CD(String titulo, String artista){
		this.titulo = titulo;
		this.artista = artista;
		M = NUM_FAIXAS_PADRAO;
	}
	
	
	private void setM(int num) throws Exception{
		if(num < 1){
			throw new Exception("Parametros passados estao incorretos");
		}else{
			M = num;
		}
	}
	/**
	 * Recupera o artista do CD
	 * @return Retorna o artista
	 */
	public String getArtista(){
		return artista;
	}
	
	/**
	 * Recupera o Titulo do CD
	 * @return Retorna o titulo
	 */
	public String getTitulo(){
		return titulo;
	}
	
	/**
	 * Recupera a Trilha Principal
	 * @return Retorna a trilha principal
	 */
	public String getTrilhaPrincipal(){
		return trilhaPrincipal;
	}
	
	/**
	 * Escolhe a Trilha Principal do CD
	 * @param faixa - Passa a trilha principal
	 * @throws Exception - A trilha informada deve existir no CD
	 */
	public void setTrilhaPrincipal(String faixa) throws Exception{
		if(faixas.contains(faixa)){
			trilhaPrincipal = faixa;
		}else{
			throw new Exception("Faixa informada nao existe.");
		}
	}
	
	/**
	 * Recupera a quantida de faixas informada
	 * @return - Retorna quantidade de faixas
	 */
	public int getM(){
		return M;
	}
	
	/**
	 * Adiciona musicas ao CD
	 * @param faixa - musica que sera adicionada
	 * @return - Retorna true ou false
	 */
	public boolean setFaixas(String faixa){
		if(this.faixas.size() < M){
			this.faixas.add(faixa);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Recupera a musica que esta na posicao informada, se nao existir retorna null
	 * @param i - posicao desejada
	 * @return - retorna o elemento da posicao i ou retorna null
	 */
	public String getI(int i) {
		if(i < faixas.size()){
			return faixas.get(i);
		}
		
		return null;
	}
	
	/**
	 * Recupera informacoes do CD
	 */
	@Override
	public String toString(){
		
		StringBuilder info = new StringBuilder();
		info.append("Titulo: " + titulo
				+ "\nArtista: " + artista);
		if(faixas.size() > VAZIO){
			if(this.getTrilhaPrincipal() == null){
				info.append("\nTrilha Principal: Nao existe");
			}else{
				info.append("\nTrilha Principal: " + trilhaPrincipal);
			}
			info.append("\nFaixas: ");
			for(int i = 0; i < faixas.size(); i++){
				info.append("\n" + i+1 + " - " + this.getI(i));
			}
		}else{
			info.append("\nTrilha Principal: Nao Existe"
					+ "\nFaixas:\nVazio");
			
		}
		
		return info.toString();
	}
	
	/**
	 * Compara se dois CDs sao iguais
	 * @param disco - Parametro que recebe um cd para ser comparado
	 * @return - Retorna true ou false
	 */
	public boolean equals(CD disco){
		if(disco.getArtista() == this.getArtista() && disco.getTitulo() == this.getTitulo()){
			return true;
		}
		return false;
	}

}
