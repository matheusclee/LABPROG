/* 
 * ALUNO 1: Matheus Clemente Pereira
 * ALUNO 2: Carlos Vinicius N Lira
 */

package lab06;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaCD {
	
	private CD disco;
	private String titulo = "Sao Joao";
	private String artista = "Trio do Forro";
	private final int NUM_FAIXAS = 3;
	
	@Before
	public void criaObjetos() throws Exception {
		disco = new CD(titulo, artista, NUM_FAIXAS);
	}
	
	@Test
	public void testaCriaCD(){
		try {
			new CD("titulo", "artista", -1);
			Assert.fail("Esperava uma excecao, pois nao esta sendo passado parametros corretos");
		}catch (Exception e){
			Assert.assertEquals("Parametros passados estao incorretos",
								e.getMessage());
		}
		
		try {
			new CD("titulo", "artista", 0);
			Assert.fail("Esperava uma excecao, pois nao esta sendo passado parametros corretos");
		}catch (Exception e){
			Assert.assertEquals("Parametros passados estao incorretos",
								e.getMessage());
		}
		
		try{
			CD cd = new CD("titulo", "artista");
			Assert.assertTrue(cd.getM()==10);
		}catch(Exception e){
			//Nao faz nada;
		}
	}
	
	
	@Test
	public void testaMudaTrilhaPrincipal() throws Exception{
		try {
			CD cd = new CD("titulo", "artista", 1);
			cd.setTrilhaPrincipal("musica");
			Assert.fail("Esperava uma excecao, pois nao existem faixas no cd");
		}catch (Exception e){
			Assert.assertEquals("Faixa informada nao existe.", 
								 e.getMessage());
		}
		
		CD cd = new CD("titulo", "artista", 1);
		cd.setFaixas("musica");
		cd.setTrilhaPrincipal("musica");
		Assert.assertTrue(cd.getTrilhaPrincipal() == "musica");
	}
	
	@Test
	public void testaMetodosAcessadores() throws Exception{
		Assert.assertTrue(disco.getArtista() == artista);
		Assert.assertFalse(disco.getArtista() == "atista errado");
		
		Assert.assertTrue(disco.getTitulo() == titulo);
		Assert.assertFalse(disco.getTitulo() == "titulo errado");
		
		Assert.assertFalse(disco.getTrilhaPrincipal() == "musica");
		disco.setFaixas("musica");
		disco.setTrilhaPrincipal("musica");
		Assert.assertTrue(disco.getTrilhaPrincipal() == "musica");
		
		Assert.assertTrue(disco.getM() == NUM_FAIXAS);
		Assert.assertFalse(disco.getM() == 10);
	}
	
	@Test
	public void testaCadastroDeFaixas(){
		Assert.assertTrue(disco.setFaixas("musica1"));
		Assert.assertTrue(disco.setFaixas("musica2"));
		Assert.assertTrue(disco.setFaixas("musica3"));
		Assert.assertFalse(disco.setFaixas("musica4"));
		
		Assert.assertTrue(disco.getI(0) == "musica1");
		Assert.assertTrue(disco.getI(3) == null);
	}
	
	/*@Test
	public void testaToString() throws Exception{
		CD cd = new CD("Chimarruts Ao Vivo", "Chimarruts", 3);
		
		Assert.assertFalse(cd.toString() == "Titulo: Chimarruts Ao Vivo\n"
				+ "Artista: Chimarruts\n"
				+ "Trilha Principal: Não existe\n"
				+ "Faixas:\nVazio");
		
		cd.setFaixas("Iemanja");
		cd.setFaixas("Pra Ela");
		cd.setFaixas("Floripa");
		cd.setTrilhaPrincipal("Pra Ela");
		Assert.assertTrue(cd.getTrilhaPrincipal() == "Pra Ela");
		Assert.assertTrue(cd.toString() == "Titulo: Chimarruts Ao Vivo\n"
				+ "Artista: Chimarruts\n"
				+ "Trilha Principal: Pra Ela\n"
				+ "Faixas:\n"
				+ "1 - Iemanja\n"
				+ "2 - Pra Ela\n"
				+ "3 - Floripa");
	}*/
	
	public void testaEquals() throws Exception{
		CD disco2 = new CD(this.titulo, this.artista);
		Assert.assertTrue(disco.equals(disco2));
		
		CD disco3 = new CD("aleatorio", "aleatorio");
		Assert.assertFalse(disco.equals(disco3));
	}
	
	public void main(String[] args) throws Exception{
		CD cd = new CD("Chimarruts Ao Vivo", "Chimarruts", 3);
		cd.setFaixas("Iemanja");
		cd.setFaixas("Pra Ela");
		cd.setFaixas("Floripa");
		
		cd.toString();
	}
	
}
