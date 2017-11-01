package lab05;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestaRobo {
	
	private Robo robo;
	private final int ENERGIA = 10;
	private Sala salaRobo = new Sala(10, 10);
	
	@Before
	public void criaObjetos() throws Exception {
		robo = new Robo(salaRobo, ENERGIA);
	}
	
	@Test
	public void testaCriarRobo() {
		try{
			new Robo(salaRobo, -1);
			Assert.fail("Espereva uma excecao, pois o valor da energia eh invalido.");
		}catch(Exception e){
			Assert.assertEquals("Mensagem Errada.",
					"Parametros incorretos para criacao do Robo. Sala nao pode estar cheia e nem ser null e a energia deve ser maior que zer.", 
					e.getMessage());
		}
		
		try{
			new Robo(salaRobo, 0);
			Assert.fail("Espereva uma excecao, pois o valor da energia eh invalido.");
		}catch(Exception e){
			Assert.assertEquals("Mensagem Errada.",
					"Parametros incorretos para criacao do Robo. Sala nao pode estar cheia e nem ser null e a energia deve ser maior que zer.", 
					e.getMessage());
		}
		
		try{
			new Robo(null, ENERGIA);
			Assert.fail("Espereva uma excecao, pois o valor da energia eh invalido.");
		}catch(Exception e){
			Assert.assertEquals("Mensagem Errada.",
					"Parametros incorretos para criacao do Robo. Sala nao pode estar cheia e nem ser null e a energia deve ser maior que zer.", 
					e.getMessage());
		}
		
		try{
			for (int i = 0; i < salaRobo.getNumPosicoesHorizontais(); i++){
				for(int j = 0; i < salaRobo.getNumPosicoesVerticais(); j++){
					salaRobo.inserirObstaculo(i, j);
				}
			}
			new Robo(salaRobo, ENERGIA);
			Assert.fail("Espereva uma excecao, pois o valor da energia eh invalido.");
		}catch(Exception e){
			Assert.assertEquals("Mensagem Errada.",
					"Parametros incorretos para criacao do Robo. Sala nao pode estar cheia e nem ser null e a energia deve ser maior que zer.", 
					e.getMessage());
		}
		
	}
	
	@Test
	public void testaPosicao(){
		
		Assert.assertTrue(robo.getPosicaoInicial() == [0,0]);
		
		Assert.assertTrue(robo.isSalaPosicaoLivre(0, 0));
		try{
			salaRobo.inserirObstaculo(0, 0);
			robo = new Robo(salaRobo, ENERGIA);
			Assert.assertTrue(robo.getPosicaoInicial() == [0,1]);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

}
