package lab07;

public class Caminhoneiros extends Rodoviarios{
	
	private double toneladas;
	private int LIMITE = 10;
	private double riquezaCaminhoneiros;
	private int numCaminhoneiros;

	public Caminhoneiros(String nome, String cod, double valorCasa, double valorCarro, double kmRodados, double numToneladas) {
		super(nome, cod, valorCasa, valorCarro, kmRodados);
		setToneladas(numToneladas);
		riquezaCaminhoneiros = riquezaGeral(riquezaCaminhoneiros);
		numCaminhoneiros++;
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
	
	public boolean sinalExteriorDeRiqueza(){
		return this.mediaRiqueza(riquezaCaminhoneiros, numCaminhoneiros);
	}

}
