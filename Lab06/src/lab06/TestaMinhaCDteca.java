/* 
 * ALUNO 1: Matheus Clemente Pereira
 * ALUNO 2: Carlos Vinicius N Lira
 */

package lab06;

import org.junit.Assert;
import org.junit.Test;

public class TestaMinhaCDteca {
	
	@Test
	public void TestaAdicionaCD() throws Exception{
		
		CD disco1 = new CD("Ao vivo", "Banda", 10);
		CD disco2 = new CD("Na sua Casa", "Armando", 10);
		CD disco3 = new CD("Ao vivo", "Banda", 10);
			
		MinhaCDteca discos = new MinhaCDteca();
		discos.adicionaCD(disco1);
		Assert.assertTrue(disco1.equals(discos.getI(0)));
		discos.adicionaCD(disco2);
		Assert.assertFalse(disco1.equals(discos.getI(1)));
		Assert.assertTrue(disco2.equals(discos.getI(1)));
	}	
	
	
	
}
