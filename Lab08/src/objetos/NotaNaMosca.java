/*
 * Aluno 1: Matheus Clemente Pereira
 * Aluno 2: Jeffiti Mucio
 * Aluno 3: Carlos Vinicius
 */

package objetos;

import java.util.Date;

import interfaces.naMosca;

public class NotaNaMosca implements naMosca{

	private int nota;
	private String comentario;
	private final int NUM_MAXIMO_DE_CARACTERES = 140;
	private final int NOTA_MINIMA = -2;
	private final int NOTA_MAXIMA = 2;
	private Date data;
	
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
	public void setData(Date data) throws Exception {
		if(data.getYear() < 2017){
			throw new Exception("Data inválida.");
		}else{
			this.data = data;
		}
	}

	@Override
	public int getNota() {
		return this.nota;
	}

	@Override
	public String getComentario() {
		return this.comentario;
	}

	@Override
	public Date getData() {
		return this.data;
	}
}
