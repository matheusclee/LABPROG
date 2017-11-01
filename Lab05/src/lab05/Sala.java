package lab05;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author finaceiro
 */
public class Sala {
    
    private int numPosicoesHorizontais;
    private int numPosicoesVerticais;
    private int[][] sala;
    public static final int LIVRE = 0;
    public static final int OCUPADO = 1;
    
    public Sala (int horizontais, int verticais) throws Exception{
        if(horizontais <= 0 || verticais <= 0){
            throw new Exception("Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero");
        }else{
            this.numPosicoesHorizontais = horizontais;
            this.numPosicoesVerticais = verticais;
            this.sala = new int[this.numPosicoesHorizontais][this.numPosicoesVerticais];
            for(int i = 0; i < this.numPosicoesHorizontais; i++){
                for(int j = 0; j <this.numPosicoesVerticais; j++){
                    this.sala[i][j] = this.LIVRE; 
                }
            }
        }
    }
    
    public int getNumPosicoesHorizontais(){
        return this.numPosicoesHorizontais;
    }
    
    public int getNumPosicoesVerticais(){
        return this.numPosicoesVerticais;
    }
    
    public boolean isVazia(){
        for(int i = 0; i < getNumPosicoesHorizontais(); i++){
            for(int j = 0; j < getNumPosicoesVerticais(); j++){
                if(sala[i][j] == this.OCUPADO){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean inserirObstaculo(int i, int j){
    	if(posicaoValida(i, j)){
    		sala[i][j] = this.OCUPADO;
    		return true;
    	}
        
        return false;
    }
    
    public boolean isPosicaoLivre(int i, int j) throws Exception{
    	if(!(posicaoValida(i,j))){
    		throw new Exception("Posicao inexistente.");
    	}else{
    		if(sala[i][j] == this.LIVRE){
                return true;
            }else{
                return false;
            }
    	}
        
    }
    
    public boolean posicaoValida(int i, int j){
        if(i >= 0 && i < this.getNumPosicoesHorizontais() && j >= 0 && j < this.getNumPosicoesVerticais()){
            return true;
        }
        return false;
    }
    
    public boolean setPosicao(int i, int j, int status) {
    	if(posicaoValida(i,j) && (status == LIVRE || status == OCUPADO)){
    	    sala[i][j] = status;
    	    return true;
    	}else{
    		return false;
    	}
       
    }
    
    @Override
    public boolean equals(Object outraSala){
    	Sala aux = (Sala) outraSala;
    	if(this.getNumPosicoesHorizontais() == aux.getNumPosicoesHorizontais() && this.getNumPosicoesVerticais() == aux.getNumPosicoesVerticais()){
    		for(int i = 0; i < this.getNumPosicoesHorizontais(); i++){
    			for(int j = 0; j < this.getNumPosicoesVerticais(); j++){
    				if(sala[i][j] != aux.sala[i][j]){
    					return false;
    				}
    				
    			}
    		}
    		
    	}
    	
    	return true;
    	
    }
    
}