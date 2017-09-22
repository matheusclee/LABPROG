

//Aluno: Matheus Clemente Pereira

package lab02;

import java.util.Scanner;

public class PedraPapelTesoura {
	
	private static Scanner sc;


	public static void main (String[] args){
		
		int jogador1, jogador2;
		final int NUM_ELEMENTOS = 3;
		final int SAIR = -1;

		
		while(true){
			jogador1 = escolha();
			if (jogador1 == SAIR){
				break;
			}
			jogador2 = escolha();
			if (jogador2 == SAIR){
				break;
			}
			
			elemento(jogador1);
			System.out.print(" - ");
			elemento(jogador2);
			
			resultado(jogador1, jogador2, NUM_ELEMENTOS);
		}
	}
	
	private static int escolha(){
		//retorna o valor digitado pelo usuario
		
		final int MENOR_OPCAO = 1;
		final int MAIOR_OPCAO = 3;
		
		sc = new Scanner(System.in);
		
		int opcao;
		
		System.out.print("Pedra (1), Papel (2), Tesoura (3)? ");
		opcao = sc.nextInt();
		
		if((opcao >= MENOR_OPCAO) && (opcao <= MAIOR_OPCAO)){
			return opcao;
		}
		if (opcao == -1){
			return opcao;
		}
		
		return escolha();
		 
	}
	
	private static void elemento(int indice){
		//imprime o elemento escolhido pelo jogador
		
		switch (indice){
			case 1:
				System.out.print("PEDRA");
				break;
				
			case 2:
				System.out.print("PAPEL");
				break;
				
			case 3:
				System.out.print("TESOURA");
				break;
				
		}	
	}
	

	private static void resultado(int i, int j, int n){
		// 'i' recebe o valor do jogador 1
		// 'j' recebe o valor do jogador 2
		// 'n' recebe o numero de elementos da partida
		
		int res = Math.abs((n+i-j)%n);
		
		if((res > 0) && (res<=(n/2))){
			System.out.println("\nJogador 1 Ganhou!");
		}
		if(res>(n/2)){
			System.out.println("\nJogador 2 Ganhou!");
		}
		if(res == 0){
			System.out.println("\nEmpate!");
		}
	}
}