/* 
 * ALUNO 1: Matheus Clemente Pereira
 * ALUNO 2: Carlos Vinicius N Lira
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
		disco3 = new CD("Ao vivo", "Banda", 10);
		discos = new MinhaCDteca();
	}
	
	@Test
	public void TestaAdicionaCD() throws Exception{
		
		discos.adicionaCD(disco1);
		Assert.assertTrue(disco1.equals(discos.getI(0)));
		discos.adicionaCD(disco2);
		Assert.assertFalse(disco1.equals(discos.getI(1)));
		Assert.assertTrue(disco2.equals(discos.getI(1)));
	}	
	
	@Test
	public void TestaRemoveCD(){
		
		discos.adicionaCD(disco1);
		discos.adicionaCD(disco2);
		discos.removeCD(disco1);
		Assert.assertFalse(disco1.equals(discos.getI(0)));
	}
	
}
