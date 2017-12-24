package objetos;
import interfaces.naMosca;;

public class Produto implements naMosca {

	private String nome;
	private int nota;
	private String comentario;
	private final int NUM_MAXIMO_DE_CARACTERES = 140;
	private final int NOTA_MINIMA = -2;
	private final int NOTA_MAXIMA = 2;
	
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
	
	
	@Override
	public void setNota(int nota) throws Exception {
		if(nota >= this.NOTA_MINIMA && nota <= this.NOTA_MAXIMA){
			this.nota = nota;
		}else{
			throw new Exception("Nota inválida.");
		}
		this.nota = nota;
		
	}

	@Override
	public void setComentario(String comentario) throws Exception {
		if(comentario.length() > this.NUM_MAXIMO_DE_CARACTERES){
			throw new Exception("Numero de caracteres maior que 140.");
		}else{
			this.comentario = comentario;
		}
		
	}

	@Override
	public void setData(int dia, int mes, int ano) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNota() {
		return this.nota;
	}

	@Override
	public String getComentario() {
		return this.comentario;
	}

}
