package lab04;

public class Fibonacci {
	
	private int atual;
	
	public Fibonacci(){
		this.atual = 1;
	}
	
	public int calculaFibonacci(int numTermos){
		if (numTermos < 2){
			return numTermos;
		}else{
			return calculaFibonacci(numTermos-1) + calculaFibonacci(numTermos-2);
		}
	}
	
	public int proximo(){
		
	}
	
	public int primeiro(){
		
	}
	
	public int termo(int numTermo){
		
	}

}
