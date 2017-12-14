/* 
 * ALUNO 1: Matheus Clemente Pereira
 * ALUNO 2: Carlos Vinicius N Lira
 * ALUNO 3: Jeffiti Mucio
 */

package lab06;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaMinhaCDteca{
	
	private CD disco1;
	private CD disco2;
	private CD disco3;
	MinhaCDteca discos;
	
	@Before
	public void CriaObjetos() throws Exception{
		
		disco1 = new CD("Ao vivo", "Banda", 10);
		disco2 = new CD("Na sua Casa", "Armando", 10);
		disco3 = new CD("Ao vivo2", "Banda", 10);
		discos = new MinhaCDteca();
	}
	
	@Test
	public void TestaAdicionaCD(){
		
		discos.adicionaCD(disco1);
		Assert.assertTrue(disco1.equals(discos.getI(0)));
		discos.adicionaCD(disco2);
		Assert.assertFalse(disco1.equals(discos.getI(1)));
		Assert.assertTrue(disco2.equals(discos.getI(1)));
	}	
	
	@Test
	public void TestaAdicionaCDs(){
		
		discos.adicionaCD(disco1);
		discos.adicionaCD(disco2);
		discos.adicionaCD(disco3);
		Assert.assertTrue(discos.getI(3) == null);
		
		MinhaCDteca discos2 = new MinhaCDteca();
		
		discos2.adicionaCDs(discos);
		discos2.adicionaCD(disco2);
		discos2.adicionaCD(disco1);
		
		Assert.assertTrue(disco1.equals(discos2.getI(0)));
		Assert.assertTrue(disco3.equals(discos2.getI(2)));
		Assert.assertTrue(disco2.equals(discos2.getI(3)));
		Assert.assertFalse(discos2.getI(4) == null);
	}
	
	@Test
	public void TestaRemoveCD(){
		
		discos.adicionaCD(disco1);
		discos.adicionaCD(disco2);
		Assert.assertTrue(discos.removeCD(disco1.getTitulo()) == disco1);
		Assert.assertFalse(discos.removeCD(disco1.getTitulo()) == disco1);
		Assert.assertTrue(discos.getI(0) == disco2);
	}
	
	@Test
	public void TestaRemoveCDs(){
		
		discos.adicionaCD(disco1);
		discos.adicionaCD(disco2);
		discos.adicionaCD(disco3);
		
		MinhaCDteca discos2 = new MinhaCDteca();
		
		discos2.adicionaCDs(discos);
		discos2.removeCD("Ao vivo2");
		Assert.assertTrue(discos2.numeroDeCDs() == 2);
		Assert.assertTrue(discos2.removeCDs(discos));
		Assert.assertTrue(discos2.numeroDeCDs() == 0);
		Assert.assertFalse(discos2.removeCDs(discos));
		discos2.adicionaCDs(discos);
		discos2.adicionaCD(disco2);
		discos2.removeCDs(discos);
		Assert.assertTrue(discos2.getI(0) == disco2);
		Assert.assertTrue(discos2.getI(1) == null);
	}
	
	@Test
	public void TestaPesquisaCD(){
		discos.adicionaCD(disco1);
		discos.adicionaCD(disco2);
		
		Assert.assertTrue(discos.pesquisaCD("Ao vivo") == disco1);
		Assert.assertTrue(discos.pesquisaCD("Na sua Casa") == disco2);
		Assert.assertTrue(discos.pesquisaCD("Nao existe") == null);
	}
	
	@Test
	public void TestaEquals(){
		discos.adicionaCD(disco1);
		discos.adicionaCD(disco2);
		discos.adicionaCD(disco3);
		
		MinhaCDteca discos2 = new MinhaCDteca();
		discos2.adicionaCDs(discos);
		
		Assert.assertTrue(discos.equals(discos2));
		
	}
	
}
