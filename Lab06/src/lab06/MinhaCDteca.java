/* 
 * ALUNO 1: Matheus Clemente Pereira
 * ALUNO 2: Carlos Vinicius N Lira
 */


package lab06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MinhaCDteca {

	private List<CD> armazenaCDs = new ArrayList();
	
	public void adicionaCD(CD disco){
		armazenaCDs.add(disco);
	}
	
	public void adicionaCDs(MinhaCDteca colecao){
		armazenaCDs.addAll((Collection<? extends CD>) colecao);
	}
	
	public void removeCD(CD disco){
		armazenaCDs.remove(disco);
	}
	
	public boolean removeCDs(MinhaCDteca colecao){
		armazenaCDs.removeAll((Collection<? extends CD>) colecao);
		return true;
	}
	
	public CD getI(int i){
		if(i < armazenaCDs.size()){
			return armazenaCDs.get(i);
		}
		
		return null;
	}
}
