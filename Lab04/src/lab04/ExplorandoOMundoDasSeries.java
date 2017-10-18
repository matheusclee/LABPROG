package lab04;

import java.util.Scanner;

/**
 * Classe para manipular series matematicas (Usando uma classe ProgressaoAritmetica).
 *
 */
public class ExplorandoOMundoDasSeries {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int op;
		final int SAIR = 6;
		
		do{
			opcoes(); //imprime opcoes para o usuário
			op = sc.nextInt();
			switch(op){
			case 1:
				System.out.print("Insira o primeiro termo: ");
				int primeiro = sc.nextInt();
				System.out.print("Insira a razao: ");
				int razao = sc.nextInt();
				
				ProgressaoAritmetica pa = new ProgressaoAritmetica(primeiro, razao);
				continue;
			
			case 2:
				System.out.print("Insira o primeiro termo: ");
				continue;
				
			case 3:
				
				continue;
				
			case 4:
				
				continue;
				
			case 5:
				
				continue;
				
			case 6:
				continue;
			default:
				System.out.println("Opção inválida.\n");
			}
		}while(op != SAIR);
	
	}
	
	public static void opcoes(){
		System.out.print(  "1. Para criar uma progressão aritmética;\n"
						+ "2. Para criar uma série de Fibonacci;\n"
						+ "3. Para ver o termo 'n' da sua PA;\n"
						+ "4. Para ver o termo 'n' da serie de Fibonacci;\n"
						+ "5. Para mostrar os 'n' primeiros termos da sua PA e da serie de Fibonacci;\n"
						+ "6. Para sair.\n");
	}

}
