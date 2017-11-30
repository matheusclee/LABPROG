package lab07;

public class Taxista extends Rodoviarios {
	
	private int numPassageiros;

	public Taxista(String nome, String cod, double valorCasa, double valorCarro, double kmRodados, int passageiros) {
		super(nome, cod, valorCasa, valorCarro, kmRodados);
		setNumPassageiros(passageiros);
	}

	public double tributacao(){
		return numPassageiros*0.5;
	}
	
	public void setNumPassageiros(int num){
		numPassageiros = num;
	}
	
	public double getNumPassageiros(){
		return numPassageiros;
	}
}
