


/* ALUNO 1: MATHEUS CLEMENTE PEREIRA
 * ALUNO 2: EVELIN FLORENÇO DA SILVA
 * ALUNO 3: JEFFITI MUCIO
 */

package lab04;

/**
 * Classe representada para usar uma Progressao Aritmetica.
 *
 * @version 1.0
 * 
 * @author Matheus/Evelin/Jeffiti
 * 
 */
public class ProgressaoAritmetica {
	
	private int primeiro, razao, atual;
	
	/**
	 * Construtor de uma progressao aritmetica.
	 *
	 * @param primeiro - Primeiro termo da progressao aritmetica.
	 * 			
	 * @param razao - A razão da progressao aritmetica.
	 * 
	 */
	public ProgressaoAritmetica(int primeiro, int razao){
		this.primeiro = primeiro;
		this.atual = primeiro;
		this.razao = razao;
	}
	
	/**
	 * Recupera a razao da progressao aritmetica.
	 *
	 * @return Retorna a razao da progressao aritmeticaa.
	 * 
	 */
	public int getRazao(){
		return this.razao;
	}
	
	/**
	 * Calcula o proximo termo da progressao aritmetica. O termo gerado passa a ser o termo atual da progressao.
	 * 			
	 * @return Retorna o proximo termo da progressao aritmetica
	 * 
	 */
	public int proximo(){
		this.atual += this.razao;
		return this.atual;
	}
	
	/**
	 * Reinicia a progressao aritmetica para o seu primeiro termo. O primeiro termo passa a ser o termo atual da progressao.
	 * 			
	 * @return Retorna o primeiro termo da progressao aritmetica
	 * 
	 */
	public int primeiro(){
		this.atual = this.primeiro;
		return this.atual;
	}
	
	/**
	 * Calcula o n-esimo termo da progessao aritmetica. "n" representa a posicao do termo na progessao (comecando de 1). Caso seja fornecido um valor de n <= 0, deve ser retornado o primeiro termo da progressao. O termo gerado passa a ser o termo atual da progressao.
	 * 			
	 * @param n - O n-esimo termo a ser calculado
	 * 
	 * @return O n-esimo termo calculado, ou o primeiro termo, se n <= 0
	 * 
	 */
	public int termo(int n){
		
		if(n <= 0){
			return primeiro();
		}else{
			this.atual = this.primeiro + ((n-1)*this.razao);
			return this.atual;
		}
	}
	
	
	/**
	 * Gera os "n" primeiros termos (1 .. n) da progressao aritmetica em uma String. Caso seja fornecido um valor de n <= 0, deve ser retornado o primeiro termo da progressao. O ultimo termo gerado passa a ser o termo atual da progessao.
	 * 			
	 * @param n - A quantidade de termos a ser gerada da progressao 	
	 * 
	 * @return a string (formato: [termo1, termo2, ..., termon] representando os termos gerados da progressao
	 * 
	 */
	public java.lang.String geraTermos(int n){
		
		if(n <= 0){
			primeiro();
			return "[" + this.primeiro +"]";
		}else{
			
			StringBuilder termos = new StringBuilder();
			termos.append("[");
			for (int i = 1; i <= n; i++){
				termos.append(termo(i));
				if (i != n)
					termos.append(", ");
			}
			
			termos.append("]");
			
			return termos.toString();
		}
		
		
		
	}
	
}
