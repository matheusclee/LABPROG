import java.util.Scanner;

public class MinMax {

	private static Scanner sc;

	public static void main(String[] args){
		
		final int NUM_DE_REPETICOES = 3;
		int minimo = Integer.MAX_VALUE;
		int maximo = Integer.MIN_VALUE;
		int num;
		
		sc = new Scanner(System.in);
		
		for(int i=0; i<NUM_DE_REPETICOES; i++){
			
			System.out.print("Digite um n�mero inteiro: ");
			num = sc.nextInt();
			
			if(num < minimo){
				minimo = num;
			}
			if(num > maximo){
				maximo = num;
			}
		}
		
		System.out.println("O maior n�mero �: "+ maximo + "\nO menor n�mero �: "+ minimo);
	}
}
