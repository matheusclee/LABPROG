package lab07;

public class Taxista extends Rodoviarios {
	
	private int numPassageiros;
	private double riquezaTaxistas;
	private int numTaxistas;

	public Taxista(String nome, String cod, double valorCasa, double valorCarro, double kmRodados, int passageiros) {
		super(nome, cod, valorCasa, valorCarro, kmRodados);
		setNumPassageiros(passageiros);
		riquezaTaxistas = this.riquezaGeral(riquezaTaxistas);
		numTaxistas++;
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
	
	public boolean sinalDeRiquezaExterior(){
		return this.mediaRiqueza(riquezaTaxistas, numTaxistas);
	}
}
