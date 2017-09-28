import java.util.Scanner;

/*
 * Aluno 1: MATHEUS CLEMENTE PEREIRA
 * Aluno 2: EVELIN FLORENÇO DA SILVA
 * Aluno 3: CARLOS VINICIUS NASCIMENTO LIRA
 */

public class JogoDaVelhaCampeonato {
	private static Scanner sc = new Scanner(System.in);
	

	public static void main(String args[]){
		final int QNT_JOGADORES = 4;
		final int SAIR = 0;
		String jogadores[] = new String[QNT_JOGADORES];	
		int vitorias[] = new int[QNT_JOGADORES];

		
		jogadores = incluiJogadores(jogadores, QNT_JOGADORES);

		int op = 1;
		do{
		    imprimirJogadores(jogadores);
			inicioJogo(jogadores, escolherJogador(1), escolherJogador(2), vitorias);
			
			System.out.print("\nPARA SAIR DIGITE '0' \nPARA CONTINUAR DIGITE QUALQUER INTEIRO: ");
			op = sc.nextInt();
			if(op == SAIR){
			    imprimeRanking(jogadores, vitorias);
			}
		}while(op  != SAIR);
		
	}
	
	private static String[] incluiJogadores(String jogadores[], int qntJogadores){
		for (int i = 0; i<qntJogadores; i++){
			System.out.print("INSIRA O NOME DO " + (i+1) + "º JOGADOR: ");
			jogadores[i] = sc.nextLine();
		}
		return jogadores;
	}
	
	private static void imprimirJogadores(String jogadores[]){
	    System.out.println("ESCOLHER JOGADORES:");
	    for(int i = 0; i < jogadores.length; i++){
	        System.out.println(i+1 + " - " + jogadores[i]);
	    }
	}
	
	private static int escolherJogador(int i){
	    System.out.print("JOGADOR " + i + ": ");
	    return (sc.nextInt() - 1);
	}

	private static void imprimeRanking(String jogadores[], int vit[]){

		int ranking[] = new int[jogadores.length];
		for(int i = 0; i<jogadores.length; i++){
			ranking[i] = i;
		}
		
		ranking = ordenarRankingInsertion(ranking, vit);
		
		
		System.out.print("\n ------RANKING------ \nJOGADOR       Nº DE VITÓRIAS\n");
		for(int i = 0; i<jogadores.length; i++){
		    System.out.println(jogadores[ranking[i]] + " " + vit[ranking[i]]);
		}
	}
	
	private static int[] ordenarRankingInsertion(int vetor[], int vit[]){
	    
	    for(int j = 2; j < vit.length; j++){
	        int chave = vit[j];
	        int i = j-1;
	        
	        while(i>0 && vit[i]>chave){
	            vit[i+1] = vit[i];
	            vetor[i+1] = i;
	            i--;
	        }
	        vit[i+1] = chave;
	    }
	    
	    return vetor;
	}
	
	private static void inicioJogo(String jogador[], int i, int j, int vitorias[]){
		char tabuleiro[][] = new char[3][3];
		final char O='O';
		final char X='X';
		final int NUM_JOGADAS = 9;
	    int jogada=0;

	    preencheTabuleiro(tabuleiro);
	    
	    imprimeTelaPrincipal(tabuleiro);

	    while(jogada<=NUM_JOGADAS)
	        {
	    	recebeArgumentos(tabuleiro, jogada, O, X, jogador, i, j);
	    	jogada++;

	        if (verificaVencedor(tabuleiro, jogada, O, X, jogador, i, j)){
	        	somaVitorias(tabuleiro, O, X, vitorias, i, j);
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
	
	private static void recebeArgumentos(char tabuleiro[][], int jogada, char O, char X, String jogadores[], int um, int dois){
		int i, j;
		System.out.println("\nINSIRA AS COORDENADAS");
        if((jogada%2)==1)System.out.print(jogadores[dois] + "\nLINHA: ");
        else System.out.print(jogadores[um] + "\nLINHA: ");
        
        sc = new Scanner (System.in);
		i = sc.nextInt();
        System.out.print("COLUNA: ");
        j = sc.nextInt();
        
        if (preencheTabuleiro(tabuleiro, jogada, i, j, O, X)){
        	imprimeTelaPrincipal(tabuleiro);
        }else{
        	imprimeTelaPrincipal(tabuleiro);
        	recebeArgumentos(tabuleiro, jogada, O, X, jogadores, um, dois);
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
	
	private static boolean verificaVencedor(char tabuleiro[][], int jogada, char O, char X, String jogadores[], int i, int j){
		if(verificaTabuleiro(tabuleiro, O))
        {
        	System.out.print("\n" + jogadores[i] + ", VOCE VENCEU!!!");
            return true;
        }
        if(verificaTabuleiro(tabuleiro, X))
        {
        	System.out.print("\n" + jogadores[j] + ", VOCE VENCEU!!!");
        	return true;
        }

        if(jogada==9)
        {
        	System.out.print("\nPARTIDA EMPATADA");
        	return true;
        }
        
        return false;
	}
	
	private static void somaVitorias(char tabuleiro[][], char O, char X, int vitorias[], int i, int j){
		if(verificaTabuleiro(tabuleiro, O))
        {
            vitorias[i]++;
        }
        if(verificaTabuleiro(tabuleiro, X))
        {
        	vitorias[j]++;
        }
        
	}
	
}