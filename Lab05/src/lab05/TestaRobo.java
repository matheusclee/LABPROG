package lab05;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


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
		try{
			robo = new Robo(salaRobo, ENERGIA);
		}catch(Exception e){
			e.printStackTrace();
		}
		int[] aux = {0,0};
		Assert.assertTrue(Arrays.equals(robo.getPosicao(), aux));
		Assert.assertTrue(robo.isSalaPosicaoLivre(0, 0));
		try{
			salaRobo.inserirObstaculo(0, 0);
			robo = new Robo(salaRobo, ENERGIA);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		int[] aux2 = {0,1};
		Assert.assertTrue(Arrays.equals(robo.getPosicao(), aux2));
	}
	
	@Test
	public void testaMovimentos(){
		try{
			robo = new Robo(salaRobo, ENERGIA);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Assert.assertFalse(robo.moveParaTras());
		Assert.assertFalse(robo.moveParaEsquerda());
		Assert.assertTrue(robo.getEnergia() == ENERGIA);
		Assert.assertTrue(robo.getPassos() == 0);
		Assert.assertTrue(robo.moveParaFrente());
		int[] aux = {1,0};
		Assert.assertTrue(Arrays.equals(robo.getPosicao(), aux));
		Assert.assertTrue(robo.moveParaDireita());
		int[] aux2 = {1,1};
		Assert.assertTrue(Arrays.equals(robo.getPosicao(), aux2));
		Assert.assertTrue(robo.moveParaEsquerda());
		Assert.assertTrue(Arrays.equals(robo.getPosicao(), aux));
		Assert.assertTrue(robo.moveParaTras());
		int[] aux3 = {0,0};
		Assert.assertTrue(Arrays.equals(robo.getPosicao(), aux3));
	}
	
	@Test
	public void testaMovimentosComObstaculos(){
		try{
			robo = new Robo(salaRobo, ENERGIA);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		robo.inserirObstaculo(1,0);
		robo.inserirObstaculo(0,2);
		
		Assert.assertFalse(robo.moveParaFrente());
		Assert.assertTrue(robo.getEnergia() == ENERGIA);
		int[] aux = {0,0};
		Assert.assertFalse(Arrays.equals(robo.getPosicao(), aux));
		Assert.assertTrue(robo.moveParaDireita());
		int[] aux2 = {0,1};
		Assert.assertTrue(Arrays.equals(robo.getPosicao(), aux2));
		Assert.assertTrue(robo.getPassos() == 1);
		Assert.assertTrue(robo.getEnergia() == 9);
		Assert.assertFalse(robo.moveParaDireita());
		Assert.assertTrue(Arrays.equals(robo.getPosicao(), aux2));
		Assert.assertTrue(robo.getPassos() == 1);
		Assert.assertTrue(robo.getEnergia() == 9);
		Assert.assertTrue(robo.moveParaFrente());
		int[] aux3 = {1,1};
		Assert.assertTrue(Arrays.equals(robo.getPosicao(), aux3));
		Assert.assertTrue(robo.getPassos() == 2);
		Assert.assertTrue(robo.getEnergia() == 8);
		Assert.assertTrue(robo.moveParaDireira());
		int[] aux4 = {1,2};
		Assert.assertTrue(Arrays.equals(robo.getPosicao(), aux4));
		Assert.assertTrue(robo.getPassos() == 3);
		Assert.assertTrue(robo.getEnergia() == 7);
	}

}
