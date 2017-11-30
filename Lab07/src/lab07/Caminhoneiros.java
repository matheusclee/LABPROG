package lab07;

public class Caminhoneiros extends Rodoviarios{
	
	private double toneladas;
	private int LIMITE = 10;

	public Caminhoneiros(String nome, String cod, boolean temCasa, boolean temCarro, double kmRodados, double numToneladas) {
		super(nome, cod, temCasa, temCarro, kmRodados);
		setToneladas(numToneladas);
	}
	
	public void setToneladas(double num){
		toneladas = num;
	}
	
	public double getToneladas(){
		return toneladas;
	}
	
	public double tributacao(){
		if(toneladas <= LIMITE){
			return 500;
		}else{
			return 500 + ((toneladas - LIMITE)*100);
		}
	}

}
