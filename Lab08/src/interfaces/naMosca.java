package interfaces;

public interface naMosca {
	
	public void setNota(int nota) throws Exception; //nota deve ser -2, -1, 0, 1 ou 2.
	public void setComentario(String comentario) throws Exception; //comentario deve ter no maximo 140 caracteres
	public void setData(int dia, int mes, int ano) throws Exception;//adiciona a data
	public int getNota(); //retorna a nota 
	public String getComentario(); //retorna o comentario
}