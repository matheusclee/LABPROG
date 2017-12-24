package interfaces;

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
	 * 
	 * @param dia
	 * @param mes
	 * @param ano
	 * @throws Exception
	 */
	public void setData(int dia, int mes, int ano) throws Exception;//adiciona a data
	
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
}