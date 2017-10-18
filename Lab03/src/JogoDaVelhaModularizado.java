import java.util.Scanner;

/*
 * Aluno 1: MATHEUS CLEMENTE PEREIRA
 * Aluno 2: EVELIN FLORENÇO DA SILVA
 * Aluno 3: CARLOS VINICIUS NASCIMENTO LIRA
 */

public class JogoDaVelhaModularizado {
	private static Scanner sc = new Scanner (System.in);

	public static void main(String args[]){
		
		final int SAIR = 0;
		
		int op = 1;
		do{
			inicioJogo();
			
			System.out.print("\nPARA SAIR DIGITE '0' \nPARA CONTINUAR DIGITE QUALQUER INTEIRO: ");
			op = sc.nextInt();
		}while(op  != SAIR);
		
	}
	
	private static void inicioJogo(){
		char tabuleiro[][] = new char[3][3];
		final char O='O';
		final char X='X';
		final int NUM_JOGADAS = 9;
	    int jogada=0;

	    preencheTabuleiro(tabuleiro);
	    
	    imprimeTelaPrincipal(tabuleiro);

	    while(jogada<=NUM_JOGADAS)
	        {
	    	recebeArgumentos(tabuleiro, jogada, O, X);
	    	jogada++;

	        if (verificaVencedor(tabuleiro, jogada, O, X)){
	        	break;
	        }

	    }
	}


	private static void preencheTabuleiro(char tabuleiro[][]){
		final int LIMITE_LINHA_COLUNA = 3;
		
		for(int i=0;i<LIMITE_LINHA_COLUNA;i++)
	        for(int j=0;j<LIMITE_LINHA_COLUNA;j++)
	            tabuleiro[i][j]=' ';
	}
	
	private static boolean preencheTabuleiro(char tabuleiro[][], int jogada, int i, int j, char O, char X){
		if(tabuleiro[i-1][j-1]==' ')
        {
            if((jogada%2)==1)tabuleiro[i-1][j-1]=X;
            else tabuleiro[i-1][j-1]=O;
            return true;
        }
		return false;
	}
	
	private static void imprimeTabuleiro(char tabuleiro[][]){
		final int LIMITE_LINHA_COLUNA = 3;
		
		for(int i=0;i<LIMITE_LINHA_COLUNA;i++)
        {
        	System.out.print(tabuleiro[i][0]+"|"+tabuleiro[i][1]+"|"+tabuleiro[i][2]);
            if(i<LIMITE_LINHA_COLUNA-1)
            {
            	System.out.print("\n------\n");
            }
        }
	}
	
	private static void imprimeTelaPrincipal(char tabuleiro[][]){
		System.out.print("  JOGO DA VELHA \n");
        
        imprimeTabuleiro(tabuleiro);
        
	}
	
	private static void recebeArgumentos(char tabuleiro[][], int jogada, char O, char X){
		int i, j;
		System.out.println("\nINSIRA AS COORDENADAS");
        if((jogada%2)==1)System.out.print("PLAYER 2\nLINHA: ");
        else System.out.print("PLAYER 1\nLINHA: ");
        
        sc = new Scanner (System.in);
		i = sc.nextInt();
		if (i>3 && i<1){
			recebeArgumentos(tabuleiro, jogada, O, X);
		}
		
        System.out.print("COLUNA: ");
        j = sc.nextInt();
        if (j>3 && j<1){
			recebeArgumentos(tabuleiro, jogada, O, X);
		}
        
        if (preencheTabuleiro(tabuleiro, jogada, i, j, O, X)){
        	imprimeTelaPrincipal(tabuleiro);
        }else{
        	imprimeTelaPrincipal(tabuleiro);
        	recebeArgumentos(tabuleiro, jogada, O, X);
        }
        
	}

	private static boolean verificaLinhas(char tabuleiro[][], char caractere, int i){

		while (i<3){
			if((tabuleiro[i][0] == caractere) && (tabuleiro[i][1] == caractere) && (tabuleiro[i][2]== caractere)){
				return true;
			}else{
				i++;
				verificaLinhas(tabuleiro, caractere, i);
			}
			
		}
		return false;
	}

	private static boolean verificaColunas(char tabuleiro[][], char caractere, int i){

		while (i<3){
			if((tabuleiro[0][i] == caractere) && (tabuleiro[1][i] == caractere) && (tabuleiro[2][i] == caractere)){
				return true;
			}else{
				i++;
				verificaColunas(tabuleiro, caractere, i);
			}
		}
		return false;
	}

	public static boolean verificaDiagonais(char tabuleiro[][], char caractere){

		return ((tabuleiro[0][0]==caractere && tabuleiro[1][1]==caractere && tabuleiro[2][2]==caractere)||
		           (tabuleiro[0][2]==caractere && tabuleiro[1][1]==caractere && tabuleiro[2][0]==caractere));
	}
	
	private static boolean verificaTabuleiro(char tabuleiro[][], char caractere){
		
		return ((verificaLinhas(tabuleiro, caractere, 0))||
		           (verificaColunas(tabuleiro, caractere, 0))||
		           (verificaDiagonais(tabuleiro, caractere)));
	}
	
	private static boolean verificaVencedor(char tabuleiro[][], int jogada, char O, char X){
		final int NUM_JOGADAS = 9;
		if(verificaTabuleiro(tabuleiro, O))
        {
        	System.out.print("\nJogador 1, VOCE VENCEU!!!");
            return true;
        }
        if(verificaTabuleiro(tabuleiro, X))
        {
        	System.out.print("\nJogador 2, VOCE VENCEU!!!");
        	return true;
        }

        if(jogada==NUM_JOGADAS)
        {
        	System.out.print("\nPARTIDA EMPATADA");
        	return true;
        }
        
        return false;
	}
	
}